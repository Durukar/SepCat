package br.com.SepCatServer.Backend.repositories;

import br.com.SepCatServer.Backend.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
}
