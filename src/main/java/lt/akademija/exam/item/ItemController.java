package lt.akademija.exam.item;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {
	

	@Autowired
	private ItemRepository itemRepository;

	@GetMapping("/api/items/{clientId}")
	public Long getNumberOfItemsByClientId(@PathVariable Integer clientId) {
		return itemRepository.countItemsBy(clientId);
	}
	
	@GetMapping("/api/items")
	@ApiOperation(value = "Returns all flights that are currently in the list")
	public List<Item> getClients() {
		return itemRepository.findAll();
	}

	@DeleteMapping("/api/items/{id}")
	public void deleteClient(@PathVariable Long id) {
		itemRepository.delete(id);
	}

	@PostMapping("/api/items")
	public Item registerClient(@RequestBody Item item) {
		return itemRepository.save(item);
	}

}
