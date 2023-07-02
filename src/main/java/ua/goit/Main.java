package ua.goit;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        DatabaseQueryService databaseQueryService = new DatabaseQueryService();

        System.out.println(Arrays.asList(databaseQueryService.findLongestProject()));
        System.out.println(Arrays.asList(databaseQueryService.findMaxProjectsClient()));
        System.out.println(Arrays.asList(databaseQueryService.findMaxSalaryWorker()));
        System.out.println(Arrays.asList(databaseQueryService.findYoungestOldestWorkers()));
        System.out.println(Arrays.asList(databaseQueryService.findProjectPrices()));
    }
}
