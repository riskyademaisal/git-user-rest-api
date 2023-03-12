package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@Table(name = "search")
public class Search extends BaseEntity {

    public Search() {
    }

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "keyword_by_username")
    private String keywordByUsername;

    @Column(name = "total")
    private Integer total;

    private String type;

    private byte[] data;


}
