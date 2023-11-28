
package dataTypes;

import java.io.Serializable;



public class Project implements Serializable, utils.Identifiable {
    private Integer id;
    public String name;
    public Integer admin_id;
    
    public Project(final Integer id, final String name, final Integer admin_id){
        this.id = id;
        this.name = name;
        this.admin_id = admin_id;
    }
    
    @Override
    public Integer getId(){ return id; }


    
    @Override
    public void setId(Integer id) { this.id = id; }
    
}
