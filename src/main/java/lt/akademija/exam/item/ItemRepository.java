package lt.akademija.exam.item;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ItemRepository {

	final static Logger logger = Logger.getLogger(ItemRepository.class);

	private static final String GET_COUNT_OF_ITEMS_BY_CLIENT_ID = " SELECT COUNT(i) FROM Item i WHERE i.clientId=:clientId";

	@PersistenceContext
	private EntityManager entityManager;

	/**
     * returns number of items by clientId
     * @param clientId id of client
     * @return Long number if items
     */
	public Long countItemsBy(Integer clientId) {
		return (Long) entityManager.createQuery(GET_COUNT_OF_ITEMS_BY_CLIENT_ID).setParameter("clientId", clientId)
				.getResultList().get(0);
	}

	/**
     * to get item by id
     * @param id unique id of item
     * @return Item Object
     */
	@Transactional(readOnly = true)
	public Item get(Long id) {
		logger.info("looking for item by id...");
		return entityManager.find(Item.class, id);
	}

	/**
     * to save new item
     * @param Item object Item
     * @return Item item
     */
	@Transactional
	public Item save(Item item) {
		logger.info("trying to save item...");
		return entityManager.merge(item);
	}

	/**
     * to delete item
     * @param id unique id of item
     */
	@Transactional
	public void delete(Long id) {
		logger.info("trying to delete item by id...");
		entityManager.remove(entityManager.find(Item.class, id));
	}

	/**
     * to get all list of items
     * @return List list of items
     */
	@Transactional(readOnly = true)
	public List<Item> findAll() {
		logger.info("trying to find all items...");
		return entityManager.createNamedQuery("findAllItems").getResultList();
	}
}
