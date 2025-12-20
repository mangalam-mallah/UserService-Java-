package com.example.userservice.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class BudgetResponseDto {
    private String userId;
    private String month;
    private BigDecimal totalBudget;

}
