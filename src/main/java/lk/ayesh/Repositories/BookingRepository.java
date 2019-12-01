package lk.ayesh.Repositories;

import lk.ayesh.Models.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
@Repository
public interface BookingRepository extends MongoRepository<Booking, String> {
}