package com.example.crud;

public class Employee extends People
{
    public String cud_designation;

    Employee(Integer crud_id, String crud_name, String curd_class, String curd_gender, String curd_picture, String crud_mobile)
    {
        super(crud_id, crud_name, curd_class, curd_gender, curd_picture, crud_mobile);
    }
}
