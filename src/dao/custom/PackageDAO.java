package dao.custom;

import dao.CrudDAO;
import entity.Package;

public interface PackageDAO extends CrudDAO<Package ,String> {
    public String getLastID()throws Exception;
}
