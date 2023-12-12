/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modules;


import java.util.ArrayList;



public interface ITester {
    dataTypes.Bug defineBug(final String name, final String type, final String priority, final String level, final Integer project_id) throws Exception;
    
    void assignBugToDev(Integer bugId, Integer developerId) throws Exception;
    
    void attachScreenshotOfBug(dataTypes.Bug bug, String screenShotPath) throws Exception;

    void updateBug(Object newData[][], Integer bugId) throws Exception;
    
    ArrayList<dataTypes.Bug> monitorBugs(Integer projectId) throws Exception;
    
    boolean sendEmailToDev(String devEmail, dataTypes.Bug bug);

}
