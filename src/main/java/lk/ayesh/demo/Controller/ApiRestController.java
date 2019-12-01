package lk.ayesh.demo.Controller;

import lk.ayesh.demo.Model.Vehicle;
import lk.ayesh.demo.Repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class ApiRestController {

    @Autowired
    private VehicleRepository vehicleRepository;


    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Vehicle add(@RequestBody Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @GetMapping
    public List<Vehicle> getAll() {
        return vehicleRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Vehicle getOne(@PathVariable String id) {
        return vehicleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException());
    }


    @DeleteMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void delete(@PathVariable String id) {
        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException());
        vehicleRepository.delete(vehicle);
    }
}
