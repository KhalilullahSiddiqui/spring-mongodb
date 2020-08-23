package com.springboot.springmongodb.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.Generated;
import java.security.PrivateKey;


@Getter
@Setter
@ToString
@Document(collection = "Book")
public class Book {

    @Id

    private int id;

    private String bookName;
    private String authorName;

}
