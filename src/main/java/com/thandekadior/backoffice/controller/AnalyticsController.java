package com.thandekadior.backoffice.controller;

import com.thandekadior.backoffice.dto.UserSpendDTO;
import com.thandekadior.backoffice.model.User;
import com.thandekadior.backoffice.service.BusinessService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/analytics")
public class AnalyticsController {

    private final BusinessService businessService;

    //constructor injection
    public AnalyticsController(BusinessService businessService) {
        this.businessService = businessService;
    }

    //GET /analytics/totalSpend
    @GetMapping("/totalSpend")
//    public Map<User, BigDecimal> getTotalSpendPerUser() {
//        return businessService.calculateTotalSpendPerUser();
//    }
    public List<UserSpendDTO> getTotalSpendPerUser() {
        Map<User, BigDecimal> totals = businessService.calculateTotalSpendPerUser();

        return totals.entrySet().stream()
                .sorted((e1,e2) -> Integer.compare(e1.getKey().getId(), e2.getKey().getId()))
                .map(entry -> new UserSpendDTO(
                        entry.getKey().getId(),
                        entry.getKey().getName(),
                        entry.getKey().getEmail(),
                        entry.getKey().getCreatedAt().toString(),
                        entry.getValue()
                ))
                .toList();
    }

    //GET /analytics/topUsers?n=2
    @GetMapping("/topUsers")
//    public List<Map.Entry<User, BigDecimal>> getTopUsersBySpend(@RequestParam(defaultValue = "2") int n) {
//        return businessService.topUsersBySpend(n);
//    }
    public List<UserSpendDTO> getTopUsersBySpend(@RequestParam(defaultValue = "2") int n) {
        return businessService.topUsersBySpend(n).stream()
//                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .sorted((e1,e2) -> Integer.compare(e1.getKey().getId(), e2.getKey().getId()))
                .map(entry -> new UserSpendDTO(
                        entry.getKey().getId(),
                        entry.getKey().getName(),
                        entry.getKey().getEmail(),
                        entry.getKey().getCreatedAt().toString(),
                        entry.getValue()
                ))
                .toList();
    }
}
