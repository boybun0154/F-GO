package entity;

public class additionFee {
    private int id;
    private int report_id;
    private String title;
    private int fee;
    private String reason;

    public additionFee(int id, int report_id, String title, int fee, String reason) {
        this.id = id;
        this.report_id = report_id;
        this.title = title;
        this.fee = fee;
        this.reason = reason;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getReport_id() {
        return report_id;
    }

    public void setReport_id(int report_id) {
        this.report_id = report_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

}
