Feature: Jira APIs

  @createIssue
  Scenario: Create a jira issue
    Given Create body for createIssueAPI
    Then Create request specification for "createIssueAPI"
    And Create response specification with status code 201
    And Send request to createIssueAPI
    And extract issueID

  @commentOnIssue
  Scenario: Comment on jira issue
    Given I have issueID
    Then Create comment body with comment "Comment from feature file"
    And Create request specification for "addCommentAPI"
    And Create response specification with status code 201
    And Send request to addCommentAPI
    And Extract commentID

  @addAttachmentToIssue
  Scenario: Add attachment to jira issue
    Given I have issueID
    Then Create request specification for "addAttachmentAPI"
    And Create response specification with status code 200
    And Send request to addAttachmentAPI
    And Extract attached files name

  @getIssueDetails
  Scenario: Get details of a jira issue
    Given I have issueID
    Then Create request specification for "getIssueAPI"
    And Create response specification with status code 200
    And Send request to getIssueAPI

  @verifyDetails
  Scenario: Verify entered details
    Given I have GetIssue API response
    Then Verify issueID
    And Verify issue summary
    And Verify issue description
    And Verify comment
    And Verify attachments

  @deleteIssue
  Scenario: Delete jira issue
    Given I have issueID
    Then Create request specification for "deleteIssueAPI"
    Then Create response specification with status code 204
    Then Send request to deleteIssueApi
    Then Verify issue is deleted
