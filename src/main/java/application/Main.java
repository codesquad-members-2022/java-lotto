package application;

import application.routes.Route;

import static spark.Spark.*;

public class Main {

    public static void main(String[] args) {
        Route route = new Route();

        port(8080);
        route.run();
    }
}
