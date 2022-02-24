package application.routes;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;

public class Route {

    public static void run() {
        get("/index", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return render(model, "index.html");
        });
        get("/result", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return render(model, "result.html");
        });
        get("/show", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return render(model, "show.html");
        });
    }

    private static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
