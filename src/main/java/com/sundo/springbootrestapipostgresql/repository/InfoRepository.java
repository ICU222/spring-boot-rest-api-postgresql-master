package com.sundo.springbootrestapipostgresql.repository;

import com.sundo.springbootrestapipostgresql.entity.Info;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InfoRepository  extends JpaRepository<Info, String> {

    // id(pk) 가 아닌, column 이름 id(not pk)로 찾기 위한 것.
    List<Info> findByColID(String name);
}