package com.example.crud;

public class Teacher extends Employee
{

    public String  cud_subject;


    Teacher(Integer crud_id, String crud_name, String curd_class, String curd_gender, String curd_picture, String crud_mobile)
    {
        super(crud_id, crud_name, curd_class, curd_gender, curd_picture, crud_mobile);
        cud_subject=curd_class;
    }
    @Override
    public Integer getCrud_id() {
        return crud_id;
    }
    @Override
    public String getCurd_name() {

        return crud_name;
    }

    public String getCud_subject() {
        return cud_subject;
    }
    @Override
    public String getCurd_gender() { return curd_gender; }
    @Override
    public String getCurd_picture() {
        return curd_picture;
    }
    @Override
    public String getCurd_mobile() { return  curd_mobile; }
}
