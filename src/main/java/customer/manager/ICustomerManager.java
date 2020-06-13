package customer.manager;

import machine.Machine;
import java.util.List;

public interface ICustomerManager<A> {

    public void addCustomer(A customer);
    public List<A> getAllCustomer();
    public A getCustomer(String value);
    public void updateCustomer(String customerName, Machine Machine);

}
