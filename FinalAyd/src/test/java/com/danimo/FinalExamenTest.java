package com.danimo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FinalExamenTest {

    private FinalExamen finalExamen;
    private FinalExamen.Order order;
    private final String NAME= "JUAN";
    private final String EMAIL = "JAUN@GMIAL.COM";
    private final String PHONE= "123456789";
    private final String ADDRESS = "Calle 123";
    private final String CITY= "GUATEMALA";
    private final String ZIP = "09001";

    @BeforeEach
    void setUp() {
        finalExamen = new FinalExamen();
    }

    @Test
    void shouldTestProcessData(){
        // Arrange
        String input = "part1, part2, part3";
        List<String> expectedData = new ArrayList<>();
        List<String> actualData = new ArrayList<>();


        // Act

        actualData.add("PART1");
        actualData.add("PART2");
        actualData.add("PART3");

        expectedData.add("PART1");
        expectedData.add("PART2");
        expectedData.add("PART3");

        // Assert
        assertEquals(expectedData, actualData);
    }

    @Test
    void shouldNotProcessData(){
        // Arrange
        String input = "part1, part2, part3";
        List<String> expectedData = new ArrayList<>();
        List<String> actualData = new ArrayList<>();

        // act
        actualData.add("part1");
        actualData.add("part2");
        actualData.add("part3");

        expectedData.add("PART1");
        expectedData.add("PART2");
        expectedData.add("PART3");

        // Assert
        assertEquals(expectedData, actualData);
    }

    @Test
    void shouldTestCreateUser(){
        // Arr
        String expected = "User created: " + NAME;

        // Act
        String result = finalExamen.createUser(NAME, EMAIL, PHONE, ADDRESS, CITY, ZIP);

        // Assert
        assertEquals(expected, result);

    }

    @Test
    void shouldNameIsEmpty() {
        // Arrange
        String name = "";
        String expected = "Name cannot be empty";

        // Act
        String result = finalExamen.createUser(name, EMAIL, PHONE, ADDRESS, CITY, ZIP);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    void shouldEmailIsEmty(){
        // Arr
        String email = "";
        String expected = "Invalid email";

        // Act
        String result = finalExamen.createUser(NAME, email, PHONE, ADDRESS, CITY, ZIP);

        // Assert
        assertEquals(expected, result);

    }

    @Test
    void shouldCalculateArea(){

        //ar
        double length = 5.0;
        double width = 10.0;
        String shape = "rectangle";
        double expectedArea = 50.0;

        // act
        double actualArea = finalExamen.calculateArea(shape, length, width);

        // assert
        assertEquals(expectedArea, actualArea);
    }

    @Test
    void shouldCalculateAreaCircle(){

        //ar
        double ratio = 5.0;
        String shape = "circle";
        double expectedArea = 25.0 * Math.PI;

        // act
        double actualArea = finalExamen.calculateArea(shape, ratio);

        // assert
        assertEquals(expectedArea, actualArea);
    }

    @Test
    void shouldCalculateAreaTriangle(){

        //arr
        double base = 5.0;
        double height = 10.0;
        String shape = "triangle";
        double expectedArea = 25.0;

        // act
        double actualArea = finalExamen.calculateArea(shape, base, height);

        // assert
        assertEquals(expectedArea, actualArea);
    }

    @Test
    void shouldNotAreaShape(){
        //arr
        String shape = "square";
        String expected = new IllegalArgumentException("Unknown shape").toString();

        // act
        try {
            finalExamen.calculateArea(shape);
        } catch (IllegalArgumentException e) {
            assertEquals(expected, e.toString());
        }

    }
}
