package order;
import machine.Machine;

public class CompletedOrder {
    private Machine Machine;
    private String customerName;
    private String branchName;

    public CompletedOrder(Machine Machine, String customerName, String branchName) {
        this.Machine = Machine;
        this.customerName = customerName;
        this.branchName = branchName;
    }

    public Machine getMachine() {
        return Machine;
    }

    public void setMachine(Machine Machine) {
        this.Machine = Machine;
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
}


