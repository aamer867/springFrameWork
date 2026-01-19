package sia.tacocloud.data;

import org.springframework.data.repository.CrudRepository;
import sia.tacocloud.Ingredient;
import sia.tacocloud.TacoOrder;

public interface OrderRepository extends CrudRepository<Ingredient, Long> {
}