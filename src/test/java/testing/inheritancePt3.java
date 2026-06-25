package testing;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class inheritancePt3 {
    int comment;
    @BeforeMethod
    @Parameters({"commentValue"})
    public void AddComment(String commentValue){
        this.comment = Integer.parseInt(commentValue);


    }

}
