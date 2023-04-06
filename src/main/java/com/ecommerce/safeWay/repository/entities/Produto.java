package com.ecommerce.safeWay.repository.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "produtos")
public class Produto {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @NotBlank
    private String nome;
    @NotNull
    private Double preco;
    @NotNull
    private Integer quantidade;
    private String categoria;

}
