package com.tech.lunch.service;

import com.tech.lunch.entity.ReservaItem;
import com.tech.lunch.repository.ReservaItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservaItemService {

    @Autowired
    private ReservaItemRepository reservaItemRepository;

    public ReservaItem crearReservaItem(ReservaItem reservaItem) {
        return reservaItemRepository.save(reservaItem);
    }

    public Iterable<ReservaItem> obtenerTodosLosReservaItems() {
        return reservaItemRepository.findAll();
    }

    public void eliminarReservaItem(Integer id) {
        reservaItemRepository.deleteById(id);
    }
}
