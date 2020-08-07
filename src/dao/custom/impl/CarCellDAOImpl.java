package dao.custom.impl;

import dao.CrudUtil;
import dao.custom.CarCellDAO;
import entity.CarCell;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CarCellDAOImpl implements CarCellDAO {
    @Override
    public ResultSet getNotReservedCells() throws Exception {
        return CrudUtil.execute("SELECT cellId FROM carCells WHERE status = ?", "not reserved");
    }

    @Override
    public List<CarCell> findAll() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM carCells");
        List<CarCell> cells = new ArrayList<>();
        while (rst.next()){
            cells.add(new CarCell(rst.getString(1),rst.getString(2)));
        }
        return cells;
    }

    @Override
    public CarCell find(String pk) throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM carCells WHERE cellId = ?", pk);
        CarCell carCell = null;
        if(rst.next()){
            carCell = new CarCell(rst.getString(1),rst.getString(2));
        }
        return carCell;
    }

    @Override
    public boolean add(CarCell entity) throws Exception {
        return CrudUtil.execute("INSERT INTO carCells VALUES (?,?)",entity.getCellId(),entity.getStatus());
    }

    @Override
    public boolean update(CarCell entity) throws Exception {
        return CrudUtil.execute("UPDATE carCells SET status = ? WHERE cellId = ?",entity.getStatus(),entity.getCellId());
    }

    @Override
    public boolean delete(String pk) throws Exception {
        return CrudUtil.execute("DELETE FROM carCells WHERE cellId = ?",pk);
    }
}
