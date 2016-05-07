package be.triberraar.lion.friends.animal.domain.api;

import java.util.Set;

public interface AnimalRepository {

	Set<? extends Animal> all();
}
