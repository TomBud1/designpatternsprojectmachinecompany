import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import user.builder.UserBuilder;
import user.model.User;

public class BuilderOrFactoryUser {

    UserBuilder userBuilder;

    @Before
    public void prepare_builder() {
        this.userBuilder = new UserBuilder();
    }

    @Test
    public void build_user_with_email() {

        User userBuildedWithEmail = userBuilder
                .withUserName("JanKowalski")
                .withAge(29).withAddress("Dluga 10, 80-000, Gdansk")
                .withEmail("email@example.com")
                .buildUser();

        Assert.assertEquals("JanKowalski", userBuildedWithEmail.getUserName());
        Assert.assertEquals("Dluga 10, 80-000, Gdansk", userBuildedWithEmail.getAddress());
        Assert.assertEquals(29, userBuildedWithEmail.getAge());
        Assert.assertEquals("email@example.com", userBuildedWithEmail.getEmail());
        Assert.assertEquals(0, userBuildedWithEmail.getPhoneNumber());

    }

    @Test
    public void build_user_with_phone_number() {
        UserBuilder userBuilder = new UserBuilder();

        User userBuildedWithphoneNumber = userBuilder
                .withUserName("JanKowalski")
                .withAge(29).withAddress("Dluga 10, 80-000, Gdansk")
                .withPhoneNumber(123456789)
                .buildUser();

        Assert.assertEquals("JanKowalski", userBuildedWithphoneNumber.getUserName());
        Assert.assertEquals("Dluga 10, 80-000, Gdansk", userBuildedWithphoneNumber.getAddress());
        Assert.assertEquals(29, userBuildedWithphoneNumber.getAge());
        Assert.assertEquals(null, userBuildedWithphoneNumber.getEmail());
        Assert.assertEquals(123456789, userBuildedWithphoneNumber.getPhoneNumber());

    }

    @Test
    public void build_user_with_email_and_phone_number() {

        User userBuildedWithEmailAndPhoneNumber = userBuilder
                .withUserName("JanKowalski")
                .withAge(29).withAddress("Dluga 10, 80-000, Gdansk")
                .withEmail("email@example.com")
                .withPhoneNumber(123456789)
                .buildUser();

        Assert.assertEquals("JanKowalski", userBuildedWithEmailAndPhoneNumber.getUserName());
        Assert.assertEquals("Dluga 10, 80-000, Gdansk",
                userBuildedWithEmailAndPhoneNumber.getAddress());
        Assert.assertEquals(29, userBuildedWithEmailAndPhoneNumber.getAge());
        Assert.assertEquals("email@example.com", userBuildedWithEmailAndPhoneNumber.getEmail());
        Assert.assertEquals(123456789, userBuildedWithEmailAndPhoneNumber.getPhoneNumber());

    }

}
