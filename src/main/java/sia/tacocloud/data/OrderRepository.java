package sia.tacocloud.data;

import org.springframework.data.repository.CrudRepository;
import sia.tacocloud.Ingredient;
import sia.tacocloud.TacoOrder;

import java.util.List;

public interface OrderRepository extends CrudRepository<TacoOrder, Long> {
    List<TacoOrder> findByDeliveryZip(String deliveryZip);
}