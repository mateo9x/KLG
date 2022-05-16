package com.example.klg_java.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "objects")
public class RentObject {

    @Id
    private Long id;
    private String name;
    private Double unitPrice;
    private Double capacity;
    private String description;
}
