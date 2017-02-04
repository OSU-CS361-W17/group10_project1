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

import edu.oregonstate.cs361.battleship.BattleshipModel;

class BattleshipModelTest {

    @Test
    public void testGetNewGame() {
        try {
            new BattleshipModel();
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testConstructModelFromParams() {
        CoordinatePair start = new CoordinatePair(0, 0);
        CoordinatePair end = new CoordinatePair(0, 0);
        Ship aircraftCarrier = new Ship("aircraftCarrier", start, end);
        Ship battleship = new Ship("battleship", start, end);
        Ship cruiser = new Ship("cruiser", start, end);
        Ship submarine = new Ship("submarine", start, end);
        Ship destroyer = new Ship("destroyer", start, end);
        Ship computerAircraftCarrier = new Ship("computerAircraftCarrier", start, end);
        Ship computerBattleship = new Ship("computerBattleship", start, end);
        Ship computerCruiser = new Ship("computerCruiser", start, end);
        Ship computerSubmarine = new Ship("computerSubmarine", start, end);
        Ship computerDestroyer = new Ship("computerDestroyer", start, end);
        ArrayList<CoordinatePair> playerHits = new ArrayList<>();
        ArrayList<CoordinatePair> playerMisses = new ArrayList<>();
        ArrayList<CoordinatePair> computerHits = new ArrayList<>();
        ArrayList<CoordinatePair> computerMisses = new ArrayList<>();

        try {
            BattleshipModel model = new BattleshipModel(
                    destroyer,
                    submarine,
                    cruiser,
                    battleship,
                    aircraftCarrier,
                    computerDestroyer,
                    computerSubmarine,
                    computerCruiser,
                    computerBattleship,
                    computerAircraftCarrier,
                    playerHits,
                    playerMisses,
                    computerHits,
                    computerMisses
            );
        } catch (Exception e) {
            fail(e.getMessage());
        }

    }

    @Test
    public void testPlaceShip() {
        BattleshipModel model = new BattleshipModel();
        model.placeShip("destroyer", 4, 5, "vertical");
        assert(model.destroyer.isPlaced());
    }

}