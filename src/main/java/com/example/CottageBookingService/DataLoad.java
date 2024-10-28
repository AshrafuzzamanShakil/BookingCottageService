package com.example.CottageBookingService;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;

public class DataLoad {
    public static void main(String[] args) {
        // Create an empty model
        Model model = ModelFactory.createDefaultModel();

        // Simplified path to the ontology file
        String ontologyFile = "file:///C:/Ontology/CottageOntology.owl";
        String instanceFile = "file:///C:/Ontology/Cottages.ttl";

        // Debug output to confirm the paths
        System.out.println("Ontology File URI: " + ontologyFile);
        System.out.println("Instance File URI: " + instanceFile);

        try {
            model.read(ontologyFile);
            System.out.println("Ontology loaded: " + ontologyFile);

            model.read(instanceFile);
            System.out.println("Instances loaded: " + instanceFile);

            // Print the model to the console in Turtle format
            model.write(System.out, "TURTLE"); // or use "RDF/XML" for XML format
        } catch (Exception e) {
            System.out.println("Error reading files: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
