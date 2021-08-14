package com.cursojava.curso.models;
import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity //The objective of this notation is access to DB
@Table(name = "Users") //Reference to the table Users in the DB
@Data //Implicits @Getter and @Setter @HashCode and @ToString
public class User {
    @Column(name = "id") //To specify the column in the table
    @Id //To specify that is a primary key
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @Column(name = "password")
    private String password;
}
