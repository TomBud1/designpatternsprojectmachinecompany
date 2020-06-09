package user.adapter;

import user.model.IOldUser;
import user.model.IUser;
import machine.Machine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OldUserAdapter implements IUser {

    IOldUser oldUser;

    public OldUserAdapter(IOldUser oldUser) {
        this.oldUser = oldUser;
    }

    @Override
    public String getUserName() {
        return oldUser.getFirstName() + " "+oldUser.getSecondName();
    }

    @Override
    public int getAge() {
        return oldUser.getAge();
    }

    @Override
    public String getAddress() {
        return oldUser.getAddress();
    }

    @Override
    public String getEmail() {
        return oldUser.getEmail();
    }

    @Override
    public int getPhoneNumber() {
        return oldUser.getPhoneNumber();
    }

    @Override
    public List<Machine> getBoughtMachines() {
        List<Machine> MachineList =  new ArrayList<>(Arrays.asList(oldUser.getBoughtMachines()));
        return MachineList.stream().filter(item -> item != null).collect(Collectors.toList());
    }

}
