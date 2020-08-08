package business.custom;

import business.SuperBO;
import entity.Users;

import java.util.List;

public interface UsersBO extends SuperBO {
    public Users getUser(String id)throws Exception;

    public List<Users> getAllUsers()throws Exception;

    public boolean saveUser(String id,String name,String nic,String address,String contact,String email,String password,String userName,String userRole)throws Exception;

    public boolean updateUser(String id,String name,String nic,String address,String contact,String email,String password,String userName,String userRole)throws Exception;

    public boolean deleteUser(String id)throws Exception;

    public String getNewUserID()throws Exception;
}
