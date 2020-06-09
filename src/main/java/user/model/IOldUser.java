package user.model;

import Machine.Machine;

public interface IOldUser {

    String getFirstName();
    String getSecondName();
    int getAge();
    String getAddress();
    String getEmail();
    int getPhoneNumber();
    Machine[] getBoughtMachines();
    void setBoughtMachines(Machine[] boughtMachines);

}
