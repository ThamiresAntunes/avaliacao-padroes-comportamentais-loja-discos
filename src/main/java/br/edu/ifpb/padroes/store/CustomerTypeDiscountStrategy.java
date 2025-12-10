package br.edu.ifpb.padroes.store;

import br.edu.ifpb.padroes.customer.CustomerType;
import br.edu.ifpb.padroes.music.Album;

public class CustomerTypeDiscountStrategy implements DiscountStrategy {

    @Override
    public double calculate(Album album, CustomerType customerType) {
        if (customerType == null) {
            return 0;
        }
        switch (customerType) {
            case VIP:
                return album.getPrice() * 0.20;
            case PREMIUM:
                return album.getPrice() * 0.15;
            case REGULAR:
                return album.getPrice() * 0.05;
            default:
                return 0;
        }
    }
}

