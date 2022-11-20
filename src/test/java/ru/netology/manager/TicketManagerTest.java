package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

public class TicketManagerTest {
    TicketRepository repository = new TicketRepository();
    TicketManager manager = new TicketManager(repository);

    Ticket ticket1 = new Ticket(11, 10_000,"DME", "EGO", 100);
    Ticket ticket2 = new Ticket(22, 8_000,"DME", "EGO", 100);
    Ticket ticket3 = new Ticket(33, 11_500,"DME", "EGO", 100);
    Ticket ticket4 = new Ticket(44, 6_500,"OGZ", "BLG", 100);
    Ticket ticket5 = new Ticket(55, 25_100,"OGZ", "BLG", 100);
    Ticket ticket6 = new Ticket(66, 9_900,"DME", "EGO", 100);
    Ticket ticket7 = new Ticket(77, 11_000,"DME", "EGO", 100);

    @BeforeEach
    public void setup() {
        manager.addTicket(ticket1);
        manager.addTicket(ticket2);
        manager.addTicket(ticket3);
        manager.addTicket(ticket4);
        manager.addTicket(ticket5);
        manager.addTicket(ticket6);
        manager.addTicket(ticket7);
    }

    @Test
    public void shouldAddandFindAllTickets() {
        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6, ticket7};
        Ticket[] actual = manager.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveId22() {
        Ticket[] expected = {ticket1, ticket3, ticket4, ticket5, ticket6, ticket7};
        Ticket[] actual = manager.removeById(22);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByDmeAndEgo() {
        Ticket[] expected = {ticket2, ticket6, ticket1, ticket7, ticket3};
        Ticket[] actual = manager.searchBy("DME", "EGO");
        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldSearchByOGZAndBLG() {
        Ticket[] expected = {ticket4, ticket5};
        Ticket[] actual = manager.searchBy("OGZ", "BLG");
        Assertions.assertArrayEquals(expected, actual);
    }
}
