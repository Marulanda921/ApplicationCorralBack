package Oncredit.BackendApp.Application.Service;

import Oncredit.BackendApp.Domain.Exception.AnimalIncompatibleException;
import Oncredit.BackendApp.Domain.Exception.CorralFullException;
import Oncredit.BackendApp.Domain.Exception.CorralNotFoundException;
import Oncredit.BackendApp.Domain.Model.Animal;
import Oncredit.BackendApp.Domain.Model.Corral;
import Oncredit.BackendApp.Infraestructure.Adapter.Request.AnimalRequest;
import Oncredit.BackendApp.Infraestructure.Adapter.Response.AnimalResponse;
import Oncredit.BackendApp.Infraestructure.Persistence.Repository.AnimalRepository;
import Oncredit.BackendApp.Infraestructure.Persistence.Repository.CorralRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private CorralRepository corralRepository;

    @Autowired
    private ModelMapper modelMapper;

    public AnimalResponse createAnimal(AnimalRequest animalRequest) {
        List<Animal> incompatibleAnimals = new ArrayList<>();
        if (animalRequest.getIncompatibleAnimalIds() != null && !animalRequest.getIncompatibleAnimalIds().isEmpty()) {
            incompatibleAnimals = animalRepository.findAllById(animalRequest.getIncompatibleAnimalIds());
            if (incompatibleAnimals.size() != animalRequest.getIncompatibleAnimalIds().size()) {
                throw new AnimalIncompatibleException("Your animal is compatible with everyone in the pen. Remove the incompatiblesID line and add it.");
            }
        }
        Animal animal = new Animal();
        animal.setName(animalRequest.getName());
        animal.setAge(animalRequest.getAge());
        animal.setDangerous(animalRequest.getDangerous());
        animal.setIncompatibleAnimals(incompatibleAnimals);
        Corral corral = corralRepository.findById(animalRequest.getCorralId())
                .orElseThrow(() -> new CorralNotFoundException("Corral not found"));

        if (corral.getAnimals().size() >= corral.getCapacity()) {
            throw new CorralFullException("Corral is full");
        }

        for (Animal existingAnimal : corral.getAnimals()) {
            if (animal.getIncompatibleAnimals().contains(existingAnimal) ||
                    existingAnimal.getIncompatibleAnimals().contains(animal)) {
                throw new AnimalIncompatibleException("Animal is incompatible with existing animals in the corral");
            }
        }
        animal.setCorral(corral);
        Animal savedAnimal = animalRepository.save(animal);
        corral.getAnimals().add(savedAnimal);
        corralRepository.save(corral);
        return modelMapper.map(savedAnimal, AnimalResponse.class);
    }


    public List<AnimalResponse> getAnimalsByCorral(Long corralId) {
        List<Animal> animals = animalRepository.findByCorralId(corralId);
        return animals.stream()
                .map(animal -> modelMapper.map(animal, AnimalResponse.class))
                .collect(Collectors.toList());
    }

    public List<AnimalResponse> getHighRiskAnimals() {
        List<Animal> animals = animalRepository.findByDangerous(true);
        return animals.stream()
                .map(animal -> modelMapper.map(animal, AnimalResponse.class))
                .collect(Collectors.toList());
    }
    public double getAverageAgeByCorral(Long corralId) {
        List<Animal> animals = animalRepository.findByCorralId(corralId);
        return animals.stream()
                .mapToInt(Animal::getAge)
                .average()
                .orElse(0.0);
    }

}