/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

/**
 *
 * @author ahmed
 */
public class Project {
    private Integer id = null;
    private String name = null;
    private String adminId = null;
    
    public Project(final Integer id, final String name, final String adminId){
        this.id = id;
        this.name = name;
        this.adminId = adminId;
    }
    
    // getters
    public Integer getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public String getAdminId(){
        return this.adminId;
    }
    

}
