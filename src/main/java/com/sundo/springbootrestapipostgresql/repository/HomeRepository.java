package com.sundo.springbootrestapipostgresql.repository;

import com.sundo.springbootrestapipostgresql.entity.Home;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;



// JpaRepository<Entity, id(primary key data type) >
// https://jobc.tistory.com/120
public interface HomeRepository extends JpaRepository<Home, String> {
    List<Home> findByArea(String area);

}