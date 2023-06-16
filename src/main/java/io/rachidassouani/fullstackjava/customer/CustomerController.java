package io.rachidassouani.fullstackjava.customer;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> findAllCustomers() {
        return customerService.findAllCustomers();
    }

    @GetMapping("{customerId}")
    public Customer findCustomerById(@PathVariable("customerId") Long customerId) {
        return customerService.findCustomerById(customerId);
    }

    @PostMapping
    public void registerCustomer(@RequestBody CustomerRegistrationRequest registrationRequest) {
        customerService.saveCustomer(registrationRequest);
    }
}