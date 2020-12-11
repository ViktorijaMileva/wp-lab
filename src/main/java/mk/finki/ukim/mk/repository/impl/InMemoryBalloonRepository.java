package mk.finki.ukim.mk.repository.impl;

import mk.finki.ukim.mk.bootstrap.DataHolder;
import mk.finki.ukim.mk.model.Balloon;
import mk.finki.ukim.mk.model.Country;
import mk.finki.ukim.mk.model.Manufacturer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryBalloonRepository {

    public List<Balloon> findAllBalloons(){
        return DataHolder.balloonList;
    }

    public List<Balloon> findAllByNameOrDescription(String text){
        return (List<Balloon>) DataHolder.balloonList.stream().filter(r->r.getName().contains(text) || r.getDescription().contains(text));
    }

    public void save(String name, String description, Manufacturer manufacturer, Country country){
        DataHolder.balloonList.removeIf(r->r.getName().equals(name));
        Balloon balloon = new Balloon(name, description, manufacturer, country);
        DataHolder.balloonList.add(balloon);
    }

    public void delete(Long id){

        DataHolder.balloonList.removeIf(r->r.getId().equals(id));
    }

    public Optional<Balloon> findById(Long id){
        return DataHolder.balloonList.stream().filter(r->r.getId().equals(id)).findFirst();
    }


}
