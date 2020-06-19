package stepDefination.jira;


import helper.pojo.comment.body.CommentBody;
import helper.pojo.issue.body.IssueBody;
import helper.pojo.issue.response.IssueResponse;

import helper.utils.DataBuilder;
import helper.utils.Utils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.session.SessionFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class FinalTests extends Utils {

    static SessionFilter session=Hooks.session;
    static IssueBody issueBody;
    static int statusCode;
    static ResponseSpecification resSpec;
    static IssueResponse issueResponse;
    static String issueID;
    static CommentBody commentBody;
    static RequestSpecification request;
    static String addCommentAPIResponse;
    static String commentID;
    static String addAttachmentAPIResponse;
    public static String picPath=".\\pic.jpg";
    public static String textFilePath=".\\abc.txt";
    static String getIssueAPIResponseString;
    static JsonPath getIssueAPIResponse;
    static List<String> attachments=new ArrayList<String>();

    //static RequestSpecification reqSpec=new RequestSpecBuilder().setBaseUri(getProperties("baseUri"))
            //.setContentType(ContentType.JSON).build();

   static void createResponseSpecification(int statusCode)
    {
        resSpec=new ResponseSpecBuilder().expectStatusCode(statusCode).expectContentType(ContentType.JSON).build();
    }

    @Given("^Create body for createIssueAPI$")
    public void create_body_for_createIssueAPI()
    {
        issueBody=new IssueBody();
        issueBody= DataBuilder.createIssueBody();
    }
    /*@Then("^Create request specification createIssueAPI$")
    public void create_request_specification_for_createIssueAPI()
    {
        request=given().spec(reqSpec).filter(session).body(issueBody);

    }*/
    /*@And("^Create response specification for createIssueAPI$")
    public void create_response_specification_for_createIssueAPI()
    {
        statusCode=201;
        createResponseSpecification(statusCode);

    }*/
    @And("^Send request to createIssueAPI$")
    public void send_request_to_createIssueAPI()
    {
        issueResponse=request.when().post(getProperties("createIssueAPI")).
                then().spec(resSpec).extract().as(IssueResponse.class);
    }

    @And("extract issueID")
    public void extract_issueID()
    {
        issueID=issueResponse.getId();
        setProperties("issueID",issueID);

    }

    @Given("^I have issueID$")
    public  void i_have_issueID()
    {

        assertNotNull(getProperties("issueID"));
    }

    @Then("Create comment body with comment {string}")
    public void create_comment_body(String comment)
    {
        commentBody=new CommentBody();
        commentBody= DataBuilder.createCommentBody(comment);
    }

   /* @And("^Create request specification for addCommentAPI$")
    public void create_request_specifications_for_addCommentAPI()
    {
        request=given().spec(reqSpec).pathParam("issueID",issueID).filter(session).body(commentBody);
    }*/

   /* @And("^Create response specification for addCommentAPI$")
    public void create_response_specification_for_addCommentAPI()
    {
        statusCode=201;
        createResponseSpecification(statusCode);
    }*/

    @And("^Send request to addCommentAPI$")
    public void send_request_to_addCommentAPI()
    {
        addCommentAPIResponse=request.when().post(getProperties("addCommentAPI"))
                                        .then().spec(resSpec).extract().response().asString();
    }

    @And("Extract commentID")
    public void extract_commentID()
    {
        JsonPath js = convertJsonToString(addCommentAPIResponse);
        commentID=js.getString("id");


    }

    /*@Then("^Create request specification for addAttachmentAPI$")
    public void create_request_specification_for_addAttachmentAPI()
    {
        request=given().spec(reqSpec).pathParam("issueID",issueID).header("X-Atlassian-Token","no-check")
                .header("Content-Type", "multipart/form-data")
                .multiPart("file",new File(picPath))
                .multiPart("file",new File(textFilePath))
                .filter(session);
    }*/

    /*@And("^Create response specification for addAttachmentAPI$")
    public void create_response_specification_for_addAttachmentAPI()
    {
        statusCode=200;
        createResponseSpecification(statusCode);
    }*/

    @And("^Send request to addAttachmentAPI$")
    public void send_request_to_addAttachmentAPI()
    {
        addAttachmentAPIResponse=request.post(getProperties("addAttachmentAPI"))
                .then().spec(resSpec).extract().response().asString();
    }

    @And("^Extract attached files name$")
    public void extract_attached_files_name()
    {
        JsonPath response= convertJsonToString(addAttachmentAPIResponse);
        for (int i = 0;; i++) {
            String fileName = response.getString("[" + i + "].filename");
            if (fileName == null)
                break;
            else
                attachments.add(fileName);
        }
    }

    /*@Then("^Create request specification for getIssueAPI$")
    public void create_request_specification_for_getIssueAPI()
    {
        request=given().spec(reqSpec).queryParam("fields","comment")
                .queryParam("fields","summary")
                .queryParam("fields","description")
                .queryParam("fields","attachment")
                .pathParam("issueID",issueID).filter(session);
    }*/
    /*@And("^Create response specification for getIssueAPI$")
    public void create_response_specification_for_getIssueAPI()
    {
        statusCode=200;
        createResponseSpecification(statusCode);
    }*/

    @And("^Send request to getIssueAPI$")
    public void send_request_to_getIssueAPI()
    {
        getIssueAPIResponseString=request.when().get(getProperties("getIssueAPI")).then().extract().response().asString();
        getIssueAPIResponse= convertJsonToString(getIssueAPIResponseString);
    }

    @Given("^I have GetIssue API response$")
    public void i_have_getIssue_API_reponse()
    {
        assertNotNull(getIssueAPIResponse);
    }

    @And("^Verify issue summary$")
    public void verify_issue_summary()
    {
        String summary=getIssueAPIResponse.getString("fields.summary");
        assertEquals(issueBody.getFields().getSummary(),summary);

    }

    @And("^Verify issue description$")
    public void verify_issue_description()
    {
        String description=getIssueAPIResponse.getString("fields.description");
        assertEquals(issueBody.getFields().getDescription(),description);
    }

    @Then("^Verify issueID$")
    public void verify_issueID()
    {
        String issueIDFromResponseOfGetIssuesAPI=getIssueAPIResponse.getString("id");
        assertEquals(issueIDFromResponseOfGetIssuesAPI,issueID);
    }
    @Then("^Verify comment$")
    public void verify_comment()
    {
        String comment=getIssueAPIResponse.getString("fields.comment.comments[0].body");
        assertEquals(commentBody.getBody(),comment);
    }

    @Then("^Verify attachments$")
    public void verify_attachments()
    {
        boolean flagPic=false;
        boolean flagTextFile=false;
        for(int i=0;i<attachments.size();i++)
        {
            if(picPath.contains(attachments.get(i)))
                flagPic=true;
            if(textFilePath.contains(attachments.get(i)))
                flagTextFile=true;
        }
        assertTrue("Image not attached properly",flagPic);
        assertTrue("Text file not attached property",flagTextFile);
    }

    /*@Then("^Create request specification for deleteIssueAPI$")
    public void create_request_specification_for_deleteIssueAPI()
    {
        request=given().spec(reqSpec).pathParam("issueID",issueID).filter(session);
    }
*/
    /*@And("^Create response specification for deleteIssueAPI$")
    public void create_response_specification_for_deleteIssueAPI()
    {
        statusCode=204;
        createResponseSpecification(statusCode);
    }*/
    @And("^Send request to deleteIssueApi$")
    public void send_request_to_deleteIssueAPI()
    {
        given().spec(request).pathParam("issueID",getProperties("issueID")).filter(session)
                .when().delete("/rest/api/2/issue/{issueID}")
                .then().spec(resSpec);
    }
    @And("^Verify issue is deleted$")
    public void verify_issue_is_deleted()
    {
        given().pathParam("issueID",getProperties("issueID")).filter(session).when().get(getProperties("deleteIssueAPI"))
                .then().assertThat().statusCode(404);
    }

    @And("^Create response specification with status code (\\d+)$")
    public void create_response_specification_with_status_code(Integer statusCode)
    {
        resSpec=new ResponseSpecBuilder().expectStatusCode(statusCode).expectContentType(ContentType.JSON).build();
    }

    @Then("^Create request specification for \"(.*)\"$")
    public void create_request_specification_for_deleteIssueAPI(String apiName)
    {
        if(apiName.equals("createIssueAPI"))
            request=given().spec(requestSpecification()).filter(session).body(issueBody);
        else if(apiName.equals("addCommentAPI"))
            request=given().spec(requestSpecification()).pathParam("issueID",getProperties("issueID")).filter(session).body(commentBody);
        else if(apiName.equals("addAttachmentAPI"))
            request=given().spec(requestSpecification()).pathParam("issueID",getProperties("issueID")).header("X-Atlassian-Token","no-check")
                    .header("Content-Type", "multipart/form-data")
                    .multiPart("file",new File(picPath))
                    .multiPart("file",new File(textFilePath))
                    .filter(session);
        else if(apiName.equals("getIssueAPI"))
            request=given().spec(requestSpecification()).queryParam("fields","comment")
                    .queryParam("fields","summary")
                    .queryParam("fields","description")
                    .queryParam("fields","attachment")
                    .pathParam("issueID",getProperties("issueID")).filter(session);
        else if(apiName.equals("deleteIssueAPI"))
            request=given().spec(requestSpecification()).pathParam("issueID",getProperties("issueID")).filter(session);
        else System.err.println("Invalid API Name");
    }

}
