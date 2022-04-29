package exam.demo.controller;

import exam.demo.exception.CustomerNotFoundException;
import exam.demo.exception.InvalidEmailException;
import exam.demo.model.Customer;
import exam.demo.model.Order;
import exam.demo.service.CustomerService;
import exam.demo.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;
    private final OrderService orderService;
    @PostMapping("/add")
    public Customer add(@RequestBody Customer c) {
        Customer add;
        try{
            add = customerService.add(c);
        }
        catch(InvalidEmailException e){
            return null;
        }
        return add;
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Customer> get(@PathVariable("id") Integer id) throws Exception {
        Customer c;
        try{
            c =customerService.get(id);
        }
        catch(CustomerNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(c);
    }

    @GetMapping("getAll")
    public List<Customer> getAll(){
        return customerService.getAll();
    }


}
