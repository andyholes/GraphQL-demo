package com.andyholes.graphqldemo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private boolean published;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "books")

    private Author author;
}
