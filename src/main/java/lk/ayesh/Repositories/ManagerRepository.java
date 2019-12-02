package lk.ayesh.Repositories;

import lk.ayesh.Models.Manager;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * This class is the vehicle manager interface
 *
 * @author Ayeshmantha Wijayagunathilaka (ID: 2018072)
 */

@CrossOrigin(origins = "http://localhost:4200")
@Repository
public interface ManagerRepository extends MongoRepository<Manager, String> {
}
