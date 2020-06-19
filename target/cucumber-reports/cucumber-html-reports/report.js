$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/FinalFeature.feature");
formatter.feature({
  "name": "Jira APIs",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Create a jira issue",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@createIssue"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Create body for createIssueAPI",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefination.jira.FinalTests.create_body_for_createIssueAPI()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Create request specification for \"createIssueAPI\"",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefination.jira.FinalTests.create_request_specification_for_deleteIssueAPI(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Create response specification with status code 201",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefination.jira.FinalTests.create_response_specification_with_status_code(java.lang.Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Send request to createIssueAPI",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefination.jira.FinalTests.send_request_to_createIssueAPI()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "extract issueID",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefination.jira.FinalTests.extract_issueID()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Comment on jira issue",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@commentOnIssue"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I have issueID",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefination.jira.FinalTests.i_have_issueID()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Create comment body with comment \"Comment from feature file\"",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefination.jira.FinalTests.create_comment_body(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Create request specification for \"addCommentAPI\"",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefination.jira.FinalTests.create_request_specification_for_deleteIssueAPI(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Create response specification with status code 201",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefination.jira.FinalTests.create_response_specification_with_status_code(java.lang.Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Send request to addCommentAPI",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefination.jira.FinalTests.send_request_to_addCommentAPI()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Extract commentID",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefination.jira.FinalTests.extract_commentID()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Add attachment to jira issue",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@addAttachmentToIssue"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I have issueID",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefination.jira.FinalTests.i_have_issueID()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Create request specification for \"addAttachmentAPI\"",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefination.jira.FinalTests.create_request_specification_for_deleteIssueAPI(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Create response specification with status code 200",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefination.jira.FinalTests.create_response_specification_with_status_code(java.lang.Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Send request to addAttachmentAPI",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefination.jira.FinalTests.send_request_to_addAttachmentAPI()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Extract attached files name",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefination.jira.FinalTests.extract_attached_files_name()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Get details of a jira issue",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@getIssueDetails"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I have issueID",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefination.jira.FinalTests.i_have_issueID()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Create request specification for \"getIssueAPI\"",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefination.jira.FinalTests.create_request_specification_for_deleteIssueAPI(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Create response specification with status code 200",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefination.jira.FinalTests.create_response_specification_with_status_code(java.lang.Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Send request to getIssueAPI",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefination.jira.FinalTests.send_request_to_getIssueAPI()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Verify entered details",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@verifyDetails"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I have GetIssue API response",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefination.jira.FinalTests.i_have_getIssue_API_reponse()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify issueID",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefination.jira.FinalTests.verify_issueID()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify issue summary",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefination.jira.FinalTests.verify_issue_summary()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify issue description",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefination.jira.FinalTests.verify_issue_description()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify comment",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefination.jira.FinalTests.verify_comment()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify attachments",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefination.jira.FinalTests.verify_attachments()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Delete jira issue",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@deleteIssue"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I have issueID",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefination.jira.FinalTests.i_have_issueID()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Create request specification for \"deleteIssueAPI\"",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefination.jira.FinalTests.create_request_specification_for_deleteIssueAPI(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Create response specification with status code 204",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefination.jira.FinalTests.create_response_specification_with_status_code(java.lang.Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Send request to deleteIssueApi",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefination.jira.FinalTests.send_request_to_deleteIssueAPI()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify issue is deleted",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefination.jira.FinalTests.verify_issue_is_deleted()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});