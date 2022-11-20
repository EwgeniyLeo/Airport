package ru.netology.repository;

import ru.netology.domain.Ticket;
import ru.netology.exception.NotFoundException;

public class TicketRepository {
    public Ticket[] tickets = new Ticket[0];

    public void addProduct(Ticket ticket) {
        Ticket[] tmp = new Ticket[tickets.length + 1];
        for (int i = 0; i < tickets.length; i++) {
            tmp[i] = tickets[i];
        }
        tmp[tmp.length - 1] = ticket;
        tickets = tmp;
    }


    public Ticket[] removeById(int id) {
        if (findById(id) != null) {
            Ticket[] tmp = new Ticket[tickets.length - 1];
            int copyToIndex = 0;
            for (Ticket product : tickets) {
                if (product.getId() != id) {
                    tmp[copyToIndex] = product;
                    copyToIndex++;
                }
                tickets = tmp;
            }
            return tickets;
        } else {
            throw new NotFoundException("Element with id: " + id + " not found");
        }
    }

    public Ticket[] findAll() {
        return tickets;
    }

    public Ticket findById(int id) {
        for (Ticket ticket : tickets) {
            if (ticket.getId() == id) {
                return ticket;
            }
        }
        return null;
    }
}
