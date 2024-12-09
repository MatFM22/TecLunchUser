package com.tech.lunch.repository;

import com.tech.lunch.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ReservaRepository extends JpaRepository<Reserva, Integer>{

    Optional<Reserva> findByCodigoReserva(String codigoReserva);
}
