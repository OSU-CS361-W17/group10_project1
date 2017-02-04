package edu.oregonstate.cs361.battleship;

import com.google.gson.Gson;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class BattleshipModel {

    // declaring player variables for various battleships
    public Ship destroyer;
    public Ship submarine;
    public Ship cruiser;
    public Ship battleship;
    public Ship aircraftCarrier;


    // declaring CPU variables for various battleships
    public Ship computerDestroyer;
    public Ship computerSubmarine;
    public Ship computerCruiser;
    public Ship computerBattleship;
    public Ship computerAircraftCarrier;

    // Hits and Misses
    public ArrayList<CoordinatePair> playerHits = new ArrayList<>();
    public ArrayList<CoordinatePair> playerMisses = new ArrayList<>();
    public ArrayList<CoordinatePair> computerHits = new ArrayList<>();
    public ArrayList<CoordinatePair> computerMisses = new ArrayList<>();


    public BattleshipModel() {  //creates all relevant ships for game
        CoordinatePair start = new CoordinatePair(0, 0);
        CoordinatePair end = new CoordinatePair(0, 0);
        this.aircraftCarrier = new Ship("aircraftCarrier", start, end);
        this.battleship = new Ship("battleship", start, end);
        this.cruiser = new Ship("cruiser", start, end);
        this.submarine = new Ship("submarine", start, end);
        this.destroyer = new Ship("destroyer", start, end);
        this.computerAircraftCarrier = new Ship("computerAircraftCarrier", start, end);
        this.computerBattleship = new Ship("computerBattleship", start, end);
        this.computerCruiser = new Ship("computerCruiser", start, end);
        this.computerSubmarine = new Ship("computerSubmarine", start, end);
        this.computerDestroyer = new Ship("computerDestroyer", start, end);

        placeComputerShips();
    }

    public BattleshipModel(
            Ship destroyer,
            Ship submarine,
            Ship cruiser,
            Ship battleship,
            Ship aircraftCarrier,
            Ship computerDestroyer,
            Ship computerSubmarine,
            Ship computerCruiser,
            Ship computerBattleship,
            Ship computerAircraftCarrier,
            ArrayList<CoordinatePair> playerHits,
            ArrayList<CoordinatePair> playerMisses,
            ArrayList<CoordinatePair> computerHits,
            ArrayList<CoordinatePair> computerMisses
    ) {
        this.destroyer = destroyer;
        this.submarine = submarine;
        this.cruiser = cruiser;
        this.battleship = battleship;
        this.aircraftCarrier = aircraftCarrier;
        this.computerDestroyer = computerDestroyer;
        this.computerSubmarine = computerSubmarine;
        this.computerCruiser = computerCruiser;
        this.computerBattleship = computerBattleship;
        this.computerAircraftCarrier = computerAircraftCarrier;

        this.playerHits = playerHits;
        this.playerMisses = playerMisses;
        this.computerHits = computerHits;
        this.computerMisses = computerMisses;
    }

    public void placeShip(String name, int down, int across, String orientation) {
        Ship selectedShip = this.getShip(name);

        if (!selectedShip.isPlaced()) {
            CoordinatePair start = new CoordinatePair(down, across);
            selectedShip.setStart(start);

            // Determine end position from start and orientation
            if (orientation.equals("vertical")) {
                CoordinatePair end = new CoordinatePair(down + selectedShip.getLength() - 1, across);
                selectedShip.setEnd(end);
            } else if (orientation.equals("horizontal")) {
                CoordinatePair end = new CoordinatePair(down, across + selectedShip.getLength() - 1);
                selectedShip.setEnd(end);
            }
        }

    }

    private void placeComputerShips() {
        this.placeShip("computerDestroyer", 1, 1, "vertical");
        this.placeShip("computerSubmarine", 7, 3, "horizontal");
        this.placeShip("computerCruiser", 6, 2, "horizontal");
        this.placeShip("computerBattleship", 3, 4, "vertical");
        this.placeShip("computerAircraftCarrier", 5, 5, "horizontal");

    }


    public void fireAt(CoordinatePair location) {

        int row = location.getAcross();
        int col = location.getDown();

        boolean outOfBounds = true;

        // Check to see if the coord is in bounds of the board(static 10 X 10)
        if (row < 11 && row > 0) {

            if (col < 11 && col > 0)

                outOfBounds = false;
        }

        // If the coord is good
        if (!outOfBounds) {

            // Check the coord against each ship

        }


    }

    private Ship getShip(String name) {
        Ship selectedShip = null;

        switch (name) {
            case "destroyer":
                selectedShip = this.destroyer;
                break;
            case "submarine":
                selectedShip = this.submarine;
                break;
            case "cruiser":
                selectedShip = this.cruiser;
                break;
            case "battleship":
                selectedShip = this.battleship;
                break;
            case "aircraftCarrier":
                selectedShip = this.aircraftCarrier;
                break;
            case "computerDestroyer":
                selectedShip = this.computerDestroyer;
                break;
            case "computerSubmarine":
                selectedShip = this.computerSubmarine;
                break;
            case "computerCruiser":
                selectedShip = this.computerCruiser;
                break;
            case "computerBattleship":
                selectedShip = this.computerBattleship;
                break;
            case "computerAircraftCarrier":
                selectedShip = this.computerAircraftCarrier;
                break;
        }

        return selectedShip;
    }



}
