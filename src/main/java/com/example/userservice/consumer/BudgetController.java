package com.example.userservice.consumer;

import com.example.userservice.entities.UserBudgetDto;
import com.example.userservice.services.UserBudgetService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users/budget")
@RequiredArgsConstructor
public class BudgetController {
    private final UserBudgetService userBudgetService;

    @PostMapping
    public ResponseEntity<?> setBudget(@RequestHeader("X-User-Id") String userId,
                                       @RequestBody UserBudgetDto dto) {
            return ResponseEntity.ok(userBudgetService.setOrUpdateBudget(userId, dto));
    }

    @GetMapping
    public ResponseEntity<?> getBudget(@RequestHeader("X-User-Id") String userId,
                                       @RequestParam String month) {
        String normalisedMonth = userBudgetService.normalizeMonth(month);
        return ResponseEntity.ok(userBudgetService.getBudget(userId, normalisedMonth));
    }
}
