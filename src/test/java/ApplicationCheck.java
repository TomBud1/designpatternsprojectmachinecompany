import machine.Machine;
import machine.MachineType;
import headquarter.Headquarter;
import headquarter.StatisticalOffice;
import order.CompletedOrder;
import order.Order;
import org.junit.Before;
import org.junit.Test;
import vendor.Branch;
import customer.CustomerType;
import customer.OldCustomerAdapter;
import customer.CustomerBuilder;
import customer.model.IOldCustomer;
import customer.model.ICustomer;
import customer.model.OldCustomer;
import customer.model.Customer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ApplicationCheck {

    Headquarter headquarter;

    Branch pomeranianBranch;

    Branch masovianBranch;

    Branch silensianBranch;


    @Before
    public void prepareData() {
        headquarter = headquarter.getInstance();

        createBranch();

        headquarter.addNewBranch(pomeranianBranch);
        headquarter.addNewBranch(masovianBranch);
        headquarter.addNewBranch(silensianBranch);

    }

    @Test
    public void should_order_dozer_machine_for_new_customer() {
        ICustomer client = (ICustomer) pomeranianBranch.getCustomerManager().getCustomer("Jan Kowalski");
        pomeranianBranch.getMachineVendor().orderMachine(MachineType.DOZER, client.getCustomerName(), pomeranianBranch.getBranchName());

        Order order = headquarter.getOrderList().stream()
                .filter(item -> item.getCustomerName().equals("Jan Kowalski"))
                .findFirst().orElse(null);

        System.out.println(order.toString());
    }

    @Test
    public void should_build_ordered_machine() {
        ICustomer client = (ICustomer) pomeranianBranch.getCustomerManager().getCustomer("Jan Kowalski");
        pomeranianBranch.getMachineVendor().orderMachine(MachineType.DOZER, client.getCustomerName(), pomeranianBranch.getBranchName());
        headquarter.produceAllMachines();

        List<CompletedOrder> CompletedOrder = headquarter.getAvailableMachinesList();
        CompletedOrder.stream().forEach(Machine -> System.out.println(Machine.toString()));

    }

    @Test
    public void should_get_machine_from_headquarter() {

        ICustomer client = (ICustomer) pomeranianBranch.getCustomerManager().getCustomer("Jan Kowalski");
        ICustomer client2 = (ICustomer) silensianBranch.getCustomerManager().getCustomer("Witold Morze");
        IOldCustomer client3 = (IOldCustomer) masovianBranch.getCustomerManager().getCustomer("Prezes");

        pomeranianBranch.getMachineVendor().orderMachine(MachineType.DOZER, client.getCustomerName(), pomeranianBranch.getBranchName());
        silensianBranch.getMachineVendor().orderMachine(MachineType.COMPACTOR, client2.getCustomerName(), silensianBranch.getBranchName());
        masovianBranch.getMachineVendor().orderMachine(MachineType.DRILL, client3.getSecondName(), masovianBranch.getBranchName());
        masovianBranch.getMachineVendor().orderMachine(MachineType.EXCAVATOR, client3.getSecondName(), masovianBranch.getBranchName());

        headquarter.produceAllMachines();
        headquarter.informAboutNewMachines();

        System.out.println("Jan Kowalski: ");
        System.out.println(((ICustomer) pomeranianBranch.getCustomerManager()
                .getCustomer("Jan Kowalski"))
                .getBoughtMachines()
                .toString());
        System.out.println("\n");

        System.out.println("Witold Morze: ");
        System.out.println(((ICustomer) silensianBranch.getCustomerManager()
                .getCustomer("Witold Morze"))
                .getBoughtMachines()
                .toString());
        System.out.println("\n");

        System.out.println("Jan Prezes: ");
        System.out.println(Arrays.toString(
                ((IOldCustomer) masovianBranch.getCustomerManager()
                        .getCustomer("Prezes"))
                        .getBoughtMachines()));

    }


    @Test
    public void should_share_data_with_statistics_office() {

        ICustomer client = (ICustomer) pomeranianBranch.getCustomerManager().getCustomer("Jan Kowalski");
        ICustomer client2 = (ICustomer) silensianBranch.getCustomerManager().getCustomer("Witold Morze");
        IOldCustomer client3 = (IOldCustomer) masovianBranch.getCustomerManager().getCustomer("Prezes");

        pomeranianBranch.getMachineVendor().orderMachine(MachineType.DOZER, client.getCustomerName(), pomeranianBranch.getBranchName());
        pomeranianBranch.getMachineVendor().orderMachine(MachineType.COMPACTOR, client.getCustomerName(), pomeranianBranch.getBranchName());

        silensianBranch.getMachineVendor().orderMachine(MachineType.DRILL, client2.getCustomerName(), silensianBranch.getBranchName());

        masovianBranch.getMachineVendor().orderMachine(MachineType.EXCAVATOR, client3.getSecondName(), masovianBranch.getBranchName());
        masovianBranch.getMachineVendor().orderMachine(MachineType.TRACK_LOADER, client3.getSecondName(), masovianBranch.getBranchName());

        headquarter.produceAllMachines();
        headquarter.informAboutNewMachines();

        StatisticalOffice statisticalOffice = new StatisticalOffice();

        System.out.println("Clients: ");
        statisticalOffice.presentAllClients();
        System.out.println("\n");
        System.out.println("Machines: ");
        statisticalOffice.presentAllMachines();
    }

    private void createBranch() {
        preparePomeranianBranch();
        prepareSilesianBranch();
        prepareWarszawaBranch();
    }

    private void preparePomeranianBranch() {
        pomeranianBranch = new Branch("pomeranianBranch", CustomerType.NORMAL);

        Customer janKowalski = new CustomerBuilder()
                .withCustomerName("Jan Kowalski")
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
                "Pogodna 29",
                "jaroslawjarzabek@example.com",
                123123123,
                new Machine[100]
        );

        OldCustomer andrzejNowak = new OldCustomer(
                "Andrzej",
                "Nowak",
                "Lazarska 10",
                "andrzejnowak@example.com",
                123123113,
                new Machine[100]
        );

        OldCustomer janPrezes = new OldCustomer(
                "Jan",
                "Prezes",
                "Wiejska 5",
                "janprezes@szef.com",
                123523113,
                new Machine[100]
        );

        masovianBranch.getCustomerManager().addCustomer(jaroslawJarzabek);
        masovianBranch.getCustomerManager().addCustomer(andrzejNowak);
        masovianBranch.getCustomerManager().addCustomer(janPrezes);

    }

    private void prepareSilesianBranch() {
        silensianBranch = new Branch("silesianBranch", CustomerType.NORMAL);

        Customer lidiaWojas = new CustomerBuilder()
                .withCustomerName("Lidia Wojas")
                .withAddress("Swietojanska 32")
                .withEmail("lidiawojas@example.com")
                .withBoughtMachines(new ArrayList())
                .buildCustomer();

        Customer katarzynaKochanowska = new CustomerBuilder()
                .withCustomerName("Katarzyna Kochanowska")
                .withAddress("Wielkopolska 13")
                .withPhoneNumber(321321321)
                .withBoughtMachines(new ArrayList())
                .buildCustomer();

        Customer witoldMorze = new CustomerBuilder()
                .withCustomerName("Witold Morze")
                .withAddress("Morska 3")
                .withEmail("witoldmorze@example.com")
                .withPhoneNumber(321321997)
                .withBoughtMachines(new ArrayList())
                .buildCustomer();

        silensianBranch.getCustomerManager().addCustomer(lidiaWojas);
        silensianBranch.getCustomerManager().addCustomer(katarzynaKochanowska);
        silensianBranch.getCustomerManager().addCustomer(witoldMorze);
    }

}
