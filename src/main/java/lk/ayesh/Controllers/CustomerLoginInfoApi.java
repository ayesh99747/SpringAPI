package lk.ayesh.Controllers;

import lk.ayesh.Models.Customer;
import lk.ayesh.Models.LoginInfo;
import lk.ayesh.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This class is the customer login info api class
 *
 * @author Ayeshmantha Wijayagunathilaka (ID: 2018072)
 */

@Controller
@RequestMapping("/api/customers")
public class CustomerLoginInfoApi {
    @Autowired
    private CustomerRepository customerRepository;

    //This url is used if a new customer is to be added
    @RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost:4200")
    @ResponseBody
    public void addNewCustomer(@RequestBody Customer customer) {
        customerRepository.insert(customer);
        CustomerLoginInfoManager.addCustomerFromDatabase(customerRepository.findAll());
    }

    //This url is used to check if a username is unique and returns a boolean accordingly
    @RequestMapping(value = "isUsernamePresent", method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:4200")
    @ResponseBody
    public boolean isUsernamePresent(@RequestParam(value = "username", required = true) String username) {
        List<Customer> listOfCustomers = CustomerLoginInfoManager.getListOfCustomers();
        for (Customer c : listOfCustomers) {
            if (username.equals(c.getUsername())) {
                return true;
            }
        }
        return false;
    }


    @RequestMapping(value = "validateLogin", method = RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost:4200")
    @ResponseBody
    public boolean validateLoginInfo(@RequestBody LoginInfo loginInfo) {
        List<Customer> customers = CustomerLoginInfoManager.getListOfCustomers();
        for (Customer customer : customers) {
            if ((customer.getUsername().equals(loginInfo.getUsername()) && customer.getPassword().equals(loginInfo.getPassword())) || (customer.getEmailAddress().equals(loginInfo.getUsername()) && customer.getPassword().equals(loginInfo.getPassword()))) {
                return true;
            } else {
                continue;
            }
        }
        return false;
    }


}
