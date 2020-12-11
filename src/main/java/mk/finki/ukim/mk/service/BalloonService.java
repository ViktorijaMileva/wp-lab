package mk.finki.ukim.mk.service;

import mk.finki.ukim.mk.model.Balloon;

import java.util.List;
import java.util.Optional;

public interface BalloonService {
     public List<Balloon> listAll();

     public Optional<Balloon> searchByNameOrDescription(String text);

     public void save(String name, String description, Long manufacturerId, Long countryId);

     public void delete(Long id);

     public Optional<Balloon> findById(Long id);

}
