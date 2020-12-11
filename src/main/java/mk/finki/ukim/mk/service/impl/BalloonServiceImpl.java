package mk.finki.ukim.mk.service.impl;

import mk.finki.ukim.mk.model.Balloon;
import mk.finki.ukim.mk.model.Country;
import mk.finki.ukim.mk.model.Manufacturer;
import mk.finki.ukim.mk.repository.jpa.BalloonRepository;
import mk.finki.ukim.mk.repository.jpa.CountryRepository;
import mk.finki.ukim.mk.repository.jpa.ManufacturerRepository;
import mk.finki.ukim.mk.service.BalloonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BalloonServiceImpl implements BalloonService {
    private final BalloonRepository balloonRepository;
    private final ManufacturerRepository manufacturerRepository;
    private final CountryRepository countryRepository;

    @Autowired
    public BalloonServiceImpl(BalloonRepository balloonRepository, ManufacturerRepository manufacturerRepository, CountryRepository countryRepository) {
        this.balloonRepository = balloonRepository;
        this.manufacturerRepository = manufacturerRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Balloon> listAll() {
               return this.balloonRepository.findAll();
    }

    @Override
    public Optional<Balloon> searchByNameOrDescription(String text) {
               return this.balloonRepository.findByName(text);
    }

    @Override
    public void save(String name, String description, Long manufacturerId, Long countryId) {
        Manufacturer manufacturer = this.manufacturerRepository.findById(manufacturerId).orElseThrow();
        Country country = this.countryRepository.findById(countryId).orElseThrow();
        Balloon balloon = new Balloon(name, description, manufacturer, country);
        this.balloonRepository.save(balloon);
    }

    @Override
    public void delete(Long id) {

        this.balloonRepository.deleteById(id);
    }

    @Override
    public Optional<Balloon> findById(Long id) {
        return this.balloonRepository.findById(id);
    }
}
