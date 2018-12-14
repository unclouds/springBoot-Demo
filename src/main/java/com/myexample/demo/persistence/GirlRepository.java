package com.myexample.demo.persistence;

import com.myexample.demo.model.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GirlRepository extends JpaRepository<Girl,Integer> {
    public List<Girl> getAllByAge(Integer age);
    public List<Girl> getAllByAgeAfter(Integer age);
    public List<Girl> getAllByAgeBefore(Integer age);
}
