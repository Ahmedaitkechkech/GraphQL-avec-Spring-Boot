package ma.rest.graph.web;

import lombok.Data;
import ma.rest.graph.entities.TypeTransaction;

import java.util.Date;

@Data
public class TransactionRequest {
    private Long compteId;
    private Double montant;
    private Date date;
    private TypeTransaction type;
}
