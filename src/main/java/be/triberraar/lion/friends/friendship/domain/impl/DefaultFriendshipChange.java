package be.triberraar.lion.friends.friendship.domain.impl;

import java.util.Set;

import be.triberraar.lion.friends.animal.domain.api.Animal;
import be.triberraar.lion.friends.friendship.domain.api.FriendshipChange;

public class DefaultFriendshipChange implements FriendshipChange {

	private Animal subject;
	private Set<DefaultFriendship> lostFriends;
	private Set<DefaultFriendship> gainedFriends;

	public DefaultFriendshipChange(Animal subject, Set<DefaultFriendship> lostFriends, Set<DefaultFriendship> gainedFriends) {
		this.subject = subject;
		this.lostFriends = lostFriends;
		this.gainedFriends = gainedFriends;
	}

	@Override
	public Animal getSubject() {
		return subject;
	}

	@Override
	public Set<DefaultFriendship> getLostFriends() {
		return lostFriends;
	}

	@Override
	public Set<DefaultFriendship> getGainedFriends() {
		return gainedFriends;
	}
}
