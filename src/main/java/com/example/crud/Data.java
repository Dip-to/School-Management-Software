package com.example.crud;

public class Data {

    private final Integer crud_id;
    private final String crud_name;
    private final String curd_class;
    private final String curd_gender;
    private final String curd_picture;

    Data(Integer crud_id, String crud_name, String curd_class, String curd_gender, String curd_picture){
        this.crud_id=crud_id;
        this.crud_name=crud_name;
        this.curd_class=curd_class;
        this.curd_gender=curd_gender;
        this.curd_picture = curd_picture;
    }

    public Integer getCrud_id() {
        return crud_id;
    }

    public String getCurd_name() {
        return crud_name;
    }

    public String getCurd_class() {
        return curd_class;
    }

    public String getCurd_gender() { return curd_gender; }

    public String getCurd_picture() {
        return curd_picture;
    }
}
