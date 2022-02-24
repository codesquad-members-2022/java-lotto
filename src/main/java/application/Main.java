package application;

import application.routes.Route;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class Main {

    public static void main(String[] args) {

        Route route = new Route();

        port(8080);
        route.run();
    }
}
