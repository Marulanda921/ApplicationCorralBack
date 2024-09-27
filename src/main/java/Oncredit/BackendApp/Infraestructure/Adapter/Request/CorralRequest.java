package Oncredit.BackendApp.Infraestructure.Adapter.Request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CorralRequest {
    @NotNull(message = "Name cannot be null")
    private String name;

    @Min(value = 1, message = "Capacity must be at least 1")
    private int capacity;
}
