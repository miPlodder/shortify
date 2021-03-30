package com.miplodder.shorify.shortify;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShortifyRepository extends JpaRepository<Mapper, Object> {

    List<Mapper> findByValue(String value);

    @Query(value = "SELECT max(id) FROM Mapper")
    int getMaxTransactionId();
}
