/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modules;

import java.util.ArrayList;
import utils.fileObj.CRUD.BugF;
import utils.fileObj.CRUD.ProjectMemberF;
import utils.fileObj.CRUD.UserF;


/**
 *
 * @author ahmed
 */
public class Admin extends dataTypes.User {
    public Admin(final Integer id, final String name, final String email, final String password, final String role) {
        super(id, name, email, password, role);
    }

    
    public ArrayList<dataTypes.Bug> viewAllBugs(Integer projectId) throws Exception{
        return new BugF().get((bug)-> bug.getId().equals(projectId));
    }

    public void addUser(dataTypes.User user, Integer projectId) throws Exception{
        dataTypes.ProjectMember pm = new dataTypes.ProjectMember(projectId, user.getId());
        
        new UserF().create(user);
        
        new ProjectMemberF().create(pm);
    }
    
    
    public void updateUser(Object newData[][] , Integer userId) throws Exception{
        new UserF().update(newData, (user)-> user.getId().equals(userId));
    }
    
    public void deleteUser(Integer userId) throws Exception{
        new UserF().delete((user)-> user.getId().equals(userId));
    }
}
