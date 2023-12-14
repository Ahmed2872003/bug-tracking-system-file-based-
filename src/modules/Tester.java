/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modules;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.UUID;
import utils.fileObj.CRUD.BugF;

public class Tester extends dataTypes.User implements ITester {

    public Tester(final Integer id, final String name, final String email, final String password, final String role) {
        super(id, name, email, password, role);
    }

    @Override
    public dataTypes.Bug defineBug(final String name, final String type, final String priority, final String level, final Integer project_id) throws Exception {

        dataTypes.Bug bug = new dataTypes.Bug(null, name, type, priority, level, project_id, null, getId(), null);

        bug = new BugF().create(bug);

        return bug;
    }

    @Override
    public void assignBugToDev(Integer bugId, Integer developerId) throws Exception {

        new BugF().update(new Object[][]{{"developer_id", developerId}}, (b) -> b.getId().equals(bugId));

    }

    @Override
    public void attachScreenshotOfBug(dataTypes.Bug bug, String screenShotPath) throws Exception {

        if (bug.getImgPath() != null && screenShotPath.equals(bug.getImgPath())) {
            return;
        }

        String generatedImgName = "";

        Path srcImgPath = Paths.get(screenShotPath);

        Path destinitionPath = null;

        Path fNamePath = srcImgPath.getFileName();

        if (fNamePath != null && Files.isRegularFile(srcImgPath)) {
            String[] fNameWExt = fNamePath.toString().split("\\."); // { "imgage", "png" }

            generatedImgName = fNameWExt[0] + '-' + UUID.randomUUID().toString() + '.' + fNameWExt[1]; // make the name like this temp-e2234-213213-421412.ext

            File dirName = new File("Images");

            if (dirName.isDirectory() == false) {
                Files.createDirectory(Paths.get(dirName.getPath())); // create the directory if not exist
            }

            destinitionPath = Paths.get(dirName.getPath() + "\\" + generatedImgName);

            Files.copy(srcImgPath, destinitionPath); // copies the file from srcPath to dest path

            if (bug.getImgPath() != null && Files.isRegularFile(Paths.get(dirName.getPath() + "\\" + bug.getImgPath()))) { // delete the previous screenshot of a bug
                Files.delete(Paths.get(dirName.getPath() + "\\" + bug.getImgPath()));
            }

            new BugF().update(new Object[][]{{"img", generatedImgName}}, (b) -> b.getId().equals(bug.getId())); // update the bug with attached screenshot

            bug.setImg(generatedImgName);

        }

    }

    @Override
    public void updateBug(Object newData[][], Integer bugId) throws Exception {

        new BugF().update(newData, (bug) -> bug.getId().equals(bugId));

    }

    @Override
    public ArrayList<dataTypes.Bug> monitorBugs(Integer projectId) throws Exception {

        ArrayList<dataTypes.Bug> res = new ArrayList<dataTypes.Bug>();

        res = new BugF().get((bug) -> bug.getProject_id().equals(projectId));

        return res;
    }

    @Override
    public boolean sendEmailToDev(String devEmail, dataTypes.Bug bug) {
        String message
                = "Bug details\n\n"
                + "   ID: " + bug.getId()
                + "\n   Name: " + bug.getName()
                + "\n   Type: " + bug.getType()
                + "\n   Priority: " + bug.getPriority()
                + "\n   Level: " + bug.getLevel()
                + "\n   Tester_id: " + getId()
                + "\n   Tester_name: " + name
                + "\n   CreatedAt: " + bug.getCreatedAt();

        return utils.Email.send(devEmail, "Assigning a bug", message);
    }

}
