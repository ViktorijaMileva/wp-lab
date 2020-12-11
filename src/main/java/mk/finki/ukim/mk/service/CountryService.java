package mk.finki.ukim.mk.service;

import mk.finki.ukim.mk.model.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    public List<Country> findAll();

    public Optional<Country> findById(Long id);
}
