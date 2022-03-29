package com.example.crud;

public class Officer extends Employee
{
    public int crd_id;
    public String crd_name;
    public String  cud_designation;
    public String crd_mobile;
    public String cud_gender;
    public String crd_picture;

    Officer(Integer crud_id, String crud_name, String curd_class, String curd_gender, String curd_picture, String crud_mobile) {
        super(crud_id, crud_name, curd_class, curd_gender, curd_picture, crud_mobile);
    }
    @Override
    public Integer getCrud_id() {
        return crd_id;
    }
    @Override
    public String getCurd_name() {
        System.out.println("over");
        return crd_name;
    }
    @Override
    public String getCurd_class() {
        return cud_designation;
    }
    @Override
    public String getCurd_gender() { return cud_gender; }
    @Override
    public String getCurd_picture() {
        return crd_picture;
    }
    @Override
    public String getCurd_mobile() { return  crd_mobile; }
}
