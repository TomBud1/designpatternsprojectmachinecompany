package customer.model;

import machine.Machine;

public interface IOldCustomer {

    String getFirstName();
    String getSecondName();
    int getAge();
    String getAddress();
    String getEmail();
    int getPhoneNumber();
    Machine[] getBoughtMachines();
    void setBoughtMachines(Machine[] boughtMachines);

}
