package com.examly.springapp.dao;

import java.util.List;

import com.examly.springapp.model.Hotel;

public interface HotelDAO
{
    void createHotel(Hotel hotel);
    void updateHotel(Hotel hotel);
    List<Hotel> getAllHotels();
    void deleteHotel(int id);
}