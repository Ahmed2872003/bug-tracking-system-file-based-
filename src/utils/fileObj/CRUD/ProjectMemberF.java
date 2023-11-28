/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils.fileObj.CRUD;

import java.util.ArrayList;
import java.util.function.Predicate;

/**
 *
 * @author ahmed
 */
public class ProjectMemberF extends ObjF<dataTypes.ProjectMember> {

    public ProjectMemberF() {
        super("ProjectMember");
    }

    @Override
    protected void validateData(dataTypes.ProjectMember newProjectMember) throws Exception {
        if (newProjectMember == null) {
            throw new Exception("Project member can not be null");
        }

        if (newProjectMember.project_id == null || newProjectMember.member_id == null) {
            throw new Exception("Provide all data");
        }

        checkUnique(newProjectMember);
    }

    @Override
    protected void checkUnique(dataTypes.ProjectMember newProjectMember) throws Exception {

        if (!isEmpty()) {
            openInput();

            for (dataTypes.ProjectMember storedProjectMember : (ArrayList<dataTypes.ProjectMember>) ois.readObject()) {
                if (newProjectMember.project_id.equals(storedProjectMember.project_id) && newProjectMember.member_id.equals(storedProjectMember.member_id) && !newProjectMember.getId().equals(storedProjectMember.getId())) {
                    closeInput();

                    throw new Exception("This member already in the project");
                }
            }
            closeInput();
        }

    }

    public ArrayList<dataTypes.Project> getProjects(Integer memberId) throws Exception{
        Predicate<dataTypes.ProjectMember> predicate = (projecdtMember)-> projecdtMember.member_id.equals(memberId);
        
        ArrayList<dataTypes.Project> res = new ArrayList<dataTypes.Project>();
        
        for(dataTypes.ProjectMember projectMember: get(predicate)){
            res.add(new ProjectF().getByID(projectMember.project_id));
        }
        
        return res;
    }

    public ArrayList<dataTypes.User> getMembers(Integer projectId, Predicate<dataTypes.User> ...predicates) throws Exception {
        
        Predicate<dataTypes.ProjectMember> predicate = (projecdtMember)-> projecdtMember.project_id.equals(projectId);
        
        ArrayList<dataTypes.User> res = new ArrayList<dataTypes.User>();
        
        for(dataTypes.ProjectMember projectMember: get(predicate)){
            
            UserF userFile = new UserF();
            
            dataTypes.User member = userFile.getByID(projectMember.member_id);
            
            if(userFile.matchFilters(member, predicates)) res.add(member);
        }
        
        return res;
        
    }
    
    public dataTypes.ProjectMember create(dataTypes.ProjectMember projectMember) throws Exception{
        
        if(new ProjectF().getByID(projectMember.project_id) == null)
            throw new Exception("No project with that id");
        
        else if(new UserF().getByID(projectMember.member_id) == null)
            throw new Exception("No user with that id");
            
        
        return super.create(projectMember);
    }
 
            
}
