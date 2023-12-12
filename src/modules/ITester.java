/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modules;


import java.util.ArrayList;



public interface ITester {
    dataTypes.Bug defineBug(final String name, final String type, final String priority, final String level, final Integer project_id);
    
    void assignBugToDev(Integer bugId, Integer developerId);
    
    void attachScreenshotOfBug(dataTypes.Bug bug, String screenShotPath);

    void updateBug(Object newData[][], Integer bugId);
    
    ArrayList<dataTypes.Bug> monitorBugs(Integer projectId);
    
    boolean sendEmailToDev(String devEmail, dataTypes.Bug bug);

}
