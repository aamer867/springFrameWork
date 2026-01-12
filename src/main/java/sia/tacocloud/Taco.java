package sia.tacocloud;

import lombok.Data;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.List;

@Data
public class Taco {

    private String id;
    private Date createdAt=new Date();

    @NotNull
    @Size(min=5, message="Name must be greater than 5 letters")
    private String name;

    @NotNull
    @Size(min=1, message="You have to add at least one Ingredient")
    private List<Ingredient> ingredients;
}
