package controller;

import service.ProductManagementService;

import java.util.Scanner;

public class ProductManagementController {
    private final ProductManagementService service;
    private Scanner scanner;

    public ProductManagementController(ProductManagementService service) {
        this.service = service;
    }

    public void Start() {
        boolean exit = false;

        while (!exit) {
            showMenu();
            int option = scanner.nextInt();
            switch (option){
                case 1 -> registerProductInStorage();
                case 2 -> updatePriceProduct();
                case 3 -> exit = true;
            }
        }

    }

    private void showMenu() {
        System.out.println("\n=== Product Management ===");
        System.out.println("1. Register Product");
        System.out.println("2. Update Price Product");
        System.out.println("3. Sair");
        System.out.print("choose a option: ");
    }

    private void registerProductInStorage() {
        System.out.println("Write id");
        int id = scanner.nextInt();
        System.out.println("Write name product");
        String name = scanner.next();
        System.out.println("Write price");
        double price = scanner.nextDouble();
        service.registerNewProduct(id, name, price);
        System.out.println("Register a new product sucessfully");
    }

    private void updatePriceProduct() {
        System.out.println("Write id that you want update the price");
        int id = scanner.nextInt();
        System.out.println("Write a new price of product");
        double price = scanner.nextDouble();
        service.updatePriceOfProduct(id, price);
    }
}
