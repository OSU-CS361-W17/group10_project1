package edu.oregonstate.cs361.battleship;

public class BattleshipModel {

    //declaring player variables for various battleships
    public Ship aircraftCarrier;
    public Ship battleship;
    public Ship cruiser;
    public Ship submarine;
    public Ship destroyer;
    //declaring CPU variables for various battleships
    public Ship CPUaircraftCarrier;
    public Ship CPUbattleship;
    public Ship CPUcruiser;
    public Ship CPUsubmarine;
    public Ship CPUdestroyer;




    public BattleshipModel() {  //creates all relevant ships for game
        aircraftCarrier = new Ship("Aircraft Carrier",0,0,0,0);
        battleship = new Ship("Ship",0,0,0,0);
        cruiser= new Ship("Cruiser",0,0,0,0);
        submarine= new Ship("Submarine",0,0,0,0);
        destroyer= new Ship("Destroyer",0,0,0,0);
        CPUaircraftCarrier = new Ship("CPU_Aircraft Carrier",0,0,0,0);
        CPUbattleship= new Ship("CPU_Ship",0,0,0,0);
        CPUcruiser= new Ship("CPU_Cruiser",0,0,0,0);
        CPUsubmarine= new Ship("CPU_Submarine",0,0,0,0);
        CPUdestroyer= new Ship("CPU_Destroyer",0,0,0,0);
    }



}

