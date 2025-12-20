package com.example.userservice.entities;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_budget",
    uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "month"}))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserBudget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(nullable = false)
    private String month;

    @Column(nullable = false)
    private BigDecimal totalBudget;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
