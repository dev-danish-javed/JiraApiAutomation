package helper.utils;

import helper.pojo.comment.body.CommentBody;
import helper.pojo.comment.body.Visibility;
import helper.pojo.issue.body.Fields;
import helper.pojo.issue.body.IssueBody;
import helper.pojo.issue.body.Issuetype;
import helper.pojo.issue.body.Project;
import helper.pojo.session.body.CreateSessionBody;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.filter.session.SessionFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.configuration.PropertiesConfiguration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import static io.restassured.RestAssured.given;

public class Utils {


    static RequestSpecification req;

    public static String getProperties(String key) {
        try {
            PropertiesConfiguration prop = new PropertiesConfiguration(".\\src\\test\\resources\\config.properties");
            return prop.getString(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean setProperties(String key, String value) {
        boolean flag;

        try {
            PropertiesConfiguration prop = new PropertiesConfiguration(".\\src\\test\\resources\\config.properties");
            prop.setProperty(key, value);
            prop.save();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }


    public static SessionFilter createSession() {
        CreateSessionBody sessionBody = new CreateSessionBody();
        sessionBody.setUsername("D");
        sessionBody.setPassword("113245");
        RestAssured.baseURI = getProperties("baseUri");
        SessionFilter session = new SessionFilter();
        given()
                .header("Content-Type", "application/json")
                .body(sessionBody)
                .filter(session)
                .when()
                .post("/rest/auth/1/session")
                .then()
                .assertThat().statusCode(200);

        return session;
    }

    public static JsonPath convertJsonToString(String response) {
        JsonPath js = new JsonPath(response);
        return js;
    }

    public static RequestSpecification requestSpecification() {
        if (req==null) {
            PrintStream log = null;
            try {
                log = new PrintStream(new File("logs.txt"));
            } catch (FileNotFoundException e) {
                System.err.println("Error loading log file !!!!!!");
                e.printStackTrace();
            }
            req = new RequestSpecBuilder().setBaseUri(getProperties("baseUri"))
                    .addFilter(RequestLoggingFilter.logRequestTo(log))
                    .addFilter(ResponseLoggingFilter.logResponseTo(log))
                    .setContentType(ContentType.JSON).build();
        }
        return req;
    }

}
