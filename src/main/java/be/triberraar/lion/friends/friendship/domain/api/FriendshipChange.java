
package be.triberraar.lion.friends.friendship.domain.api;

import java.util.Set;

import javax.validation.constraints.NotNull;

import be.triberraar.lion.friends.animal.domain.api.Animal;
import be.triberraar.lion.friends.friendship.domain.impl.DefaultFriendship;

public interface FriendshipChange {

	@NotNull(message = "friendship.change.subject.null")
	Animal getSubject();

	@NotNull(message = "friendship.change.lost.friends.null")
	Set<DefaultFriendship> getLostFriends();

	@NotNull(message = "friendship.change.gained.friends.null")
	Set<DefaultFriendship> getGainedFriends();

}
