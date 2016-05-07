package be.triberraar.lion.friends.animal.domain.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.util.reflection.Whitebox;
import org.mockito.runners.MockitoJUnitRunner;

import be.triberraar.lion.friends.animal.domain.api.AnimalType;

@RunWith(MockitoJUnitRunner.class)
public class DefaultAnimalRepositoryAllTest {

	private DefaultAnimalRepository defaultAnimalRepository = new DefaultAnimalRepository();

	private DefaultAnimalFactory defaultAnimalFactory = new DefaultAnimalFactory();

	@Test
	public void populatesWithAllAnimals() {
		Whitebox.setInternalState(defaultAnimalRepository, "defaultAnimalFactory", defaultAnimalFactory);
		defaultAnimalRepository.init();

		Set<DefaultAnimal> allAnimals = defaultAnimalRepository.all();
		assertThat(allAnimals).hasSize(7);
		assertContains(allAnimals, "Dog one", AnimalType.DOG, "Meat", "Hunting dog");
		assertContains(allAnimals, "Parrot one", AnimalType.PARROT, "Grain", "Wingspan 0.25", "Cannot speak");
		assertContains(allAnimals, "Chicken one", AnimalType.CHICKEN, "CORN", "Wingspan 0.75", "Is broiler");
		assertContains(allAnimals, "Dog two", AnimalType.DOG, "Fresh meat", "Assistance dog");
		assertContains(allAnimals, "Parrot two", AnimalType.PARROT, "CORN", "Wingspan 0.5", "Can speak");
		assertContains(allAnimals, "Chicken two", AnimalType.CHICKEN, "Corn", "Wingspan 0.75", "Is not broiler");
		assertContains(allAnimals, "Dog three", AnimalType.DOG, "Perdigree", "Racing dog");
	}

	private boolean assertContains(Set<DefaultAnimal> animals, String name, AnimalType animalType, String favoriteFood, String... metaData) {
		for (DefaultAnimal defaultAnimal : animals) {
			if (defaultAnimal.getName().equals(name) && defaultAnimal.getAnimalType().equals(animalType) && defaultAnimal.getFavoriteFood().equals(favoriteFood)
					&& defaultAnimal.getMetaData().equals(new HashSet<>(Arrays.asList(metaData)))) {
				return true;
			}
		}
		return false;
	}
}
