package com.examly.springapp.dao;

import java.util.*;
import java.sql.*;
import com.examly.springapp.model.Hotel;

public class HotelDAOImpl implements HotelDAO
{

    Connection connection=null;
    PreparedStatement ps=null;

    @Override
    public void createHotel(Hotel hotel) {
        try
        {
            connection=JDBCUtils.getConnection();
            String query="insert into hotel values(?, ?, ?, ?, ?, ?, ?);";
            ps=connection.prepareStatement(query);

            ps.setInt(1, hotel.getId());
            ps.setString(2, hotel.getHotelname());
            ps.setString(3, hotel.getLocation());
            ps.setFloat(4, hotel.getRating());
            ps.setBoolean(5, hotel.getPool());
            ps.setBoolean(6, hotel.getGym());
            ps.setBoolean(7, hotel.getSpa());

            int noOfInsertions=ps.executeUpdate();

            if(noOfInsertions>0)
            System.out.println("Hotel inserted successfully");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        
    }

    @Override
    public void updateHotel(Hotel hotel) {
        try
        {
            connection=JDBCUtils.getConnection();
            String query="update hotel set hotelname=?, location=?, rating=?, pool=?, gym=?, spa=? where id=?;";
            ps=connection.prepareStatement(query);

            ps.setInt(7, hotel.getId());
            ps.setString(1, hotel.getHotelname());
            ps.setString(2, hotel.getLocation());
            ps.setFloat(3, hotel.getRating());
            ps.setBoolean(4, hotel.getPool());
            ps.setBoolean(5, hotel.getGym());
            ps.setBoolean(6, hotel.getSpa());

            int noOfUpdations=ps.executeUpdate();

            if(noOfUpdations>0)
            System.out.println("Hotel updated successfully");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public List<Hotel> getAllHotels() {
        List<Hotel> hotels=null;
        try
        {
            connection=JDBCUtils.getConnection();
            String query="select * from hotel";
            ps=connection.prepareStatement(query);
            hotels=new ArrayList<>();

            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                Hotel hotelObj=new Hotel();
                hotelObj.setId(rs.getInt(1));
                hotelObj.setHotelname(rs.getString(2));
                hotelObj.setLocation(rs.getString(3));
                hotelObj.setRating(rs.getFloat(4));
                hotelObj.setPool(rs.getBoolean(5));
                hotelObj.setGym(rs.getBoolean(6));
                hotelObj.setSpa(rs.getBoolean(7));

                hotels.add(hotelObj);
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return hotels;
    }

    @Override
    public void deleteHotel(int id) {
        try
        {
            connection=JDBCUtils.getConnection();
            String query="delete from hotel where id=?;";
            ps=connection.prepareStatement(query);
            ps.setInt(1, id);
            int noOfDeletions=ps.executeUpdate();

            if(noOfDeletions>0)
            System.out.println("Hotel deleted successfully");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
    
}