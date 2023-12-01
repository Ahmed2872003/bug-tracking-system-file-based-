/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modules;

import java.util.ArrayList;
import utils.fileObj.CRUD.*;

/**
 *
 * @author ahmed
 */
public class Project_Manager extends dataTypes.User {

    public Project_Manager(final Integer id, final String name, final String email, final String password, final String role) {
        super(id, name, email, password, role);
    }

    public ArrayList<dataTypes.Bug> monitorBugs(Integer projectId) throws Exception {
        return new BugF().get((bug) -> bug.getProject_id().equals(projectId));
    }

    public void checkPerformance(Integer projectId) {
        try {

            ArrayList<dataTypes.ProjectMember> projectMembers = new ProjectMemberF().get((pm) -> pm.getProject_id().equals(projectId)); // Get all the project members

            for (dataTypes.ProjectMember pm : projectMembers) {
                dataTypes.User member = new UserF().getByID(pm.getMember_id()); // get member details

                if (member.getRole().equals("Developer")) {
                    ArrayList<dataTypes.Bug> devSolvedBugs = new BugF().get((bug) -> bug.getDeveloper_id() != null, (bug) -> bug.getDeveloper_id().equals(member.getId()), (bug)-> bug.getStatus()); // Get completed bugs of a developer
                    System.out.println("Developer with data: " + member.getId() + " " + member.getName() + " Solved: " + devSolvedBugs.size() + " bugs");
                }
                else if(member.getRole().equals("Tester")){
                    ArrayList<dataTypes.Bug> testerIdenBugs = new BugF().get((bug)-> bug.getTester_id() != null, (bug)-> bug.getTester_id().equals(member.getId()));
                    System.out.println("Tester with data: " + member.getId() + " " + member.getName() + " Identefied: " + testerIdenBugs.size() + " bugs");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
