/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modules;

import java.util.ArrayList;
import java.util.function.Predicate;
import utils.fileObj.CRUD.*;

/**
 *
 * @author ahmed
 */
public class Project_Manager extends dataTypes.User implements IProjectManager {

    public Project_Manager(final Integer id, final String name, final String email, final String password, final String role) {
        super(id, name, email, password, role);
    }

    @Override
    public ArrayList<dataTypes.Bug> monitorBugs(Integer projectId) {

        ArrayList<dataTypes.Bug> res = new ArrayList<dataTypes.Bug>();
        try {
            res = new BugF().get((bug) -> bug.getProject_id().equals(projectId));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return res;
    }

    @Override
    public ArrayList<Object[]> checkTesterPerformance(Integer projectId) {

        ArrayList<Object[]> testersPerformance = new ArrayList<Object[]>();

        try {
            ArrayList<dataTypes.ProjectMember> projectMembers = new ProjectMemberF().get((pm) -> pm.getProject_id().equals(projectId)); // Get all the project members

            for (dataTypes.ProjectMember pm : projectMembers) {
                dataTypes.User member = new UserF().getByID(pm.getMember_id()); // get member details

                if (member.getRole().equals("Tester")) {

                    ArrayList<dataTypes.Bug> idenBugs = new BugF().get((bug) -> bug.getTester_id() != null && bug.getTester_id().equals(member.getId()) && bug.getProject_id().equals(projectId));

                    testersPerformance.add(new Object[]{member.getId(), member.getName(), idenBugs.size()});
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return testersPerformance;

    }

    @Override
    public ArrayList<Object[]> checkDevPerformance(Integer projectId) {
        ArrayList<Object[]> devsPerformance = new ArrayList<Object[]>();
        
        try {
            ArrayList<dataTypes.ProjectMember> projectMembers = new ProjectMemberF().get((pm) -> pm.getProject_id().equals(projectId)); // Get all the project members

            for (dataTypes.ProjectMember pm : projectMembers) {
                dataTypes.User member = new UserF().getByID(pm.getMember_id()); // get member details

                if (member.getRole().equals("Developer")) {

                    Predicate<dataTypes.Bug> filter = (bug) -> bug.getDeveloper_id() != null && bug.getDeveloper_id().equals(member.getId()) && bug.getProject_id().equals(projectId);

                    ArrayList<dataTypes.Bug> completedBugs = new BugF().get(filter.and((bug) -> bug.getStatus()));

                    ArrayList<dataTypes.Bug> totalBugs = new BugF().get(filter);

                    devsPerformance.add(new Object[]{member.getId(), member.getName(), completedBugs.size(), totalBugs.size()});
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return devsPerformance;
    }
}
