package user.builder;

import Machine.Machine;
import user.model.User;

import java.util.List;

public class UserBuilder {

    private User user;

    public UserBuilder() {
        this.user = new User();
    }

    public UserBuilder withUserName(String userName) {
        this.user.setUserName(userName);
        return this;
    }

    public UserBuilder withAge(int age) {
        this.user.setAge(age);
        return this;
    }

    public UserBuilder withAddress(String address) {
        this.user.setAddress(address);
        return this;
    }

    public UserBuilder withEmail(String email) {
        this.user.setEmail(email);
        return this;
    }

    public UserBuilder withPhoneNumber(int phoneNumber) {
        this.user.setPhoneNumber(phoneNumber);
        return this;
    }

    public UserBuilder withBoughtMachines(List<Machine> Machines) {
        this.user.setBoughtMachines(Machines);
        return this;
    }

    public User buildUser() {
        return user;
    }

}
