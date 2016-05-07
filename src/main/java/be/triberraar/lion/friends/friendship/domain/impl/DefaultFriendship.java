package be.triberraar.lion.friends.friendship.domain.impl;

import be.triberraar.lion.friends.animal.domain.api.Animal;
import be.triberraar.lion.friends.friendship.domain.api.Friendship;

public class DefaultFriendship implements Friendship {

	private Animal friend1;
	private Animal friend2;

	public DefaultFriendship(Animal friend1, Animal friend2) {
		this.friend1 = friend1;
		this.friend2 = friend2;
	}

	@Override
	public Animal getFriend1() {
		return friend1;
	}

	@Override
	public Animal getFriend2() {
		return friend2;
	}

}
