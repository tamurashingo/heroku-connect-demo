package com.github.tamurashingo.herokuconnectdemo.herokuconnectdemo.service;

import com.github.tamurashingo.herokuconnectdemo.herokuconnectdemo.HerokuConnectdemoException;
import com.github.tamurashingo.herokuconnectdemo.herokuconnectdemo.controller.request.TelSupportReservationForm;
import com.github.tamurashingo.herokuconnectdemo.herokuconnectdemo.mapper.TelSupportReservationMapper;
import com.github.tamurashingo.herokuconnectdemo.herokuconnectdemo.model.TelSupportReservation;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TelSupportReservationService {

    List<TelSupportReservation> findAll() throws TelSupportReservationException;

    TelSupportReservation findById(String externalid) throws TelSupportReservationException;

    void createReservation(TelSupportReservationForm form) throws TelSupportReservationException;

    public static class TelSupportReservationException extends HerokuConnectdemoException {
        private static final long serialVersionUID = 1L;

        public TelSupportReservationException(String message) {
            super(message);
        }

        public TelSupportReservationException(String message, Throwable cause) {
            super(message, cause);
        }

        public TelSupportReservationException(Throwable cause) {
            super(cause);
        }
    }
}
