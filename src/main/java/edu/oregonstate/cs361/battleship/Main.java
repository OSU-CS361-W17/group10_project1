package edu.oregonstate.cs361.battleship;

import com.google.gson.Gson;
import spark.Request;
import spark.Response;
import spark.Spark;

import static spark.Spark.*;

public class Main {


    public static void main(String[] args) {
        Spark.exception(Exception.class, (exception, request, response) -> {
            exception.printStackTrace();
        });
        //This will allow us to server the static pages such as index.html, app.js, etc.
        staticFiles.location("/public");

        //This will listen to GET requests to /model and return a clean new model
        get("/model", (req, res) -> newModel());
        //This will listen to POST requests and expects to receive a game model, as well as location to fire to
        post("/fire/:row/:col", (req, res) -> fireAt(req));
        //This will listen to POST requests and expects to receive a game model, as well as location to place the ship
        post("/placeShip/:ship/:row/:col/:orientation", (req, res) -> placeShip(req, res));
    }

    //This function should return a new model
    static String newModel() {
        BattleshipModel model = new BattleshipModel();
        return modelToJSON(model);
    }

    //This function should accept an HTTP request and deseralize it into an actual Java object.
    private static BattleshipModel getModelFromReq(Request req){
        Gson gson = new Gson();
        BattleshipModel model = gson.fromJson(req.body(), BattleshipModel.class);
        return model;
    }

    private static String modelToJSON(BattleshipModel model) {
        Gson gson = new Gson();
        return gson.toJson(model);
    }

    //This controller should take a json object from the front end, and place the ship as requested, and then return the object.
    private static String placeShip(Request req, Response res) {
        BattleshipModel model = getModelFromReq(req);

        String shipName = req.params(":ship");
        int row = Integer.parseInt(req.params(":row"));
        int col = Integer.parseInt(req.params(":col"));
        String orientation = req.params(":orientation");

        model.placeShip(shipName, row, col, orientation);
        return modelToJSON(model);
    }

    //Similar to placeShip, but with firing.
    private static String fireAt(Request req) {

        BattleshipModel model = getModelFromReq(req);

        CoordinatePair target = new CoordinatePair();

        target.setAcross(Integer.parseInt(req.params(":row")));
        target.setDown(Integer.parseInt(req.params(":col")));

        model.fireAt(target);

        return modelToJSON(model);
    }

}