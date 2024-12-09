package com.tech.lunch.entity;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class MetodoPagoConverter implements AttributeConverter<MetodoPago, String>{

    @Override
    public String convertToDatabaseColumn(MetodoPago metodoPago) {
        if (metodoPago == null) {
            return null;
        }
        // Mapear el enum a un valor adecuado para la base de datos
        switch (metodoPago) {
            case Banca_Movil:
                return "Banca Movil";
            case Efectivo:
                return "Efectivo";
            case Tarjeta:
                return "Tarjeta";
            default:
                throw new IllegalArgumentException("Método de pago desconocido: " + metodoPago);
        }
    }

    @Override
    public MetodoPago convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        // Mapear el valor de la base de datos al enum correspondiente
        switch (dbData) {
            case "Banca Movil":
                return MetodoPago.Banca_Movil;
            case "Efectivo":
                return MetodoPago.Efectivo;
            case "Tarjeta":
                return MetodoPago.Tarjeta;
            default:
                throw new IllegalArgumentException("Método de pago desconocido en la base de datos: " + dbData);
        }
    }
}
