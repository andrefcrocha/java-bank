package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.persistence.dao.jpa.GenericJpaDao;
import org.academiadecodigo.javabank.services.CustomerService;
import org.academiadecodigo.javabank.services.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ControllerServlet{

    @Autowired
    private CustomerService customerService;

        @RequestMapping(method = RequestMethod.GET, value = "/")
        public String sayMyName(Model model) {

            List<Customer> customers = customerService.getCustomers();

            model.addAttribute("customers",customers);
            return "index";
        }

    }

