package br.edu.ifpb.padroes.store;

import br.edu.ifpb.padroes.customer.Customer;
import br.edu.ifpb.padroes.music.Album;

import java.util.List;

public class CustomerNotifier {
    public void notifyInterestedCustomers(List<Customer> customers, Customer buyer, Album album) {
        for (Customer c : customers) {
            if (c.isInterestedIn(album.getGenre()) && !c.equals(buyer)) {
                System.out.println("Notifying " + c.getName() + " about popular " + album.getGenre() + " purchase");
            }
        }
    }
}