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
    public ArrayList<dataTypes.Bug> viewAllBugs(Integer projectId) {
        ArrayList<dataTypes.Bug> res = new ArrayList<dataTypes.Bug>();

        try {
            res = new BugF().get((bug) -> bug.getProject_id().equals(projectId));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return res;

    }

    @Override
    public dataTypes.User addUser(dataTypes.User user) {
        dataTypes.User res = null;
        try {
            res = new UserF().create(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public void deleteUser(Integer userId) {
        try {
            new UserF().delete((user) -> user.getId().equals(userId));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void addUserToProject(Integer userId, Integer projectId) {
        try {
            new ProjectMemberF().create(new ProjectMember(projectId, userId));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteUserFromProject(Integer memberId, Integer projectId) {
        try {
            new ProjectMemberF().delete((pm) -> pm.getMember_id().equals(memberId) && pm.getProject_id().equals(projectId));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updateUser(Object newData[][], Integer userId) {
        try {
            new UserF().update(newData, (user) -> user.getId().equals(userId));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
