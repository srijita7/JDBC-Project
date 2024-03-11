package com.examly.springapp.service;
import java.util.*;
import com.examly.springapp.dao.HotelDAO;
import com.examly.springapp.dao.HotelDAOImpl;
import com.examly.springapp.model.Hotel;

public class HotelService
{
    HotelDAO hotelDAOObj=new HotelDAOImpl();
    public void createHotel(Hotel hotel)
    {
        hotelDAOObj.createHotel(hotel);
    }
    public void updateHotel(Hotel hotel)
    {
        hotelDAOObj.updateHotel(hotel);
    }
    public List<Hotel> viewAllHotels()
    {
        return hotelDAOObj.getAllHotels();
    }
    public void deleteHotel(int id)
    {
        hotelDAOObj.deleteHotel(id);
    }
}