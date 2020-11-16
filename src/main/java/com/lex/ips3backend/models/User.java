package com.lex.ips3backend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID")
    @Getter
    private Integer id;

    @OneToMany(
            mappedBy="user",
            cascade=CascadeType.ALL,
            orphanRemoval=true
    )
    @JsonBackReference
    @Getter
    private List<Post> posts;

    @OneToMany(
            mappedBy="user",
            cascade=CascadeType.ALL,
            orphanRemoval=true
    )
    @JsonBackReference
    @Getter
    private List<Comment> comments;

    @Getter
    private String username;

    @Getter
    private String password;

    @Getter
    private String email;

    @Column(name="created_at",
            columnDefinition="DATETIME DEFAULT CURRENT_TIMESTAMP",
            nullable = false,
            insertable = false)
    @Getter
    private LocalDateTime createdAt;

    @Column(name="deleted_at")
    @Getter
    private LocalDateTime deletedAt;
}
