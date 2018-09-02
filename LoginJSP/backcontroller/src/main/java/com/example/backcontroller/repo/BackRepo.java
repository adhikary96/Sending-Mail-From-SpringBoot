package com.example.backcontroller.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backcontroller.beans.LoginData;

@Repository
public interface BackRepo extends JpaRepository<LoginData, String>{

}
