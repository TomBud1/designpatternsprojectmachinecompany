import Machine.Machine;
import Machine.factory.CaterpillarMachineFactory;
import machine.MachineType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import user.adapter.OldUserAdapter;
import user.adapter.UserAdapter;
import user.builder.UserBuilder;
import user.model.IOldUser;
import user.model.IUser;
import user.model.OldUser;

import java.util.ArrayList;
import java.util.List;

public class UsersAdapterTest {

    OldUserAdapter oldUserAdapter;
    UserAdapter userAdapter;

    IOldUser oldUser;
    IUser user;

    CaterpillarMachineFactory bmwFactory;
    Machine GUNMachine;
    Machine MODULARMachine;

    @Before
    public void prepareTests() {
        bmwFactory = CaterpillarMachineFactory.getInstance();
        GUNMachine = bmwFactory.orderMachine(MachineType.GUN);
        MODULARMachine = bmwFactory.orderMachine(MachineType.MODULAR);
        prepareOldUser();
        prepareUser();

    }

    @Test
    public void should_convert_old_user_to_user() {
        oldUserAdapter = new OldUserAdapter(oldUser);
        Assert.assertEquals(oldUserAdapter.getBoughtMachines(), user.getBoughtMachines());
        Assert.assertEquals(oldUserAdapter.getUserName(), user.getUserName());
    }

    @Test
    public void should_convert_user_to_old_user() {
        userAdapter = new UserAdapter(user);
        Assert.assertEquals(oldUser.getFirstName(), userAdapter.getFirstName());
        Assert.assertEquals(oldUser.getSecondName(), userAdapter.getSecondName());
        Assert.assertEquals(oldUser.getBoughtMachines(), userAdapter.getBoughtMachines());
    }

    private void prepareOldUser() {
        Machine[] Machines = new Machine[2];
        Machines[0] = GUNMachine;
        Machines[1] = MODULARMachine;

        this.oldUser = new OldUser(
                "Jan",
                "Kowalski",
                32,
                "Przykladna 22",
                "jankowalski@example.com",
                123123123,
                Machines
        );
    }

    private void prepareUser() {
        List<Machine> MachineList = new ArrayList();
        MachineList.add(GUNMachine);
        MachineList.add(MODULARMachine);

        UserBuilder userBuilder = new UserBuilder();

        this.user = userBuilder
                .withUserName("Jan Kowalski")
                .withAge(32)
                .withAddress("Przykladna 22")
                .withEmail("jankowalski@example.com")
                .withPhoneNumber(123123123)
                .withBoughtMachines(MachineList)
                .buildUser();
    }

}
