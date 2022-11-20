package ru.netology.manager;

import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;

public class TicketManager {
    private TicketRepository repository;

    public TicketManager(TicketRepository repository) {
        this.repository = repository;
    }

    public Ticket[] findAll() {
        Ticket[] all = repository.findAll();
        return all;
    }

    public void addTicket(Ticket ticket) {
        repository.addTicket(ticket);
    }

    public Ticket[] removeById(int id) {

        Ticket[] remove = repository.removeById(id);
        return remove;
    }

    public Ticket[] searchBy(String departureAirport, String arrivalAirport) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repository.findAll()) {
            if (matches(ticket, departureAirport, arrivalAirport)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

    public boolean matches(Ticket ticket, String departureAirport, String arrivalAirport) {
        if (ticket.getDepartureAirport().contains(departureAirport)) {
            if (ticket.getArrivalAirport().contains(arrivalAirport)) {
                return true;
            }
            return true;
        } else {
            return false;
        }
    }
}
