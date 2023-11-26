
package dataTypes;

import java.io.Serializable;



public class Project implements Serializable, utils.Identifiable {
    public Integer id;
    public String name;
    public User admin;
    
    public Project(final Integer id, final String name, final User admin){
        this.id = id;
        this.name = name;
        this.admin = admin;
    }
    
    @Override
    public Integer getId(){ return id; }
    public String getName(){ return name; }
    public User getAdmin(){ return admin; }

    
    @Override
    public void setId(Integer id) { this.id = id; }
    
}
