package com.ecommerce.wFlowerService.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="ROLE")
@Getter
public class Role {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private long id;

    @Column(name = "NAME", columnDefinition = "NVARCHAR(20)")
    private String name;

    @OneToMany(mappedBy = "roleID")
    @JsonIgnore
    private List<User> users;
}
