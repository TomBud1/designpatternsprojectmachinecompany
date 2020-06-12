import customer.CustomerBuilder;
import customer.CustomerType;
import customer.OldCustomerAdapter;
import customer.model.Customer;
import customer.model.ICustomer;
import customer.model.IOldCustomer;
import customer.model.OldCustomer;
import headquarter.Headquarter;
import machine.Machine;
import machine.MachineType;
import org.junit.Before;
import org.junit.Test;
import vendor.Branch;

import java.util.ArrayList;

public class CustomerTransfer {


    Headquarter headquarter;

    Branch pomeranianBranch;

    Branch masovianBranch;

    Branch silensianBranch;

    private void createBranch() {
        preparePomeranianBranch();
        prepareWarszawaBranch();
    }


    private void preparePomeranianBranch() {
        pomeranianBranch = new Branch("pomeranianBranch", CustomerType.NORMAL);

        Customer janKowalski = new CustomerBuilder()
                .withCustomerName("Jan Kowalski")
                .withAge(29)
                .withAddress("Dluga 10")
                .withEmail("jankowalski@example.com")
                .withPhoneNumber(123123123)
                .withBoughtMachines(new ArrayList())
                .buildCustomer();

        pomeranianBranch.getCustomerManager().addCustomer(janKowalski);
    }

    private void prepareWarszawaBranch() {
        masovianBranch = new Branch("masovianBranch", CustomerType.OLD);

        OldCustomer jaroslawJarzabek = new OldCustomer(
                "Jaroslaw",
                "Jarzabek",
                41,
                "Pogodna 29",
                "jaroslawjarzabek@example.com",
                123123123,
                new Machine[100]
        );

        OldCustomer andrzejNowak = new OldCustomer(
                "Andrzej",
                "Nowak",
                22,
                "Lazarska 10",
                "andrzejnowak@example.com",
                123123113,
                new Machine[100]
        );

        OldCustomer janPrezes = new OldCustomer(
                "Jan",
                "Prezes",
                49,
                "Wiejska 5",
                "janprezes@szef.com",
                123523113,
                new Machine[100]
        );

        masovianBranch.getCustomerManager().addCustomer(jaroslawJarzabek);
        masovianBranch.getCustomerManager().addCustomer(andrzejNowak);
        masovianBranch.getCustomerManager().addCustomer(janPrezes);

    }

    @Before
    public void prepareData() {
        headquarter = headquarter.getInstance();

        createBranch();

        headquarter.addNewBranch(pomeranianBranch);
        headquarter.addNewBranch(masovianBranch);
        headquarter.addNewBranch(silensianBranch);

    }

    @Test
    public void should_move_client_from_masovian_to_pomeranian() {

        IOldCustomer oldCustomer = (IOldCustomer) masovianBranch.getCustomerManager().getCustomer("Prezes");

        masovianBranch.getMachineVendor().orderMachine(MachineType.COMPACTOR, oldCustomer.getSecondName(), masovianBranch.getBranchName());
        masovianBranch.getMachineVendor().orderMachine(MachineType.DOZER, oldCustomer.getSecondName(), masovianBranch.getBranchName());

        headquarter.produceAllMachines();
        headquarter.informAboutNewMachines();

        OldCustomerAdapter oldCustomerAdapter = new OldCustomerAdapter(oldCustomer);

        ICustomer newCustomer = new CustomerBuilder()
                .withCustomerName(oldCustomerAdapter.getCustomerName())
                .withAddress(oldCustomerAdapter.getAddress())
                .withAge(oldCustomerAdapter.getAge())
                .withEmail(oldCustomerAdapter.getEmail())
                .withPhoneNumber(oldCustomerAdapter.getPhoneNumber())
                .withBoughtMachines(oldCustomerAdapter.getBoughtMachines())
                .buildCustomer();

        pomeranianBranch.getCustomerManager().addCustomer(newCustomer);

        ICustomer newPomeranianCustomer = (ICustomer) pomeranianBranch.getCustomerManager().getCustomer("Jan Prezes");

        pomeranianBranch.getMachineVendor().orderMachine(MachineType.COMPACTOR, newPomeranianCustomer.getCustomerName(), pomeranianBranch.getBranchName());

        headquarter.produceAllMachines();
        headquarter.informAboutNewMachines();

        System.out.println("Jan Prezes: ");
        ((ICustomer) pomeranianBranch.getCustomerManager()
                .getCustomer("Jan Prezes"))
                .getBoughtMachines()
                .forEach( Machine -> {
                    System.out.println(Machine.toString());
                    System.out.println("\n");
                });
    }
}
