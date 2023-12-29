package com.joseph.service;

import java.util.List;

import com.joseph.entity.Customer;
// import com.joseph..exception.ResourceNotFoundException;

public interface CustomerService {

    public List<Customer> getCustomers();

    void addCustomer(Customer customer);

    public Customer getCustomerById(int customerId);

    public void saveCustomer(Customer customer);

    void deleteCustomer(int customerId);
}