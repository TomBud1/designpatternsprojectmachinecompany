package customer.manager;

import machine.Machine;
import customer.model.ICustomer;

import java.util.ArrayList;
import java.util.List;

public class CustomerManager implements ICustomerManager<ICustomer> {

    private List<ICustomer> customerList;

    public CustomerManager() {
        this.customerList = new ArrayList();
    }

    @Override
    public void addCustomer(ICustomer customer) {
        this.customerList.add(customer);
    }

    @Override
    public List<ICustomer> getAllCustomer() {
        return customerList;
    }

    @Override
    public ICustomer getCustomer(String customerName) {
        ICustomer customer = customerList.stream()
                .filter( filteredCustomer -> filteredCustomer.getCustomerName().equals(customerName))
                .findFirst()
                .orElse(null);
        return customer;
    }

    @Override
    public void updateCustomer(String customerName, Machine machine) {
        getCustomer(customerName).getBoughtMachines().add(machine);
    }

}
