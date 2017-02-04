package edu.oregonstate.cs361.battleship;

import com.google.gson.Gson;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import spark.Spark;
import spark.utils.IOUtils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.rmi.UnexpectedException;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static spark.Spark.awaitInitialization;

class ShipTest {

    @Test
    public void testCreateShipWithOrientation() {
        String name = "aircraftCarrier";
        CoordinatePair start = new CoordinatePair(3, 5);
        try {
            new Ship(name, start, "horizontal");
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testIsPlaced() {
        Ship shipA = new Ship("destroyer", new CoordinatePair(2, 2), "vertical");
        Ship shipB = new Ship("submarine", new CoordinatePair(7, 7), "horizontal");

        assertAll(
                () -> assertTrue(shipA.isPlaced()),
                () -> assertTrue(shipB.isPlaced())
        );
    }

}