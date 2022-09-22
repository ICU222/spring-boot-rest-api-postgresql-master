package com.sundo.springbootrestapipostgresql.controller;


import com.sundo.springbootrestapipostgresql.entity.Info;
import com.sundo.springbootrestapipostgresql.repository.InfoRepository;
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
@RequestMapping("/api/info")
public class InfoRestController {

        @Autowired
        private InfoRepository repository;

        @PostMapping
        public ResponseEntity<?> addInfo(@RequestBody Info info) {
            return new ResponseEntity<>(repository.save(info), HttpStatus.CREATED);
        }

        @GetMapping
        public ResponseEntity<Collection<Info>> getAllHome() {
            return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
        }

        @GetMapping("/{name}")
        public ResponseEntity<Info> getInfoWithName(@PathVariable String name) {
            return new ResponseEntity<Info>(repository.findById(name).get(), HttpStatus.OK);
        }

        // 이 주석 위 아래의 메소드 차이점이 뭐지? 같은거 아닌가?
        // 코드 변수 명 바꿀 때 잘못 넣어서 둘이 같은 기능처럼 보였음. 현재는 해결 완료

        @GetMapping(params = {"id"})
        public ResponseEntity<Collection<Info>> findInfoWithID(@RequestParam(value = "id") String id) {
            return new ResponseEntity<>(repository.findByColID(id), HttpStatus.OK);
        }

        @PutMapping("/{id}")
        public ResponseEntity<Info> updateInfoFromDB(@PathVariable("name") String id, @RequestBody Info info) {

            // Optional : https://velog.io/@wldus9503/spring-boot-OptionalT
            // 'null일 수도 있는 객체'를 감싸는 일종의 Wrapper 클래스
            Optional<Info> currentInfoOpt = repository.findById(id);

            // get() : Optional 내부에 담긴 객체를 반환
            Info currentInfo = currentInfoOpt.get();
            currentInfo.setName(info.getName());
            currentInfo.setId(info.getId());

            return new ResponseEntity<>(repository.save(currentInfo), HttpStatus.OK);
        }

        @DeleteMapping("/{id}")
        public void deleteBookWithId(@PathVariable String id) {
            repository.deleteById(id);
        }

        @DeleteMapping
        public void deleteAllBooks() {
            repository.deleteAll();
        }

    }
