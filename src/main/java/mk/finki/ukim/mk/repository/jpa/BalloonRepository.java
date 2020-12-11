package mk.finki.ukim.mk.repository.jpa;

import mk.finki.ukim.mk.model.Balloon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BalloonRepository extends JpaRepository<Balloon, Long> {

    void deleteById(Long id);

    Optional<Balloon> findByName(String text);

    List<Balloon> findAll();
}
