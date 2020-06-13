package customer;

import customer.model.Customer;
import machine.Machine;

import java.util.List;

public class CustomerBuilder {

    private Customer customer;

    public CustomerBuilder() {
        this.customer = new Customer();
    }

    public CustomerBuilder withCustomerName(String customerName) {
        this.customer.setCustomerName(customerName);
        return this;
    }

    public CustomerBuilder withAddress(String address) {
        this.customer.setAddress(address);
        return this;
    }

    public CustomerBuilder withEmail(String email) {
        this.customer.setEmail(email);
        return this;
    }

    public CustomerBuilder withPhoneNumber(int phoneNumber) {
        this.customer.setPhoneNumber(phoneNumber);
        return this;
    }

    public CustomerBuilder withBoughtMachines(List<Machine> Machines) {
        this.customer.setBoughtMachines(Machines);
        return this;
    }

    public Customer buildCustomer() {
        return customer;
    }

}
