/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modules;

import java.util.ArrayList;
import utils.fileObj.CRUD.BugF;

public class Developer extends dataTypes.User {

    public Developer(final Integer id, final String name, final String email, final String password, final String role) {
        super(id, name, email, password, role);
    }

    public ArrayList<dataTypes.Bug> getAssignedBugs(Integer projectId) throws Exception {
        return new BugF().get((bug) -> bug.getDeveloper_id() != null, (bug) -> bug.getDeveloper_id().equals(getId()), (bug) -> bug.getProject_id().equals(projectId));
    }

    public void changeBugStatus(Integer bugId) throws Exception {
        dataTypes.Bug bug = new BugF().getByID(bugId);
        
        new BugF().update(new Object[][]{{"status", !bug.getStatus()}}, (b) -> b.getId().equals(bugId));
    }

    public void sendEmailToTester(String testerEmail, Integer bugId) {
        String message
                = "Developer with data\n"
                + "   ID: " + getId()
                + "\n   Name: " + name
                + "\n has completed a bug with id: " + bugId;

        utils.Email.send(testerEmail, "bug solved", message);
    }

}
