
package be.triberraar.lion.friends.animal.domain.api;

import java.util.Set;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

public interface Animal {

	@NotBlank(message = "animal.error.name.blank")
	String getName();

	@NotNull(message = "animal.error.animal.type.null")
	AnimalType getAnimalType();

	@NotBlank(message = "animal.error.favorite.food.blank")
	String getFavoriteFood();

	Set<String> getMetaData();

}
