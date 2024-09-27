package Oncredit.BackendApp.Infraestructure.Adapter.Request;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnimalRequest {
    @NotNull
    private String name;
    @Min(0)
    private int age;
    @NotNull
    private Boolean dangerous;
    @NotNull
    private Long corralId;

    private List<Long> incompatibleAnimalIds;
}
