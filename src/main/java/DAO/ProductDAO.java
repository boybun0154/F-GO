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
                        rs.getString(6), rs.getString(7), rs.getString(8),
                        rs.getString(9), rs.getString(10), rs.getString(11), rs.getInt(12), rs.getInt(13)));
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
                        rs.getString(6), rs.getString(7), rs.getString(8),
                        rs.getString(9), rs.getString(10), rs.getString(11), rs.getInt(12), rs.getInt(13)));
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
                        rs.getString(6), rs.getString(7), rs.getString(8),
                        rs.getString(9), rs.getString(10), rs.getString(11), rs.getInt(12), rs.getInt(13)));
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
                        rs.getString(6), rs.getString(7), rs.getString(8),
                        rs.getString(9), rs.getString(10), rs.getString(11), rs.getInt(12), rs.getInt(13)));
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
                        rs.getString(6), rs.getString(7), rs.getString(8),
                        rs.getString(9), rs.getString(10), rs.getString(11), rs.getInt(12), rs.getInt(13)));
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
                        rs.getString(6), rs.getString(7), rs.getString(8),
                        rs.getString(9), rs.getString(10), rs.getString(11), rs.getInt(12), rs.getInt(13)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public void addProduct(String name, String des, String image,
            String cateId, String seat, String gear, String color, String licensePlate, String fuel,
            String yearRelease, String price, String exCharge) {
        String query = "insert into Vehicle\n"
                + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, des);
            ps.setString(3, image);
            ps.setString(4, cateId);
            ps.setString(5, seat);
            ps.setString(6, gear);
            ps.setString(7, color);
            ps.setString(8, licensePlate);
            ps.setString(9, fuel);
            ps.setString(10, yearRelease);
            ps.setString(11, price);
            ps.setString(12, exCharge);

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
                        rs.getString(6), rs.getString(7), rs.getString(8),
                        rs.getString(9), rs.getString(10), rs.getString(11), rs.getInt(12), rs.getInt(13));
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

    public void editProduct(String name, String des, String image,
            String cateId, String seat, String gear, String color, String licensePlate, String fuel, String yearRelease,
            String price,
            String exCharge,
            String pid) {
        String query = "update Vehicle\n"
                + "set productName = ?,\n"
                + "	productTitle =?,\n"
                + "	productImg =?,\n"
                + "     categoryID = ?,\n"
                + "	seat = ?,\n"
                + "	gear = ?,\n"
                + "	color = ?,\n"
                + "	licensePlate = ?,\n"
                + "	fuel = ?,\n"
                + "	yearRelease = ?,\n"
                + "	productPrice = ?,\n"
                + "	exCharge = ?\n"
                + "Where productID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, des);
            ps.setString(3, image);
            ps.setString(4, cateId);
            ps.setString(5, seat);
            ps.setString(6, gear);
            ps.setString(7, color);
            ps.setString(8, licensePlate);
            ps.setString(9, fuel);
            ps.setString(10, yearRelease);
            ps.setString(11, price);
            ps.setString(12, exCharge);
            ps.setString(13, pid);

            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public List<Product> getTop6most() {
        List<Product> list = new ArrayList<>();
        String query = "select top 6 Vehicle.productID,productName,productTitle,productImg,Vehicle.productPrice,Vehicle.categoryID,Vehicle.seat,Vehicle.gear,Vehicle.color,Vehicle.licensePlate,Vehicle.fuel,Vehicle.yearRelease,avg(rate.rate) as rating,count(rate.rate) as Soluongrate from RATE LEFT JOIN Vehicle\n"
                +
                "                 on Vehicle.productID=rate.productID \n" +
                "                 group by Vehicle.productID,productName,productTitle,productImg,Vehicle.productPrice,Vehicle.categoryID,Vehicle.seat,Vehicle.gear,Vehicle.color,Vehicle.licensePlate,Vehicle.fuel,Vehicle.yearRelease\n"
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
                        rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getInt(5), rs.getInt(6), rs.getString(7), rs.getString(8),
                        rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12),
                        rating = rs.getFloat("rating"), cmt = rs.getInt("Soluongrate")));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Product> getnoibatmost() {
        List<Product> list = new ArrayList<>();
        String query = "select Vehicle.productID,productName,productTitle,productImg,Vehicle.productPrice,Vehicle.categoryID,Vehicle.seat,Vehicle.gear,Vehicle.color,Vehicle.licensePlate,Vehicle.fuel,Vehicle.yearRelease,avg(rate.rate) as rating,count(rate.rate) as Soluongrate from RATE LEFT JOIN Vehicle\n"
                +
                "                 on Vehicle.productID=rate.productID \n" +
                "                 group by Vehicle.productID,productName,productTitle,productImg,Vehicle.productPrice,Vehicle.categoryID,Vehicle.seat,Vehicle.gear,Vehicle.color,Vehicle.licensePlate,Vehicle.fuel,Vehicle.yearRelease\n"
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
                        rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getInt(5), rs.getInt(6), rs.getString(7), rs.getString(8),
                        rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12),
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
                        rs.getString(6), rs.getString(7), rs.getString(8),
                        rs.getString(9), rs.getString(10), rs.getString(11), rs.getInt(12), rs.getInt(13));
            }
        } catch (Exception e) {

        }
        return null;
    }

    // public void changeProductStatus(int id, String status) {
    // String query = "update Vehicle\n"
    // + "set productStatus = ?\n"
    // + "where productID = ?";
    // try {
    // conn = new DBContext().getConnection();
    // ps = conn.prepareStatement(query);
    // ps.setString(1, status);
    // ps.setInt(2, id);
    // ps.executeUpdate();
    // } catch (Exception e) {
    // }
    // }

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

    public List<Product> getProductFList() {
        List<Product> list = new ArrayList<Product>();
        String query = "select distinct * from VEHICLE";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                int productID = rs.getInt("productID");
                String productName = rs.getString("productName");
                String productTitle = rs.getString("productTitle");
                String productImg = rs.getString("productImg");
                int categoryID = rs.getInt("categoryID");
                String seat = rs.getString("seat");
                String gear = rs.getString("gear");
                String color = rs.getString("color");
                String licensePlate = rs.getString("licensePlate");
                String fuel = rs.getString("fuel");
                String yearRelease = rs.getString("yearRelease");
                int price = rs.getInt("productPrice");
                list.add(new Product(productID, productName, productTitle, productImg, categoryID, seat,
                        gear, color,
                        licensePlate, fuel, yearRelease, price));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Product> getProductBydate(String startDate, String endDate) {
        List<Product> list = new ArrayList<Product>();
        String query = "declare @start as date=?\n" +
                "declare @end as date =?\n" +
                "SELECT * FROM VEHICLE V\n" +
                "WHERE NOT EXISTS (\n" +
                "SELECT 'X' FROM [ORDER] O \n" +
                "WHERE V.productID = O.productID\n" +
                "AND (\n" +
                "(O.timeBegin <= @start AND o.timeEnd >= @end)\n" +
                "OR\n" +
                "(O.timeBegin <= @start AND o.timeEnd >= @start)\n" +
                "OR\n" +
                "(O.timeBegin >= @end AND o.timeEnd <= @end)\n" +
                "));";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, startDate);
            ps.setString(2, endDate);
            rs = ps.executeQuery();
            while (rs.next()) {
                int productID = rs.getInt("productID");
                String productName = rs.getString("productName");
                String productTitle = rs.getString("productTitle");
                String productImg = rs.getString("productImg");
                int categoryID = rs.getInt("categoryID");
                String seat = rs.getString("seat");
                String gear = rs.getString("gear");
                String color = rs.getString("color");
                String licensePlate = rs.getString("licensePlate");
                String fuel = rs.getString("fuel");
                String yearRelease = rs.getString("yearRelease");
                int price = rs.getInt("productPrice");
                list.add(new Product(productID, productName, productTitle, productImg, categoryID, seat,
                        gear, color,
                        licensePlate, fuel, yearRelease, price));
            }
        } catch (Exception e) {
        }
        return list;
    }
}
