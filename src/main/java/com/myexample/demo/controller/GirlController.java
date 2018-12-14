package com.myexample.demo.controller;

import com.myexample.demo.model.Girl;
import com.myexample.demo.persistence.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    /**
    * @Description select all girls
    * @Author  rcss_j
    * @Date   2018/12/14 11:49
    * @Param
    * @Return
    * @Exception
    *
    */
    @GetMapping(value = "/girls")
    public List<Girl> getGirls(){
        List<Girl> list=girlRepository.findAll();
        return list;
    }

    /**
    * @Description add girl
    * @Author  rcss_j
    * @Date   2018/12/14 11:56
    * @Param
    * @Return
    * @Exception
    *
    */
    @PostMapping(value ="/girl")
    public Girl addGirl(@RequestParam String cupSize,@RequestParam Integer age){
        return girlRepository.save(new Girl(cupSize,age));
    }

    /**
    * @Description delete girl by id
    * @Author  rcss_j
    * @Date   2018/12/14 14:03
    * @Param
    * @Return
    * @Exception
    *
    */
    @DeleteMapping(value ="/girl/{id}")
    public void deleteGirl(@PathVariable Integer id){
        girlRepository.deleteById(id);
    }

    /**
     * @Description update girl by id
     * @Author  rcss_j
     * @Date   2018/12/14 11:56
     * @Param
     * @Return
     * @Exception
     *
     */
    @PutMapping(value ="/girl/{id}")
    public Girl updateGirl(@PathVariable("id") Integer id,
            @RequestParam String cupSize,@RequestParam Integer age){
        return girlRepository.save(new Girl(id,cupSize,age));
    }

    /**
     * @Description select a girl by id
     * @Author  rcss_j
     * @Date   2018/12/14 11:56
     * @Param
     * @Return
     * @Exception   findById or findOne有编译异常，springBoot版本过高导致，可更换低版本依赖，或者写成如下方式。
     *
     */
    @GetMapping(value ="/girl/{id}")
    public Girl getGirl(@PathVariable("id") Integer id){
        return girlRepository.findById(id).orElse(null);
    }

    /**
    * @Description get all girls by age
    * @Author  rcss_j
    * @Date   2018/12/14 14:44
    * @Param
    * @Return
    * @Exception
    *
    */
    @GetMapping(value = "/girl/age/{age}")
    public List<Girl> getGirlsByAge(@PathVariable("age")Integer age){
        return girlRepository.getAllByAge(age);
    }

    /**
     * @Description get all girls by age before
     * @Author  rcss_j
     * @Date   2018/12/14 14:44
     * @Param
     * @Return
     * @Exception
     *
     */
    @GetMapping(value = "/girl/age/before/{age}")
    public List<Girl> getGirlsByAgeBefore(@PathVariable("age")Integer age){
        return girlRepository.getAllByAgeBefore(age);
    }


    /**
     * @Description get all girls by age after
     * @Author  rcss_j
     * @Date   2018/12/14 14:44
     * @Param
     * @Return
     * @Exception
     *
     */
    @GetMapping(value = "/girl/age/after/{age}")
    public List<Girl> getGirlsByAgeAfter(@PathVariable("age")Integer age){
        return girlRepository.getAllByAgeAfter(age);
    }
}
