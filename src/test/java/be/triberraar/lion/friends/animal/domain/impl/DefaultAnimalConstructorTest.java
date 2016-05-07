package be.triberraar.lion.friends.animal.domain.impl;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import be.triberraar.lion.friends.animal.domain.api.AnimalType;

public class DefaultAnimalConstructorTest {

	private static final String FAVORITE_FOOD = "favorite food";
	private static final AnimalType ANIMAL_TYPE = AnimalType.DOG;
	private static final String NAME = "name";

	@Test
	public void shouldConstructCorrectly() {
		DefaultAnimal defaultAnimal = new DefaultAnimal(NAME, ANIMAL_TYPE, FAVORITE_FOOD);

		assertThat(defaultAnimal.getName()).isEqualTo(NAME);
		assertThat(defaultAnimal.getAnimalType()).isEqualTo(ANIMAL_TYPE);
		assertThat(defaultAnimal.getFavoriteFood()).isEqualTo(FAVORITE_FOOD);
		assertThat(defaultAnimal.getMetaData()).isEmpty();
	}
}
