package controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidateNameTest {
    private PlaceOrderController placeOrderController;
    @BeforeEach
    void setUp() {
        placeOrderController = new PlaceOrderController();
    }
    @ParameterizedTest
    @CsvSource({
            "ND Long, true",
            "Nguyen Duy Long, true",
            "Long, true",
            ",false",
            "Nguyen Duy Long 1234, false",
            "N.D.Long, false",
            "Long*****, false",
    })
    void validateName(String name, boolean expected){
        boolean isValid = placeOrderController.validateName(name);
        assertEquals(expected, isValid);
    }
}