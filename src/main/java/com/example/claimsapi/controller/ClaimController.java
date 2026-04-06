package com.example.claimsapi.controller;

import com.example.claimsapi.model.Claim;
import com.example.claimsapi.model.ClaimStatus;
import com.example.claimsapi.service.ClaimService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/claims")
public class ClaimController {

    private final ClaimService claimService;

    public ClaimController(ClaimService claimService) {
        this.claimService = claimService;
    }

    @GetMapping
    public List<Claim> getAllClaims(@RequestParam(required = false) ClaimStatus status) {
        if (status != null) {
            return claimService.getClaimsByStatus(status);
        }
        return claimService.getAllClaims();
    }

    @GetMapping("/{claimNumber}")
    public Claim getClaim(@PathVariable String claimNumber) {
        return claimService.getClaimByNumber(claimNumber);
    }

    @PostMapping
    public Claim submitClaim(@RequestBody Claim claim) {
        return claimService.submitClaim(claim);
    }

    @PatchMapping("/{claimNumber}/status")
    public Claim updateStatus(@PathVariable String claimNumber, @RequestParam ClaimStatus status) {
        return claimService.updateClaimStatus(claimNumber, status);
    }
}
