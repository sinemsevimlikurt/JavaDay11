package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Grocery {

    public static List<String> groceryList = new ArrayList<>();

    public static void startGrocery() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n Menü: \n0: Çıkış \n1: Eleman Ekleme \n2: Eleman Çıkarma \nLütfen seçiminizi yapın (0, 1 veya 2): ");
            String input = scanner.nextLine();
            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Hatalı tuşlama");
                continue;
            }
            if (choice == 0) {
                System.out.println("Sistemden çıkılıyor");
                break;
            } else if (choice == 1) {
                System.out.println("Eklenmesini istediğiniz elemanları giriniz.");
                String eventInput = scanner.nextLine();
                addItems(eventInput);
            } else if (choice == 2) {
                System.out.println("Çıkarmak istediğiniz elemanları giriniz.");
                String eventInput = scanner.nextLine();
                removeItems(eventInput);
            } else {
                System.out.println("Yanlış seçim.");
            }
            printSorted();
        }
            scanner.close();


    }
    public static void addItems(String input){
        String[] items = input.split(",");
        for(String item: items){
            String trimmedItem = item.trim();
            if(!trimmedItem.isEmpty() && !checkItemIsInList(trimmedItem)){
                groceryList.add(trimmedItem);
            }

        }
        Collections.sort(groceryList);
    }
    public static boolean checkItemIsInList(String product){
        return  groceryList.contains(product);
    }

    public static void removeItems(String input){
        String[] items = input.split(",");
        for(String item: items){
            String trimmedItem = item.trim();
            if(!trimmedItem.isEmpty() && checkItemIsInList(trimmedItem)){
                groceryList.remove(trimmedItem);
            }
        }
        Collections.sort(groceryList);
    }
    public static void printSorted(){
        Collections.sort(groceryList);
        System.out.println("Grocery List: " + groceryList);
    }
}
