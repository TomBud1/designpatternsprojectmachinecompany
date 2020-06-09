import machine.Machine;
import machine.MachineType;
import headquarter.Headquarter;
import headquarter.StatisticalOffice;
import order.CompletedOrder;
import order.Order;
import org.junit.Before;
import org.junit.Test;
import shop.Showroom;
import user.UserType;
import user.adapter.OldUserAdapter;
import user.builder.UserBuilder;
import user.model.IOldUser;
import user.model.IUser;
import user.model.OldUser;
import user.model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ApplicationTest {

    Headquarter headquarter;

    Showroom gdanskShowroom;

    Showroom warszawaShowroom;

    Showroom gdyniaShowRoom;


    @Before
    public void prepareData() {
        headquarter = headquarter.getInstance();

        createshowroom();

        headquarter.addNewShowroom(gdanskShowroom);
        headquarter.addNewShowroom(warszawaShowroom);
        headquarter.addNewShowroom(gdyniaShowRoom);

    }

    @Test
    public void should_order_GUN_Machine_for_new_user() {
        IUser client = (IUser) gdanskShowroom.getUserManager().getUser("Jan Kowalski");
        gdanskShowroom.getMachineShop().orderMachine(MachineType.GUN, client.getUserName(), gdanskShowroom.getShowroomName());

        Order order = headquarter.getOrderList().stream()
                .filter(item -> item.getUserName().equals("Jan Kowalski"))
                .findFirst().orElse(null);

        System.out.println(order.toString());
    }

    @Test
    public void should_build_ordered_Machine() {
        IUser client = (IUser) gdanskShowroom.getUserManager().getUser("Jan Kowalski");
        gdanskShowroom.getMachineShop().orderMachine(MachineType.GUN, client.getUserName(), gdanskShowroom.getShowroomName());
        headquarter.produceAllMachines();

        List<CompletedOrder> CompletedOrder = headquarter.getAvailableMachinesList();
        CompletedOrder.stream().forEach(Machine -> System.out.println(Machine.toString()));

    }

    @Test
    public void should_get_Machine_from_headquarter() {

        IUser client = (IUser) gdanskShowroom.getUserManager().getUser("Jan Kowalski");
        IUser client2 = (IUser) gdyniaShowRoom.getUserManager().getUser("Witold Morze");
        IOldUser client3 = (IOldUser) warszawaShowroom.getUserManager().getUser("Prezes");

        gdanskShowroom.getMachineShop().orderMachine(MachineType.GUN, client.getUserName(), gdanskShowroom.getShowroomName());
        gdyniaShowRoom.getMachineShop().orderMachine(MachineType.MODULAR, client2.getUserName(), gdyniaShowRoom.getShowroomName());
        warszawaShowroom.getMachineShop().orderMachine(MachineType.LIMOUSINE, client3.getSecondName(), warszawaShowroom.getShowroomName());
        warszawaShowroom.getMachineShop().orderMachine(MachineType.MINI_RIFLE, client3.getSecondName(), warszawaShowroom.getShowroomName());

        headquarter.produceAllMachines();
        headquarter.informAboutNewMachines();

        System.out.println("Jan Kowalski: ");
        System.out.println(((IUser) gdanskShowroom.getUserManager()
                .getUser("Jan Kowalski"))
                .getBoughtMachines()
                .toString());
        System.out.println("\n");

        System.out.println("Witold Morze: ");
        System.out.println(((IUser) gdyniaShowRoom.getUserManager()
                .getUser("Witold Morze"))
                .getBoughtMachines()
                .toString());
        System.out.println("\n");

        System.out.println("Jan Prezes: ");
        System.out.println(Arrays.toString(
                ((IOldUser) warszawaShowroom.getUserManager()
                        .getUser("Prezes"))
                        .getBoughtMachines()));

    }

    @Test
    public void should_move_client_from_warsaw_to_gdansk() {

        IOldUser oldUser = (IOldUser) warszawaShowroom.getUserManager().getUser("Prezes");

        warszawaShowroom.getMachineShop().orderMachine(MachineType.RIFLE, oldUser.getSecondName(), warszawaShowroom.getShowroomName());
        warszawaShowroom.getMachineShop().orderMachine(MachineType.GUN, oldUser.getSecondName(), warszawaShowroom.getShowroomName());

        headquarter.produceAllMachines();
        headquarter.informAboutNewMachines();

        OldUserAdapter oldUserAdapter = new OldUserAdapter(oldUser);

        IUser newUser = new UserBuilder()
                .withUserName(oldUserAdapter.getUserName())
                .withAddress(oldUserAdapter.getAddress())
                .withAge(oldUserAdapter.getAge())
                .withEmail(oldUserAdapter.getEmail())
                .withPhoneNumber(oldUserAdapter.getPhoneNumber())
                .withBoughtMachines(oldUserAdapter.getBoughtMachines())
                .buildUser();

        gdanskShowroom.getUserManager().addUser(newUser);

        IUser newGdanskUser = (IUser) gdanskShowroom.getUserManager().getUser("Jan Prezes");

        gdanskShowroom.getMachineShop().orderMachine(MachineType.MODULAR, newGdanskUser.getUserName(), gdanskShowroom.getShowroomName());

        headquarter.produceAllMachines();
        headquarter.informAboutNewMachines();

        System.out.println("Jan Prezes: ");
        ((IUser) gdanskShowroom.getUserManager()
                .getUser("Jan Prezes"))
                .getBoughtMachines()
                .forEach( Machine -> {
                    System.out.println(Machine.toString());
                    System.out.println("\n");
                });
    }

    @Test
    public void should_share_data_with_statistics_office() {

        IUser client = (IUser) gdanskShowroom.getUserManager().getUser("Jan Kowalski");
        IUser client2 = (IUser) gdyniaShowRoom.getUserManager().getUser("Witold Morze");
        IOldUser client3 = (IOldUser) warszawaShowroom.getUserManager().getUser("Prezes");

        gdanskShowroom.getMachineShop().orderMachine(MachineType.GUN, client.getUserName(), gdanskShowroom.getShowroomName());
        gdanskShowroom.getMachineShop().orderMachine(MachineType.RIFLE, client.getUserName(), gdanskShowroom.getShowroomName());

        gdyniaShowRoom.getMachineShop().orderMachine(MachineType.MODULAR, client2.getUserName(), gdyniaShowRoom.getShowroomName());

        warszawaShowroom.getMachineShop().orderMachine(MachineType.LIMOUSINE, client3.getSecondName(), warszawaShowroom.getShowroomName());
        warszawaShowroom.getMachineShop().orderMachine(MachineType.MINI_RIFLE, client3.getSecondName(), warszawaShowroom.getShowroomName());

        headquarter.produceAllMachines();
        headquarter.informAboutNewMachines();

        StatisticalOffice StatisticalOffice = new StatisticalOffice();

        System.out.println("Clients: ");
        StatisticalOffice.presentAllClients();
        System.out.println("\n");
        System.out.println("Machines: ");
        StatisticalOffice.presentAllMachines();
    }

    private void createshowroom() {
        prepareGdanskShowroom();
        preparegdyniaShowroom();
        prepareWarszawaShowroom();
    }

    private void prepareGdanskShowroom() {
        gdanskShowroom = new Showroom("gdanskShowroom", UserType.NORMAL);

        User janKowalski = new UserBuilder()
                .withUserName("Jan Kowalski")
                .withAge(29)
                .withAddress("Dluga 10")
                .withEmail("jankowalski@example.com")
                .withPhoneNumber(123123123)
                .withBoughtMachines(new ArrayList())
                .buildUser();

        gdanskShowroom.getUserManager().addUser(janKowalski);
    }

    private void prepareWarszawaShowroom() {
        warszawaShowroom = new Showroom("warszawaShowroom", UserType.OLD);

        OldUser jaroslawJarzabek = new OldUser(
                "Jaroslaw",
                "Jarzabek",
                41,
                "Pogodna 29",
                "jaroslawjarzabek@example.com",
                123123123,
                new Machine[100]
        );

        OldUser andrzejNowak = new OldUser(
                "Andrzej",
                "Nowak",
                22,
                "Lazarska 10",
                "andrzejnowak@example.com",
                123123113,
                new Machine[100]
        );

        OldUser janPrezes = new OldUser(
                "Jan",
                "Prezes",
                49,
                "Wiejska 5",
                "janprezes@szef.com",
                123523113,
                new Machine[100]
        );

        warszawaShowroom.getUserManager().addUser(jaroslawJarzabek);
        warszawaShowroom.getUserManager().addUser(andrzejNowak);
        warszawaShowroom.getUserManager().addUser(janPrezes);

    }

    private void preparegdyniaShowroom() {
        gdyniaShowRoom = new Showroom("gdyniaShowroom", UserType.NORMAL);

        User lidiaWojas = new UserBuilder()
                .withUserName("Lidia Wojas")
                .withAge(22)
                .withAddress("Swietojanska 32")
                .withEmail("lidiawojas@example.com")
                .withBoughtMachines(new ArrayList())
                .buildUser();

        User katarzynaKochanowska = new UserBuilder()
                .withUserName("Katarzyna Kochanowska")
                .withAge(41)
                .withAddress("Wielkopolska 13")
                .withPhoneNumber(321321321)
                .withBoughtMachines(new ArrayList())
                .buildUser();

        User witoldMorze = new UserBuilder()
                .withUserName("Witold Morze")
                .withAge(91)
                .withAddress("Morska 3")
                .withEmail("witoldmorze@example.com")
                .withPhoneNumber(321321997)
                .withBoughtMachines(new ArrayList())
                .buildUser();

        gdyniaShowRoom.getUserManager().addUser(lidiaWojas);
        gdyniaShowRoom.getUserManager().addUser(katarzynaKochanowska);
        gdyniaShowRoom.getUserManager().addUser(witoldMorze);
    }

}
