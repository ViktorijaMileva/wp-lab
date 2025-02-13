package mk.finki.ukim.mk.repository.impl;

import mk.finki.ukim.mk.bootstrap.DataHolder;
import mk.finki.ukim.mk.model.Manufacturer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryManufacturerRepository {

    public List<Manufacturer> findAll(){
        return DataHolder.manufacturerList;
    }

    public Optional<Manufacturer> findById(Long id){
        return DataHolder.manufacturerList.stream().filter(r->r.getId().equals(id)).findFirst();
    }
}
