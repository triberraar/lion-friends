package be.triberraar.lion.friends.animal.domain.api;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import be.triberraar.lion.friends.animal.domain.api.AnimalType;

public class AnimalTypeTest {

	@Test
	public void thereAre3TypesOfAnimals() {
		assertThat(AnimalType.values()).hasSize(3);
	}

	@Test
	public void dogIsAnAnimalType() {
		assertThat(AnimalType.DOG.getDescription()).isEqualTo("Dog");
	}

	@Test
	public void parrotIsAnAnimalType() {
		assertThat(AnimalType.PARROT.getDescription()).isEqualTo("Parrot");
	}

	@Test
	public void ChickenIsAnAnimalType() {
		assertThat(AnimalType.CHICKEN.getDescription()).isEqualTo("Chicken");
	}

}
