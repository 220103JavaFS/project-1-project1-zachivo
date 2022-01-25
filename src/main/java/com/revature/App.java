package com.revature;

import com.revature.controllers.Controller;
import com.revature.controllers.LoginController;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

public class App {

    private static Javalin app;

    public static void main(String[] args) {
        app = Javalin.create((config)->{
            config.addStaticFiles("C:\\Users\\zbyrs\\Desktop\\Project1\\HelloProject1",
                    Location.EXTERNAL);
        });
        configure(new LoginController());
        app.start();
    }

    private static void configure(Controller... controllers){
        for(Controller c: controllers){
            c.addRoutes(app);
        }
    }
}
