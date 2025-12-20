package com.example.userservice.entities;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class UserBudgetDto {
    private String month;
    private BigDecimal totalBudget;
}
