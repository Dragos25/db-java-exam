package exam.demo.controller;

import exam.demo.repository.PizzaRepository;
import exam.demo.service.PizzaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pizzas")
@RequiredArgsConstructor
public class PizzaController {
    private final PizzaService pizzaService;
    @GetMapping("/menu")
    public List<String> menu(){
        return pizzaService.menu();
    }
}
