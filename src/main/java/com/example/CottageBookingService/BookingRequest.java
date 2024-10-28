package com.example.CottageBookingService;

public class BookingRequest {
    private String bookerName;
    private int requiredPlaces;
    private int requiredBedrooms;
    private int maxDistanceToLake;
    private String nearestCity;
    private int maxDistanceToCity;
    private int requiredDays;
    private String startingDate;  // Format: "dd.MM.yyyy"
    private int maxShiftDays;
    private String bookingPeriod; // Add this line

    // Constructors
    public BookingRequest() {}

    public BookingRequest(String bookerName, int requiredPlaces, int requiredBedrooms, int maxDistanceToLake, 
                          String nearestCity, int maxDistanceToCity, int requiredDays, 
                          String startingDate, int maxShiftDays, String bookingPeriod) { // Add bookingPeriod here
        this.bookerName = bookerName;
        this.requiredPlaces = requiredPlaces;
        this.requiredBedrooms = requiredBedrooms;
        this.maxDistanceToLake = maxDistanceToLake;
        this.nearestCity = nearestCity;
        this.maxDistanceToCity = maxDistanceToCity;
        this.requiredDays = requiredDays;
        this.startingDate = startingDate;
        this.maxShiftDays = maxShiftDays;
        this.bookingPeriod = bookingPeriod; // Add bookingPeriod assignment
    }

    // Getters and Setters
    public String getBookerName() {
        return bookerName;
    }

    public void setBookerName(String bookerName) {
        this.bookerName = bookerName;
    }

    public int getRequiredPlaces() {
        return requiredPlaces;
    }

    public void setRequiredPlaces(int requiredPlaces) {
        this.requiredPlaces = requiredPlaces;
    }

    public int getRequiredBedrooms() {
        return requiredBedrooms;
    }

    public void setRequiredBedrooms(int requiredBedrooms) {
        this.requiredBedrooms = requiredBedrooms;
    }

    public int getMaxDistanceToLake() {
        return maxDistanceToLake;
    }

    public void setMaxDistanceToLake(int maxDistanceToLake) {
        this.maxDistanceToLake = maxDistanceToLake;
    }

    public String getNearestCity() {
        return nearestCity;
    }

    public void setNearestCity(String nearestCity) {
        this.nearestCity = nearestCity;
    }

    public int getMaxDistanceToCity() {
        return maxDistanceToCity;
    }

    public void setMaxDistanceToCity(int maxDistanceToCity) {
        this.maxDistanceToCity = maxDistanceToCity;
    }

    public int getRequiredDays() {
        return requiredDays;
    }

    public void setRequiredDays(int requiredDays) {
        this.requiredDays = requiredDays;
    }

    public String getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(String startingDate) {
        this.startingDate = startingDate;
    }

    public int getMaxShiftDays() {
        return maxShiftDays;
    }

    public void setMaxShiftDays(int maxShiftDays) {
        this.maxShiftDays = maxShiftDays;
    }

    // Add the following getter and setter for bookingPeriod
    public String getBookingPeriod() {
        return bookingPeriod;
    }

    public void setBookingPeriod(String bookingPeriod) {
        this.bookingPeriod = bookingPeriod;
    }
}
