package exam.demo.service;

import exam.demo.model.Pizza;
import exam.demo.repository.PizzaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PizzaService {
    private PizzaRepository pizzaRepository;
    public Pizza add(Pizza pizza){
        return pizzaRepository.save(pizza);
    }

    public List<String> menu() {
        ArrayList<String> menu = new ArrayList<>();
        menu.add("Diavola");
        menu.add("Marguerita");
        menu.add("Pepperoni");
        return menu;
    }

    public boolean exists(String pizzaName){
        ArrayList<String> menu = (ArrayList<String>) menu();
        for(String pizza : menu)
            if(pizza.equals(pizzaName)) return true;
        return false;
    }
}
