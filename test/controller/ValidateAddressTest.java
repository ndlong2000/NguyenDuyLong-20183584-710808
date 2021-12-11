package controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidateAddressTest {
    private PlaceOrderController placeOrderController;
    @BeforeEach
    void setUp() {
        placeOrderController = new PlaceOrderController();
    }
    @ParameterizedTest
    @CsvSource({
            "'thon 7, Xuan Quan, Van Giang, Hung Yen' ,true",
            "2k19 - ngo 55 Nguyen An Ninh, true",
            "*,false",
            ", false"
    })
    void validateAddress(String address, boolean expected){
        //when
        boolean actual = placeOrderController.validateAddress(address);
        //then
        assertEquals(expected, actual);
    }
}