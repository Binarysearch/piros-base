package com.example;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.piros.injection.Injector;
import org.piros.injection.ControllerManager;
import org.piros.services.MessageProcessorService;
import org.piros.services.RequestProcessorService;
import org.piros.services.db.DatabaseService;

@WebListener
public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        String scanPath = "com.example";
        
        Injector.init(scanPath);

        RequestProcessorService rpService = Injector.get(RequestProcessorService.class);
        MessageProcessorService mpService = Injector.get(MessageProcessorService.class);
        
        ControllerManager.scanControllers("org.piros", rpService);
        ControllerManager.scanWsControllers(scanPath, mpService);
        ControllerManager.scanControllers(scanPath, rpService);

        DatabaseService ds = Injector.get(DatabaseService.class);

        ds.createDatabase(scanPath);

        System.out.println("-----------     CONTEXTO INICIALIZADO     --------------");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("ContextListener.contextDestroyed()");
    }

}
