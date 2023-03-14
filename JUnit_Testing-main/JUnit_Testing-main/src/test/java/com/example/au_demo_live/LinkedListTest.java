package com.example.au_demo_live;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;


class LinkedListTest {

    private LinkedList<Integer> list;

    @BeforeEach
    void setup(){
        list=new LinkedList<>();
    }


    @ParameterizedTest
    @ValueSource(ints={-1,-3,-5,Integer.MAX_VALUE})
    @DisplayName("many test cases")
    void testGetElementmany(int negativeIndex){
        assertThrows(RuntimeException.class,()->list.getElement(negativeIndex));
    }

    @Test
    @DisplayName("Given the index is negative,getElemet() should throw exception")

    public void testGetElement(){
        final  var list=new LinkedList<Integer>();
        assertThrows(RuntimeException.class,()->list.getElement(-1));
    }

    @Test
    @DisplayName("Given a valid index,getElment() shoul retuwn the value")
    void testGetElementNoexceptio(){

        list.addElement(10);
        assertEquals(10,list.getElement(0));
    }

    @Test
    @DisplayName("Given index greater than the size")
    void testGet_shouldthrowIndexGreat(){
        final var list=new LinkedList<Integer>();
        list.addElement(10);
        list.addElement(20);
        final var exception=assertThrows(RuntimeException.class,()->list.getElement(2));
        assertEquals("index greater",exception.getMessage());
    }

    @Test
    @DisplayName("Null value")
    void testaddnull(){

        final var exception = assertThrows(RuntimeException.class,()->list.addElement(null));
        assertEquals("null value",exception.getMessage());
    }

}