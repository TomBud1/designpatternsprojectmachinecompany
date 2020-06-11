package order;
import machine.MachineType;

public class Order {
    private MachineType MachineType;
    private String customerName;
    private String branchName;

    public Order(MachineType MachineType, String customerName, String branchName) {
        this.MachineType = MachineType;
        this.customerName = customerName;
        this.branchName = branchName;
    }

    public MachineType getMachineType() {
        return MachineType;
    }

    public void setMachineType(MachineType MachineType) {
        this.MachineType = MachineType;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    @Override
    public String toString() {
        return "Order{" +
                "MachineType=" + MachineType +
                ", customerName='" + customerName + '\'' +
                ", branchName='" + branchName + '\'' +
                '}';
    }
}
