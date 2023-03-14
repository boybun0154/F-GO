package entity;

public class Report {
    private int id;
    private int order_id;
    private int damagePercent;
    private String title;
    private String content;
    private String date;
    private String prePic;
    private String afterPic;

    public Report(int id, int order_id, int damagePercent, String title, String content, String date, String prePic,
            String afterPic) {
        this.id = id;
        this.order_id = order_id;
        this.damagePercent = damagePercent;
        this.title = title;
        this.content = content;
        this.date = date;
        this.prePic = prePic;
        this.afterPic = afterPic;
    }

    public String getPrePic() {
        return prePic;
    }

    public void setPrePic(String prePic) {
        this.prePic = prePic;
    }

    public String getAfterPic() {
        return afterPic;
    }

    public void setAfterPic(String afterPic) {
        this.afterPic = afterPic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getDamagePercent() {
        return damagePercent;
    }

    public void setDamagePercent(int damagePercent) {
        this.damagePercent = damagePercent;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
