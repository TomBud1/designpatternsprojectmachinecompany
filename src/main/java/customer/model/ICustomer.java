package customer.model;

import machine.Machine;

import java.util.List;

public interface ICustomer {

    String getCustomerName();
    int getAge();
    String getAddress();
    String getEmail();
    int getPhoneNumber();
    List<Machine> getBoughtMachines();

}
