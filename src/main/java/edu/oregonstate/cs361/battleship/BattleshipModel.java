package edu.oregonstate.cs361.battleship;

/**
 * Created by michaelhilton on 1/26/17.
 */
public class BattleshipModel {

    //declaring player variables for various battleships
    private Battleship aircraftCarrier;
    private Battleship battleship;
    private Battleship cruiser;
    private Battleship submarine;
    private Battleship destroyer;
    //declaring CPU variables for various battleships
    private Battleship CPUaircraftCarrier;
    private Battleship CPUbattleship;
    private Battleship CPUcruiser;
    private Battleship CPUsubmarine;
    private Battleship CPUdestroyer;




    public BattleshipModel(){  //creates all relevant ships for game
     aircraftCarrier = new Battleship("Aircraft Carrier",0,0,0,0);
     battleship = new Battleship("Battleship",0,0,0,0);
     cruiser= new Battleship("Cruiser",0,0,0,0);
     submarine= new Battleship("Submarine",0,0,0,0);
     destroyer= new Battleship("Destroyer",0,0,0,0);
     CPUaircraftCarrier = new Battleship("CPU_Aircraft Carrier",0,0,0,0);
     CPUbattleship= new Battleship("CPU_Battleship",0,0,0,0);
     CPUcruiser= new Battleship("CPU_Cruiser",0,0,0,0);
     CPUsubmarine= new Battleship("CPU_Submarine",0,0,0,0);
     CPUdestroyer= new Battleship("CPU_Destroyer",0,0,0,0);


    }



}

