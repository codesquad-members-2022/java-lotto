import spark.ModelAndView;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

import spark.template.handlebars.HandlebarsTemplateEngine;

public class SparkTest {
    public static void main(String[] args) {
        String path = System.getProperty("user.dir");
        System.out.println(path);

        port(8080);
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

    public static String render(Map<String, Object> model, String templatePath) {
        return new HandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
