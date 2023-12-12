/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modules;


import java.util.ArrayList;



public interface IProjectManager {
    ArrayList<dataTypes.Bug> monitorBugs(Integer projectId);
    
    ArrayList<Object[]> checkTesterPerformance(Integer projectId);
    
    ArrayList<Object[]> checkDevPerformance(Integer projectId);
}
