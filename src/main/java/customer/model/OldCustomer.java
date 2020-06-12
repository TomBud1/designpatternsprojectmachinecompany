package customer.model;

import machine.Machine;
import machine.MachineArrayIterator;
import machine.MachineIterator;

import java.util.Arrays;

public class OldCustomer implements IOldCustomer {

    private String firstName;

    private String secondName;

    private String address;

    private String email;

    private int phoneNumber;

    private Machine[] boughtMachines;

    public MachineIterator createIterator() {
        return new MachineArrayIterator(boughtMachines);
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    @Override
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public Machine[] getBoughtMachines() {
        return boughtMachines;
    }

    public void setBoughtMachines(Machine[] boughtMachines) {
        this.boughtMachines = boughtMachines;
    }

    public OldCustomer(String firstName, String secondName, String address, String email, int phoneNumber, Machine[] boughtMachines) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.boughtMachines = boughtMachines;
    }

    @Override
    public String toString() {
        return "OldCustomer{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", boughtMachines=" + Arrays.toString(boughtMachines) +
                '}';
    }

}
