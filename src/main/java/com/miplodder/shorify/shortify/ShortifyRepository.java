package com.miplodder.shorify.shortify;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShortifyRepository extends JpaRepository<Mapper, Object> {

}
