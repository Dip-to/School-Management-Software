package com.example.school_management;

public class class_res
{
    public  Integer roll;
    public  String name;
    public  String class_name;
    public  Integer ban;
    public  Integer en;
    public  Integer mth;



    class_res(Integer crud_id, String crud_name, String curd_gender, Integer b, Integer e, Integer m)
    {
        this.roll=crud_id;
        this.name=crud_name;
        this.class_name=curd_gender;
        this.ban=b;
        this.en=e;
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
        return ban;
    }

    public Integer getEn()
    {
        return en;
    }

    public Integer getMth()
    {
        return mth;
    }


}
