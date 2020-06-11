package customer;

import customer.model.IOldCustomer;
import customer.model.ICustomer;
import machine.Machine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OldCustomerAdapter implements ICustomer {

    IOldCustomer oldCustomer;

    public OldCustomerAdapter(IOldCustomer oldCustomer) {
        this.oldCustomer = oldCustomer;
    }

    @Override
    public String getCustomerName() {
        return oldCustomer.getFirstName() + " "+oldCustomer.getSecondName();
    }

    @Override
    public int getAge() {
        return oldCustomer.getAge();
    }

    @Override
    public String getAddress() {
        return oldCustomer.getAddress();
    }

    @Override
    public String getEmail() {
        return oldCustomer.getEmail();
    }

    @Override
    public int getPhoneNumber() {
        return oldCustomer.getPhoneNumber();
    }

    @Override
    public List<Machine> getBoughtMachines() {
        List<Machine> MachineList =  new ArrayList<>(Arrays.asList(oldCustomer.getBoughtMachines()));
        return MachineList.stream().filter(item -> item != null).collect(Collectors.toList());
    }

}
