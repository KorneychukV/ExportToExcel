package ru.vkorneychuk.POJO;

public class Car {

    private Integer id;
    private String mark;
    private String model;
    private String number;

    public Car() {
    }

    public Car(Integer id, String mark, String model, String number) {
        this.id = id;
        this.mark = mark;
        this.model = model;
        this.number = number;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
