package be.triberraar.lion.friends.animal.domain.api;

public enum AnimalType {
	DOG("Dog"), PARROT("Parrot"), CHICKEN("Chicken");

	private String description;

	AnimalType(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
