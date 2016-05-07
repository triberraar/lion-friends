package be.triberraar.lion.friends.friendship.domain.impl;

import java.util.Set;

import javax.validation.ConstraintViolation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import be.triberraar.lion.friends.AbstractValidationTest;
import be.triberraar.lion.friends.animal.domain.api.Animal;

@RunWith(MockitoJUnitRunner.class)
public class DefaultFriendshipValidationTest extends AbstractValidationTest<DefaultFriendship> {

	@Mock
	private Animal animal;

	@Test
	public void failsWhenFriend1IsNull() {
		DefaultFriendship friendship = new DefaultFriendship(null, animal);

		Set<ConstraintViolation<DefaultFriendship>> violations = validator.validate(friendship);
		assertViolationsContains(violations, "friendship.error.friend1.null");
	}

	@Test
	public void failsWhenFriend2IsNull() {
		DefaultFriendship friendship = new DefaultFriendship(animal, null);

		Set<ConstraintViolation<DefaultFriendship>> violations = validator.validate(friendship);
		assertViolationsContains(violations, "friendship.error.friend2.null");
	}

}
