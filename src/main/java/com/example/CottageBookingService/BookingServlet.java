package com.example.CottageBookingService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jena.query.*;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.util.FileManager;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;

@WebServlet("/api/bookings")
public class BookingServlet extends HttpServlet {
    private Model model;

    @Override
    public void init() throws ServletException {
        // Initialize model and load ontology and instance data
        model = ModelFactory.createDefaultModel();
        
        // Path to the ontology and instance files
        String ontologyFile = "file:///C:/Ontology/CottageOntology.owl";
        String instanceFile = "file:///C:/Ontology/Cottages.ttl";
        
        // Load the ontology and instance data
        model.read(ontologyFile);
        model.read(instanceFile);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Parse BookingRequest from the incoming HTTP request
        BookingRequest request = parseBookingRequest(req);

        // Create and execute a SPARQL query
        String sparqlQuery = createSparqlQuery(request); // Make sure this method is accessible
        Query query = QueryFactory.create(sparqlQuery);
        QueryExecution qexec = QueryExecutionFactory.create(query, model);

        // Process the query results and populate the BookingResponse
        BookingResponse response = new BookingResponse();
        List<Cottage> cottages = new ArrayList<>();
        try {
            ResultSet results = qexec.execSelect();
            while (results.hasNext()) {
                QuerySolution soln = results.nextSolution();
                Cottage cottage = new Cottage();
                cottage.setName(soln.getLiteral("cottageName").getString());
                cottage.setAddress(soln.getLiteral("address").getString());
                cottages.add(cottage);
            }
        } finally {
            qexec.close();
        }
        response.setCottages(cottages);

        // Send JSON response back to client
        resp.setContentType("application/json");
        resp.getWriter().write(convertToJson(response));
    }

    // Change visibility from private to public
    public String createSparqlQuery(BookingRequest request) {
        return "PREFIX : <http://localhost:8080/CottageBookingService/onto#> " +
               "SELECT ?cottageName ?address " +
               "WHERE { " +
               "    ?cottage rdf:type :Cottage . " +
               "    ?cottage :cottageName ?cottageName . " +
               "    ?cottage :address ?address . " +
               "    ?cottage :places ?places . " +
               "    FILTER (?places >= " + request.getRequiredPlaces() + ") " +
               "}";
    }

    private BookingRequest parseBookingRequest(HttpServletRequest req) {
        // Parse request parameters
        BookingRequest request = new BookingRequest();
        request.setRequiredPlaces(Integer.parseInt(req.getParameter("requiredPlaces")));
        // Add more parameters as needed
        return request;
    }

    private String convertToJson(BookingResponse response) {
        Gson gson = new Gson();
        return gson.toJson(response);
    }
}

// Additional class for Cottage representation
class Cottage {
    private String name;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
