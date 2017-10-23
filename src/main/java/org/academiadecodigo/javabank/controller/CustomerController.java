package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.model.CustomerDTO;
import org.academiadecodigo.javabank.model.account.Account;
import org.academiadecodigo.javabank.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private ConvertDTO convertDTO;


    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String listCustomers(Model model) {

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
    public String deleteCustomer(@PathVariable Integer id, Model model, RedirectAttributes redirectAttributes){
        customerService.deleteCustomer(id);

        redirectAttributes.addFlashAttribute("deleteTrue", "Customer deleted successfully!");

        return "redirect:/";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/customer-edit/{id}")
    public String editCustomer(@PathVariable Integer id, Model model){

        Customer customer = customerService.findById(id);
        model.addAttribute("customer", customer);

        return "customer-edit";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/save")
    public String postCustomer(@Valid @ModelAttribute("customer") CustomerDTO customerDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){


        if (bindingResult.hasErrors()) {
            return "customer-edit";
        }

        Customer customer = convertDTO.dtotoCustomer(customerDTO);
        customerService.saveCustomer(customer);
        redirectAttributes.addFlashAttribute("addTrue", "Updated customer successfully!");
        return "redirect:/";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/customer-create")
    public String addCustomer(Model model){
        model.addAttribute("customer", new Customer());
        return "customer-edit";

    }




}

