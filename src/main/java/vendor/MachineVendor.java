package vendor;

import machine.MachineType;
import headquarter.Headquarter;

public class MachineVendor {

    private Headquarter headquarter;

    public MachineVendor() {
        headquarter = headquarter.getInstance();
    }

    public void orderMachine(MachineType MachineType, String customerName, String branchName) {
        headquarter.addMachineToOrderList(MachineType, customerName, branchName);
    }
}

