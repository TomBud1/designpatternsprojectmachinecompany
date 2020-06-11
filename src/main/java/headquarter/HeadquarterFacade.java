package headquarter;
import machine.MachineIterator;
import customer.CustomerType;
import machine.Machine;
import customer.model.OldCustomer;
import customer.model.Customer;
import java.util.ArrayList;
import java.util.List;

public class HeadquarterFacade {

    private Headquarter headquarter;

    public HeadquarterFacade() {
        this.headquarter = headquarter.getInstance();
    }

    public List<Customer> downloadAllNormalCustomers() {
        List<Customer> allNormalCustomers = new ArrayList();
        headquarter.getBranchList().stream().
                forEach(branch -> {
                    if(branch.getTypeOfCustomers() == CustomerType.NORMAL) {
                        allNormalCustomers.addAll(branch.getCustomerManager().getAllCustomer());
                    }
                });

        return allNormalCustomers;
    }

    public List<OldCustomer> downloadAllOldCustomers() {
        List<OldCustomer> allOldCustomers = new ArrayList();
        headquarter.getBranchList().stream().
                forEach(branch -> {
                    if(branch.getTypeOfCustomers() == CustomerType.OLD) {
                        allOldCustomers.addAll(branch.getCustomerManager().getAllCustomer());
                    }
                });

        return allOldCustomers;
    }

    public List<Machine> downloadAllBoughtMachines(List<OldCustomer> allOldCustomers, List<Customer> allNormalCustomers) {
        List<Machine> MachineList = new ArrayList();
        getAllMachinesIterator().stream()
                .forEach( (iterator) -> {
                    while(iterator.hasNext()){
                        MachineList.add(iterator.next());
                    }
                });
        return MachineList;
    }

    private List<MachineIterator> getAllMachinesIterator() {
        List<MachineIterator> MachineIterators = new ArrayList();
        downloadAllNormalCustomers().stream().forEach(customer -> MachineIterators.add(customer.createIterator()));
        downloadAllOldCustomers().stream().forEach( customer -> MachineIterators.add(customer.createIterator()));
        return MachineIterators;
    }

}
