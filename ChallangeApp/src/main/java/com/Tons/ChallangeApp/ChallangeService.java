package com.Tons.ChallangeApp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ChallangeService  {
    private List<Challange> challanges = new ArrayList<>();
    private long id = 1;



    public void ChallangeController() {

    }

    public List<Challange> getAllChallanges() {
        return challanges;
    }

   public  Boolean addChallanges( Challange challange){
        if(challange != null) {
            challange.setId(id++);
            challanges.add(challange);
            return true;
        }else{
            return false;
        }

    }

    public Challange getChallage(String month) {
        for (Challange challange : challanges) {
            if (challange.getMonths().equalsIgnoreCase(month)) {
                return challange;
            }
        }
        return null;
    }


    public  boolean updateChalange(Long id, Challange updatedChallange) {
        for (Challange challange : challanges) {
            if (id.equals(challange.getId())) {
                challange.setMonths(updatedChallange.getMonths());
                challange.setDescription(updatedChallange.getDescription());
                return true;

            }
        }
        return false;
    }
    public boolean deleteChallange(Long id) {
        return challanges.removeIf(challenge -> challenge.getId().equals(id));
    }

}
