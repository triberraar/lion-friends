package be.triberraar.lion.friends.animal.domain.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import be.triberraar.lion.friends.animal.domain.api.AnimalType;
import be.triberraar.lion.friends.animal.exception.AnimalNotFoundException;

@Named
public class DefaultAnimalRepository {

	private Map<String, DefaultAnimal> animals;

	@Inject
	private DefaultAnimalFactory defaultAnimalFactory;

	@PostConstruct
	public void init() {
		animals = new HashMap<String, DefaultAnimal>();
		animals.put("Dog one", defaultAnimalFactory.create("Dog one", AnimalType.DOG, "Meat", "Hunting dog"));
		animals.put("Parrot one", defaultAnimalFactory.create("Parrot one", AnimalType.PARROT, "Grain", "Wingspan 0.25", "Cannot speak"));
		animals.put("Chicken one", defaultAnimalFactory.create("Chicken one", AnimalType.CHICKEN, "Corn", "Hunting 0.75", "Is broiler"));
		animals.put("Dog two", defaultAnimalFactory.create("Dog two", AnimalType.DOG, "Fresh meat", "Assistance dog"));
		animals.put("Parrot two", defaultAnimalFactory.create("Parrot two", AnimalType.PARROT, "Corn", "Wingspan 0.5", "Can speak"));
		animals.put("Dog three", defaultAnimalFactory.create("Dog three", AnimalType.DOG, "Pedigree", "Racing dog"));
		animals.put("Chicken two", defaultAnimalFactory.create("Chicken two", AnimalType.CHICKEN, "Corn", "Wingspan 0.75", "Is not broiler"));
	}

	public Set<DefaultAnimal> all() {
		return new HashSet<>(animals.values());
	}

	public DefaultAnimal getByName(String name) {
		DefaultAnimal animal = animals.get(name);
		if (animal == null) {
			throw new AnimalNotFoundException(name);
		}
		return animal;
	}

}
