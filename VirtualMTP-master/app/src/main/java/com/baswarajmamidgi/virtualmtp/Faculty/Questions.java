package com.baswarajmamidgi.virtualmtp.Faculty;

/**
 * Created by Ak on 08-01-2018.
 */

public class Questions {
    String q,o1,o2,o3,o4;
    Questions(){

    }
    Questions(String question,String option1,String option2){
        this.q=question;
        this.o1=option1;
        this.o2=option2;

    }
    Questions(String question,String option1,String option2,String option3,String option4){
        this.q=question;
        this.o1=option1;
        this.o2=option2;
        this.o3=option3;
        this.o4=option4;
    }
    public String get_Questions(){

        return q;
    }
}
