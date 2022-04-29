package exam.demo.model.pizzas;

import exam.demo.model.Pizza;
import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class Diavola extends Pizza {
    private final String type = "Diavola";
}
