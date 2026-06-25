package testing;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
public class pt2 extends inheritancePt3{

    @Test
    public void UserCreatesProfile(){
        System.out.println("User profile Created");
    }


    @Test
    public void UserLoggedIn(){
        System.out.println("User has logged in succesfully");
    }

    @Test
    public void PostLiked(){
        System.out.println("User liked a Post");
    }

    @Test
    public void PostCommented(){
        System.out.println("User commented on a Post"+ "number of comments"+ comment);
    }

    @Test
    public void PostShared(){
        System.out.println("User shared a post");
    }

    @Test
    public void PostSaved(){
        System.out.println("User shared a post");
    }

}
