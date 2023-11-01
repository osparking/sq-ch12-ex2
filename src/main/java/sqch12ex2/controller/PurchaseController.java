package sqch12ex2.controller;

import java.util.List;

import javax.xml.crypto.KeySelector.Purpose;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import sqch12ex2.domain.Purchase;
import sqch12ex2.repository.PurchaseRepository;

@RestController
@AllArgsConstructor
@RequestMapping("/purchase")
public class PurchaseController {
	private final PurchaseRepository repository;
	
	@PostMapping
	public void createPurchase(@RequestBody Purchase purchase) {
		repository.storePurchase(purchase);
	}

	@GetMapping
	public List<Purchase> findAllPurchases() {
		return repository.findAllPurchases();
	}
}
