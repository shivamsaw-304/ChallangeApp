package com.Tons.ChallangeApp;

public class Challange {
    private Long id;
    private String months;
    private String description;

    Challange(long id,String months,String description){
        this.description = description;
        this.id = id;
        this.months = months;

    }

    public Long getId(){
        return id;
    }
    public String getMonths(){
        return months;
    }

    public String getDescription(){
        return description;
    }

    public void setId(long l) {
        this.id = l;
    }
    public void setMonths(String month){
        this.months = month;
    }

    public void setDescription(String Desc){
        this.description = Desc;

    }
}
