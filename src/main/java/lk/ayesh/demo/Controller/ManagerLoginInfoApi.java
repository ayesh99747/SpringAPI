package lk.ayesh.demo.Controller;

import lk.ayesh.demo.Model.LoginInfo;
import lk.ayesh.demo.Model.Manager;
import lk.ayesh.demo.Repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/managers")
public class ManagerLoginInfoApi {

    @Autowired
    private ManagerRepository managerRepository;

    @GetMapping("")
    @CrossOrigin(origins = "http://localhost:4200")
    @ResponseBody
    public List<Manager> allManagers() {
        return ManagerLoginInfoManager.getListOfManagers();
    }


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

    @RequestMapping(value = "/addManager", method = RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost:4200")
    @ResponseBody
    public void addNewManager(@RequestBody Manager manager) {
        managerRepository.insert(manager);
        ManagerLoginInfoManager.addManagersFromDatabase(managerRepository.findAll());
    }

    @RequestMapping(value = "/isUsernamePresent", method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:4200")
    @ResponseBody
    public boolean isUsernamePresent(@RequestParam(value="username", required=true) String username) {
        List<Manager> listOfManagers = ManagerLoginInfoManager.getListOfManagers();
        for (Manager m:listOfManagers) {
            if (username.equals(m.getUsername())){
                return true;
            }
        }
        return false;
    }

    @Autowired
    ConsoleMenu consoleMenu;

    @GetMapping("/console")
    @ResponseBody
    @CrossOrigin(origins = "http://localhost:4200")
    public String startConsole() {
        System.out.println("Starting console...");
        consoleMenu.run();
        return "Console Started";
    }
}
