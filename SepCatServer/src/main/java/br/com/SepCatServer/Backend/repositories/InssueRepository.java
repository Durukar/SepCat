package br.com.SepCatServer.Backend.repositories;

import br.com.SepCatServer.Backend.entities.Inssue;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InssueRepository extends JpaRepository<Inssue, Long> {
}
