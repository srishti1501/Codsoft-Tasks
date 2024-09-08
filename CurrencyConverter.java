import java.util.Scanner;

public class CurrencyConverter {

    // Define exchange rates (as of some fixed date for simplicity)
    private static final double USD_TO_EUR = 0.93; // 1 USD = 0.93 EUR
    private static final double USD_TO_GBP = 0.76; // 1 USD = 0.76 GBP
    private static final double EUR_TO_USD = 1.08; // 1 EUR = 1.08 USD
    private static final double EUR_TO_GBP = 0.82; // 1 EUR = 0.82 GBP
    private static final double GBP_TO_USD = 1.32; // 1 GBP = 1.32 USD
    private static final double GBP_TO_EUR = 1.22; // 1 GBP = 1.22 EUR

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Currency Converter");
        System.out.println("Select source currency (USD, EUR, GBP): ");
        String sourceCurrency = scanner.next().toUpperCase();
        
        System.out.println("Select target currency (USD, EUR, GBP): ");
        String targetCurrency = scanner.next().toUpperCase();
        
        System.out.println("Enter amount in " + sourceCurrency + ": ");
        double amount = scanner.nextDouble();
        
        double convertedAmount = convertCurrency(sourceCurrency, targetCurrency, amount);
        
        if (convertedAmount != -1) {
            System.out.printf("%.2f %s is equal to %.2f %s%n", amount, sourceCurrency, convertedAmount, targetCurrency);
        } else {
            System.out.println("Invalid currency code.");
        }
        
        scanner.close();
    }

    public static double convertCurrency(String sourceCurrency, String targetCurrency, double amount) {
        double rate = getConversionRate(sourceCurrency, targetCurrency);
        
        if (rate == -1) {
            return -1; // invalid conversion rate
        }
        
        return amount * rate;
    }

    public static double getConversionRate(String sourceCurrency, String targetCurrency) {
        if (sourceCurrency.equals("USD")) {
            switch (targetCurrency) {
                case "EUR": return USD_TO_EUR;
                case "GBP": return USD_TO_GBP;
                default: return -1; // invalid currency code
            }
        } else if (sourceCurrency.equals("EUR")) {
            switch (targetCurrency) {
                case "USD": return EUR_TO_USD;
                case "GBP": return EUR_TO_GBP;
                default: return -1; // invalid currency code
            }
        } else if (sourceCurrency.equals("GBP")) {
            switch (targetCurrency) {
                case "USD": return GBP_TO_USD;
                case "EUR": return GBP_TO_EUR;
                default: return -1; // invalid currency code
            }
        }
        return -1; // invalid source currency code
    }
}
