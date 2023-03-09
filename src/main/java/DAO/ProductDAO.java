package DAO;

import context.DBContext;
import entity.Category;
import entity.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bin
 */
public class ProductDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Product> getAllProduct() {
        List<Product> list = new ArrayList<>();
        String query = "Select * from Vehicle";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
                        rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9),
                        rs.getString(10), rs.getString(11), rs.getString(12), rs.getInt(13)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Category> getAllCategory() {
        List<Category> list = new ArrayList<>();
        String query = "Select * from CATEGORY";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Category(rs.getInt(1),
                        rs.getString(2), rs.getString(3)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Product> getAllProductByCID(String cid) {
        List<Product> list = new ArrayList<>();
        String sql = "Select * from Vehicle\n"
                + "where categoryID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, cid);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
                        rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9),
                        rs.getString(10), rs.getString(11), rs.getString(12), rs.getInt(13)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Product> getAllProductByCIDInt(int cid) {
        List<Product> list = new ArrayList<>();
        String sql = "Select * from Vehicle\n"
                + "where categoryID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, cid);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
                        rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9),
                        rs.getString(10), rs.getString(11), rs.getString(12), rs.getInt(13)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Product> searchProductByName(String txtSearch) {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT * from Vehicle\n"
                + "where productName like ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + txtSearch + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
                        rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9),
                        rs.getString(10), rs.getString(11), rs.getString(12), rs.getInt(13)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Product> getTop6() {
        List<Product> list = new ArrayList<>();
        String sql = "Select top 6 * from Vehicle";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
                        rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9),
                        rs.getString(10), rs.getString(11), rs.getString(12), rs.getInt(13)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Product> getNext6Products(int ammount) {
        List<Product> list = new ArrayList<>();
        String sql = "select * from Vehicle\n"
                + "ORDER by productID\n"
                + "OFFSET ? ROWS\n"
                + "FETCH NEXT 6 ROWS ONLY";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, ammount);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
                        rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9),
                        rs.getString(10), rs.getString(11), rs.getString(12), rs.getInt(13)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public void addProduct(String name, String des, String image, String price, String status,
            String cateId, String seat, String gear, String color, String licensePlate, String fuel,
            String yearRelease) {
        String query = "insert into Vehicle\n"
                + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, des);
            ps.setString(3, image);
            ps.setString(4, price);
            ps.setString(5, status);
            ps.setString(6, cateId);
            ps.setString(7, seat);
            ps.setString(8, gear);
            ps.setString(9, color);
            ps.setString(10, licensePlate);
            ps.setString(11, fuel);
            ps.setString(12, yearRelease);

            ps.executeUpdate();
        } catch (Exception e) {
        }

    }

    public Product getProductById(String id) {
        String sql = "select * from Vehicle where productID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Product(rs.getInt(1),
                        rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
                        rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9),
                        rs.getString(10), rs.getString(11), rs.getString(12), rs.getInt(13));
            }
        } catch (Exception e) {

        }
        return null;
    }

    public void deleteProduct(String pid) {
        String query = "delete from Vehicle\n"
                + "where productID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, pid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void editProduct(String name, String des, String image, String price, String status,
            String cateId, String seat, String gear, String color, String licensePlate, String fuel, String yearRelease,
            String pid) {
        String query = "update Vehicle\n"
                + "set productName = ?,\n"
                + "	productTitle =?,\n"
                + "	productImg =?,\n"
                + "	productPrice = ?,\n"
                + "	productStatus = ?,\n"
                + "    categoryID = ?,\n"
                + "	seat = ?,\n"
                + "	gear = ?,\n"
                + "	color = ?,\n"
                + "	licensePlate = ?,\n"
                + "	fuel = ?,\n"
                + "	yearRelease = ?\n"
                + "Where productID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, des);
            ps.setString(3, image);
            ps.setString(4, price);
            ps.setString(5, status);
            ps.setString(6, cateId);
            ps.setString(7, seat);
            ps.setString(8, gear);
            ps.setString(9, color);
            ps.setString(10, licensePlate);
            ps.setString(11, fuel);
            ps.setString(12, yearRelease);
            ps.setString(13, pid);

            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public List<Product> getTop6most() {
        List<Product> list = new ArrayList<>();
        String query = "select top 6 Vehicle.productID,productName,productTitle,productImg,Vehicle.productPrice,Vehicle.productStatus,Vehicle.categoryID,Vehicle.seat,Vehicle.gear,Vehicle.color,Vehicle.licensePlate,Vehicle.fuel,Vehicle.yearRelease,avg(rate.rate) as rating,count(rate.rate) as Soluongrate from RATE LEFT JOIN Vehicle\n"
                +
                "                 on Vehicle.productID=rate.productID \n" +
                "                 group by Vehicle.productID,productName,productTitle,productImg,Vehicle.productPrice,Vehicle.productStatus,Vehicle.categoryID,Vehicle.seat,Vehicle.gear,Vehicle.color,Vehicle.licensePlate,Vehicle.fuel,Vehicle.yearRelease\n"
                +
                "                 order by avg(rate.rate) desc";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            float rating = 0;
            int cmt = 0;
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
                        rs.getInt(6), rs.getInt(7), rs.getString(8), rs.getString(9),
                        rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13),
                        rating = rs.getFloat("rating"), cmt = rs.getInt("Soluongrate")));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public Product getProductByIdInt(int id) {
        String sql = "select * from Vehicle where productID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Product(rs.getInt(1),
                        rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
                        rs.getInt(6), rs.getString(7), rs.getString(8), rs.getString(9),
                        rs.getString(10), rs.getString(11), rs.getString(12), rs.getInt(13));
            }
        } catch (Exception e) {

        }
        return null;
    }

    public void changeProductStatus(int id, String status) {
        String query = "update Vehicle\n"
                + "set productStatus = ?\n"
                + "where productID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, status);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public List<Product> getproductTime() {
        List<Product> list = new ArrayList<>();
        String query = "SELECT top 5 [ORDER].productID, [Vehicle].productName, [Vehicle].productImg, count([ORDER].productID) as solanthue\n"
                + "FROM [ORDER]\n"
                + "INNER JOIN [Vehicle] ON [ORDER].productID=[Vehicle].productID\n"
                + "Group by [ORDER].productID, [Vehicle].productName, [Vehicle].productImg\n"
                + "ORDER by solanthue desc";

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2), rs.getString(3), rs.getInt(4)));
            }
        } catch (Exception e) {
        }
        return list;
    }
}
