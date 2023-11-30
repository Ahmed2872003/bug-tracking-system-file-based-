/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataTypes;

import java.io.Serializable;
import java.time.LocalDateTime;


public class Bug implements Serializable, utils.Identifiable {
    protected Integer id;
    protected String name;
    protected String type;
    protected String priority;
    protected String level;
    protected Integer project_id;
    protected Integer developer_id;
    protected Integer tester_id;
    protected String createdAt;
    protected Boolean status;
    protected String img;
    
    public Bug(final Integer id, final String name, final String type, final String priority, final String level, final Integer project_id, final Integer developer_id, final Integer tester_id, final String img){
        
        this.id = id;
        this.name = name;
        this.type = type;
        this.priority = priority;
        this.level = level;
        this.project_id = project_id;
        this.developer_id = developer_id;
        this.tester_id = tester_id;
        this.createdAt = LocalDateTime.now().toString().split("\\.")[0]; // gets current Data and time
        this.status = false;
        this.img = img;
    }
    
    
    @Override
    public Integer getId(){ return id; }
    public String getName(){ return name; }
    public String getType(){ return type; }
    public String getPriority(){ return priority; }
    public String getLevel(){ return level; }
    public Integer getProject_id(){ return project_id; }
    public Integer getDeveloper_id(){ return developer_id; }
    public Integer getTester_id(){ return tester_id; }
    public String getCreatedAt(){ return createdAt; }
    public Boolean getStatus(){ return status; }
    public String getImgPath(){ return img; }


    @Override
    public void setId(Integer id) { this.id = id; }


}
