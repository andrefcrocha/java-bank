package org.academiadecodigo.javabank.controller.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.academiadecodigo.javabank.command.CustomerForm;
import org.academiadecodigo.javabank.converters.CustomerFormToCustomer;
import org.academiadecodigo.javabank.converters.CustomerToCustomerForm;
import org.academiadecodigo.javabank.model.Customer;
import org.academiadecodigo.javabank.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class restCustomerController {

    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerFormToCustomer customerFormToCustomer;

    @Autowired
    private CustomerToCustomerForm customerToCustomerForm;

    @RequestMapping(method = RequestMethod.GET, path = {"/list", "/", ""})
    public ResponseEntity<List<CustomerForm>> listCustomers() {
        List<Customer> customers = customerService.list();
        if (customers == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        List<CustomerForm> customerForms = new ArrayList<>();
        for (Customer customer : customers) {

            customerForms.add( customerToCustomerForm.convert(customer));
        }
        return new ResponseEntity<>(customerForms, HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.GET, path = "/add")
    public ResponseEntity addCustomer(@Valid @RequestBody CustomerForm customerForm, BindingResult bindingResult) {
        CustomerForm customerForm1 = new CustomerForm();
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(customerFormToCustomer.convert(customerForm1), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/edit/{id}")
    public ResponseEntity editCustomer(@PathVariable Integer id) {

        if (id == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(customerToCustomerForm.convert(customerService.get(id)), HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<CustomerForm> showCustomer(@PathVariable Integer id) {
        Customer customer = customerService.get(id);

        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(customerToCustomerForm.convert(customer), HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.POST, path = {"/", ""})
    public String saveCustomer(@Valid @ModelAttribute("customer") CustomerForm customerForm, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            return "customer/add-update";
        }

        Customer savedCustomer = customerService.save(customerFormToCustomer.convert(customerForm));

        redirectAttributes.addFlashAttribute("lastAction", "Saved " + savedCustomer.getFirstName() + " " + savedCustomer.getLastName());
        return "redirect:/customer/";

    }

    @RequestMapping(method = RequestMethod.GET, path = "/delete/{id}")
    public ResponseEntity deleteCustomer(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        Customer customer = customerService.get(id);
        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        customerService.delete(id);
        redirectAttributes.addFlashAttribute("lastAction", "Deleted " + customer.getFirstName() + " " + customer.getLastName());
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @ExceptionHandler(Exception.class)
    public void handleAllException(Exception ex) {
        ex.printStackTrace();
    }
}


