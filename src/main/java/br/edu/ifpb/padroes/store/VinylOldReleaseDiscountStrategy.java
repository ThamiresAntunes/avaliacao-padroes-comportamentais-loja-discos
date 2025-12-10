package br.edu.ifpb.padroes.store;

import br.edu.ifpb.padroes.customer.CustomerType;
import br.edu.ifpb.padroes.music.Album;
import br.edu.ifpb.padroes.music.MediaType;

public class VinylOldReleaseDiscountStrategy implements DiscountStrategy {

    @Override
    public double calculate(Album album, CustomerType customerType) {
        if (album == null) {
            return 0;
        }
        if (album.getType() == MediaType.VINYL && album.getReleaseDate().getYear() < 1980) {
            return album.getPrice() * 0.10;
        }
        return 0;
    }
}
