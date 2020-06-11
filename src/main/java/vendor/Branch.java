package vendor;
import order.CompletedOrder;
import customer.CustomerType;
import customer.manager.ICustomerManager;
import customer.manager.OldCustomerManager;
import customer.manager.CustomerManager;

import java.util.List;

public class Branch {

    private String branchName;

    private MachineVendor machineShop;

    private ICustomerManager customerManager;

    private CustomerType typeOfCustomers;

    public Branch(String name, CustomerType customersType) {
        this.branchName = name;
        this.typeOfCustomers = customersType;
        this.machineShop = new MachineVendor();
        if (customersType == CustomerType.NORMAL) {
            customerManager = new CustomerManager();
        } else if (customersType == CustomerType.OLD) {
            customerManager = new OldCustomerManager();
        }
    }

    public void getNewMachines(List<CompletedOrder> doneOrderList) {
        doneOrderList.stream()
                .filter(order -> order.getBranchName().equals(branchName))
                .forEach( order -> {
                    customerManager.updateCustomer(order.getCustomerName(), order.getMachine());
                });
    }

    public String getBranchName() {
        return branchName;
    }

    public MachineVendor getMachineShop() {
        return machineShop;
    }

    public ICustomerManager getCustomerManager() {
        return customerManager;
    }

    public CustomerType getTypeOfCustomers() {
        return typeOfCustomers;
    }
}
