/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils.fileObj.CRUD;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.regex.*;
import java.util.ArrayList;
import java.util.function.Predicate;
import utils.fileObj.CRUD.*;

public class UserF extends ObjF<dataTypes.User> {

    private String roleRegex = "Tester|Developer|Project Manager|Admin";

    public UserF() {
        super("user");
    }

    @Override
    protected void validateData(dataTypes.User newUser) throws Exception {
        if (newUser == null) {
            throw new Exception("User can not be null");
        }

        if (newUser.getName() == null || newUser.getEmail() == null || newUser.getPassword() == null || newUser.getName().isBlank() || newUser.getEmail().isBlank() || newUser.getPassword().isBlank()) {
            throw new Exception("provide all user information");
        }

        if (!utils.Email.isValidate(newUser.getEmail())) {
            throw new Exception("Provide a valid email");
        }

        Pattern pattern = Pattern.compile(roleRegex);

        Matcher matcher = pattern.matcher(newUser.getRole());

        if (!matcher.matches()) {
            throw new Exception("valid roles are: " + roleRegex);
        }

        checkUnique(newUser);

    }

    @Override
    protected void checkUnique(dataTypes.User newUser) throws Exception {
        if (!isEmpty()) {

            openInput();

            ArrayList<dataTypes.User> storedUserList = (ArrayList<dataTypes.User>) ois.readObject();

            for (dataTypes.User storedUser : storedUserList) {
                if (storedUser.getEmail().equals(newUser.getEmail()) && storedUser.getId().intValue() != newUser.getId().intValue()) {
                    closeInput();
                    throw new Exception("This email is used");
                }
            }

            closeInput();
        }
    }

    public int delete(Predicate<dataTypes.User>... predicates) throws Exception {
        int c = 0;

        for (dataTypes.User removedUser : get(predicates)) {

            c = super.delete((user) -> user.getId().equals(removedUser.getId())); // remove the user

            ProjectMemberF ProjectMemberFile = new ProjectMemberF();

            ProjectMemberFile.delete((projectMember) -> projectMember.getMember_id().equals(removedUser.getId()));

            // handling other files when deleting a user
            switch (removedUser.getRole()) {
                case "Admin": {

                    ProjectF projectFile = new ProjectF();

                    projectFile.delete((project) -> project.getAdmin_id().equals(removedUser.getId()));

                    break;
                }

                case "Tester": {
                    BugF bugFile = new BugF();

                    bugFile.update(new Object[][]{{"tester_id", null}}, (bug) -> bug.getTester_id().equals(removedUser.getId()));

                    break;
                }

                case "Developer": {
                    BugF bugFile = new BugF();

                    bugFile.update(new Object[][]{{"developer_id", null}}, (bug) -> bug.getDeveloper_id().equals(removedUser.getId()));

                    break;
                }
            }
        }
        return c;

    }

    public int update(Object newData[][], Predicate<dataTypes.User>... predicates) throws Exception {

        int c = 0;
        int roleIndex = -1;

        for (int i = 0; i < newData.length; i++) {
            if (newData[i][0].equals("role")) {
                roleIndex = i;
                break;
            }
        }

        if (roleIndex != -1) {
            for (dataTypes.User user : get(predicates)) {
                super.update(newData, (u) -> u.getId().equals(user.getId()));
                c++;
                if ((user.getRole().equals("Developer") || user.getRole().equals("Tester")) && !user.getRole().equals(newData[roleIndex][1])) {
                    switch (user.getRole()) {
                        case "Developer":
                            new BugF().update(new Object[][]{{"developer_id", null}},(bug)-> bug.getDeveloper_id() != null, (bug) -> bug.getDeveloper_id().equals(user.getId()));
                            break;
                        case "Tester":
                            new BugF().update(new Object[][]{{"tester_id", null}}, (bug)-> bug.getTester_id()!= null, (bug) -> bug.getTester_id().equals(user.getId()));
                            break;
                    }
                }
            }
            return c;
        } else {
            return super.update(newData, predicates);
        }
    }

}

//            switch (String.valueOf(arr[0])) {
//                case "role": {
//                    utils.Regex regex = new utils.Regex(this.roleRegex);
//
//                    if (!regex.test((String) arr[1])) {
//                        throw new Exception("valid roles are: " + this.roleRegex);
//                    }
//                    break;
//                }
//                case "email": {
//                    if (!utils.Email.isValidate((String) arr[1])) {
//                        throw new Exception("Enter a valid email");
//                    }
//                    break;
//                }
//            }
