package com.example;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.piros.injection.Injector;
import org.piros.api.services.ApiService;
import org.piros.data.services.DatabaseService;

@WebListener
public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        String scanPath = "com.example";
        
        Injector.init(scanPath);

        ApiService api = Injector.get(ApiService.class);
        
        api.scanControllers("org.piros", scanPath);

        DatabaseService ds = Injector.get(DatabaseService.class);

        ds.createDatabase(scanPath);

        System.out.println("-----------     CONTEXTO INICIALIZADO     --------------");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("ContextListener.contextDestroyed()");
    }

}
