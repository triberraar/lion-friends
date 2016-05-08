package be.triberraar.lion.friends.friendship.domain.impl;

import be.triberraar.lion.friends.animal.domain.api.Animal;
import be.triberraar.lion.friends.friendship.domain.api.Friendship;
import be.triberraar.lion.friends.friendship.domain.exception.InvalidFriendException;

public class DefaultFriendship implements Friendship {

	private Animal friend1;
	private Animal friend2;
	private Integer established;

	public DefaultFriendship(Animal friend1, Animal friend2, Integer established) {
		this.friend1 = friend1;
		this.friend2 = friend2;
		this.established = established;
	}

	@Override
	public Animal getFriend1() {
		return friend1;
	}

	@Override
	public Animal getFriend2() {
		return friend2;
	}

	@Override
	public Integer getEstablished() {
		return established;
	}

	@Override
	public Animal getFriendOf(Animal animal) {
		if (friend1.equals(animal)) {
			return friend2;
		} else if (friend2.equals(animal)) {
			return friend1;
		} else {
			throw new InvalidFriendException(animal, this);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((friend1 == null) ? 0 : friend1.hashCode());
		result = prime * result + ((friend2 == null) ? 0 : friend2.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DefaultFriendship other = (DefaultFriendship) obj;
		if (friend1 == null) {
			if (other.friend1 != null)
				return false;
		}
		if (friend2 == null) {
			if (other.friend2 != null)
				return false;
		}
		if ((friend1.equals(other.friend2) && friend2.equals(other.friend1)) || (friend1.equals(other.friend1) && friend2.equals(other.friend2))) {
			return true;
		}
		return false;
	}

}
