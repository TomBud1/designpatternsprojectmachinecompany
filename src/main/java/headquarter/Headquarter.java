package headquarter;

import machine.MachineType;
import machine.Machine;
import machine.MachineFactory;
import machine.caterpillar.factory.CaterpillarMachineFactory;
import order.CompletedOrder;
import order.Order;
import vendor.Branch;
import java.util.ArrayList;
import java.util.List;

public class Headquarter {

        private static Headquarter headquarter;

        private List<Branch> branchList;

        private List<Order> orderList;

        private List<CompletedOrder> availableMachinesList;

        private MachineFactory caterpillarFactory;

        private Headquarter() {
            this.branchList = new ArrayList();
            this.orderList = new ArrayList();
            this.availableMachinesList = new ArrayList();
            this.caterpillarFactory = new CaterpillarMachineFactory();
        }

        public static synchronized Headquarter getInstance() {
            if (headquarter == null) {
                headquarter = new Headquarter();
            }
            return headquarter;
        }

        public void addNewBranch(Branch branch) {
            branchList.add(branch);
        }

        public Branch getBranchFromList(String branchName) {
            return branchList.stream()
                    .filter( branch -> branch.getBranchName().equals(branchName))
                    .findFirst()
                    .orElse(null);
        }

        public void informAboutNewMachines() {
            branchList.stream().forEach( branch -> branch.getNewMachines(availableMachinesList));
            availableMachinesList = new ArrayList();
        }

        public void produceAllMachines() {
            orderList.stream()
                    .forEach((order) -> {
                        Machine Machine = caterpillarFactory.orderMachine(order.getMachineType());
                        availableMachinesList.add(new CompletedOrder(Machine, order.getCustomerName(), order.getBranchName()));
                    });
            orderList = new ArrayList();
        }

        public void addMachineToOrderList(MachineType MachineType, String customerName, String branchName) {
            orderList.add(new Order(MachineType, customerName, branchName));
        }

    public static Headquarter getHeadquarter() {
        return headquarter;
    }

    public List<Branch> getBranchList() {
        return branchList;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public List<CompletedOrder> getAvailableMachinesList() {
        return availableMachinesList;
    }

    public MachineFactory getFordFactory() {
        return caterpillarFactory;
    }
}
