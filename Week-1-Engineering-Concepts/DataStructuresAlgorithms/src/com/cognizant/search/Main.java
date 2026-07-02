package com.cognizant.search;

import java.util.Arrays;
import java.util.Comparator;

public class Main {

    // Linear Search
    public static Product linearSearch(Product[] products, String name) {

        for (Product product : products) {
            if (product.productName.equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }

    // Binary Search
    public static Product binarySearch(Product[] products, String name) {

        int left = 0;
        int right = products.length - 1;

        while (left <= right) {

            int mid = (left + right) / 2;

            int compare = products[mid].productName.compareToIgnoreCase(name);

            if (compare == 0)
                return products[mid];

            if (compare < 0)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return null;
    }

    public static void main(String[] args) {

        Product[] products = {
                new Product(101, "Laptop", "Electronics"),
                new Product(102, "Mouse", "Electronics"),
                new Product(103, "Keyboard", "Electronics"),
                new Product(104, "Phone", "Electronics"),
                new Product(105, "Shoes", "Fashion")
        };

        // Linear Search
        Product result1 = linearSearch(products, "Laptop");

        if (result1 != null)
            System.out.println("Linear Search Found : " + result1.productName);
        else
            System.out.println("Product not found");

        // Sort before Binary Search
        Arrays.sort(products, Comparator.comparing(p -> p.productName));

        Product result2 = binarySearch(products, "Laptop");

        if (result2 != null)
            System.out.println("Binary Search Found : " + result2.productName);
        else
            System.out.println("Product not found");

        System.out.println();
        System.out.println("Time Complexity:");
        System.out.println("Linear Search : O(n)");
        System.out.println("Binary Search : O(log n)");

    }
}