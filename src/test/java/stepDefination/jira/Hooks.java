package stepDefination.jira;




import helper.utils.Utils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.filter.session.SessionFilter;



public class Hooks {
    protected static SessionFilter session;

    @Before
    public void setup()
    {
        System.err.println("Output from before");
        if (session==null)
        {
            session= Utils.createSession();
        }
    }

    @After
    public  void after()
    {
        System.err.println("Output from After");
    }

}
