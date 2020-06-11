package headquarter;

import machine.Machine;
import customer.model.OldCustomer;
import customer.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class StatisticalOffice {

    HeadquarterFacade headquarterFacade;

    List<OldCustomer> listOfOldCustomers;

    List<Customer> listOfNewCustomers;

    List<Machine> listOfMachines;

    public StatisticalOffice() {
        headquarterFacade = new HeadquarterFacade();
        listOfOldCustomers = new ArrayList();
        listOfNewCustomers = new ArrayList();
        listOfMachines = new ArrayList();

        listOfOldCustomers = headquarterFacade.downloadAllOldCustomers();
        listOfNewCustomers = headquarterFacade.downloadAllNormalCustomers();

        listOfMachines = headquarterFacade.downloadAllBoughtMachines(listOfOldCustomers, listOfNewCustomers);
    }

    public void presentAllClients() {
        for (OldCustomer customer: listOfOldCustomers) {
            System.out.println( customer.toString());
            System.out.println("\n");
        }
        for (Customer customer: listOfNewCustomers) {
            System.out.println(customer.toString());
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

