package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import context.DBContext;
import entity.Driver;

public class DriverDAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Driver> getAllDriverAccount() {
        List<Driver> list = new ArrayList<>();
        String query = "Select * from DRIVER,ACCOUNT where DRIVER.accountID=ACCOUNT.accountID";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                int driverId = rs.getInt("driverID");
                String name = rs.getString("name");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                String status = rs.getString("status");
                String license = rs.getString("license");
                int accountId = rs.getInt("accountID");
                String account = rs.getString("account");
                String password = rs.getString("password");
                list.add(new Driver(driverId, name, phone, address, status, license, accountId, account,
                        password));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public void addDriver(String account, String password, String name, String phone, String address,
            String license) {
        String query = "insert into Account values(?,?,3); insert into DRIVER values(?,?,?,'available',?,@@identity)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, account);
            ps.setString(2, password);
            ps.setString(3, name);
            ps.setString(4, phone);
            ps.setString(5, address);
            ps.setString(6, license);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void deleteDriver(int id, String status) {

        // driver must be available to delete
        if (status.equals("available")) {
            String query = "declare @accid int;\n" +
                    "select @accid =(select accountID from DRIVER where driverID=?);\n" +
                    "delete from DRIVER where driverID = ?\n" +
                    "delete from Account where accountID =@accid ;";
            try {
                conn = new DBContext().getConnection();
                ps = conn.prepareStatement(query);
                ps.setInt(1, id);
                ps.setInt(2, id);
                ps.executeUpdate();
            } catch (Exception e) {
            }
        } else {
            throw new IllegalStateException("Driver is not available to delete");
        }
    }

    public void updateDriver(String id, String name, String phone, String address,
            String license) {
        String query = "update DRIVER set name=?, phone=?, address=?, license=? where driverID=?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, phone);
            ps.setString(3, address);
            ps.setString(4, license);
            ps.setString(5, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public int getDriverId(int accountId) {
        String query = "select driverID from DRIVER where accountID=?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, accountId);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt("driverID");
            }
        } catch (Exception e) {

        }
        return -1;
    }

    public int getDriverOrderID(int driverId) {
        String query = "select orderID from [ORDER] where driver_id=?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, driverId);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt("orderID");
            }
        } catch (Exception e) {

        }
        return -1;
    }

    public void updateDriverStatus(int driverId, String status) {
        String query = "update DRIVER set status=? where driverID=?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, status);
            ps.setInt(2, driverId);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
}
