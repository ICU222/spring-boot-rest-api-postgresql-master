package com.sundo.springbootrestapipostgresql.controller;


import com.sundo.springbootrestapipostgresql.entity.Home;
import com.sundo.springbootrestapipostgresql.repository.HomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api/home")
public class HomeAreaRestController {


    // 반환형 <T> : 이떄 T가 "엔티티 객체(여기서는 Home)"면 하나의 결과만 전달,
    //  T가 List 객체면 쿼리에 해당하는 모든 값을 전달.
    //  >> 즉 pk가 아닌 key값으로 찾을 때는 리스트형으로 반환 해야되는구나. 아님 콜랙션이나

    @Autowired
    private HomeRepository repository;

    @PostMapping
    public ResponseEntity<?> addHome(@RequestBody Home home) {
        return new ResponseEntity<>(repository.save(home), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Collection<Home>> getAllInfo() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<Home> getHomeWithName(@PathVariable String name) {
        return new ResponseEntity<Home>(repository.findById(name).get(), HttpStatus.OK);
    }

    @GetMapping(params = {"area"})
    public ResponseEntity<Collection<Home>> findHomeWithArea(@RequestParam(value = "area") String area) {
        return new ResponseEntity<>(repository.findByArea(area), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Home> updateHomeFromDB(@PathVariable("id") String id, @RequestBody Home home) {

        // Optional : https://velog.io/@wldus9503/spring-boot-OptionalT
        // 'null일 수도 있는 객체'를 감싸는 일종의 Wrapper 클래스
        Optional<Home> currentHomeOpt = repository.findById(id);

        // get() : Optional 내부에 담긴 객체를 반환
        Home currentHome = currentHomeOpt.get();
        currentHome.setName(home.getName());
        currentHome.setArea(home.getArea());

        return new ResponseEntity<>(repository.save(currentHome), HttpStatus.OK);
    }

    @DeleteMapping("/{name}")
    public void deleteHomeWithName(@PathVariable String name) {
        repository.deleteById(name);
    }

    @DeleteMapping
    public void deleteAllHomes() {
        repository.deleteAll();
    }

}
