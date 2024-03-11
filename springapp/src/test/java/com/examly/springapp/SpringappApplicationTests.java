package com.examly.springapp;

 


import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.junit.jupiter.api.Assertions.fail;


 

import java.io.File;

import java.lang.reflect.Method;

 

import org.junit.jupiter.api.Test;


import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import org.springframework.boot.test.context.SpringBootTest;

// import org.springframework.http.MediaType;

 

 

@SpringBootTest

@AutoConfigureMockMvc

public class SpringappApplicationTests {



     
    private void checkClassExists(String className) {
        try {
            Class.forName(className);
        } catch (ClassNotFoundException e) {
            fail("Class " + className + " does not exist.");
        }
    }

    private void checkFieldExists(String className, String fieldName) {
        try {
            Class<?> clazz = Class.forName(className);
            clazz.getDeclaredField(fieldName);
        } catch (ClassNotFoundException | NoSuchFieldException e) {
            fail("Field " + fieldName + " in class " + className + " does not exist.");
        }
    }
 


    @Test

    public void Week1_Day6_daoFolder() {

        String directoryPath = "src/main/java/com/examly/springapp/dao"; // Replace with the path to your
        File directory = new File(directoryPath);
        assertTrue(directory.exists() && directory.isDirectory());

    }

 

    @Test
    public void Week1_Day6_modelFolder() {

        String directoryPath = "src/main/java/com/examly/springapp/model"; // Replace with the path to your
        File directory = new File(directoryPath);
        assertTrue(directory.exists() && directory.isDirectory());

    }

    @Test
    public void Week1_Day6_serviceFolder() {

        String directoryPath = "src/main/java/com/examly/springapp/service"; // Replace with the path to your
        File directory = new File(directoryPath);
        assertTrue(directory.exists() && directory.isDirectory());

    }

    @Test
    public void Week1_Day6_testModelClassExists() {
        checkClassExists("com.examly.springapp.model.Hotel");
    }

    @Test
    public void Week1_Day6_testServiceClassExists() {
        checkClassExists("com.examly.springapp.service.HotelService");
    }

    @Test
    public void Week1_Day6_testDaoClassExists() {
        checkClassExists("com.examly.springapp.dao.HotelDAO");
    }
    @Test
    public void Week1_Day6_testDaoImpClassExists() {
        checkClassExists("com.examly.springapp.dao.HotelDAOImpl");
    }
    @Test
    public void Week1_Day6_testJdbcClassExists() {
        checkClassExists("com.examly.springapp.dao.JDBCUtils");
    }

    @Test
    public void Week1_Day6_testCreateHotel() {
        try {
            Class<?> springAppClass = Class.forName("com.examly.springapp.SpringappApplication");
            Method[] methods = springAppClass.getDeclaredMethods();
            boolean methodExists = false;
            for (Method method : methods) {
                if (method.getName().equals("createHotel")) {
                    methodExists = true;
                    break;
                }
            } 

            assertTrue(methodExists, "Method 'createHotel' should exist in SpringappApplication class");
        } catch (ClassNotFoundException e) {
            fail("Class 'SpringappApplication' not found: " + e.getMessage());
        }
    }


 

    @Test
    public void Week1_Day6_testgetAllHotels() {

        try {
            Class<?> springAppClass = Class.forName("com.examly.springapp.SpringappApplication");
            Method[] methods = springAppClass.getDeclaredMethods();
               boolean methodExists = false;
            for (Method method : methods) {
                if (method.getName().equals("viewAllHotels")) {
                    methodExists = true;
                    break;
                }
            }  
            assertTrue(methodExists, "Method 'viewAllHotels' should exist in SpringappApplication class");
        } catch (ClassNotFoundException e) {
            fail("Class 'SpringappApplication' not found: " + e.getMessage());
        }
    }

    @Test
    public void Week2_Day1_testUpdateHotel() {
        try {

            Class<?> springAppClass = Class.forName("com.examly.springapp.SpringappApplication");
            Method[] methods = springAppClass.getDeclaredMethods();
               boolean methodExists = false;
            for (Method method : methods) {
                if (method.getName().equals("updateHotel")) {
                    methodExists = true;
                    break;
                }
            }  
            assertTrue(methodExists, "Method 'updateHotel' should exist in SpringappApplication class");
        } catch (ClassNotFoundException e) {
            fail("Class 'SpringappApplication' not found: " + e.getMessage());
        }
    }

      @Test
    public void Week2_Day1_testdeleteHotel() {
        try {

            Class<?> springAppClass = Class.forName("com.examly.springapp.SpringappApplication");
            Method[] methods = springAppClass.getDeclaredMethods();
               boolean methodExists = false;
            for (Method method : methods) {
                if (method.getName().equals("deleteHotel")) {
                    methodExists = true;
                    break;
                }
            }  
            assertTrue(methodExists, "Method 'deleteHotel' should exist in SpringappApplication class");
        } catch (ClassNotFoundException e) {
            fail("Class 'SpringappApplication' not found: " + e.getMessage());
        }
    }

 

   

}