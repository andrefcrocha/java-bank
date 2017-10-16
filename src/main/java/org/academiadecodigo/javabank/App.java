package org.academiadecodigo.javabank;

import org.academiadecodigo.javabank.controller.Controller;
import org.academiadecodigo.javabank.persistence.manager.JpaSessionManager;
import org.academiadecodigo.javabank.persistence.manager.JpaTransactionManager;
import org.academiadecodigo.javabank.persistence.manager.SessionManager;
import org.academiadecodigo.javabank.persistence.H2WebServer;
import org.academiadecodigo.javabank.services.jpa.JpaAccountService;
import org.academiadecodigo.javabank.services.jpa.JpaCustomerService;
import org.academiadecodigo.javabank.services.AuthServiceImpl;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.SQLException;

public class App {

    public static void main(String[] args) {

        try {


            H2WebServer h2WebServer = new H2WebServer();
            h2WebServer.start();

            EntityManagerFactory emf = Persistence.createEntityManagerFactory(Config.PERSISTENCE_UNIT);

            App app = new App();
            app.bootStrap(emf);

            emf.close();
            h2WebServer.stop();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void bootStrap(EntityManagerFactory emf) {

        Bootstrap bootstrap = new Bootstrap();
        SessionManager sm = new JpaSessionManager(emf);

        bootstrap.setAuthService(new AuthServiceImpl());
        bootstrap.setAccountService(new JpaAccountService(emf));
        bootstrap.setCustomerService(new JpaCustomerService(emf));
        bootstrap.setSessionManager(sm);
        bootstrap.setTransactionManager(new JpaTransactionManager(sm));


        Controller controller = bootstrap.wireObjects();

        // start application
        controller.init();

    }
}
