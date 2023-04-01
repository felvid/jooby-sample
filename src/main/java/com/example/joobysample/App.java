package com.example.joobysample;

import io.jooby.Jooby;
import io.jooby.json.JacksonModule;

public class App {

    public static void main(final String[] args) {
        var productRepository = new ProductRepository();
        var productController = new ProductController(productRepository);
        Jooby.runApp(args, app -> {
            app.install(new JacksonModule());
            app.get("/", ctx -> "Service running.");
            productController.addRoutes(app);
        });
    }
}
