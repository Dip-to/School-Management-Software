package com.example.crud;

public class Student extends People
{
    public int crd_id;
    public String crd_name;
    public String  cud_class;
    public String crd_mobile;
    public String cud_gender;
    public String crd_picture;

    Student(Integer crud_id, String crud_name, String curd_class, String curd_gender, String curd_picture, String crud_mobile) {
        super(crud_id, crud_name, curd_class, curd_gender, curd_picture, crud_mobile);
        crd_id=crud_id;
        crd_name=crud_name;
        cud_class=curd_class;
        cud_gender=curd_gender;
        crd_picture=curd_picture;
        crd_mobile=crud_mobile;
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
        return cud_class;
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
