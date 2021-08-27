package com.springMVChibernateCRUD.demoproject.controller;

import com.springMVChibernateCRUD.demoproject.dao.CustomerDAOImpl;
import com.springMVChibernateCRUD.demoproject.dao.ICustomerDAO;
import com.springMVChibernateCRUD.demoproject.entity.Customer;
import com.springMVChibernateCRUD.demoproject.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    //need to inject the customer DAO
    @Autowired
    private ICustomerService customerService;

    @GetMapping("/list")
    public String listCustomers(Model theModel){
        //get customers from the DAO
        List<Customer> customerList = customerService.getCustomers();

        //add the customers to the model
        theModel.addAttribute("customers",customerList);

        return "list-customers";
    }

    @GetMapping("/showFormForAdd")
    public String addCustomer(Model theModel){
        //create model attribute to bind form data
        Customer theCustomer = new Customer();
        theModel.addAttribute("customer",theCustomer);

        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer){

        //save the customer using our service
        customerService.saveCustomer(theCustomer);

        return "redirect:/customer/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel){
        //get the customer from the service
        Customer theCustomer=customerService.getCustomer(theId);

        //set customer as a model attribute to pre-populate the form
        theModel.addAttribute("customer",theCustomer);

        //send over to our form
        return "customer-form";
    }
    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId") int theId){
        customerService.deleteCustomer(theId);

        return "redirect:/customer/list";
    }
}
