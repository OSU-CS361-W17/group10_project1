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
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static spark.Spark.awaitInitialization;


class MainTest {

    @BeforeAll
    public static void beforeClass() {
        Main.main(null);
        awaitInitialization();
    }

    @AfterAll
    public static void afterClass() {
        Spark.stop();
    }

    @Test
    public void testGetModel() {
        TestResponse res = request("GET", "/model", null);
        assertEquals(200, res.status);
        assertEquals("{\"destroyer\":{\"start\":{\"across\":0,\"down\":0},\"end\":{\"across\":0,\"down\":0},\"name\":\"destroyer\",\"length\":2},\"submarine\":{\"start\":{\"across\":0,\"down\":0},\"end\":{\"across\":0,\"down\":0},\"name\":\"submarine\",\"length\":3},\"cruiser\":{\"start\":{\"across\":0,\"down\":0},\"end\":{\"across\":0,\"down\":0},\"name\":\"cruiser\",\"length\":3},\"battleship\":{\"start\":{\"across\":0,\"down\":0},\"end\":{\"across\":0,\"down\":0},\"name\":\"battleship\",\"length\":4},\"aircraftCarrier\":{\"start\":{\"across\":0,\"down\":0},\"end\":{\"across\":0,\"down\":0},\"name\":\"aircraftCarrier\",\"length\":5},\"computerDestroyer\":{\"start\":{\"across\":1,\"down\":1},\"end\":{\"across\":2,\"down\":1},\"name\":\"computerDestroyer\",\"length\":2},\"computerSubmarine\":{\"start\":{\"across\":7,\"down\":3},\"end\":{\"across\":7,\"down\":5},\"name\":\"computerSubmarine\",\"length\":3},\"computerCruiser\":{\"start\":{\"across\":6,\"down\":2},\"end\":{\"across\":6,\"down\":4},\"name\":\"computerCruiser\",\"length\":3},\"computerBattleship\":{\"start\":{\"across\":3,\"down\":4},\"end\":{\"across\":6,\"down\":4},\"name\":\"computerBattleship\",\"length\":4},\"computerAircraftCarrier\":{\"start\":{\"across\":5,\"down\":5},\"end\":{\"across\":5,\"down\":9},\"name\":\"computerAircraftCarrier\",\"length\":5},\"playerHits\":[],\"playerMisses\":[],\"computerHits\":[],\"computerMisses\":[]}",res.body);
    }

    @Test
    public void testPlaceShip() {
        Gson gson = new Gson();
        String model = gson.toJson(new BattleshipModel());
        TestResponse res = request("POST", "/placeShip/aircraftCarrier/1/1/horizontal", model);

        assertEquals(200, res.status);
        assertEquals("{\"destroyer\":{\"start\":{\"across\":0,\"down\":0},\"end\":{\"across\":0,\"down\":0},\"name\":\"destroyer\",\"length\":2},\"submarine\":{\"start\":{\"across\":0,\"down\":0},\"end\":{\"across\":0,\"down\":0},\"name\":\"submarine\",\"length\":3},\"cruiser\":{\"start\":{\"across\":0,\"down\":0},\"end\":{\"across\":0,\"down\":0},\"name\":\"cruiser\",\"length\":3},\"battleship\":{\"start\":{\"across\":0,\"down\":0},\"end\":{\"across\":0,\"down\":0},\"name\":\"battleship\",\"length\":4},\"aircraftCarrier\":{\"start\":{\"across\":1,\"down\":1},\"end\":{\"across\":1,\"down\":5},\"name\":\"aircraftCarrier\",\"length\":5},\"computerDestroyer\":{\"start\":{\"across\":1,\"down\":1},\"end\":{\"across\":2,\"down\":1},\"name\":\"computerDestroyer\",\"length\":2},\"computerSubmarine\":{\"start\":{\"across\":7,\"down\":3},\"end\":{\"across\":7,\"down\":5},\"name\":\"computerSubmarine\",\"length\":3},\"computerCruiser\":{\"start\":{\"across\":6,\"down\":2},\"end\":{\"across\":6,\"down\":4},\"name\":\"computerCruiser\",\"length\":3},\"computerBattleship\":{\"start\":{\"across\":3,\"down\":4},\"end\":{\"across\":6,\"down\":4},\"name\":\"computerBattleship\",\"length\":4},\"computerAircraftCarrier\":{\"start\":{\"across\":5,\"down\":5},\"end\":{\"across\":5,\"down\":9},\"name\":\"computerAircraftCarrier\",\"length\":5},\"playerHits\":[],\"playerMisses\":[],\"computerHits\":[],\"computerMisses\":[]}", res.body);
    }

    private TestResponse request(String method, String path, String body) {
        try {
            URL url = new URL("http://localhost:4567" + path);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(method);
            connection.setDoOutput(true);
            if(body != null) {
                byte[] bodyBytes = body.getBytes("UTF-8");
                connection.getOutputStream().write(bodyBytes);
            }
            connection.connect();
            String responseBody = IOUtils.toString(connection.getInputStream());
            return new TestResponse(connection.getResponseCode(), responseBody);
        } catch (IOException e) {
            e.printStackTrace();
            fail("Sending request failed: " + e.getMessage());
            return null;
        }
    }

    private static class TestResponse {

        public final String body;
        public final int status;

        public TestResponse(int status, String body) {
            this.status = status;
            this.body = body;
        }

        public Map<String,String> json() {
            return new Gson().fromJson(body, HashMap.class);
        }
    }


}