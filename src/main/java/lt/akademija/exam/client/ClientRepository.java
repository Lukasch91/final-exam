package lt.akademija.exam.client;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Client repository
 */
@Repository
public class ClientRepository {

	final static Logger logger = Logger.getLogger(ClientRepository.class);

	
	@PersistenceContext
	private EntityManager entityManager;

	/**
     * to get user by id
     * @param id unique id of user
     * @return Client Object
     */
	@Transactional(readOnly = true)
	public Client get(Long id) {
		logger.info("looking for client by id...");
		return entityManager.find(Client.class, id);
	}

	/**
     * to save new client
     * @param client object Client
     * @return Client Object
     */
	@Transactional
	public Client save(Client client) {
		logger.info("trying to save client...");
		return entityManager.merge(client);
	}

	/**
     * to delete client
     * @param id unique id of client
     */
	@Transactional
	public void delete(Long id) {
		logger.info("trying to delete client by id...");
		entityManager.remove(entityManager.find(Client.class, id));
	}

	/**
     * to get all list of clients
     * @return List list of clients
     */
	@Transactional(readOnly = true)
	public List<Client> findAll() {
		logger.info("trying to find all clients...");
		return entityManager.createNamedQuery("findAllClients").getResultList();
	}
}
