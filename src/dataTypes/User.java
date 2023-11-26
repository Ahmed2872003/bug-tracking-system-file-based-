/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataTypes;

import java.sql.*;
import database.DB;
import java.io.Serializable;
import utils.Identifiable;
/**
 *
 * @author ahmed
 */
public class User implements Serializable, Identifiable{
    
    public Integer id;
    public String name;
    public String email;
    public String password;
    public String role;
    
    
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
    @Override
    public void setId(Integer id) { this.id = id; }
    
}
