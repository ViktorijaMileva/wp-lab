package mk.finki.ukim.mk.service;


import mk.finki.ukim.mk.model.Manufacturer;

import java.util.List;
import java.util.Optional;

public interface ManufacturerService {

    public List<Manufacturer> findAll();

    public Optional<Manufacturer> findById(Long id);
}
