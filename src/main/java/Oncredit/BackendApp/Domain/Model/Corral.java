package Oncredit.BackendApp.Domain.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "corral")
public class Corral {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Corral name cannot be null")
    @NotEmpty(message = "Corral name cannot be empty")
    private String name;

    @Min(value = 1, message = "Capacity must be at least 1")
    private int capacity;

    @OneToMany(mappedBy = "corral", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Animal> animals = new ArrayList<>();

    public void addAnimal(Animal animal) {
        if (this.animals.size() < this.capacity) {
            if (!this.animals.contains(animal)) {
                this.animals.add(animal);
                animal.setCorral(this);
            }
        } else {
            throw new RuntimeException("Corral is full");
        }
    }
}
