package com.sundo.springbootrestapipostgresql.repository;

import com.sundo.springbootrestapipostgresql.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-rest-api-postgresql
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-01-18
 * Time: 22:06
 * To change this template use File | Settings | File Templates.
 */
@RepositoryRestResource
public interface BookRepository extends JpaRepository<Book, Long> {

    // 설마 이게 primary key 라서 그런건가?
    // ㄴㄴ . https://jobc.tistory.com/120
    List<Book> findByName(String name);
}