package com.thandekadior.backoffice.controller;

import com.thandekadior.backoffice.model.User;
import com.thandekadior.backoffice.service.BusinessService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@RestController
public class AnalyticsController {

    private final BusinessService businessService = new BusinessService();

    //endpoint: /analytics/totalSpend
    @GetMapping("/analytics/totalSpend")
    public Map<User, BigDecimal> getTotalSpendPerUser() {
        return businessService.calculateTotalSpendPerUser();
    }

    //endpoint: /analytics/topUsers?n=2
    @GetMapping("/analytics/topUsers")
    public List<Map.Entry<User, BigDecimal>> getTopUsersBySpend(int n) {
        return businessService.topUsersBySpend(n);
    }
}
