package com.example.userservice.services;

import com.example.userservice.entities.UserBudget;
import com.example.userservice.entities.UserBudgetDto;
import com.example.userservice.repository.UserBudgetRepo;
import com.example.userservice.response.BudgetResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

@Service
@RequiredArgsConstructor
public class UserBudgetService {
    private final UserBudgetRepo userBudgetRepo;

    public BudgetResponseDto setOrUpdateBudget(String userId, UserBudgetDto dto){
        UserBudget budget = userBudgetRepo.
                findByUserIdAndMonth(userId, dto.getMonth())
                .orElse(UserBudget.builder()
                        .userId(userId)
                        .month(dto.getMonth())
                        .createdAt(LocalDateTime.now())
                        .build());

        budget.setTotalBudget(dto.getTotalBudget());
        budget.setUpdatedAt(LocalDateTime.now());

        userBudgetRepo.save(budget);

        return BudgetResponseDto.builder()
                .userId(userId)
                .month(dto.getMonth())
                .totalBudget(dto.getTotalBudget())
                .build();
    }

    public BudgetResponseDto getBudget(String userId, String month){
        UserBudget budget = userBudgetRepo.findByUserIdAndMonth(userId, month)
                .orElse(UserBudget.builder()
                .userId(userId)
                .month(month)
                .totalBudget(BigDecimal.ZERO)
                .createdAt(LocalDateTime.now())
                .build());

        return BudgetResponseDto.builder()
                .userId(userId)
                .month(budget.getMonth())
                .totalBudget(budget.getTotalBudget())
                .build();
    }

    public String normalizeMonth(String input) {

        if (input.matches("\\d{4}-\\d{2}")) {
            return input;
        }

        if (input.matches("\\d{2}-\\d{4}")) {
            String[] parts = input.split("-");
            String month = parts[0];
            String year = parts[1];

            int m = Integer.parseInt(month);
            if (m < 1 || m > 12) {
                throw new IllegalArgumentException("Invalid month value");
            }

            return year + "-" + String.format("%02d", m);
        }

        throw new IllegalArgumentException(
                "Invalid month format. Use YYYY-MM or MM-YYYY"
        );
    }

}
