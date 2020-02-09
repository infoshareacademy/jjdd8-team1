package com.infoshareacademy.service;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

@Singleton
@Startup
public class Scheduler {

    @Inject
    ReservationService reservationService;

    @Schedule(hour = "*", minute = "20/5",
            second = "*", info = "Every 5 minutes timer")
    public void schedule () {
        reservationService.removeUnconfirmedReservations();
    }
}
