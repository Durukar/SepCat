package br.com.SepCatServer.Backend.repositories;

import br.com.SepCatServer.Backend.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long>{
}
