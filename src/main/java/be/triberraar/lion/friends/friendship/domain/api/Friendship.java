package be.triberraar.lion.friends.friendship.domain.api;

import javax.validation.constraints.NotNull;

import be.triberraar.lion.friends.animal.domain.api.Animal;

public interface Friendship {

	@NotNull(message = "friendship.error.friend1.null")
	Animal getFriend1();

	@NotNull(message = "friendship.error.friend2.null")
	Animal getFriend2();

	Animal getFriendOf(Animal animal);

}
