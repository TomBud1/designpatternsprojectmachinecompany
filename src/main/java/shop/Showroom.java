package shop;
import order.CompletedOrder;
import user.UserType;
import user.userManager.IUserManager;
import user.userManager.OldUserManager;
import user.userManager.UserManager;

import java.util.List;

public class Showroom {

    private String showroomName;

    private MachineShop MachineShop;

    private IUserManager userManager;

    private UserType typeOfUsers;

    public Showroom(String name, UserType usersType) {
        this.showroomName = name;
        this.typeOfUsers = usersType;
        this.MachineShop = new MachineShop();
        if (usersType == UserType.NORMAL) {
            userManager = new UserManager();
        } else if (usersType == UserType.OLD) {
            userManager = new OldUserManager();
        }
    }

    public void getNewMachines(List<CompletedOrder> doneOrderList) {
        doneOrderList.stream()
                .filter(order -> order.getShowroomName().equals(showroomName))
                .forEach( order -> {
                    userManager.updateUser(order.getUserName(), order.getMachine());
                });
    }

    public String getShowroomName() {
        return showroomName;
    }

    public MachineShop getMachineShop() {
        return MachineShop;
    }

    public IUserManager getUserManager() {
        return userManager;
    }

    public UserType getTypeOfUsers() {
        return typeOfUsers;
    }
}
