package com.example.claimsapi.controller;

import com.example.claimsapi.model.Provider;
import com.example.claimsapi.repository.ProviderRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/providers")
public class ProviderController {

    private final ProviderRepository providerRepository;

    public ProviderController(ProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }

    @GetMapping
    public List<Provider> getProviders() {
        return providerRepository.findAll();
    }

    @PostMapping
    public Provider createProvider(@RequestBody Provider provider) {
        return providerRepository.save(provider);
    }
}
