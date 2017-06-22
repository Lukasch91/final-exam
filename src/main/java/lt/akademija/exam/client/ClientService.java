package lt.akademija.exam.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

	@Autowired
	ClientRepository clientRepository;

	public Client saveClient(Client client) {

		List<Client> allClientList = clientRepository.findAll();
		
		if (!allClientList.contains(client)) {
			return clientRepository.save(client);
		}else {
		     throw new RuntimeException("This clients already exists");
		}
	}

}
