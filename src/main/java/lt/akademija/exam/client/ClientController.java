package lt.akademija.exam.client;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
* <h1>Client rest controller</h1>
*
* @author  lcholomskis
* */
@RestController
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired 
    private ClientService clientService;
    

    @GetMapping("/api/clients")
    @ApiOperation(value = "Returns all flights that are currently in the list")
    public List<Client> getClients() {
        return clientRepository.findAll();
    }


    @DeleteMapping("/api/clients/{id}")
    public void deleteClient(@PathVariable Long id) {
        clientRepository.delete(id);
    }


    @PostMapping("/api/clients")
    public Client registerClient(@RequestBody Client client) {

        return clientService.saveClient(client);
    }
}
