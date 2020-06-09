package user.adapter;

import machine.Machine;
import user.model.IOldUser;
import user.model.IUser;

public class UserAdapter implements IOldUser {

    private IUser user;

    public UserAdapter(IUser user) {
        this.user = user;
    }

    @Override
    public String getFirstName() {
        String[] nameList = user.getUserName().split(" ");
        return nameList[0];
    }

    @Override
    public String getSecondName() {
        String[] nameList = user.getUserName().split(" ");
        return nameList[1];
    }

    @Override
    public int getAge() {
        return user.getAge();
    }

    @Override
    public String getAddress() {
        return user.getAddress();
    }

    @Override
    public String getEmail() {
        return user.getEmail();
    }

    @Override
    public int getPhoneNumber() {
        return user.getPhoneNumber();
    }

    @Override
    public Machine[] getBoughtMachines() {
        return user.getBoughtMachines().stream().toArray(Machine[]::new);
    }

    @Override
    public void setBoughtMachines(Machine[] boughtMachines) {

    }
}