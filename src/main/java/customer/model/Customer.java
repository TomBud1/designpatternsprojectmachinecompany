package customer.model;

import machine.Machine;
import machine.MachineIterator;
import machine.MachineListIterator;

import java.util.List;

public class Customer implements ICustomer {

    private String customerName;

    private String address;

    private String email;

    private int phoneNumber;

    private List<Machine> boughtMachines;

    public MachineIterator createIterator() {
        return new MachineListIterator(boughtMachines);
    }

    @Override
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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
        return "Customer{" +
                "customerName='" + customerName + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", boughtMachines=" + boughtMachines +
                '}';
    }
}

