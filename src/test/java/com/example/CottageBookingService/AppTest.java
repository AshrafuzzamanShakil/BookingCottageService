package com.example.CottageBookingService;

import com.google.gson.Gson;

public class AppTest {
    public static void main(String[] args) {
        BookingServlet servlet = new BookingServlet();
        
        // Initialize the servlet (like in a servlet container)
        try {
            servlet.init();  // Call the init method to load the model
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        
        // Simulate a booking request
        BookingRequest request = new BookingRequest();
        request.setBookerName("John Doe");
        request.setRequiredPlaces(4);
        request.setBookingPeriod("2024-10-28 to 2024-10-30");
        
        // Create a dummy response object
        BookingResponse response = new BookingResponse();
        
        // Simulate the doPost method logic (without HttpServletRequest and HttpServletResponse)
        String sparqlQuery = servlet.createSparqlQuery(request);
        System.out.println("Generated SPARQL Query: " + sparqlQuery);

        // Normally you'd execute the query here, but for simplicity, let's just pretend we did
        // (You would also typically handle the response and populate the response object)
        response.setBookingNumber("123456");
        response.setAddress("123 Lakeview Rd.");
        response.setActualPlaces(4);
        response.setImageURL("http://example.com/cottage.jpg");
        
        // Convert response to JSON
        String jsonResponse = convertToJson(response);
        System.out.println("Response JSON: " + jsonResponse);
    }

    private static String convertToJson(BookingResponse response) {
        Gson gson = new Gson();
        return gson.toJson(response);
    }
}
