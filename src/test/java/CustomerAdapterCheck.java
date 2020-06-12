import machine.Machine;
import machine.caterpillar.factory.CaterpillarMachineFactory;
import machine.MachineType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import customer.OldCustomerAdapter;
import customer.CustomerAdapter;
import customer.CustomerBuilder;
import customer.model.IOldCustomer;
import customer.model.ICustomer;
import customer.model.OldCustomer;

import java.util.ArrayList;
import java.util.List;

public class CustomerAdapterCheck {

    OldCustomerAdapter oldCustomerAdapter;
    CustomerAdapter customerAdapter;

    IOldCustomer oldCustomer;
    ICustomer customer;

    CaterpillarMachineFactory caterpillarFactory;
    Machine dozer;
    Machine compactor;

    @Before
    public void prepareTests() {
        caterpillarFactory = CaterpillarMachineFactory.getInstance();
        dozer = caterpillarFactory.orderMachine(MachineType.DOZER);
        compactor = caterpillarFactory.orderMachine(MachineType.COMPACTOR);
        prepareOldCustomer();
        prepareCustomer();

    }

    @Test
    public void should_convert_old_customer_to_customer() {
        oldCustomerAdapter = new OldCustomerAdapter(oldCustomer);
        Assert.assertEquals(oldCustomerAdapter.getBoughtMachines(), customer.getBoughtMachines());
        Assert.assertEquals(oldCustomerAdapter.getCustomerName(), customer.getCustomerName());
    }

    @Test
    public void should_convert_customer_to_old_customer() {
        customerAdapter = new CustomerAdapter(customer);
        Assert.assertEquals(oldCustomer.getFirstName(), customerAdapter.getFirstName());
        Assert.assertEquals(oldCustomer.getSecondName(), customerAdapter.getSecondName());
        Assert.assertEquals(oldCustomer.getBoughtMachines(), customerAdapter.getBoughtMachines());
    }

    private void prepareOldCustomer() {
        Machine[] Machines = new Machine[2];
        Machines[0] = dozer;
        Machines[1] = compactor;

        this.oldCustomer = new OldCustomer(
                "Jan",
                "Kowalski",
                "Przykladna 22",
                "jankowalski@example.com",
                123123123,
                Machines
        );
    }

    private void prepareCustomer() {
        List<Machine> MachineList = new ArrayList();
        MachineList.add(dozer);
        MachineList.add(compactor);

        CustomerBuilder customerBuilder = new CustomerBuilder();

        this.customer = customerBuilder
                .withCustomerName("Jan Kowalski")
                .withAddress("Przykladna 22")
                .withEmail("jankowalski@example.com")
                .withPhoneNumber(123123123)
                .withBoughtMachines(MachineList)
                .buildCustomer();
    }

}
