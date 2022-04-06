package com.example.crud;

public class Employee extends People
{
    public String cud_designation;

    Employee(Integer crud_id, String crud_name, String curd_class, String curd_gender, String curd_picture, String crud_mobile)
    {
        super(crud_id, crud_name,  curd_gender, curd_picture, crud_mobile);
    }

    @Override
    Integer getCrud_id() {
        return null;
    }

    @Override
    String getCurd_name() {
        return null;
    }

    String getCud_designation() {
        return cud_designation;
    }

    @Override
    String getCurd_gender() {
        return null;
    }

    @Override
    String getCurd_picture() {
        return null;
    }

    @Override
    String getCurd_mobile() {
        return null;
    }
}
