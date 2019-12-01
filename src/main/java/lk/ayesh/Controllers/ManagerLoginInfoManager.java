package lk.ayesh.Controllers;

import lk.ayesh.Models.Manager;

import java.util.ArrayList;
import java.util.List;

public class ManagerLoginInfoManager {
    private static List<Manager> listOfManagers = new ArrayList<Manager>();

    public static List<Manager> getListOfManagers() {
        return listOfManagers;
    }

    public static void addManager(Manager newManager) {
        listOfManagers.add(newManager);
    }

    public static void addManagersFromDatabase(List<Manager> listOfManagersFromDb) {
        listOfManagers.clear();
        System.out.println("Managers added to List: ");
        for (Manager m : listOfManagersFromDb) {
            listOfManagers.add(m);
            System.out.println(m);
        }
    }
}
