package br.com.SepCatServer.Backend.repositories;

import br.com.SepCatServer.Backend.entities.Category;
import br.com.SepCatServer.Backend.entities.Form;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormRepository extends JpaRepository<Form, Long>{
}
