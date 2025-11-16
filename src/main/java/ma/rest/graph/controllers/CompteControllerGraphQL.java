package ma.rest.graph.controllers;

import lombok.AllArgsConstructor;
import ma.rest.graph.entities.Compte;
import ma.rest.graph.repositories.CompteRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;

@Controller
@AllArgsConstructor
public class CompteControllerGraphQL {

    private final CompteRepository compteRepository;

    // ------------------ QUERIES COMPTES ------------------

    @QueryMapping
    public List<Compte> allComptes() {
        return compteRepository.findAll();
    }

    @QueryMapping
    public Compte compteById(@Argument Long id) {
        return compteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        String.format("Compte %s not found", id)
                ));
    }

    // ------------------ MUTATION COMPTES ------------------

    @MutationMapping
    public Compte saveCompte(@Argument("compte") Compte compte) {
        // GraphQL mappe l'input CompteRequest sur l'entité Compte
        return compteRepository.save(compte);
    }

    // ------------------ STATS SOLDES ------------------

    @QueryMapping
    public Map<String, Object> totalSolde() {
        long count = compteRepository.count();
        double sum = compteRepository.sumSoldes();
        double average = count > 0 ? sum / count : 0;

        return Map.of(
                "count", count,
                "sum", sum,
                "average", average
        );
    }
}