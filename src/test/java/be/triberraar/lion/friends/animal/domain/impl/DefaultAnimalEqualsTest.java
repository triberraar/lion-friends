package be.triberraar.lion.friends.animal.domain.impl;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import be.triberraar.lion.friends.animal.domain.api.AnimalType;

public class DefaultAnimalEqualsTest {

	@Test
	public void animalsAreEqualWhenNameAndAnimalTypeAreSame() {
		DefaultAnimal animal1 = new DefaultAnimal("name 1", AnimalType.DOG, "food 1");
		DefaultAnimal animal2 = new DefaultAnimal("name 1", AnimalType.DOG, "food 2");

		assertThat(animal1).isEqualTo(animal2);
	}

	@Test
	public void animalsAreNotEqualWhenNameIsDifferent() {
		DefaultAnimal animal1 = new DefaultAnimal("name 1", AnimalType.DOG, "food 1");
		DefaultAnimal animal2 = new DefaultAnimal("name 2", AnimalType.DOG, "food 2");

		assertThat(animal1).isNotEqualTo(animal2);
	}

	@Test
	public void animalsAreNotEqualWhenAnimalTypeIsDifferent() {
		DefaultAnimal animal1 = new DefaultAnimal("name 1", AnimalType.DOG, "food 1");
		DefaultAnimal animal2 = new DefaultAnimal("name 1", AnimalType.PARROT, "food 2");

		assertThat(animal1).isNotEqualTo(animal2);

	}
}
