import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import customer.CustomerBuilder;
import customer.model.Customer;

public class CustomerBuilderCheck {

    customer.CustomerBuilder customerBuilder;

    @Before
    public void prepare_builder() {
        this.customerBuilder = new customer.CustomerBuilder();
    }

    @Test
    public void build_customer_with_email() {

        Customer customerBuildedWithEmail = customerBuilder
                .withCustomerName("JanKowalski")
                .withAddress("Dluga 10, 80-000, Gdansk")
                .withEmail("email@example.com")
                .buildCustomer();

        Assert.assertEquals("JanKowalski", customerBuildedWithEmail.getCustomerName());
        Assert.assertEquals("Dluga 10, 80-000, Gdansk", customerBuildedWithEmail.getAddress());
        Assert.assertEquals("email@example.com", customerBuildedWithEmail.getEmail());
        Assert.assertEquals(0, customerBuildedWithEmail.getPhoneNumber());

    }

    @Test
    public void build_customer_with_phone_number() {
        customer.CustomerBuilder customerBuilder = new customer.CustomerBuilder();

        Customer customerBuildedWithphoneNumber = customerBuilder
                .withCustomerName("JanKowalski")
                .withAddress("Dluga 10, 80-000, Gdansk")
                .withPhoneNumber(123456789)
                .buildCustomer();

        Assert.assertEquals("JanKowalski", customerBuildedWithphoneNumber.getCustomerName());
        Assert.assertEquals("Dluga 10, 80-000, Gdansk", customerBuildedWithphoneNumber.getAddress());
        Assert.assertEquals(null, customerBuildedWithphoneNumber.getEmail());
        Assert.assertEquals(123456789, customerBuildedWithphoneNumber.getPhoneNumber());

    }

    @Test
    public void build_customer_with_email_and_phone_number() {

        Customer customerBuildedWithEmailAndPhoneNumber = customerBuilder
                .withCustomerName("JanKowalski")
                .withAddress("Dluga 10, 80-000, Gdansk")
                .withEmail("email@example.com")
                .withPhoneNumber(123456789)
                .buildCustomer();

        Assert.assertEquals("JanKowalski", customerBuildedWithEmailAndPhoneNumber.getCustomerName());
        Assert.assertEquals("Dluga 10, 80-000, Gdansk",
                customerBuildedWithEmailAndPhoneNumber.getAddress());
        Assert.assertEquals("email@example.com", customerBuildedWithEmailAndPhoneNumber.getEmail());
        Assert.assertEquals(123456789, customerBuildedWithEmailAndPhoneNumber.getPhoneNumber());

    }

}
