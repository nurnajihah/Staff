package sg.edu.rp.c346.user;

import java.io.Serializable;

public class Task implements Serializable {
    private int id;
    private String name;
    private String type;
    private String user_incharge;
    private Long percent_of_uic;
    private String liaison_person;
    private Long percent_of_lp;
    private Long price;
    private Boolean complete;
    private Boolean billed;
    private String due_date;

    public Task(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Task(int id, String name, String type, String user_incharge, Long percent_of_uic, String liaison_person, Long percent_of_lp, Long price, Boolean complete, Boolean billed, String due_date) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.user_incharge = user_incharge;
        this.percent_of_uic = percent_of_uic;
        this.liaison_person = liaison_person;
        this.percent_of_lp = percent_of_lp;
        this.price = price;
        this.complete = complete;
        this.billed = billed;
        this.due_date = due_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUser_incharge() {
        return user_incharge;
    }

    public void setUser_incharge(String user_incharge) {
        this.user_incharge = user_incharge;
    }

    public Long getPercent_of_uic() {
        return percent_of_uic;
    }

    public void setPercent_of_uic(Long percent_of_uic) {
        this.percent_of_uic = percent_of_uic;
    }

    public String getLiaison_person() {
        return liaison_person;
    }

    public void setLiaison_person(String liaison_person) {
        this.liaison_person = liaison_person;
    }

    public Long getPercent_of_lp() {
        return percent_of_lp;
    }

    public void setPercent_of_lp(Long percent_of_lp) {
        this.percent_of_lp = percent_of_lp;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Boolean getComplete() {
        return complete;
    }

    public void setComplete(Boolean complete) {
        this.complete = complete;
    }

    public Boolean getBilled() {
        return billed;
    }

    public void setBilled(Boolean billed) {
        this.billed = billed;
    }

    public String getDue_date() {
        return due_date;
    }

    public void setDue_date(String due_date) {
        this.due_date = due_date;
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                '}';
    }
}
