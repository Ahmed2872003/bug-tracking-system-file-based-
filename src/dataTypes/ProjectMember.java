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
public class ProjectMember extends dataTypes implements Serializable, utils.Identifiable{
    protected Integer id;
    protected Integer project_id;
    protected Integer member_id;
    
    public ProjectMember(final Integer project_id, final Integer member_id){
        this.project_id = project_id;
        this.member_id = member_id;
    }
    @Override
    public Integer getId(){ return id; }
    public Integer getProject_id() { return project_id; }
    public Integer getMember_id() { return member_id; }


    @Override
    public void setId(Integer id){ this.id = id; }
}
