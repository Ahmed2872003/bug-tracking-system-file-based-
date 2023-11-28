/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataTypes;

import java.io.Serializable;
import java.time.LocalDateTime;


public class Bug implements Serializable, utils.Identifiable {
    private Integer id;
    public String name;
    public String type;
    public String priority;
    public String level;
    public Integer project_id;
    public Integer developer_id;
    public Integer tester_id;
    public String createdAt;
    public Boolean status;
    public String img;
    
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


    @Override
    public void setId(Integer id) { this.id = id; }


}
