package sqch12ex1.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;
import sqch12ex1.domain.Purchase;

@Repository
@AllArgsConstructor
public class PurchaseRepository {
	private final JdbcTemplate jdbcTemplate;

	public void storePurchase(Purchase purchase) {
		jdbcTemplate.update("insert into purchase values (null, ?, ?)",
				purchase.getProduct(), purchase.getPrice());
	}

	public List<Purchase> findAllPurchases() {
		RowMapper<Purchase> rowMapper = ((rs, rowNum) -> {
			var purchase = new Purchase();
			purchase.setId(rs.getInt("id"));
			purchase.setProduct(rs.getString("product"));
			purchase.setPrice(rs.getBigDecimal("price"));
			return purchase;
		});
		
		return jdbcTemplate.query("select * from purchase", rowMapper);
	}
}
