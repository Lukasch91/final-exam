package lt.akademija.exam.client;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Client service
 */
@Service
public class ClientService {

	final static Logger logger = Logger.getLogger(ClientService.class);

	@Autowired
	ClientRepository clientRepository;

	/**
	 * to check was client created already or not
	 * 
	 * @param client object Client
	 * @return Client Object
	 */
	public Client saveClient(Client client) {

		List<Client> allClientList = clientRepository.findAll();

		if (!allClientList.contains(client)) {
			return clientRepository.save(client);
			
		} else {
			logger.error("This clients already exists");
			throw new RuntimeException("This clients already exists");
		}
		
	}

}
