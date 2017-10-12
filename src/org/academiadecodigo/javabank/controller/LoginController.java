package org.academiadecodigo.javabank.controller;

<<<<<<< HEAD
import org.academiadecodigo.javabank.model.service.CustomerService;

=======
>>>>>>> bfad24a2754f00d2ae3eeb9f386c883238ddc5ae
public class LoginController extends AbstractController {

    private Controller nextController;

<<<<<<< HEAD
    private CustomerService customerService;

    public void onLogin(int id) {
        customerService.setLoginCustomer(id);
        nextController.init();
=======
    public void onLogin(int id) {

        if (authService.authenticate(id)) {
            nextController.init();
            return;
        }

        init();

>>>>>>> bfad24a2754f00d2ae3eeb9f386c883238ddc5ae
    }

    public void setNextController(Controller nextController) {
        this.nextController = nextController;
    }

<<<<<<< HEAD
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }
=======
>>>>>>> bfad24a2754f00d2ae3eeb9f386c883238ddc5ae
}
