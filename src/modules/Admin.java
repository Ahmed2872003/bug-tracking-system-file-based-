/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modules;

import dataTypes.ProjectMember;
import java.util.ArrayList;
import utils.fileObj.CRUD.BugF;
import utils.fileObj.CRUD.ProjectMemberF;
import utils.fileObj.CRUD.UserF;

/**
 *
 * @author ahmed
 */
public class Admin extends dataTypes.User implements IAdmin {

    public Admin(final Integer id, final String name, final String email, final String password, final String role) {
        super(id, name, email, password, role);
    }

    @Override
    public ArrayList<dataTypes.Bug> viewAllBugs(Integer projectId) throws Exception {
        return new BugF().get((bug) -> bug.getProject_id().equals(projectId));
    }

    @Override
    public dataTypes.User addUser(dataTypes.User user) throws Exception {
        return new UserF().create(user);
    }
    
    @Override
    public void deleteUser(Integer userId) throws Exception {
        new UserF().delete((user) -> user.getId().equals(userId));
    }
    
    
    @Override
    public void addUserToProject(Integer userId, Integer projectId) throws Exception{
        new ProjectMemberF().create(new ProjectMember(projectId, userId));
    }
    
    @Override
    public void deleteUserFromProject(Integer memberId, Integer projectId) throws Exception{
        new ProjectMemberF().delete((pm)-> pm.getMember_id().equals(memberId) && pm.getProject_id().equals(projectId));
    }

    @Override
    public void updateUser(Object newData[][], Integer userId) throws Exception {
        new UserF().update(newData, (user) -> user.getId().equals(userId));
    }

    
}
