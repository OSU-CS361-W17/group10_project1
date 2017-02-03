package edu.oregonstate.cs361.battleship;



/**
 * Created by brandon on 2/3/2017.
 */


//Class data for all battleships
public class Battleship {

    private CoordinatePair initial; //starting coordinate for battleship, either left or top
    private CoordinatePair terminal; //ending coordinate for battleship, either right or bottom
    private String shipName;            //type of ship (ie Cruiser, Carrier, etc)
    private int shipLength;           //length of ship (number of spaces it occupies)
    private char orientation;           // 'H' for horizontal || 'V' for vertical

    //setters
    public void setShipName(String x){
        this.shipName = x;
    }
    public void setShipLength(int x){
        this.shipLength = x;
    }
    public void setInitial(int x, int y){
        this.initial = new CoordinatePair(x,y);
    }
    public void setTerminal(int x, int y){
        this.terminal = new CoordinatePair(x,y);
    }
    public void setOrientation(char x) {
        this.orientation = x;
    }

    //getter functions

    public String getShipName(){
        return shipName;
    }
    public int getShipLength(){
        return shipLength;
    }
    public CoordinatePair getInitial(){
        return initial;
    }
    public CoordinatePair getTerminal(){
        return terminal;
    }
    public char getOrientation(){
        return orientation;
    }


    //constructor
    public Battleship(String name, int x, int y, int i, int j){
        setShipName(name); //set the name which will then be used to determine ship length
        if (shipName.contains("Destroyer") || (shipName.contains("destroyer"))){
            setShipLength(2);
        }
        //Cruiser and Sub are same length. One long ugly or statement below
        else if (shipName.contains("Submarine") || shipName.contains("Cruiser") || shipName.contains("submarine") || shipName.contains("cruiser")){
            setShipLength(3);
        }
        else if (shipName.contains("Battleship") || shipName.contains("battleship")){
            setShipLength(4);
        }
        //using contains since name contains space and probably more prone to error
        else if (shipName.contains("Aircraft") || shipName.contains("aircraft")){
            setShipLength(5);
        }
        setInitial (x, y);
        setTerminal (i, j);

    }
    //default constructor
    public Battleship(){
        shipName="Boaty McBoatFace";
        shipLength=0;
        setInitial(0,0);
        setTerminal(0,0);
        setOrientation('V');
    }

    //no destructor in java because IT IS A TRASH TIER LANGUAGE
    //Removed dynamic allocation, so hopefully it won't be an issue


}
