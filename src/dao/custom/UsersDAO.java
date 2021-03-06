package dao.custom;

import dao.CrudDAO;
import entity.Users;

public interface UsersDAO extends CrudDAO<Users,String> {
    public String getLastUserID()throws Exception;

    public int searchUserRole(Users entity)throws Exception;
}
