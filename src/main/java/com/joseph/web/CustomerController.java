package com.joseph.web;

import java.util.List;

import com.joseph.entity.Article;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.joseph.entity.Customer;
// import com.joseph.exception.ResourceNotFoundException;
import com.joseph.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private static final Logger LOG = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String showCustomerList(Model theModel) {
        List<Customer> customers = customerService.getCustomers();
        theModel.addAttribute("customers", customers);
        return "customer-form";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer-add";
    }

    @PostMapping("/add")
    public String addCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.addCustomer(customer);
        return "redirect:/customer/list";
    }

    @GetMapping("/EditCustomer")
    public String showEditCustomerForm(@RequestParam("id") int customerId, Model model) {
        Customer customer = customerService.getCustomerById(customerId);
        model.addAttribute("customer", customer);
        return "custmer-edit";
    }

    @PostMapping("/EditCustomer")
    public String processEditCustomerForm(@ModelAttribute("customer") Customer editedCustomer) {
        customerService.saveCustomer(editedCustomer);
        return "redirect:/customer/list";
    }


    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("id") int customerId) {
        customerService.deleteCustomer(customerId);
        return "redirect:/customer/list";
    }
}