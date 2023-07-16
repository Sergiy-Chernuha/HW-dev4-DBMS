package ua.goit;

import ua.goit.db_dto.Worker;
import ua.goit.repos.impl.WorkerCrudService;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        WorkerCrudService workerCrudService= new WorkerCrudService();
        Optional<Worker> byId = workerCrudService.findById(28l);
        System.out.println(byId.orElse(new Worker()).getName());
    }
}
