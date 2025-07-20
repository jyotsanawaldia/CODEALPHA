// StockTrading.java

import java.util.*;

class Stock {
    String symbol;
    double price;

    Stock(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
    }
}

class Portfolio {
    Map<String, Integer> holdings = new HashMap<>();
    double balance;

    Portfolio(double initialBalance) {
        this.balance = initialBalance;
    }

    void buyStock(String symbol, int quantity, double price) {
        double cost = quantity * price;
        if (balance >= cost) {
            balance -= cost;
            holdings.put(symbol, holdings.getOrDefault(symbol, 0) + quantity);
            System.out.println("✅ Bought " + quantity + " shares of " + symbol);
        } else {
            System.out.println("❌ Not enough balance to buy " + symbol);
        }
    }

    void sellStock(String symbol, int quantity, double price) {
        int owned = holdings.getOrDefault(symbol, 0);
        if (owned >= quantity) {
            balance += quantity * price;
            holdings.put(symbol, owned - quantity);
            System.out.println("✅ Sold " + quantity + " shares of " + symbol);
        } else {
            System.out.println("❌ Not enough shares to sell " + symbol);
        }
    }

    void viewPortfolio() {
        System.out.println("💼 Portfolio:");
        if (holdings.isEmpty()) {
            System.out.println("You don't own any stocks.");
        } else {
            for (var entry : holdings.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue() + " shares");
            }
        }
        System.out.printf("💰 Balance: ₹%.2f\n", balance);
    }
}

public class StockTrading {
    static Map<String, Stock> stockMarket = new HashMap<>();
    static Scanner scanner = new Scanner(System.in);
    static Portfolio portfolio = new Portfolio(10000.0); // Initial ₹10,000

    public static void main(String[] args) {
        stockMarket.put("TCS", new Stock("TCS", 3500.0));
        stockMarket.put("INFY", new Stock("INFY", 1500.0));
        stockMarket.put("WIPRO", new Stock("WIPRO", 450.0));

        int choice;
        do {
            System.out.println("\n📈 Stock Trading Platform");
            System.out.println("1. View Market");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Portfolio");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> viewMarket();
                case 2 -> buyStock();
                case 3 -> sellStock();
                case 4 -> portfolio.viewPortfolio();
                case 5 -> System.out.println("👋 Exiting... Happy Trading!");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 5);
    }

    static void viewMarket() {
        System.out.println("📊 Market Stocks:");
        for (var stock : stockMarket.values()) {
            System.out.printf("%s - ₹%.2f\n", stock.symbol, stock.price);
        }
    }

    static void buyStock() {
        System.out.print("Enter stock symbol to buy: ");
        String symbol = scanner.nextLine().toUpperCase();
        if (stockMarket.containsKey(symbol)) {
            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();
            scanner.nextLine();
            Stock stock = stockMarket.get(symbol);
            portfolio.buyStock(symbol, quantity, stock.price);
        } else {
            System.out.println("❌ Invalid stock symbol.");
        }
    }

    static void sellStock() {
        System.out.print("Enter stock symbol to sell: ");
        String symbol = scanner.nextLine().toUpperCase();
        if (stockMarket.containsKey(symbol)) {
            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();
            scanner.nextLine();
            Stock stock = stockMarket.get(symbol);
            portfolio.sellStock(symbol, quantity, stock.price);
        } else {
            System.out.println("❌ Invalid stock symbol.");
        }
    }
}
