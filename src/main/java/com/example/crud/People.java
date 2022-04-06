package com.example.crud;

abstract class People
{

    public  Integer crud_id;
    public  String crud_name;
    public  String curd_gender;
    public String curd_picture;
    public  String curd_mobile;

    People(Integer crud_id, String crud_name, String curd_gender, String curd_picture, String crud_mobile)
    {
        this.crud_id=crud_id;
        this.crud_name=crud_name;
        this.curd_gender=curd_gender;
        this.curd_picture = curd_picture;
        this.curd_mobile=crud_mobile;
    }

    abstract Integer getCrud_id();

    abstract String getCurd_name();

    abstract String getCurd_gender() ;

    abstract String getCurd_picture();

    abstract String getCurd_mobile() ;
}
