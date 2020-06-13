package customer;

import customer.model.ICustomer;
import customer.model.IOldCustomer;
import machine.Machine;

public class CustomerAdapter implements IOldCustomer {

    private ICustomer customer;

    public CustomerAdapter(ICustomer customer) {
        this.customer = customer;
    }

    @Override
    public String getFirstName() {
        String[] nameList = customer.getCustomerName().split(" ");
        return nameList[0];
    }

    @Override
    public String getSecondName() {
        String[] nameList = customer.getCustomerName().split(" ");
        return nameList[1];
    }

    @Override
    public String getAddress() {
        return customer.getAddress();
    }

    @Override
    public String getEmail() {
        return customer.getEmail();
    }

    @Override
    public int getPhoneNumber() {
        return customer.getPhoneNumber();
    }

    @Override
    public Machine[] getBoughtMachines() {
        return customer.getBoughtMachines().stream().toArray(Machine[]::new);
    }

    @Override
    public void setBoughtMachines(Machine[] boughtMachines) {

    }
}