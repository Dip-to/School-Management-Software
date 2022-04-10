package com.example.subject;

public class HighSchool_subject extends compulsory_sub_data {
    public Integer science;
    public Integer religion;
    public  Integer ict;
    public Integer bgs;

    public HighSchool_subject(Integer crud_id, String crud_name, String curd_gender, Integer b1, Integer b2, Integer e1, Integer e2, Integer m, Integer s, Integer r, Integer bg, Integer ic) {
        super(crud_id, crud_name, curd_gender, b1,b2, e1,e2,m);
        this.science=s;
        this.religion=r;
        this.ict=ic;
        this.bgs=bg;
    }
    public Integer getScience(){return science;}
    public Integer getReligion(){return religion;}
    public Integer getIct(){return ict;}
    public Integer getBgs() {return bgs;}
}
