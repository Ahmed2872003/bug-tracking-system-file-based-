/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataTypes;

import java.io.Serializable;
import utils.Identifiable;
/**
 *
 * @author ahmed
 */
public class User extends dataTypes implements Serializable, Identifiable{
    
    protected Integer id;
    protected String name;
    protected String email;
    protected String password;
    protected String role;
    
    
    public User(final Integer id, final String name, final String email, final String password, final String role){
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }
    
    public User(){}

    public boolean is(String role){
        return this.role.equals(role);
        
    }
    
    @Override
    public Integer getId(){ return id; }
    public String getName(){ return name; }
    public String getEmail(){ return email; }
    public String getPassword(){ return password; }
    public String getRole(){ return role; }
    
    
    @Override
    public void setId(Integer id) { this.id = id; }
    
}
