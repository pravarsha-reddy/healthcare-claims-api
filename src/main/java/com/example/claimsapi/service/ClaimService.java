package com.example.claimsapi.service;

import com.example.claimsapi.model.*;
import com.example.claimsapi.repository.ClaimRepository;
import com.example.claimsapi.repository.MemberRepository;
import com.example.claimsapi.repository.ProviderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClaimService {

    private final ClaimRepository claimRepository;
    private final MemberRepository memberRepository;
    private final ProviderRepository providerRepository;

    public ClaimService(ClaimRepository claimRepository,
                        MemberRepository memberRepository,
                        ProviderRepository providerRepository) {
        this.claimRepository = claimRepository;
        this.memberRepository = memberRepository;
        this.providerRepository = providerRepository;
    }

    public List<Claim> getAllClaims() {
        return claimRepository.findAll();
    }

    public Claim getClaimByNumber(String claimNumber) {
        return claimRepository.findByClaimNumber(claimNumber)
                .orElseThrow(() -> new IllegalArgumentException("Claim not found: " + claimNumber));
    }

    public Claim submitClaim(Claim claim) {
        validateReferences(claim);
        if (claim.getStatus() == null) {
            claim.setStatus(ClaimStatus.SUBMITTED);
        }
        return claimRepository.save(claim);
    }

    public Claim updateClaimStatus(String claimNumber, ClaimStatus status) {
        Claim claim = getClaimByNumber(claimNumber);
        claim.setStatus(status);
        return claimRepository.save(claim);
    }

    public List<Claim> getClaimsByStatus(ClaimStatus status) {
        return claimRepository.findByStatus(status);
    }

    private void validateReferences(Claim claim) {
        if (claim.getMember() == null || claim.getMember().getId() == null) {
            throw new IllegalArgumentException("Member reference is required.");
        }
        if (claim.getProvider() == null || claim.getProvider().getId() == null) {
            throw new IllegalArgumentException("Provider reference is required.");
        }

        Member member = memberRepository.findById(claim.getMember().getId())
                .orElseThrow(() -> new IllegalArgumentException("Member not found."));
        Provider provider = providerRepository.findById(claim.getProvider().getId())
                .orElseThrow(() -> new IllegalArgumentException("Provider not found."));

        claim.setMember(member);
        claim.setProvider(provider);
    }
}
