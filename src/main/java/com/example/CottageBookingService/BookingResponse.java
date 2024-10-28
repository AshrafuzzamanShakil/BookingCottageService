package com.example.CottageBookingService;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a response containing booking details and available cottages.
 */
public class BookingResponse {
    private String bookerName;
    private String bookingNumber;
    private String address;
    private String imageURL;
    private int actualPlaces;
    private int actualBedrooms;
    private int actualDistanceToLake;
    private String nearestCity;
    private int distanceToCity;
    private String bookingPeriod;
    private List<Cottage> cottages; // Field for cottages

    // Default Constructor
    public BookingResponse() {
        this.cottages = new ArrayList<>(); // Initialize cottages list to avoid null
    }

    // Parameterized Constructor
    public BookingResponse(String bookerName, String bookingNumber, String address, String imageURL, 
                           int actualPlaces, int actualBedrooms, int actualDistanceToLake, 
                           String nearestCity, int distanceToCity, String bookingPeriod, 
                           List<Cottage> cottages) {
        this.bookerName = bookerName;
        this.bookingNumber = bookingNumber;
        this.address = address;
        this.imageURL = imageURL;
        this.actualPlaces = actualPlaces;
        this.actualBedrooms = actualBedrooms;
        this.actualDistanceToLake = actualDistanceToLake;
        this.nearestCity = nearestCity;
        this.distanceToCity = distanceToCity;
        this.bookingPeriod = bookingPeriod;
        this.cottages = cottages != null ? cottages : new ArrayList<>(); // Initialize cottages
    }

    // Getters and Setters
    public String getBookerName() {
        return bookerName;
    }

    public void setBookerName(String bookerName) {
        this.bookerName = bookerName;
    }

    public String getBookingNumber() {
        return bookingNumber;
    }

    public void setBookingNumber(String bookingNumber) {
        this.bookingNumber = bookingNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public int getActualPlaces() {
        return actualPlaces;
    }

    public void setActualPlaces(int actualPlaces) {
        this.actualPlaces = actualPlaces;
    }

    public int getActualBedrooms() {
        return actualBedrooms;
    }

    public void setActualBedrooms(int actualBedrooms) {
        this.actualBedrooms = actualBedrooms;
    }

    public int getActualDistanceToLake() {
        return actualDistanceToLake;
    }

    public void setActualDistanceToLake(int actualDistanceToLake) {
        this.actualDistanceToLake = actualDistanceToLake;
    }

    public String getNearestCity() {
        return nearestCity;
    }

    public void setNearestCity(String nearestCity) {
        this.nearestCity = nearestCity;
    }

    public int getDistanceToCity() {
        return distanceToCity;
    }

    public void setDistanceToCity(int distanceToCity) {
        this.distanceToCity = distanceToCity;
    }

    public String getBookingPeriod() {
        return bookingPeriod;
    }

    public void setBookingPeriod(String bookingPeriod) {
        this.bookingPeriod = bookingPeriod;
    }

    public List<Cottage> getCottages() { // Getter for cottages
        return cottages;
    }

    public void setCottages(List<Cottage> cottages) { // Setter for cottages
        this.cottages = cottages != null ? cottages : new ArrayList<>(); // Avoid null
    }
}
