package ma.rest.graph.repositories;

import ma.rest.graph.entities.Compte;
import ma.rest.graph.entities.Transaction;
import ma.rest.graph.entities.TypeTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findByCompte(Compte compte);

    @Query("SELECT COALESCE(SUM(t.montant), 0) FROM Transaction t WHERE t.type = :type")
    double sumByType(@Param("type") TypeTransaction type);

    @Query("SELECT COALESCE(SUM(t.montant), 0) FROM Transaction t WHERE t.compte = :compte AND t.type = :type")
    double sumByCompteAndType(
            @Param("compte") Compte compte,
            @Param("type") TypeTransaction type
    );
}
