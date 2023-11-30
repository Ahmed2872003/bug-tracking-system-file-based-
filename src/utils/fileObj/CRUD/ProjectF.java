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
public class ProjectF extends ObjF<dataTypes.Project>{
    public ProjectF(){
        super("project");
    }
    
    @Override 
    protected void validateData(dataTypes.Project newProject) throws Exception{
        
        if(newProject == null) throw new Exception("Project can not be null");
            
        if(newProject.getName() == null || newProject.getName().isBlank() || newProject.getAdmin_id() == null)
            throw new Exception("Provide all data");
        
        checkUnique(newProject);
    }
    
    @Override 
    protected void checkUnique(dataTypes.Project newProject) throws Exception{
        if(!isEmpty()){
            openInput();
            
            for(dataTypes.Project storedProject: (ArrayList<dataTypes.Project>)ois.readObject()){
                if(storedProject.getName().equals(newProject.getName()) && storedProject.getAdmin_id().equals(newProject.getAdmin_id()) && !storedProject.getId().equals(newProject.getId())){
                    closeInput();
                    throw new Exception("This project has been created before");
                }
            }
            closeInput();
        }
    }
    
    
    public int delete(Predicate<dataTypes.Project>... predicates) throws Exception{
        int c = 0;
        
        for(dataTypes.Project removedProject: get(predicates)){
        
            c = super.delete((project)-> project.getId().equals(removedProject.getId()));
            
            new BugF().delete(bug-> bug.getProject_id().equals(removedProject.getId()));
            
            new ProjectMemberF().delete((projectMember) -> projectMember.getProject_id().equals(removedProject.getId()));
            
        }
        return c;
    }
    
    
}
