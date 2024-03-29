package com.example.budget.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Category {

    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false, unique = true)
    String name;

    @Column(nullable = false)
    Integer averageRate;

    @Builder
    public Category(String name, Integer averageRate) {
        this.name = name;
        this.averageRate = averageRate != null ? averageRate : 0;
    }

    public Category(Long id, String name, Integer averageRate) {
        this.id = id;
        this.name = name;
        this.averageRate = averageRate != null ? averageRate : 0;
    }

    public void updateAverageRate(Integer averageRate) {
        this.averageRate = averageRate;
    }

}