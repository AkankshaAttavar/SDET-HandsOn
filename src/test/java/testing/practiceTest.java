package testing;
import org.testng.annotations.Test;

public class practiceTest {
    @Test
    public void userLoginPage() {
        System.out.println("User add details");
    }
    @Test
    public void userForgotPassword() {
        System.out.println("User forgot Password");
    }
    @Test
    public void userForgotUsername() {
        System.out.println("User forgot username");
    }
    @Test(enabled = false)
    public void userNotFound() {
        System.out.println("User Not found");
    }


}
