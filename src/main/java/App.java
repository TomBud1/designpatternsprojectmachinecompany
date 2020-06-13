import customer.CustomerBuilder;
import customer.CustomerType;
import customer.model.Customer;
import customer.model.ICustomer;
import customer.model.OldCustomer;
import headquarter.Headquarter;
import headquarter.StatisticalOffice;
import machine.Machine;
import machine.MachineFactory;
import machine.MachineType;
import machine.caterpillar.factory.CaterpillarMachineFactory;
import order.CompletedOrder;
import order.Order;
import vendor.Branch;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

        private static Headquarter headquarter;

        private static Branch pomeranianBranch = new Branch("pomeranianBranch", CustomerType.NORMAL);

        private static Branch silensianBranch = new Branch("silesianBranch", CustomerType.NORMAL);

        private static Branch masovianBranch = new Branch("masovianBranch", CustomerType.OLD);

        private static StatisticalOffice statisticalOffice;

        private static CaterpillarMachineFactory caterpillarMachineFactory;

        private static CustomerBuilder customerBuilder = new CustomerBuilder();

        private static Scanner menu_in = new Scanner(System.in);

        private static Scanner customer_in = new Scanner(System.in);

        private static Scanner customer_in_order = new Scanner(System.in);

        private static Scanner customer_in_build_machine = new Scanner(System.in);

        private static Scanner customer_order2 = new Scanner(System.in);

        private static Scanner customer_order3 = new Scanner(System.in);

        private static Scanner machine2 = new Scanner(System.in);

        private static Scanner machine3 = new Scanner(System.in);



    public static void main(String[] args) {
        prepareTestData();
        menu();
    }

    private static void menu() {
        int option_number;
        do {
            viewMenu();
            option_number = menu_in.nextInt();
            switch (option_number)
            {
                        // Add customer
                case 1: option_first();
                        break;
                        // Add order
                case 2: option_second();
                        break;
                        // Build machine
                case 3: option_third();
                        break;
                        // View all orders
                case 4: option_fourth();
                        break;
                        // View all customers
                case 5: option_fifth();
                        break;
                        // View all available machines
                case 6: option_sixth();
                        break;
                        // Statistical Office
                case 7: option_seventh();
            }

        }
        while (option_number != 8);
    }

    private static void viewMenu() {
        System.out.println("");
        System.out.println("Choose option");
        System.out.println("1. Add customer");
        System.out.println("2. Add order");
        System.out.println("3. Build machine");
        System.out.println("4. View all orders");
        System.out.println("5. View all customers");
        System.out.println("6. View all available machines");
        System.out.println("7. Statictical office");
    }

    private static void option_first() {

        String customer_name;
        String customer_address;
        String customer_email;
        int customer_phone_number;
        int customer_branch;

        System.out.println("Please provide customer name");
        customer_name = customer_in.nextLine();
        System.out.println("Please provide customer address");
        customer_address = customer_in.nextLine();
        System.out.println("Please provide customer email");
        customer_email = customer_in.nextLine();
        System.out.println("Please provide customer phone_number");
        customer_phone_number = customer_in.nextInt();
        System.out.println("Please provide customer branch (Pomeranian|Masovian|Silesian");
        customer_branch = customer_in.nextInt();

        Customer customerBuild = customerBuilder
                .withCustomerName(customer_name)
                .withAddress(customer_address)
                .withEmail(customer_email)
                .withPhoneNumber(customer_phone_number)
                .buildCustomer();

        switch (customer_branch)
            {
                case 1: pomeranianBranch.getCustomerManager().addCustomer(customerBuild);
                        System.out.println(pomeranianBranch.getCustomerManager().getAllCustomer());
                        break;
                case 2: masovianBranch.getCustomerManager().addCustomer(customerBuild);
                        System.out.println(masovianBranch.getCustomerManager().getAllCustomer());
                        break;
                case 3: silensianBranch.getCustomerManager().addCustomer(customerBuild);
                        System.out.println(silensianBranch.getCustomerManager().getAllCustomer());
            }

    }

    private static void option_second() {

        int customer_branch;
        System.out.println("Please provide customer branch (Pomeranian|Masovian|Silesian");
        customer_branch = customer_in_order.nextInt();

        String client_order;
        System.out.println("Please provide customer name");
        client_order = customer_order2.nextLine();

        String machine_order;
        System.out.println("Please provide machine type");
        machine_order = machine2.nextLine();


        switch (customer_branch)
        {
            case 1: ICustomer client1 = (ICustomer) pomeranianBranch.getCustomerManager().getCustomer(client_order);
                    pomeranianBranch.getMachineVendor().orderMachine(MachineType.valueOf(machine_order), client1.getCustomerName(), pomeranianBranch.getBranchName());

                    Order order1 = headquarter.getOrderList().stream()
                            .filter(item -> item.getCustomerName().equals(client_order))
                            .filter(item ->item.getMachineType().equals(MachineType.valueOf(machine_order))).findAny().orElse(null);

                    System.out.println(order1.toString());
                break;
            case 2: ICustomer client2 = (ICustomer) masovianBranch.getCustomerManager().getCustomer(client_order);
                    masovianBranch.getMachineVendor().orderMachine(MachineType.valueOf(machine_order), client2.getCustomerName(), masovianBranch.getBranchName());

                    Order order2 = headquarter.getOrderList().stream()
                            .filter(item -> item.getCustomerName().equals(client_order))
                            .filter(item ->item.getMachineType().equals(MachineType.valueOf(machine_order))).findAny().orElse(null);

                    System.out.println(order2.toString());
                break;
            case 3: ICustomer client3 = (ICustomer) silensianBranch.getCustomerManager().getCustomer(client_order);
                    silensianBranch.getMachineVendor().orderMachine(MachineType.valueOf(machine_order), client3.getCustomerName(), silensianBranch.getBranchName());

                    Order order3 = headquarter.getOrderList().stream()
                            .filter(item -> item.getCustomerName().equals(client_order))
                            .filter(item ->item.getMachineType().equals(MachineType.valueOf(machine_order))).findAny().orElse(null);

                    System.out.println(order3.toString());
        }

    }

    private static void option_third() {

        caterpillarMachineFactory = CaterpillarMachineFactory.getInstance();
        int customer_branch;
        System.out.println("Please provide customer branch (Pomeranian|Masovian|Silesian");
        customer_branch = customer_in_build_machine.nextInt();

        String client_order;
        System.out.println("Please provide customer name");
        client_order = customer_order3.nextLine();

        String machine_order;
        System.out.println("Please provide machine type");
        machine_order = machine3.nextLine();


        switch (customer_branch)
        {
            case 1: ICustomer client1 = (ICustomer) pomeranianBranch.getCustomerManager().getCustomer(client_order);
                    pomeranianBranch.getMachineVendor().orderMachine(MachineType.valueOf(machine_order), client1.getCustomerName(), pomeranianBranch.getBranchName());
                    headquarter.produceAllMachines();
                    List<CompletedOrder> CompletedOrder1 = headquarter.getAvailableMachinesList();
                    CompletedOrder1.stream().forEach(Machine -> System.out.println(Machine.toString()));
                    pomeranianBranch.getCustomerManager().updateCustomer(client_order, caterpillarMachineFactory.createMachine(MachineType.valueOf(machine_order)));

                break;
            case 2: ICustomer client2 = (ICustomer) masovianBranch.getCustomerManager().getCustomer(client_order);
                    masovianBranch.getMachineVendor().orderMachine(MachineType.valueOf(machine_order), client2.getCustomerName(), masovianBranch.getBranchName());
                    headquarter.produceAllMachines();
                    List<CompletedOrder> CompletedOrder2 = headquarter.getAvailableMachinesList();
                    CompletedOrder2.stream().forEach(Machine -> System.out.println(Machine.toString()));
                    masovianBranch.getCustomerManager().updateCustomer(client_order, caterpillarMachineFactory.createMachine(MachineType.valueOf(machine_order)));

                break;
            case 3: ICustomer client3 = (ICustomer) silensianBranch.getCustomerManager().getCustomer(client_order);
                    silensianBranch.getMachineVendor().orderMachine(MachineType.valueOf(machine_order), client3.getCustomerName(), silensianBranch.getBranchName());
                    headquarter.produceAllMachines();
                    List<CompletedOrder> CompletedOrder3 = headquarter.getAvailableMachinesList();
                    CompletedOrder3.stream().forEach(Machine -> System.out.println(Machine.toString()));
                    silensianBranch.getCustomerManager().updateCustomer(client_order, caterpillarMachineFactory.createMachine(MachineType.valueOf(machine_order)));

        }
    }

    private static void option_fourth() {

        System.out.println(headquarter.getOrderList().toString());
    }

    private static void option_fifth() {
        System.out.println("Pomeranian Branch:");
        System.out.println(pomeranianBranch.getCustomerManager().getAllCustomer());
        System.out.println("Masovian Branch:");
        System.out.println(masovianBranch.getCustomerManager().getAllCustomer());
        System.out.println("Silesian Branch:");
        System.out.println(silensianBranch.getCustomerManager().getAllCustomer());
    }

    private static void option_sixth() {
        MachineFactory caterpillarFactory = CaterpillarMachineFactory.getInstance();
        Machine compactor = caterpillarFactory.createMachine(MachineType.COMPACTOR);
        Machine dozer = caterpillarFactory.createMachine(MachineType.DOZER);
        Machine drill = caterpillarFactory.createMachine(MachineType.DRILL);
        Machine excavator = caterpillarFactory.createMachine(MachineType.EXCAVATOR);
        Machine trackHouse = caterpillarFactory.createMachine(MachineType.TRACK_LOADER);
        Machine truck = caterpillarFactory.createMachine(MachineType.TRUCK);
        System.out.println(MachineType.COMPACTOR);
        System.out.println(compactor.toString());
        System.out.println(MachineType.DOZER);
        System.out.println(dozer.toString());
        System.out.println(MachineType.DRILL);
        System.out.println(drill.toString());
        System.out.println(MachineType.EXCAVATOR);
        System.out.println(excavator.toString());
        System.out.println(MachineType.TRACK_LOADER);
        System.out.println(trackHouse.toString());
        System.out.println(MachineType.TRUCK);
        System.out.println(truck.toString());
    }

    private static void option_seventh() {
        statisticalOffice = new StatisticalOffice();
        statisticalOffice.presentAllClients();
        statisticalOffice.presentAllMachines();
    }

    private static void prepareTestData() {
        headquarter = Headquarter.getInstance();
        headquarter.addNewBranch(pomeranianBranch);
        headquarter.addNewBranch(masovianBranch);
        headquarter.addNewBranch(silensianBranch);
        headquarter.produceAllMachines();
        headquarter.informAboutNewMachines();

        MachineFactory caterpillarFactory = CaterpillarMachineFactory.getInstance();
        Machine compactor = caterpillarFactory.createMachine(MachineType.COMPACTOR);
        Machine dozer = caterpillarFactory.createMachine(MachineType.DOZER);
        Machine drill = caterpillarFactory.createMachine(MachineType.DRILL);
        Machine excavator = caterpillarFactory.createMachine(MachineType.EXCAVATOR);
        Machine trackHouse = caterpillarFactory.createMachine(MachineType.TRACK_LOADER);
        Machine truck = caterpillarFactory.createMachine(MachineType.TRUCK);

        Machine[] machines1 = new Machine[2];
        machines1[0] = dozer;
        machines1[1] = compactor;

        Machine[] machines2 = new Machine[2];
        machines2[0] = drill;
        machines2[1] = truck;

        Machine[] machines3 = new Machine[3];
        machines3[0] = excavator;
        machines3[1] = trackHouse;
        machines3[2] = truck;

        Customer janKowalski = new CustomerBuilder()
                .withCustomerName("Jan Kowalski")
                .withAddress("Dluga 10, Gdańsk")
                .withEmail("jankowalski@example.com")
                .withPhoneNumber(444555666)
                .withBoughtMachines(new ArrayList())
                .buildCustomer();

        pomeranianBranch.getCustomerManager().addCustomer(janKowalski);

        Customer mpmGdynia = new CustomerBuilder()
                .withCustomerName("MTM Gdynia")
                .withAddress("Hutnicza 35, Gdynia")
                .withEmail("mtmgdynia@mtmgdynia.com")
                .withPhoneNumber(777888999)
                .withBoughtMachines(new ArrayList())
                .buildCustomer();

        pomeranianBranch.getCustomerManager().addCustomer(mpmGdynia);


        OldCustomer mostostalWarszawa = new OldCustomer(
                "Mostostal",
                "Warszawa SA",
                "Konstruktorska 12A, Warszawa",
                "mostostalwarszawa@mostostalwarszawa.com",
                123123123,
                machines1
        );

        OldCustomer drogiMosty = new OldCustomer(
                "Drogi",
                "Mosty",
                "Łazarska 10, Pruszków",
                "drogimosty@drogimosty.com",
                321321321,
                machines2
        );

        OldCustomer prezesPol = new OldCustomer(
                "Prezes",
                "POL",
                "Wiejska 5, Wołomin",
                "prezespol@prezespol.com",
                111222333,
                machines3

        );

        masovianBranch.getCustomerManager().addCustomer(mostostalWarszawa);
        masovianBranch.getCustomerManager().addCustomer(drogiMosty);
        masovianBranch.getCustomerManager().addCustomer(prezesPol);



        Customer tauron = new CustomerBuilder()
                .withCustomerName("Tauron")
                .withAddress("Swietojańska 32, Katowice")
                .withEmail("tauron@tauron.com")
                .withBoughtMachines(new ArrayList())
                .buildCustomer();

        Customer kwkWujek = new CustomerBuilder()
                .withCustomerName("Kopalnia Wujek")
                .withAddress("Górnicza 13")
                .withPhoneNumber(333222111)
                .withBoughtMachines(new ArrayList())
                .buildCustomer();

        Customer autoEx = new CustomerBuilder()
                .withCustomerName("Autostrady Export")
                .withAddress("Morska 3")
                .withEmail("autoex@autoex.com")
                .withPhoneNumber(666555444)
                .withBoughtMachines(new ArrayList())
                .buildCustomer();

        silensianBranch.getCustomerManager().addCustomer(tauron);
        silensianBranch.getCustomerManager().addCustomer(kwkWujek);
        silensianBranch.getCustomerManager().addCustomer(autoEx);

    }
}
