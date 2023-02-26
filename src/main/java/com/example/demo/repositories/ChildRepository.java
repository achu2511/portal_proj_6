package com.example.demo.repositories;

import java.awt.print.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Models.Child;

@Repository
public interface ChildRepository extends JpaRepository<Child,Integer>{
	
}
