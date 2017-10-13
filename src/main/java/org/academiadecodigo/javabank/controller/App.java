package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.controller.controller.LoginController;
import org.academiadecodigo.javabank.controller.persistence.Config;
import org.academiadecodigo.javabank.controller.persistence.H2WebServer;
import org.academiadecodigo.javabank.controller.services.AuthServiceImpl;
import org.academiadecodigo.javabank.controller.services.AccountServiceImpl;
import org.academiadecodigo.javabank.controller.services.CustomerServiceImpl;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.SQLException;

public class App {

    public static void main(String[] args) {

      try {
          H2WebServer h2WebServer = new H2WebServer();
          Config config = new Config();
          h2WebServer.start();

          EntityManagerFactory emf = Persistence.createEntityManagerFactory(config.PERSISTENCE_UNIT);

          App app = new App();
          app.bootStrap();

          emf.close();
          h2WebServer.stop();
      }catch (SQLException ex){
          ex.printStackTrace();
      }

    }

      private void bootStrap() {

        Bootstrap bootstrap = new Bootstrap();
        bootstrap.setAuthService(new AuthServiceImpl());
        bootstrap.setAccountService(new AccountServiceImpl());
        bootstrap.setCustomerService(new CustomerServiceImpl());
        bootstrap.loadCustomers();

        LoginController loginController = bootstrap.wireObjects();

        // start application
        loginController.init();

    }
}
