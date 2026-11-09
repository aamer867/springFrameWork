package sia.tacocloud.web;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import sia.tacocloud.TacoOrder;
import sia.tacocloud.data.OrderRepository;
import sia.tacocloud.data.UserRepository;
import sia.tacocloud.tacos.User;

import java.security.Principal;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
public class OrderController {

    private OrderRepository orderRepo;
    private UserRepository userRepo;

    @Autowired
    public OrderController(OrderRepository orderRepo, UserRepository userRepository) {
        this.orderRepo = orderRepo;
        this.userRepo = userRepository;
    }

    @GetMapping(value = "/current")
    public String showOrderForm() {
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid TacoOrder order,
                               Errors errors,
                               SessionStatus sessionStatus,
                               Principal principal) {

        if(errors.hasErrors()) {
            return "orderForm";
        }

        User user = userRepo.findByUsername(
                principal.getName());

        order.setUser(user);

        orderRepo.save(order);
        sessionStatus.setComplete();

        return "redirect:/";
    }

}
