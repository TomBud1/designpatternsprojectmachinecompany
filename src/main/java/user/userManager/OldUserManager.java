package user.userManager;

import Machine.Machine;
import user.model.IOldUser;

import java.util.ArrayList;
import java.util.List;

public class OldUserManager implements IUserManager<IOldUser> {

    private List<IOldUser> oldUserList;

    public OldUserManager() {
        this.oldUserList = new ArrayList();
    }

    @Override
    public void addUser(IOldUser user) {
        this.oldUserList.add(user);
    }

    @Override
    public List<IOldUser> getAllUser() {
        return oldUserList;
    }

    @Override
    public IOldUser getUser(String secondName) {
        return oldUserList.stream()
                .filter(user -> user.getSecondName().equals(secondName))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void updateUser(String username, Machine Machine) {
        Machine[] list = getUser(username).getBoughtMachines();
        for(int i = 0 ; i < list.length ; i++ ){
            if(list[i] == null) {
                list[i] = Machine;
                break;
            }
        }
    }

}
