/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modules;

import java.util.ArrayList;
import utils.fileObj.CRUD.BugF;

/**
 *
 * @author ahmed
 */
public class Project_Manager extends dataTypes.User{
    public Project_Manager(final Integer id, final String name, final String email, final String password, final String role){
        super(id, name, email, password, role);
    }

    public ArrayList<dataTypes.Bug> monitorBugs(Integer projectId) throws Exception{
        return new BugF().get((bug)-> bug.getProject_id().equals(projectId));
    }

    public void checkPerformance(){} // ???
    
    
}
