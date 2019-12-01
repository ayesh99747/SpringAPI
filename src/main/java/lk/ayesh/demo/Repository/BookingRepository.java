package lk.ayesh.demo.Repository;

import lk.ayesh.demo.Model.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
@Repository
public interface BookingRepository extends MongoRepository<Booking, String> {
}
