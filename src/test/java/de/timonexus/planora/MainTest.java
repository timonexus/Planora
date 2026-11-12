package de.timonexus.planora;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MainTest {
    
    @Test 
    void shouldReturnCorrectValue(){
        int expected = 10;

        int actual = 5 + 5;

        assertEquals(expected, actual);
    }
}
