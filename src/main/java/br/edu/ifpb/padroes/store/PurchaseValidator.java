package br.edu.ifpb.padroes.store;

import br.edu.ifpb.padroes.customer.Customer;
import br.edu.ifpb.padroes.music.Album;
import br.edu.ifpb.padroes.music.AgeRestriction;

import java.time.LocalDate;

public class PurchaseValidator {

    public ValidationResult validate(Customer customer, Album album) {
        // Verificacoes
        if (album.getStock() <= 0) {
            return ValidationResult.fail("Out of stock");
        }

        if (customer.getCredit() < album.getPrice()) {
            return ValidationResult.fail("Insufficient credit");
        }

        if (album.getAgeRestriction().equals(AgeRestriction.PARENTAL_ADVISORY)
                && customer.getDateOfBirth().isAfter(LocalDate.now().minusYears(18))) {
            return ValidationResult.fail("Age restriction");
        }

        return ValidationResult.ok();
    }
}

