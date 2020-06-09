package shop;

import machine.MachineType;
import headquarter.Headquarter;

public class MachineShop {

    private Headquarter headquarter;

    public MachineShop() {
        headquarter = headquarter.getInstance();
    }

    public void orderMachine(MachineType MachineType, String userName, String showroomName) {
        headquarter.addMachineToOrderList(MachineType, userName, showroomName);
    }
}

