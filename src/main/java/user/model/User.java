package user.model;

import Machine.Machine;
import user.iterator.MachineIterator;
import user.iterator.MachineListIterator;

import java.util.List;

public class User implements IUser {

    private String userName;

    private int age;

    private String address;

    private String email;

    private int phoneNumber;

    private List<Machine> boughtMachines;

    public MachineIterator createIterator() {
        return new MachineListIterator(boughtMachines);
    }

    @Override
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Machine> getBoughtMachines() {
        return boughtMachines;
    }

    public void setBoughtMachines(List<Machine> boughtMachines) {
        this.boughtMachines = boughtMachines;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", boughtMachines=" + boughtMachines +
                '}';
    }
}

