package be.triberraar.lion.friends.animal.domain.impl;

import java.util.HashSet;
import java.util.Set;

import be.triberraar.lion.friends.animal.domain.api.Animal;
import be.triberraar.lion.friends.animal.domain.api.AnimalType;

public class DefaultAnimal implements Animal {

	private String name;
	private AnimalType animalType;
	private String favoriteFood;
	private Set<String> metaData;

	public DefaultAnimal(String name, AnimalType animalType, String favoriteFood) {
		this.name = name;
		this.animalType = animalType;
		this.favoriteFood = favoriteFood;
		this.metaData = new HashSet<>();
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public AnimalType getAnimalType() {
		return animalType;
	}

	@Override
	public String getFavoriteFood() {
		return favoriteFood;
	}

	public void addMetaData(String metaData) {
		this.metaData.add(metaData);
	}

	@Override
	public Set<String> getMetaData() {
		return metaData;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((animalType == null) ? 0 : animalType.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		DefaultAnimal other = (DefaultAnimal) obj;
		if (animalType != other.animalType)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
