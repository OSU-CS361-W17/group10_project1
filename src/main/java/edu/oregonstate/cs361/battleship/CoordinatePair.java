package edu.oregonstate.cs361.battleship;

/**
 * Created by brandon on 2/3/2017.
 */
public class CoordinatePair {
    int xCoordinate;        //self explanatory variables
    int yCoordinate;

    //setters
    public void setxCoordinate(int x){
        this.xCoordinate = x;
    }
    public void setyCoordinate(int y){
        this.yCoordinate = y;
    }
    //getters
    public int getxCoordinate(){
        return xCoordinate;
    }
    public int getyCoordinate(){
        return yCoordinate;
    }

    //constructor
    public CoordinatePair(int x, int y){
        setxCoordinate(x);
        setyCoordinate(y);
    }
    //default constructor
    public CoordinatePair(){
        setxCoordinate(0);
        setyCoordinate(0);
    }

}
