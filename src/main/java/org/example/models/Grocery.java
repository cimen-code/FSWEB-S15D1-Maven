package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Grocery {

    public static ArrayList<String> groceryList = new ArrayList<>();

    public static void startGrocery() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("0 - Çıkış");
            System.out.println("1 - Eleman ekle");
            System.out.println("2 - Eleman çıkar");

            String option = scanner.nextLine();

            switch (option) {
                case "0":
                    return;

                case "1":
                    System.out.println("Eklenmesini istediğiniz elemanları giriniz.");
                    addItems(scanner.nextLine());
                    break;

                case "2":
                    System.out.println("Cıkarılmasını istediğiniz elemanları giriniz.");
                    removeItems(scanner.nextLine());
                    break;

                default:
                    System.out.println("Geçersiz seçim.");
            }
        }
    }

    public static void addItems(String input) {
        String[] products = input.split(",");

        for (String product : products) {
            String item = product.trim();

            if (!item.isEmpty() && !checkItemIsInList(item)) {
                groceryList.add(item);
            }
        }

        printSorted();
    }

    public static void removeItems(String input) {
        String[] products = input.split(",");

        for (String product : products) {
            String item = product.trim();

            if (checkItemIsInList(item)) {
                groceryList.remove(item);
            }
        }

        printSorted();
    }

    public static boolean checkItemIsInList(String product) {
        return groceryList.contains(product.trim());
    }

    public static void printSorted() {
        Collections.sort(groceryList);
        System.out.println(groceryList);
    }
}
