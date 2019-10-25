package ec.edu.espe.experiment.springrest.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.experiment.springrest.dao.IOrderDAO;
import ec.edu.espe.experiment.springrest.dto.Order;
import ec.edu.espe.experiment.springrest.dto.OrderEntityClient;
import io.micrometer.core.ipc.http.HttpSender.Response;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})
@RequestMapping("/api/order")
public class RestOrderController{
    @Autowired
    private IOrderDAO dao;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Order> getAll() {        
        return dao.getAll();
    }

    @GetMapping(value = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Order> get(@PathVariable("id") Integer id) {
        Order responsOrder = dao.get(id);
        if(responsOrder != null){
            return ResponseEntity.status(HttpStatus.OK).body(responsOrder);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responsOrder);
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Order> post(@RequestBody OrderEntityClient entity) {
        Order responsOrder = dao.post(entity);
        if(responsOrder != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(responsOrder);
        } else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responsOrder);
        }
    }

}