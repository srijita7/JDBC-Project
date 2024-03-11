package com.examly.springapp;

import java.util.List;
import java.util.Scanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.examly.springapp.model.Hotel;
import com.examly.springapp.service.HotelService;

@SpringBootApplication
public class SpringappApplication {
    static void createHotel(Scanner sc, HotelService serviceObj) {
        int id = sc.nextInt();
        sc.nextLine();
        String hotelname = sc.nextLine();
        String location = sc.nextLine();
        float rating = sc.nextFloat();
        boolean pool = sc.nextBoolean();
        boolean gym = sc.nextBoolean();
        boolean spa = sc.nextBoolean();
        Hotel hotel = new Hotel();
        hotel.setId(id);
        hotel.setHotelname(hotelname);
        hotel.setLocation(location);
        hotel.setRating(rating);
        hotel.setPool(pool);
        hotel.setGym(gym);
        hotel.setSpa(spa);
        serviceObj.createHotel(hotel);
    }

    static void updateHotel(Scanner sc, HotelService serviceObj) {
        int id = sc.nextInt();
        sc.nextLine();
        String hotelname = sc.nextLine();
        String location = sc.nextLine();
        float rating = sc.nextFloat();
        boolean pool = sc.nextBoolean();
        boolean gym = sc.nextBoolean();
        boolean spa = sc.nextBoolean();
        Hotel hotel = new Hotel();
        hotel.setId(id);
        hotel.setHotelname(hotelname);
        hotel.setLocation(location);
        hotel.setRating(rating);
        hotel.setPool(pool);
        hotel.setGym(gym);
        hotel.setSpa(spa);
        serviceObj.updateHotel(hotel);
    }

    static void deleteHotel(Scanner sc, HotelService serviceObj) {
        int id = sc.nextInt();
        serviceObj.deleteHotel(id);
    }

    static void viewAllHotels(HotelService serviceObj) {
        List<Hotel> hotels = serviceObj.viewAllHotels();
        if(hotels.isEmpty())
        {
            System.out.println("No records found");
        }
        else
        {
            for (Hotel hotel : hotels) {
                System.out.println(hotel.getId() + "\t" + hotel.getHotelname() + "\t" + hotel.getLocation() + "\t"
                        + hotel.getRating() + "\t" + hotel.getPool() + "\t" + hotel.getGym() + "\t" + hotel.getSpa());
            }
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringappApplication.class, args);

        HotelService serviceObj = new HotelService();
        Scanner scannerObj = new Scanner(System.in);

        int option=5;
        int flag=1;

        while(flag==1)
        {
            option = scannerObj.nextInt();
            switch (option) {
                case 1:
                    createHotel(scannerObj, serviceObj);
                    break;
                case 2:
                    updateHotel(scannerObj, serviceObj);
                    break;
                case 3:
                    deleteHotel(scannerObj, serviceObj);
                    break;
                case 4:
                    viewAllHotels(serviceObj);
                    break;
                case 5: flag=0; break;
                default: System.out.println("Invalid option");
            }
        }
    }
    // Rest of the methods for sorting and displaying data
}
