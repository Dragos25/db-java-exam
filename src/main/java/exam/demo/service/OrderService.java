package exam.demo.service;

import exam.demo.exception.PizzaNotInMenuException;
import exam.demo.factory.PizzaFactory;
import exam.demo.model.Customer;
import exam.demo.model.Order;
import exam.demo.model.Pizza;
import exam.demo.repository.OrderRepository;
import exam.demo.repository.PizzaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final CustomerService customerService;
    private final PizzaService pizzaService;
    private final OrderRepository orderRepository;
    private final PizzaRepository pizzaRepository;
    public Order order(Integer customerId, String pizzaName) throws Exception {
        if(!pizzaService.exists(pizzaName)) throw new PizzaNotInMenuException(pizzaName);
        Pizza pizza = PizzaFactory.getPizza(pizzaName);
        Customer customer = customerService.get(customerId);
        Order order = new Order();
        order.setCustomer(customer);
        order.setPizza(pizza);
        customer.addOrderToList(order);
        Order orderAdd = orderRepository.save(order);
        pizzaRepository.save(pizza);
        customerService.save(customer);
        return orderAdd;


    }

}
