package entity;

public class Driver {
    private int driverId;
    private String name;
    private String phone;
    private String address;
    private String status;
    private String license;
    private int accountId;
    private String account;
    private String password;

    public Driver(int driverId, String name, String phone, String address, String status, String license,
            int accountId) {
        this.driverId = driverId;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.status = status;
        this.license = license;
        this.accountId = accountId;
    }

    public Driver(int driverId, String name, String phone, String address, String status, String license,
            int accountId, String account, String password) {
        this.driverId = driverId;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.status = status;
        this.license = license;
        this.accountId = accountId;
        this.account = account;
        this.password = password;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

}
