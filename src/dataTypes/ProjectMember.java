/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataTypes;

import java.io.Serializable;

/**
 *
 * @author ahmed
 */
public class ProjectMember implements Serializable, utils.Identifiable{
    public Integer id;
    public Project project;
    public User member;
    
    ProjectMember(final Project p, final User u){
        this.project = p;
        this.member = u;
    }
    @Override
    public Integer getId(){ return id; }
    public Project getProject(){ return project; }
    public User getMember() { return member; }


    @Override
    public void setId(Integer id){ this.id = id; }
}
