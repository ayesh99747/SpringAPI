package lk.ayesh.Repositories;

import lk.ayesh.Models.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
public interface VehicleRepository extends MongoRepository<Vehicle, String> {
}
