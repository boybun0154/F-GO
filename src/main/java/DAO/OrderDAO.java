/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import context.DBContext;
import entity.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class OrderDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Order> getAllOrder() {
        List<Order> list = new ArrayList<>();
        String query = "Select * from [ORDER]";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                int orderId = rs.getInt("orderID");
                int customerID = rs.getInt("customerID");
                int productId = rs.getInt("productID");
                String address = rs.getString("address");
                int totalMoney = rs.getInt("totalMoney");
                int status = rs.getInt("status");
                String timeBegin = rs.getString("timeBegin");
                String timeEnd = rs.getString("timeEnd");
                String area = rs.getString("area");
                String startLocation = rs.getString("startLocation");
                String endLocation = rs.getString("endLocation");
                int driverId = rs.getInt("driver_id");
                list.add(new Order(orderId, customerID, productId, address, totalMoney, status, timeBegin, timeEnd,
                        area, startLocation, endLocation, driverId));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public void addOrder(int customerId, String productID, String dateBegin, String dateEnd, String address,
            int totalMoney, String status) {
        // to do
        String query = "insert into [ORDER]\n"
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, customerId);
            ps.setString(2, productID);
            ps.setString(3, dateBegin);
            ps.setString(4, dateEnd);
            ps.setString(5, address);
            ps.setFloat(6, totalMoney);
            ps.setString(7, status);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public Order getOrderById(String id) {
        // to do

        String sql = "select * from [ORDER] where orderID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Order(rs.getInt(1),
                        rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getInt(5),
                        rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9),
                        rs.getString(10), rs.getString(11), rs.getInt(12));
            }
        } catch (Exception e) {

        }
        return null;
    }

    public void editOrder(String customerID, String productId, String timeBegin, String timeEnd,
            String address, int totalMoney, String status, String oid) {
        // to do

        String query = "update [ORDER]\n"
                + "set customerID = ?,\n"
                + "	productID =?,\n"
                + "	timeBegin =?,\n"
                + "	timeEnd = ?,\n"
                + "	address = ?,\n"
                + "    totalMoney = ?,\n"
                + "	status = ?\n"
                + "Where orderID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, customerID);
            ps.setString(2, productId);
            ps.setString(3, timeBegin);
            ps.setString(4, timeEnd);
            ps.setString(5, address);
            ps.setInt(6, totalMoney);
            ps.setString(7, status);
            ps.setString(8, oid);

            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void deleteOrder(String oid) {
        // to do

        String query = "delete from [ORDER]\n"
                + "where orderID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, oid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void updateOrderStatus(int id, int status) {
        String query = "update [ORDER]\n"
                + "set status = ?\n"
                + "where orderID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, status);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public String getCustomerMail(int orderid) {
        String sql = "select email from CUSTOMER where customerID=(select top 1 customerID from [ORDER] where orderID=?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, orderid);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getString(1);
            }
        } catch (Exception e) {
        }
        return null;
    }

    public String getCustomerName(int orderid) {
        String sql = "select customerName from CUSTOMER where customerID=(select top 1 customerID from [ORDER] where orderID=?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, orderid);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getString(1);
            }
        } catch (Exception e) {
        }
        return null;
    }
}
