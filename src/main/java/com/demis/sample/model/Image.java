package com.demis.sample.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, columnDefinition = "varchar(100)")
    private String name;
    @Column(nullable = false)
    private Long size;
    @Column(nullable = false, columnDefinition = "VARCHAR(50)")
    private String type;
    @Column(nullable = false, columnDefinition = "BYTEA")
    private byte[] data;


}

