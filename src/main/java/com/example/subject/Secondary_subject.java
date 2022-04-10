package com.example.subject;

public class Secondary_subject extends compulsory_sub_data {
    public Integer phy;
    public Integer chem;
    public  Integer h_math;
    public Integer bio;
    public Secondary_subject(Integer crud_id, String crud_name, String curd_gender, Integer b1, Integer b2, Integer e1, Integer e2, Integer m, Integer s, Integer r, Integer bg, Integer ic) {
        super(crud_id, crud_name, curd_gender, b1,b2, e1,e2,m);
        this.phy=s;
        this.chem=r;
        this.h_math=bg;
        this.bio=ic;
    }
    public Integer getBio() {
        return bio;
    }

    public Integer getChem() {
        return chem;
    }

    public Integer getH_math() {
        return h_math;
    }

    public Integer getPhy() {
        return phy;
    }
}
