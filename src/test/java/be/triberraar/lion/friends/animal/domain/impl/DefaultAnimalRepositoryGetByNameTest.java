package be.triberraar.lion.friends.animal.domain.impl;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.util.reflection.Whitebox;
import org.mockito.runners.MockitoJUnitRunner;

import be.triberraar.lion.friends.animal.exception.AnimalNotFoundException;

@RunWith(MockitoJUnitRunner.class)
public class DefaultAnimalRepositoryGetByNameTest {

	private static final String NON_EXISTING_NAME = "unicorn";
	private static final String EXISTING_NAME = "Dog one";

	private DefaultAnimalRepository defaultAnimalRepository = new DefaultAnimalRepository();

	private DefaultAnimalFactory defaultAnimalFactory = new DefaultAnimalFactory();

	@Before
	public void setUp() {
		Whitebox.setInternalState(defaultAnimalRepository, "defaultAnimalFactory", defaultAnimalFactory);
		defaultAnimalRepository.init();
	}

	@Test
	public void returnsAnimalWithNameWhenFound() {
		DefaultAnimal result = defaultAnimalRepository.getByName(EXISTING_NAME);

		assertThat(result).isNotNull();
		assertThat(result.getName()).isEqualTo(EXISTING_NAME);
	}

	@Test(expected = AnimalNotFoundException.class)
	public void failsWhenNoAnimalWithName() {
		defaultAnimalRepository.getByName(NON_EXISTING_NAME);
	}
}
