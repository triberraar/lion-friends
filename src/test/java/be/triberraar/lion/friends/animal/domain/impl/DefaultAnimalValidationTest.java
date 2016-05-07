package be.triberraar.lion.friends.animal.domain.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Test;

import be.triberraar.lion.friends.animal.domain.api.AnimalType;

public class DefaultAnimalValidationTest {

	private static Validator validator;

	@BeforeClass
	public static void setUp() {

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void failsWhenNameNull() {
		DefaultAnimal defaultAnimal = new DefaultAnimal(null, AnimalType.CHICKEN, "favorite food");

		Set<ConstraintViolation<DefaultAnimal>> violations = validator.validate(defaultAnimal);
		assertThat(violations).hasSize(1);
		assertThat(assertViolationsContains(violations, "animal.error.name.blank")).isTrue();

	}

	@Test
	public void failsWhenNameBlank() {
		DefaultAnimal defaultAnimal = new DefaultAnimal(" ", AnimalType.CHICKEN, "favorite food");

		Set<ConstraintViolation<DefaultAnimal>> violations = validator.validate(defaultAnimal);
		assertThat(violations).hasSize(1);
		assertThat(assertViolationsContains(violations, "animal.error.name.blank")).isTrue();
	}

	@Test
	public void failsWhenAnimalTypeNull() {
		DefaultAnimal defaultAnimal = new DefaultAnimal("name", null, "favorite food");

		Set<ConstraintViolation<DefaultAnimal>> violations = validator.validate(defaultAnimal);
		assertThat(violations).hasSize(1);
		assertThat(assertViolationsContains(violations, "animal.error.animal.type.null")).isTrue();
	}

	@Test
	public void failsWhenFavoriteFoodNull() {
		DefaultAnimal defaultAnimal = new DefaultAnimal("name", AnimalType.CHICKEN, null);

		Set<ConstraintViolation<DefaultAnimal>> violations = validator.validate(defaultAnimal);
		assertThat(violations).hasSize(1);
		assertThat(assertViolationsContains(violations, "animal.error.favorite.food.blank")).isTrue();
	}

	@Test
	public void failsWhenFavoriteFoodBlank() {
		DefaultAnimal defaultAnimal = new DefaultAnimal("name", AnimalType.CHICKEN, " ");

		Set<ConstraintViolation<DefaultAnimal>> violations = validator.validate(defaultAnimal);
		assertThat(violations).hasSize(1);
		assertThat(assertViolationsContains(violations, "animal.error.favorite.food.blank")).isTrue();
	}

	private boolean assertViolationsContains(Set<ConstraintViolation<DefaultAnimal>> violations, String message) {
		for (ConstraintViolation<DefaultAnimal> constraintViolation : violations) {
			if (constraintViolation.getMessage().equals(message)) {
				return true;
			}
		}
		return false;
	}
}
