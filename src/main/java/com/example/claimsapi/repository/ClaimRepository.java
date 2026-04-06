package com.example.claimsapi.repository;

import com.example.claimsapi.model.Claim;
import com.example.claimsapi.model.ClaimStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClaimRepository extends JpaRepository<Claim, Long> {
    Optional<Claim> findByClaimNumber(String claimNumber);
    List<Claim> findByStatus(ClaimStatus status);
}
