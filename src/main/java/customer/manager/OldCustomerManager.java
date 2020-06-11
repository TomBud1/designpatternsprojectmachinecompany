package customer.manager;

import machine.Machine;
import customer.model.IOldCustomer;

import java.util.ArrayList;
import java.util.List;

public class OldCustomerManager implements ICustomerManager<IOldCustomer> {

    private List<IOldCustomer> oldCustomerList;

    public OldCustomerManager() {
        this.oldCustomerList = new ArrayList();
    }

    @Override
    public void addCustomer(IOldCustomer customer) {
        this.oldCustomerList.add(customer);
    }

    @Override
    public List<IOldCustomer> getAllCustomer() {
        return oldCustomerList;
    }

    @Override
    public IOldCustomer getCustomer(String secondName) {
        return oldCustomerList.stream()
                .filter(customer -> customer.getSecondName().equals(secondName))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void updateCustomer(String customername, Machine Machine) {
        Machine[] list = getCustomer(customername).getBoughtMachines();
        for(int i = 0 ; i < list.length ; i++ ){
            if(list[i] == null) {
                list[i] = Machine;
                break;
            }
        }
    }

}
