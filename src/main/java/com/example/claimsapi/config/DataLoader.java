package com.example.claimsapi.config;

import com.example.claimsapi.model.*;
import com.example.claimsapi.repository.ClaimRepository;
import com.example.claimsapi.repository.MemberRepository;
import com.example.claimsapi.repository.ProviderRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.time.LocalDate;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner seedData(MemberRepository memberRepository,
                               ProviderRepository providerRepository,
                               ClaimRepository claimRepository) {
        return args -> {
            if (memberRepository.count() > 0) {
                return;
            }

            Member member = new Member();
            member.setMemberId("MBR1001");
            member.setFullName("Ava Johnson");
            member.setPlanName("Clark Student Health Plus");
            member.setEligibilityStatus("ACTIVE");
            member = memberRepository.save(member);

            Provider provider = new Provider();
            provider.setNpi("1234567890");
            provider.setProviderName("Worcester Family Care");
            provider.setSpecialty("Primary Care");
            provider = providerRepository.save(provider);

            Claim claim = new Claim();
            claim.setClaimNumber("CLM-2026-0001");
            claim.setMember(member);
            claim.setProvider(provider);
            claim.setServiceDate(LocalDate.now().minusDays(5));
            claim.setBilledAmount(new BigDecimal("245.75"));
            claim.setStatus(ClaimStatus.IN_REVIEW);
            claim.setDiagnosisCode("J02.9");
            claim.setProcedureCode("99213");
            claimRepository.save(claim);
        };
    }
}
