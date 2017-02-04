package edu.oregonstate.cs361.battleship;

import com.google.gson.Gson;

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
    public CoordinatePair[] playerHits = {};
    public CoordinatePair[] playerMisses = {};
    public CoordinatePair[] computerHits = {};
    public CoordinatePair[] computerMisses = {};


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
            CoordinatePair[] playerHits,
            CoordinatePair[] playerMisses,
            CoordinatePair[] computerHits,
            CoordinatePair[] computerMisses
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
        Gson gson = new Gson();
        System.out.println("Initial Ship:");
        System.out.println(selectedShip);
        System.out.println(gson.toJson(selectedShip));

        if(!selectedShip.isPlaced()) {
            System.out.println("Placing Ship...");
            System.out.println(down);
            System.out.println(across);
            System.out.println(orientation);
            // Set start position
            selectedShip.setStart(down, across);

            // Determine end position from start and orientation
            if (orientation.equals("vertical")) {
                System.out.println("Setting end 1");
                selectedShip.setEnd(down + selectedShip.getLength() - 1, across);
            } else if (orientation.equals("horizontal")) {
                System.out.println("setting end 2");
                selectedShip.setEnd(down, across + selectedShip.getLength() - 1);
            }
        }

        System.out.println(gson.toJson(selectedShip));

    }

    private Ship getShip(String name) {
        Ship selectedShip = null;

        switch(name) {
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

