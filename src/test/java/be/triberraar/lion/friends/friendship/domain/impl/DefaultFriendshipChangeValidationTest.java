package be.triberraar.lion.friends.friendship.domain.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintViolation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import be.triberraar.lion.friends.AbstractValidationTest;
import be.triberraar.lion.friends.animal.domain.api.Animal;

@RunWith(MockitoJUnitRunner.class)
public class DefaultFriendshipChangeValidationTest extends AbstractValidationTest<DefaultFriendshipChange> {

	@Mock
	private Animal animal;

	@Test
	public void failsWhenSubjectIsNull() {
		DefaultFriendshipChange result = new DefaultFriendshipChange(null, new HashSet<>(), new HashSet<>());

		Set<ConstraintViolation<DefaultFriendshipChange>> constraints = validator.validate(result);
		assertThat(constraints).hasSize(1);
		assertThat(assertViolationsContains(constraints, "friendship.change.error.subject.null"));
	}

	@Test
	public void failsWhenLostFriendsIsNull() {
		DefaultFriendshipChange result = new DefaultFriendshipChange(animal, null, new HashSet<>());

		Set<ConstraintViolation<DefaultFriendshipChange>> constraints = validator.validate(result);
		assertThat(constraints).hasSize(1);
		assertThat(assertViolationsContains(constraints, "friendship.change.error.lost.friends.null"));
	}

	@Test
	public void failsWhenGainedFriendsIsNull() {
		DefaultFriendshipChange result = new DefaultFriendshipChange(animal, new HashSet<>(), null);

		Set<ConstraintViolation<DefaultFriendshipChange>> constraints = validator.validate(result);
		assertThat(constraints).hasSize(1);
		assertThat(assertViolationsContains(constraints, "friendship.change.error.gained.friends.null"));
	}
}
