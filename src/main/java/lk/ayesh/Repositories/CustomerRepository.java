package lk.ayesh.Repositories;

import lk.ayesh.Models.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
public interface CustomerRepository extends MongoRepository<Customer, String> {
}
