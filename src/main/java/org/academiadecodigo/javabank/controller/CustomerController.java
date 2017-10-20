package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.persistence.dao.jpa.GenericJpaDao;
import org.academiadecodigo.javabank.services.AccountService;
import org.academiadecodigo.javabank.services.CustomerService;
import org.academiadecodigo.javabank.services.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

        @RequestMapping(method = RequestMethod.GET, value = "/")
        public String sayMyName(Model model) {

            List<Customer> customers = customerService.getCustomers();

            model.addAttribute("customers",customers);
            return "index";
        }

                @RequestMapping(method = RequestMethod.GET, value = "/customer-info/{id}")
        public String showCustomer(@PathVariable Integer id, Model model){

            Customer customerInfo = customerService.findById(id);
            model.addAttribute("customerInfo", customerInfo);

            List<Account> accounts = customerService.findById(id).getAccounts();
            model.addAttribute("accounts", accounts);

            return "customer-info";
        }

        @RequestMapping(method = RequestMethod.GET, value = "/{id}/delete")
        public String deleteCustomer(@PathVariable Integer id,Model model){
                        customerService.deleteCustomer(id);
                        List<Customer> customers = customerService.getCustomers();
                        model.addAttribute("customers",customers);
                        return "index";
        }
    }

