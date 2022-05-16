package com.example.klg_java.repository;

import com.example.klg_java.entity.RentObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentObjectRepository extends JpaRepository<RentObject, Long> {
}
