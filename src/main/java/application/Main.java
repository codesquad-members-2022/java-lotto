package application;

import java.util.Map;

import static spark.Spark.*;

public class Main {

    public static void main(String[] args) {
//        GameController gameController = new GameController();
//        gameController.run();

        port(8080);
        get("/hello-world", (req, res) -> {
            return "Hello, world!";
        });

    }


}
