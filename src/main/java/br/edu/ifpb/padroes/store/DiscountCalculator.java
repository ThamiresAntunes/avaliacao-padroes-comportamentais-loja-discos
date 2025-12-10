package br.edu.ifpb.padroes.store;

import br.edu.ifpb.padroes.customer.CustomerType;
import br.edu.ifpb.padroes.music.Album;

import java.util.ArrayList;
import java.util.List;

public class DiscountCalculator {

    private final List<DiscountStrategy> strategies = new ArrayList<>();

    public DiscountCalculator() {
        strategies.add(new CustomerTypeDiscountStrategy());
        strategies.add(new VinylOldReleaseDiscountStrategy());
        strategies.add(new PopPunkVipDiscountStrategy());
    }

    public double calculate(Album album, CustomerType customerType) {
        double total = 0;
        for (DiscountStrategy s : strategies) {
            total += s.calculate(album, customerType);
        }
        return total;
    }
}

