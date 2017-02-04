package edu.oregonstate.cs361.battleship;

public class CoordinatePair {
    public int across;
    public int down;

    // setters
    public void setAcross(int across){
        this.across = across;
    }
    public void setDown(int down){
        this.down = down;
    }

    // getters
    public int getAcross(){
        return this.across;
    }
    public int getDown(){
        return this.down;
    }

    // constructor
    public CoordinatePair(int across, int down) {
        if(across > 10 || down > 10) {
            throw new IllegalArgumentException("Placement coordinates cannot exceed board size.");
        }
        this.across = across;
        this.down = down;
    }

    // default constructor
    public CoordinatePair() {
        this.across = 0;
        this.down = 0;
    }

}
