package lk.ayesh.demo.Repository;

import lk.ayesh.demo.Model.Manager;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
public interface ManagerRepository extends MongoRepository<Manager, String> {
}
