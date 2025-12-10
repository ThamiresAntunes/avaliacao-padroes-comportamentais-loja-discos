package br.edu.ifpb.padroes.store;

import br.edu.ifpb.padroes.customer.Customer;
import br.edu.ifpb.padroes.customer.CustomerType;
import br.edu.ifpb.padroes.music.AgeRestriction;
import br.edu.ifpb.padroes.music.Album;
import br.edu.ifpb.padroes.music.MediaType;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MusicStore {

    private List<Album> inventory = new ArrayList<>();
    private List<Customer> customers = new ArrayList<>();

    // Validator de compras
    private final PurchaseValidator purchaseValidator = new PurchaseValidator();

    // Calculator que aplica várias strategies de desconto
    private final DiscountCalculator discountCalculator = new DiscountCalculator();
    private final PrintPurchase printPurchase = new PrintPurchase();
    private final CustomerNotifier observer = new CustomerNotifier();


    public void addMusic(Album album) {
        inventory.add(album);
        System.out.println("Added: " + album.getTitle());
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public List<Album> searchMusic(SearchType searchType, String searchTerm) {
        List<Album> results = new ArrayList<>();

        SearchStrategy strategy = searchType.getStrategy();

        for (Album album : inventory) {
            if (strategy.matches(album, searchTerm)) {
                results.add(album);
            }
        }

        return results;
    }

    public void purchaseMusic(Customer customer, Album album) {
        if (validatePurchase(customer, album)) {
            double discount = calculateDiscount(album, customer.getType());
            double finalPrice = album.getPrice() - discount;

            printPurchase.print(customer, album, discount, finalPrice);

            album.decreaseStock();
            customer.addPurchase(album);

            observer.notifyInterestedCustomers(customers, customer, album);

        } else {
            // Mensagem será impressa na validatePurchase (delegada)
        }
    }

    public boolean validatePurchase(Customer customer, Album album) {
        ValidationResult result = purchaseValidator.validate(customer, album);
        if (!result.isValid()) {
            System.out.println("Validation failed: " + result.getReason());
        }
        return result.isValid();
    }

    public double calculateDiscount(Album album, CustomerType customerType) {
        return discountCalculator.calculate(album, customerType);
    }

    public List<Album> getInventory() {
        return inventory;
    }

}
