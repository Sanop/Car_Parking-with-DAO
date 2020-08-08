package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.UsersDAO;
import entity.Users;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsersDAOImpl implements UsersDAO {
    @Override
    public List<Users> findAll() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM users");
        List<Users> users = new ArrayList<>();
        while(rst.next()){
            users.add(new Users(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getString(7),
                    rst.getString(8),
                    rst.getString(9)));
        }
        return users;
    }

    @Override
    public Users find(String pk) throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM users WHERE id = ?", pk);
        Users users = null;
        if(rst.next()){
            users = new Users(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getString(7),
                    rst.getString(8),
                    rst.getString(9));
        }
        return users;
    }

    @Override
    public boolean add(Users entity) throws Exception {
        return CrudUtil.execute("INSERT INTO users VALUES (?,?,?,?,?,?,?,?,?)",entity.getId(),entity.getName(),entity.getNic(),entity.getAddress(),entity.getContact(),entity.getEmail(),entity.getPassword(),entity.getUserName(),entity.getUserRole());
    }

    @Override
    public boolean update(Users entity) throws Exception {
        return CrudUtil.execute("UPDATE users SET name = ?,nic = ?,address = ?,contact = ?,email = ?,password = ?,userName = ?,userRole = ? WHERE id = ?",entity.getName(),entity.getNic(),entity.getAddress(),entity.getContact(),entity.getEmail(),entity.getPassword(),entity.getUserName(),entity.getUserRole(),entity.getId());
    }

    @Override
    public boolean delete(String pk) throws Exception {
        return CrudUtil.execute("DELETE FROM users WHERE id = ?",pk);
    }

    @Override
    public String getLastUserID() throws Exception {
        ResultSet resultSet = CrudUtil.execute("SELECT id FROM users ORDER BY id DESC LIMIT 1");
        if(resultSet.next()){
            return resultSet.getString(1);
        }
        return null;
    }

    @Override
    public int searchUserRole(Users entity) throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM users WHERE userName = ? and password = ? and userRole = ?", entity.getUserName(), entity.getPassword(), entity.getUserRole());
        if(rst.next()){
            return 1;
        }
        return 0;
    }
}
