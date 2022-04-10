package com.example.subject;

abstract class compulsory_sub_data {
    public  Integer roll;
    public  String name;
    public  String class_name;
    public  Integer ban1;
    public  Integer ban2;
    public  Integer en1;
    public  Integer en2;
    public  Integer mth;


    compulsory_sub_data(Integer crud_id, String crud_name, String curd_gender, Integer b, Integer e, Integer m)
    {
        this.roll=crud_id;
        this.name=crud_name;
        this.class_name=curd_gender;
        this.ban1=b;
        this.en1=e;
        this.mth=m;
    }
    compulsory_sub_data(Integer crud_id, String crud_name, String curd_gender, Integer b1,Integer b2,Integer e1, Integer e2, Integer m)
    {
        this.roll=crud_id;
        this.name=crud_name;
        this.class_name=curd_gender;
        this.ban1=b1;
        this.en1=e1;
        this.ban2=b2;
        this.en2=e2;
        this.mth=m;
    }
    public Integer getRoll()
    {
        return roll;
    }

    public String getName()
    {
        return name;
    }

    public String getClass_name()
    {
        return class_name;
    }

    public Integer getBan()
    {
        return ban1;
    }

    public Integer getEn()
    {
        return en1;
    }

    public Integer getMth()
    {
        return mth;
    }
    public  Integer getBan2(){ return ban2;}
    public  Integer getEn2() { return en2;}

}
