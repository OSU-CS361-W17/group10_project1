package edu.oregonstate.cs361.battleship;

//Class data for all battleships
public class Ship {
    private CoordinatePair start;  // starting coordinate for battleship, either left or top
    private CoordinatePair end;    // ending coordinate for battleship, either right or bottom
    private String name;           // type of ship (ie Cruiser, Carrier, etc)
    private int length;            // length of ship (number of spaces it occupies)

    // setters
    public void setName(String x){
        this.name = x;
    }
    public void setLength(int x){
        this.length = x;
    }
    public void setStart(int x, int y){
        this.start = new CoordinatePair(x,y);
    }
    public void setStart(CoordinatePair start) { this.start = start; }
    public void setEnd(int x, int y){
        this.end = new CoordinatePair(x,y);
    }
    public void setEnd(CoordinatePair end) { this.end = end; }

    // getters
    public String getName(){
        return this.name;
    }
    public int getLength(){
        return this.length;
    }
    public CoordinatePair getStart(){
        return this.start;
    }
    public CoordinatePair getEnd(){
        return this.end;
    }


    public Ship(String name) {
        // Set ship type
        this.name = name;

        // Determine ship length
        switch(name) {
            case "destroyer":
            case "computerDestroyer":
                this.length = 2;
                break;
            case "submarine":
            case "computerSubmarine":
                this.length = 3;
                break;
            case "cruiser":
            case "computerCruiser":
                this.length = 3;
                break;
            case "battleship":
            case "computerBattleship":
                this.length = 4;
                break;
            case "aircraftCarrier":
            case "computerAircraftCarrier":
                this.length = 5;
                break;
        }
    }

    public Ship(String name, CoordinatePair start, String orientation) {
        // Set name and type
        this(name);

        // Set start position
        this.start = start;

        // Determine end position from start and orientation
        if (orientation == "vertical") {
            this.end = new CoordinatePair(start.across, start.down + this.length -1);
        } else if (orientation == "horizontal") {
            this.end = new CoordinatePair(start.across + this.length -1, start.down);
        }
    }

    public Ship(String name, CoordinatePair start, CoordinatePair end) {
        // Set name and length
        this(name);

        // Set start and end positions
        this.start = start;
        this.end = end;
    }

    public Boolean isPlaced() {
        CoordinatePair start = this.start;
        CoordinatePair end = this.end;

        return !(start.across == 0 && start.down == 0 && end.across == 0 && end.down == 0);
    }

    public Boolean containsCoord(CoordinatePair location) {

        // If the incoming coordinate is within the ship's taken up coordinates

        if(location.down >= this.start.down
                && location.down <= this.end.down
                && location.across >= this.start.across
                && location.across <= this.end.across)
            return true;

        else
            return false;

    }

}
