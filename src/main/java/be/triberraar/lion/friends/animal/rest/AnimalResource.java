package be.triberraar.lion.friends.animal.rest;

import java.util.Set;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import be.triberraar.lion.friends.animal.domain.api.AnimalRepository;

@RestController
@RequestMapping("/animal")
public class AnimalResource {

	@Inject
	private AnimalRepository animalRepository;

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public Set<AnimalToJsonAdapter> all() {
		return animalRepository.all().parallelStream().map(animal -> new AnimalToJsonAdapter(animal)).collect(Collectors.toSet());
	}

}