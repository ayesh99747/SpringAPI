package lk.ayesh.Controllers;

import lk.ayesh.Models.LoginInfo;
import lk.ayesh.Models.Manager;
import lk.ayesh.Repositories.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This class is the manager login info class
 *
 * @author Ayeshmantha Wijayagunathilaka (ID: 2018072)
 */

@Controller
@RequestMapping("/api/managers")
public class ManagerLoginInfoApi {

    @Autowired
    ConsoleMenu consoleMenu;
    @Autowired
    private ManagerRepository managerRepository;

    //This url is used to validate a manager login
    @RequestMapping(value = "/validateLogin", method = RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost:4200")
    @ResponseBody
    public boolean validateLoginInfo(@RequestBody LoginInfo loginInfo) {
        List<Manager> managers = ManagerLoginInfoManager.getListOfManagers();
        for (Manager manager : managers) {
            if (manager.getUsername().equals(loginInfo.getUsername()) && manager.getPassword().equals(loginInfo.getPassword())) {
                return true;
            } else {
                continue;
            }
        }
        return false;
    }

    //This url is used when adding a new manager
    @RequestMapping(value = "/addManager", method = RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost:4200")
    @ResponseBody
    public void addNewManager(@RequestBody Manager manager) {
        managerRepository.insert(manager);
        ManagerLoginInfoManager.addManagersFromDatabase(managerRepository.findAll());
    }

    //This url is used to check if a username is unique
    @RequestMapping(value = "/isUsernamePresent", method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:4200")
    @ResponseBody
    public boolean isUsernamePresent(@RequestParam(value = "username", required = true) String username) {
        List<Manager> listOfManagers = ManagerLoginInfoManager.getListOfManagers();
        for (Manager m : listOfManagers) {
            if (username.equals(m.getUsername())) {
                return true;
            }
        }
        return false;
    }

    //This url is used when launching the console
    @GetMapping("/console")
    @ResponseBody
    @CrossOrigin(origins = "http://localhost:4200")
    public String startConsole() {
        System.out.println("Starting console...");
        consoleMenu.run();
        return "Console Started";
    }
}
