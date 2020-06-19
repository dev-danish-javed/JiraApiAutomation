package helper.utils;

import helper.pojo.comment.body.CommentBody;
import helper.pojo.comment.body.Visibility;
import helper.pojo.issue.body.Fields;
import helper.pojo.issue.body.IssueBody;
import helper.pojo.issue.body.Issuetype;
import helper.pojo.issue.body.Project;

public class DataBuilder {

    static public IssueBody createIssueBody() {
        IssueBody issueBody = new IssueBody();
        Fields fields = new Fields();
        Issuetype issuetype = new Issuetype();
        issuetype.setName("Bug");
        Project project = new Project();
        project.setKey("RES");
        fields.setProject(project);
        fields.setIssuetype(issuetype);
        fields.setSummary("Automated Bug");
        fields.setDescription("Bug reporting using the REST API");
        issueBody.setFields(fields);

        return issueBody;
    }

    static public CommentBody createCommentBody(String comment) {
        CommentBody commentBody = new CommentBody();
        Visibility visibility = new Visibility();
        visibility.setType("role");
        visibility.setValue("Administrators");
        commentBody.setBody(comment);
        commentBody.setVisibility(visibility);
        return commentBody;
    }

}
