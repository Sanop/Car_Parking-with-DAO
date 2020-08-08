package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.PackageCellsDAO;
import entity.CarCell;
import entity.PackageCells;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PackageCellsDAOImpl implements PackageCellsDAO {
    @Override
    public ResultSet getNotReservedCells() throws Exception {
        return CrudUtil.execute("SELECT cellId FROM packageCells WHERE status = ?", "not reserved");
    }

    @Override
    public List<PackageCells> findAll() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM packageCells");
        List<PackageCells> cells = new ArrayList<>();
        while (rst.next()){
            cells.add(new PackageCells(rst.getString(1),rst.getString(2)));
        }
        return cells;
    }

    @Override
    public PackageCells find(String pk) throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM packageCells WHERE cellId = ?", pk);
        PackageCells carCell = null;
        if(rst.next()){
            carCell = new PackageCells(rst.getString(1),rst.getString(2));
        }
        return carCell;
    }

    @Override
    public boolean add(PackageCells entity) throws Exception {
        return CrudUtil.execute("INSERT INTO packageCells VALUES (?,?)",entity.getId(),entity.getStatus());
    }

    @Override
    public boolean update(PackageCells entity) throws Exception {
        return CrudUtil.execute("UPDATE packageCells SET status = ? WHERE cellId = ?",entity.getStatus(),entity.getId());
    }

    @Override
    public boolean delete(String pk) throws Exception {
        return CrudUtil.execute("DELETE FROM packageCells WHERE cellId = ?",pk);
    }
}
