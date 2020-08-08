package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.PackageDAO;
import entity.Package;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PackageDAOImpl implements PackageDAO {
    @Override
    public List<Package> findAll() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM package");
        List<Package> packages = new ArrayList<>();
        while (rst.next()){
            packages.add(new Package(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3)));
        }
        return packages;
    }

    @Override
    public Package find(String pk) throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM package WHERE id = ?",pk);
        Package aPackage = null;
        if(rst.next()){
            aPackage = new Package(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3));
        }
        return aPackage;
    }

    @Override
    public boolean add(Package entity) throws Exception {
        return CrudUtil.execute("INSERT INTO package VALUES (?,?,?)",entity.getId(),entity.getType(),entity.getPrice());
    }

    @Override
    public boolean update(Package entity) throws Exception {
        return CrudUtil.execute("UPDATE package SET type = ? ,price = ? WHERE id = ?",entity.getType(),entity.getPrice(),entity.getId());
    }

    @Override
    public boolean delete(String pk) throws Exception {
        return CrudUtil.execute("DELETE FROM package WHERE id = ?",pk);
    }

    @Override
    public String getLastID() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT id FROM package ORDER BY id DESC LIMIT 1");
        if(rst.next()){
            return rst.getString(1);
        }
        return null;
    }
}
