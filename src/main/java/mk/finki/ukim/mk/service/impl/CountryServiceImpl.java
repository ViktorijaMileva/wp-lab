package mk.finki.ukim.mk.service.impl;

import mk.finki.ukim.mk.model.Country;
import mk.finki.ukim.mk.repository.jpa.CountryRepository;
import mk.finki.ukim.mk.service.CountryService;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> findAll() {
        return this.countryRepository.findAll();
    }

    @Override
    public Optional<Country> findById(Long id) {
        return this.countryRepository.findById(id);
    }
}
