
package be.triberraar.lion.friends.friendship.domain.api;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import be.triberraar.lion.friends.animal.domain.api.Animal;

public interface FriendshipChange {

	@NotNull(message = "friendship.change.subject.null")
	Animal getSubject();

	Optional<Animal> getLostFriend();

	Optional<Animal> getGainedFriend();

}
