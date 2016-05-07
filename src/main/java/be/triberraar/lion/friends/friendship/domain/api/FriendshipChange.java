
package be.triberraar.lion.friends.friendship.domain.api;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import be.triberraar.lion.friends.animal.domain.api.Animal;
import be.triberraar.lion.friends.friendship.domain.impl.DefaultFriendship;

public interface FriendshipChange {

	@NotNull(message = "friendship.change.subject.null")
	Animal getSubject();

	Optional<DefaultFriendship> getLostFriend();

	Optional<DefaultFriendship> getGainedFriend();

}
