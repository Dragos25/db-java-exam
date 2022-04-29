package exam.demo.controller;

import exam.demo.exception.PizzaNotInMenuException;
import exam.demo.model.Order;
import exam.demo.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("orders")
public class OrderController {
    private final OrderService orderService;
    @PostMapping("orderPizza/{customerId}/{name}")
    public ResponseEntity<Order> orderPizza(@PathVariable("name") String name, @PathVariable("customerId") Integer id) throws Exception {
        Order order;
        try {
            order = orderService.order(id, name);
        }
        catch(PizzaNotInMenuException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(order);
    }
}
