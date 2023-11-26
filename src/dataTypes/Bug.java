/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataTypes;

import java.io.Serializable;
import java.time.LocalDateTime;


public class Bug implements Serializable, utils.Identifiable {
    public Integer id;
    public String name;
    public String type;
    public String priority;
    public String level;
    public Project project;
    public User developer;
    public User tester;
    public String createdAt;
    public Boolean status;
    public String img;
    
    public Bug(final Integer id, final String name, final String type, final String priority, final String level, final Project project, final User developer, final User tester, final String img){
        
        this.id = id;
        this.name = name;
        this.type = type;
        this.priority = priority;
        this.level = level;
        this.project = project;
        this.developer = developer;
        this.tester = tester;
        this.createdAt = LocalDateTime.now().toString().split("\\.")[0]; // gets current Data and time
        this.status = false;
        this.img = img;
    }
    
    
    @Override
    public Integer getId(){ return id; }


    @Override
    public void setId(Integer id) { this.id = id; }


}
