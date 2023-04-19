package com.springroy.ecommerceapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@MappedSuperclass
public class BaseEntity {

    @Column(updatable = true)
    private LocalDateTime createdAt;
    @Column(updatable = true)
    private Integer createdBy;
    @Column(insertable = false)
    private LocalDateTime updatedAt;
    @Column(insertable = false)
    private Integer updatedBy;
}
