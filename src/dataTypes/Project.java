
package dataTypes;

import java.io.Serializable;



public class Project extends dataTypes implements Serializable, utils.Identifiable {
    protected Integer id;
    protected String name;
    protected Integer admin_id;
    
    public Project(final Integer id, final String name, final Integer admin_id){
        this.id = id;
        this.name = name;
        this.admin_id = admin_id;
    }
    
    @Override
    public Integer getId(){ return id; }
    public String getName() { return name; }
    public Integer getAdmin_id(){ return admin_id; }


    
    @Override
    public void setId(Integer id) { this.id = id; }
    
}
