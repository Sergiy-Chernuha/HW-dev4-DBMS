package ua.goit;

import ua.goit.db_dto.Client;
import ua.goit.repos.impl.ClientService;

import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        ClientService clientService = new ClientService();
        clientService.save(new Client("Elephant"));
        clientService.save(new Client("Rabbit"));
        Optional<Client> client1 = clientService.findById(7l);
        System.out.println(client1.orElse(new Client()).getName());

        clientService.save(new Client(7l, "putler"));
        Optional<Client> client2 = clientService.findById(7l);
        System.out.println(client2.orElse(new Client()).getName());

        clientService.update(new Client(7l, "Harry Potter"));
        Optional<Client> client3 = clientService.findById(7l);
        System.out.println(client3.orElse(new Client()).getName());

        clientService.delete(new Client(7l, "Harry Potter"));
        Optional<Client> client4 = clientService.findById(7l);
        System.out.println(client4.orElse(new Client()).getName());

        List<Client> allClients = clientService.findAll();
        System.out.println((allClients));

        try {
            clientService.save(new Client("p"));
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}
