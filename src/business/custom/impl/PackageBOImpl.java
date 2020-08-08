package business.custom.impl;

import business.custom.PackageBO;
import dao.DAOFactory;
import dao.DAOType;
import dao.custom.PackageDAO;
import entity.Package;

import java.util.List;

public class PackageBOImpl implements PackageBO {
    @Override
    public boolean addPackage(Package entity) throws Exception {
        PackageDAO packageDAO = DAOFactory.getInstance().getDAO(DAOType.PACKAGE);
        return packageDAO.add(entity);
    }

    @Override
    public boolean updatePackage(Package entity) throws Exception {
        PackageDAO packageDAO = DAOFactory.getInstance().getDAO(DAOType.PACKAGE);
        return packageDAO.update(entity);
    }

    @Override
    public boolean deletePackage(String id) throws Exception {
        PackageDAO packageDAO = DAOFactory.getInstance().getDAO(DAOType.PACKAGE);
        return packageDAO.delete(id);
    }

    @Override
    public List<Package> getAllPackages() throws Exception {
        PackageDAO packageDAO = DAOFactory.getInstance().getDAO(DAOType.PACKAGE);
        return packageDAO.findAll();
    }

    @Override
    public Package getPackage(String id) throws Exception {
        PackageDAO packageDAO = DAOFactory.getInstance().getDAO(DAOType.PACKAGE);
        return packageDAO.find(id);
    }

    @Override
    public String createNewPackageID() throws Exception {
        PackageDAO packageDAO = DAOFactory.getInstance().getDAO(DAOType.PACKAGE);
        String lastID = packageDAO.getLastID();
        if(lastID == null){
            return "P001";
        }
        lastID = lastID.substring(1, 4);
        int newID = Integer.parseInt(lastID) + 1;
        if(newID < 10){
            return "P00"+newID;
        }else if(newID < 100){
            return "P0"+newID;
        }else {
            return "P"+ newID;
        }
    }
}
