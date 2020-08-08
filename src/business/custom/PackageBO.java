package business.custom;

import business.SuperBO;
import entity.Package;

import java.util.List;

public interface PackageBO extends SuperBO {

    public boolean addPackage(Package entity)throws Exception;

    public boolean updatePackage(Package entity)throws Exception;

    public boolean deletePackage(String id)throws Exception;

    public List<Package> getAllPackages()throws Exception;

    public Package getPackage(String id)throws Exception;

    public String createNewPackageID()throws Exception;
}
