package be.triberraar.lion.friends.friendship.rest;

import java.util.Set;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import be.triberraar.lion.friends.animal.domain.api.Animal;
import be.triberraar.lion.friends.animal.domain.api.AnimalRepository;
import be.triberraar.lion.friends.animal.rest.AnimalToJsonAdapter;
import be.triberraar.lion.friends.friendship.domain.api.Friendship;
import be.triberraar.lion.friends.friendship.domain.api.FriendshipRepository;

@RestController
@RequestMapping("/friend")
public class FriendResource {

	@Inject
	private FriendshipRepository friendshipRepository;
	@Inject
	private AnimalRepository animalRepository;

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public Set<AnimalToJsonAdapter> getFriends(@RequestParam(required = true, value = "name") String name) {
		Animal animal = animalRepository.getByName(name);
		Set<? extends Friendship> friendships = friendshipRepository.getFriendsOf(animal);
		return friendships.parallelStream().map(friendship -> new AnimalToJsonAdapter(friendship.getFriendOf(animal))).collect(Collectors.toSet());
	}
}
