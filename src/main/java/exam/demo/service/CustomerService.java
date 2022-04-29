package exam.demo.service;

import exam.demo.exception.CustomerNotFoundException;
import exam.demo.exception.InvalidEmailException;
import exam.demo.model.Customer;
import exam.demo.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import exam.demo.util.EmailValidator;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    public Customer add(Customer customer) throws InvalidEmailException {
        if(!EmailValidator.validate(customer.getEmail())) throw new InvalidEmailException();
        return customerRepository.save(customer);
    }

    public void save(Customer customer){
        customerRepository.save(customer);
    }

    public Customer get(Integer id) throws Exception {
        Optional<Customer> customer = customerRepository.findById(id);
        if(!customer.isPresent()){
            throw new CustomerNotFoundException(id);
        }
        return customer.get();
    }

    public List<Customer> getAll(){
        return customerRepository.findAll();
    }
}
