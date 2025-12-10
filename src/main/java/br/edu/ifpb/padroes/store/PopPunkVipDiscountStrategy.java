package br.edu.ifpb.padroes.store;

import br.edu.ifpb.padroes.customer.CustomerType;
import br.edu.ifpb.padroes.music.Album;

public class PopPunkVipDiscountStrategy implements DiscountStrategy {

    @Override
    public double calculate(Album album, CustomerType customerType) {
        if (album == null || customerType == null) {
            return 0;
        }
        if ("Pop Punk".equalsIgnoreCase(album.getGenre()) && customerType == CustomerType.VIP) {
            return album.getPrice() * 0.05;
        }
        return 0;
    }
}

