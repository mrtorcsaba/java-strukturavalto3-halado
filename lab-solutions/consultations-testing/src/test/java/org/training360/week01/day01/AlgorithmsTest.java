package org.training360.week01.day01;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AlgorithmsTest implements BeforeAlgorithms{

    Algorithms algorithms = new Algorithms();

    @Test
    void testFindNotSingleNumber(){
        int result = algorithms.findNotSingleNumber(List.of(1,2,3,2,4,5));

        assertEquals(2, result);
    }

    @Test
    void testFindNotSingleNumberWrongList(){
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
                ()->algorithms.findNotSingleNumber(List.of(1,2,5,6)));

        assertEquals("Input is not valid!",iae.getMessage());

    }

    @Test
    void testFindNotSingleNumberWithSort(){
        int result = algorithms.findNotSingleNumberWithSort(new ArrayList<>(List.of(1,2,3,2,4,5)));
        assertEquals(2, result);
    }

    @Test
    @Disabled("Not now!")
    void testFindNotSingleNumberWithMap(){
        int result = algorithms.findNotSingleNumberWithMap(List.of(0,2,3,0,10,1));

        assertEquals(0, result);
    }



}