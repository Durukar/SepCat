package br.com.SepCatServer.Backend.repositories;

import br.com.SepCatServer.Backend.entities.InssueItem;
import br.com.SepCatServer.Backend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InssueItemRepository extends JpaRepository<InssueItem, Long> {
}
