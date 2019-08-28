package com.example.demo.control;

import com.example.demo.entity.People;
import com.example.demo.testData.PeopleDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class PeopleControl {
    @Autowired
    private PeopleDate peopleDate;

    @RequestMapping(value = "/search",method = RequestMethod.POST)
    public People search(@RequestParam("code")String code) {
    int usercode=Integer.parseInt(code);
        System.out.println("a:"+usercode);
        System.out.println(code);
        System.out.println(peopleDate.getPeopleData(usercode));
        People people=new People();
        if (peopleDate.getPeopleData(usercode)!=null){
            people.setUsercode(peopleDate.getPeopleData(usercode).getUsercode());
            people.setUsername(peopleDate.getPeopleData(usercode).getUsername());
            people.setDepartment(peopleDate.getPeopleData(usercode).getDepartment());
            System.out.println(people.getDepartment());
            return people;
        }else {
            System.out.println("查无此人");
        }
        return people;
    }
}
