package com.Tons.ChallangeApp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.spi.LocaleNameProvider;


@RestController
@RequestMapping("/challanges") // line 22,27 is same url so rrequestionMaping will do action according the request method and no need to pass url on get and post mapping
public class ChallangeController {

    private ChallangeService challangeService = new ChallangeService();




    @GetMapping("/challanges")
    public ResponseEntity<List<Challange>> getChallanges() {
      return new ResponseEntity<>( challangeService.getAllChallanges(),HttpStatus.OK);
    }

    @PostMapping("/challanges")
    public ResponseEntity<String> postChallanges(@RequestBody  Challange challange){
        boolean isAdded = challangeService.addChallanges(challange);
        if(isAdded){
            return new ResponseEntity<>( "chalange added sucessfully",HttpStatus.OK);

        }else {
            return new ResponseEntity<>("chalange not addes Sorry",HttpStatus.NOT_FOUND);// using ResponseEntity<> we can chnage http status of api

        }
    }
    @GetMapping("/challanges/{month}")
    public ResponseEntity<Challange> getChalangeById(@PathVariable String  month){
        Challange challange  = challangeService.getChallage(month);
        if(challange != null){
            return new ResponseEntity<>(challange, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
  @PutMapping("/challanges/{id}")
    public ResponseEntity<String> updateChallange(@PathVariable  Long id ,@RequestBody Challange updatedChallange){
        boolean isChalangeUpdated = challangeService.updateChalange(id,updatedChallange);

      if(isChalangeUpdated){
          return new ResponseEntity<>( "chalange added sucessfully",HttpStatus.OK);

      }else {
          return new ResponseEntity<>("chalange not addes Sorry",HttpStatus.NOT_FOUND);// using ResponseEntity<> we can chnage http status of api

      }

    }

    @DeleteMapping("/challanges/{id}")

    public ResponseEntity<String> deletChalange(Long id){
      boolean ischalangeDeleted =  challangeService.deleteChallange(id);

        if(ischalangeDeleted){
            return new ResponseEntity<>( "chalange added sucessfully",HttpStatus.OK);

        }else {
            return new ResponseEntity<>("chalange not deleted Sorry",HttpStatus.NOT_FOUND);// using ResponseEntity<> we can chnage http status of api

        }



    }



}
