package lk.ayesh.demo.Controller;

import lk.ayesh.demo.Model.Customer;
import lk.ayesh.demo.Model.LoginInfo;
import lk.ayesh.demo.Model.Manager;
import lk.ayesh.demo.Repository.CustomerRepository;
import lk.ayesh.demo.Repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/customers")
public class CustomerLoginInfoApi {
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("")
    @CrossOrigin(origins = "http://localhost:4200")
    @ResponseBody
    public List<Customer> allCustomers() {
        return CustomerLoginInfoManager.getListOfCustomers();
    }

    @RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost:4200")
    @ResponseBody
    public void addNewCustomer(@RequestBody Customer customer) {
        customerRepository.insert(customer);
        CustomerLoginInfoManager.addCustomerFromDatabase(customerRepository.findAll());
    }

    @RequestMapping(value = "isUsernamePresent", method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:4200")
    @ResponseBody
    public boolean isUsernamePresent(@RequestParam(value="username", required=true) String username) {
        List<Customer> listOfCustomers = CustomerLoginInfoManager.getListOfCustomers();
        for (Customer c:listOfCustomers) {
            if (username.equals(c.getUsername())){
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
