package be.triberraar.lion.friends.animal.domain.impl;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import be.triberraar.lion.friends.animal.domain.api.AnimalType;

public class DefaultAnimalFactoryCreateTest {

	private static final String DATA_2 = "data 2";
	private static final String DATA_1 = "data 1";
	private static final String FAVORITE_FOOD = "favorite food";
	private static final AnimalType ANIMAL_TYPE = AnimalType.DOG;
	private static final String NAME = "name";

	private DefaultAnimalFactory defaultAnimalFactory = new DefaultAnimalFactory();

	@Test
	public void createsAnimals() {
		DefaultAnimal result = defaultAnimalFactory.create(NAME, ANIMAL_TYPE, FAVORITE_FOOD, DATA_1, DATA_2);

		assertThat(result.getName()).isEqualTo(NAME);
		assertThat(result.getAnimalType()).isEqualTo(ANIMAL_TYPE);
		assertThat(result.getFavoriteFood()).isEqualTo(FAVORITE_FOOD);
		assertThat(result.getMetaData()).hasSize(2).contains(DATA_1, DATA_2);
	}

}
