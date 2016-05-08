package be.triberraar.lion.friends.animal.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import be.triberraar.lion.friends.animal.domain.api.Animal;
import be.triberraar.lion.friends.animal.domain.api.AnimalRepository;
import be.triberraar.lion.friends.animal.domain.api.AnimalType;

@RunWith(MockitoJUnitRunner.class)
public class AnimalResourceAllTest {

	private static final String METATDATA2 = "metatdata2";
	private static final String FOOD2 = "food2";
	private static final AnimalType TYPE2 = AnimalType.DOG;
	private static final String NAME2 = "name2";
	private static final String METATDATA1 = "metatdata 1";
	private static final String FOOD1 = "food1";
	private static final AnimalType TYPE1 = AnimalType.CHICKEN;
	private static final String NAME1 = "name1";

	@InjectMocks
	private AnimalResource animalResource;

	@Mock
	private AnimalRepository animalRepository;
	@Mock
	private Animal animal1, animal2;

	@Before
	public void setUp() {
		when(animal1.getName()).thenReturn(NAME1);
		when(animal1.getAnimalType()).thenReturn(TYPE1);
		when(animal1.getFavoriteFood()).thenReturn(FOOD1);
		when(animal2.getMetaData()).thenReturn(new HashSet<>(Arrays.asList(METATDATA1)));
		when(animal2.getName()).thenReturn(NAME2);
		when(animal2.getAnimalType()).thenReturn(TYPE2);
		when(animal2.getFavoriteFood()).thenReturn(FOOD2);
		when(animal2.getMetaData()).thenReturn(new HashSet<>(Arrays.asList(METATDATA2)));
	}

	@Test
	public void returnsAllAnimals() {
		doReturn(new HashSet<>(Arrays.asList(animal1, animal2))).when(animalRepository).all();

		Set<AnimalToJsonAdapter> result = animalResource.all();

		assertThat(result).hasSize(2);
		assertThat(assertContains(result, animal1)).isTrue();
		assertThat(assertContains(result, animal2)).isTrue();
	}

	private boolean assertContains(Set<AnimalToJsonAdapter> adapters, Animal animal) {
		for (AnimalToJsonAdapter adapter : adapters) {
			if (adapter.getName().equals(animal.getName()) && adapter.getFavoriteFood().equals(animal.getFavoriteFood()) && adapter.getType().equals(animal.getAnimalType().getDescription())
					&& adapter.getMetaData().equals(animal.getMetaData())) {
				return true;
			}
		}
		return false;
	}
}