package mk.finki.ukim.mk.service.impl;

import mk.finki.ukim.mk.model.Manufacturer;
import mk.finki.ukim.mk.repository.impl.InMemoryManufacturerRepository;
import mk.finki.ukim.mk.repository.jpa.ManufacturerRepository;
import mk.finki.ukim.mk.service.ManufacturerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

    private final ManufacturerRepository manufacturerRepository;

    public ManufacturerServiceImpl(ManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }

    @Override
    public List<Manufacturer> findAll() {
        return manufacturerRepository.findAll();
    }

    @Override
    public Optional<Manufacturer> findById(Long id) {
        return this.manufacturerRepository.findById(id);
    }
}
