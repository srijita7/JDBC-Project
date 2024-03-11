package com.examly.springapp.model;
public class Hotel
{
    private int id;
    private String hotelname;
    private String location;
    private float rating;
    private boolean pool;
    private boolean gym;
    private boolean spa;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getHotelname() {
        return hotelname;
    }
    public void setHotelname(String hotelname) {
        this.hotelname = hotelname;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public float getRating() {
        return rating;
    }
    public void setRating(float rating) {
        this.rating = rating;
    }
    public boolean getPool() {
        return pool;
    }
    public void setPool(boolean pool) {
        this.pool = pool;
    }
    public boolean getGym() {
        return gym;
    }
    public void setGym(boolean gym) {
        this.gym = gym;
    }
    public boolean getSpa() {
        return spa;
    }
    public void setSpa(boolean spa) {
        this.spa = spa;
    }
    
}