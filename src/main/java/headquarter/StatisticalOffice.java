package headquarter;

import Machine.Machine;
import user.model.OldUser;
import user.model.User;

import java.util.ArrayList;
import java.util.List;

public class StatisticalOffice {

    HeadquarterFacade headquarterFacade;

    List<OldUser> listOfOldUsers;

    List<User> listOfNewUsers;

    List<Machine> listOfMachines;

    public StatisticalOffice() {
        headquarterFacade = new HeadquarterFacade();
        listOfOldUsers = new ArrayList();
        listOfNewUsers = new ArrayList();
        listOfMachines = new ArrayList();

        listOfOldUsers = headquarterFacade.downloadAllOldUsers();
        listOfNewUsers = headquarterFacade.downloadAllNormalUsers();

        listOfMachines = headquarterFacade.downloadAllBoughtMachines(listOfOldUsers, listOfNewUsers);
    }

    public void presentAllClients() {
        for (OldUser user: listOfOldUsers) {
            System.out.println( user.toString());
            System.out.println("\n");
        }
        for (User user: listOfNewUsers) {
            System.out.println(user.toString());
            System.out.println("\n");
        }
    }

    public void presentAllMachines() {
        for (Machine Machine: listOfMachines) {
            System.out.println(Machine.toString());
            System.out.println("\n");
        }
    }


}

