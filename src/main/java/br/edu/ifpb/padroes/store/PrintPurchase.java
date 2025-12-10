package br.edu.ifpb.padroes.store;

import br.edu.ifpb.padroes.customer.Customer;
import br.edu.ifpb.padroes.music.Album;

public class PrintPurchase {

    public void print(Customer customer, Album album, double discount, double finalPrice) {
        System.out.println("Purchase: " + album.getFormattedName() + " by " + customer.getName());
        System.out.println("Original price: $" + album.getPrice());
        System.out.println("Discount: $" + discount);
        System.out.println("Final price: $" + finalPrice);
    }
}
