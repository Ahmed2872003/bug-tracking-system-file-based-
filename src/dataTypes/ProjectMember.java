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
    private Integer id;
    public Integer project_id;
    public Integer member_id;
    
    public ProjectMember(final Integer project_id, final Integer member_id){
        this.project_id = project_id;
        this.member_id = member_id;
    }
    @Override
    public Integer getId(){ return id; }


    @Override
    public void setId(Integer id){ this.id = id; }
}
