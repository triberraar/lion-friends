package be.triberraar.lion.friends.friendship.domain.exception;

import be.triberraar.lion.friends.animal.domain.api.Animal;
import be.triberraar.lion.friends.friendship.domain.api.Friendship;

public class InvalidFriendException extends RuntimeException {

	private Animal animal;
	private Friendship friendship;

	public InvalidFriendException(Animal animal, Friendship friendship) {
		this.animal = animal;
		this.friendship = friendship;
	}

	@Override
	public String getMessage() {
		return "Animal '" + animal.getName() + "' is not part of the friendship between '" + friendship.getFriend1().getName() + "' and '" + friendship.getFriend2().getName() + "'.";
	}
}
