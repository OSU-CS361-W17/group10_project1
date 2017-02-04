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

import static org.junit.jupiter.api.Assertions.*;
import static spark.Spark.awaitInitialization;

import edu.oregonstate.cs361.battleship.BattleshipModel;

class CoordinatePairTest {
    @Test
    public void testCanCreateCoordinatePair() {
        try {
            CoordinatePair coord = new CoordinatePair();
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testAcross() {
        CoordinatePair coord = new CoordinatePair();
        coord.setAcross(4);
        assertEquals(coord.getAcross(), 4);
    }

    @Test
    public void testDown() {
        CoordinatePair coord = new CoordinatePair();
        coord.setDown(7);
        assertEquals(coord.getDown(), 7);
    }
}