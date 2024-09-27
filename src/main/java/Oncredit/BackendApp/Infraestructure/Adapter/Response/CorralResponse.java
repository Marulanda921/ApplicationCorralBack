package Oncredit.BackendApp.Infraestructure.Adapter.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CorralResponse {
    private Long id;
    private String name;
    private int capacity;
}
