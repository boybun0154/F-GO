/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

public class Order {
    private int orderId;
    private int customerID;
    private int productId;
    private String address;
    private int totalMoney;
    private int status;
    private String timeBegin;
    private String timeEnd;
    private String area;
    private String startLocation;
    private String endLocation;
    private int driverId;
    private int statusMoney;

    public Order() {
    }

    public Order(int orderId, int customerID, int productId, String address, int totalMoney, int status,
            String timeBegin, String timeEnd, String area, String startLocation, String endLocation, int driverId, int statusMoney) {
        this.orderId = orderId;
        this.customerID = customerID;
        this.productId = productId;
        this.address = address;
        this.totalMoney = totalMoney;
        this.status = status;
        this.timeBegin = timeBegin;
        this.timeEnd = timeEnd;
        this.area = area;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.driverId = driverId;
        this.statusMoney = statusMoney;
    }
    
    public Order(int orderId, int customerID, int productId, String address, int totalMoney, int status,
            String timeBegin, String timeEnd, String area, String startLocation, String endLocation, int driverId) {
        this.orderId = orderId;
        this.customerID = customerID;
        this.productId = productId;
        this.address = address;
        this.totalMoney = totalMoney;
        this.status = status;
        this.timeBegin = timeBegin;
        this.timeEnd = timeEnd;
        this.area = area;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.driverId = driverId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(int totalMoney) {
        this.totalMoney = totalMoney;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTimeBegin() {
        return timeBegin;
    }

    public void setTimeBegin(String timeBegin) {
        this.timeBegin = timeBegin;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }

    public String getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(String endLocation) {
        this.endLocation = endLocation;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public int getStatusMoney() {
        return statusMoney;
    }

    public void setStatusMoney(int statusMoney) {
        this.statusMoney = statusMoney;
    }
    
}