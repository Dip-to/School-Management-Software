package com.example.crud;

public class Data {

    private final Integer crud_id;
    private final String curd_surname;
    private final String curd_givename;
    private final String curd_gender;
    private final String curd_picture;

    Data(Integer curd_id, String curd_surname, String curd_givenname, String curd_gender, String curd_picture){
        this.crud_id=curd_id;
        this.curd_surname=curd_surname;
        this.curd_givename=curd_givenname;
        this.curd_gender=curd_gender;
        this.curd_picture = curd_picture;
    }

    public Integer getCrud_id() {
        return crud_id;
    }

    public String getCurd_surname() {
        return curd_surname;
    }

    public String getCurd_givenname() {
        return curd_givename;
    }

    public String getCurd_gender() {
        return curd_gender;
    }

    public String getCurd_picture() {
        return curd_picture;
    }
}
