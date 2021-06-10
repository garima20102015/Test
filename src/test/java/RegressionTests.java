import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by gtripathi on 6/9/2021.
 */
public class RegressionTests extends Services {




    @Test(dataProvider = "getCustomerData")
    public void bookFlight(String source, String destination, String name,String address,String city, String state, String zipcode, String cardType, String creditCardNumber, String creditCardMonth,String creditCardYear, String nameOnCard) throws IOException, InterruptedException {
            BaseTest.beforeTest();
            Services.findByNamehandType("srcName",source );
            Services.findByNamehandType("toName", destination);
            Services.submit("findFlightsButton");
            Services.submit("chooseFlight");
            Services.findByXpathandType("name",name);
            Services.findByXpathandType("address",address);
            Services.findByXpathandType("city",city);
            Services.findByXpathandType("state",state);
            Services.findByXpathandType("zipcode",zipcode);
            Services.findByXpathandType("cardType",cardType);
            Services.findByXpathandType("creditCardNumber",creditCardNumber);
            Services.clearAndEnter("creditCardMonth",creditCardMonth);
            Services.clearAndEnter("creditCardYear",creditCardYear);
            Services.findByXpathandType("nameOnCard",nameOnCard);
            Services.submit("purchaseFlight");
            String confId=Services.getText("confirmationId");
            Boolean testStatus=Boolean.FALSE;
            if(confId !=null)
            {
                testStatus=Boolean.TRUE;
                Assert.assertTrue(testStatus);

            }
            else
                Assert.assertFalse(testStatus);





    }



}
