package business.custom.impl;

import business.custom.UsersBO;
import dao.DAOFactory;
import dao.DAOType;
import dao.SuperDAO;
import dao.custom.UsersDAO;
import entity.Users;

import java.util.List;

public class UsersBOImpl implements UsersBO {

    UsersDAO usersDAO = DAOFactory.getInstance().getDAO(DAOType.USERS);

    @Override
    public Users getUser(String id) throws Exception {
        return usersDAO.find(id);
    }

    @Override
    public List<Users> getAllUsers() throws Exception {
        return usersDAO.findAll();
    }

    @Override
    public boolean saveUser(String id, String name, String nic, String address, String contact, String email, String password, String userName, String userRole) throws Exception {
        return usersDAO.add(new Users(id,name,nic,address,contact,email,password,userName,userRole));
    }

    @Override
    public boolean updateUser(String id, String name, String nic, String address, String contact, String email, String password, String userName, String userRole) throws Exception {
        return usersDAO.update(new Users(id,name,nic,address,contact,email,password,userName,userRole));
    }

    @Override
    public boolean deleteUser(String id) throws Exception {
        return usersDAO.delete(id);
    }

    @Override
    public String getNewUserID() throws Exception {
        String lastUserID = usersDAO.getLastUserID();
        if(lastUserID == null){
            return "U001";
        }
        lastUserID = lastUserID.substring(1, 4);
        int newID = Integer.parseInt(lastUserID) + 1;

        if(newID < 10){
            return "U00"+newID;
        }else if(newID < 100){
            return "U0"+newID;
        }else{
            return "U"+newID;
        }
    }
}
