/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modules;

import java.util.ArrayList;
import utils.fileObj.CRUD.BugF;

public class Tester extends dataTypes.User {

    public Tester(final Integer id, final String name, final String email, final String password, final String role) {
        super(id, name, email, password, role);
    }

    public dataTypes.Bug defineBug(final Integer id, final String name, final String type, final String priority, final String level, final Integer project_id, final Integer developer_id, final Integer tester_id, final String img) throws Exception {

        dataTypes.Bug bug = new dataTypes.Bug(id, name, type, priority, level, project_id, developer_id, tester_id, img);

        new BugF().create(bug);

        return bug;
    }

    public void assignBugToDev(Integer bugId, Integer developerId) throws Exception {
        new BugF().update(new Object[][]{{"developer_id", developerId}}, (bug) -> bug.getId().equals(bugId));
    }

    public void attachScreenshotOfBug(Integer bugId, String screenShotPath) throws Exception {
        new BugF().update(new Object[][]{{"img", screenShotPath}}, (bug) -> bug.getId().equals(bugId));
    }

    public ArrayList<dataTypes.Bug> monitorBugs(Integer projectId) throws Exception {
        return new BugF().get((bug) -> bug.getProject_id().equals(projectId));
    }

    public boolean sendEmailToDev(String devEmail, dataTypes.Bug bug) {
        String message
                = "Bug details\n\n"
                + "   ID: " + bug.getId()
                + "\n   Name: " + bug.getName()
                + "\n   Type: " + bug.getType()
                + "\n   Priority: " + bug.getPriority()
                + "\n   Level: " + bug.getLevel()
                + "\n   Tester_id: " + getId()
                + "\n   Tester_name: " + name
                + "\n   CreatedAt: " + bug.getCreatedAt();
        
        return utils.Email.send(devEmail, "Assigning a bug", message);
    }

}
