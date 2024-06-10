package br.edu.infnet.dr1_tp3.model;

import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "materiais")
@Data
public class MaterialDidatico {
    @Id
    private String id;
    private String titulo;
    private String conteudo;

}