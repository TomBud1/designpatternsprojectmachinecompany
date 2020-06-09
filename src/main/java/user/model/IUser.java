package user.model;

import Machine.Machine;

import java.util.List;

public interface IUser {

    String getUserName();
    int getAge();
    String getAddress();
    String getEmail();
    int getPhoneNumber();
    List<Machine> getBoughtMachines();

}
