package be.triberraar.lion.friends;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;

public class AbstractValidationTest<T> {

	protected static Validator validator;

	@BeforeClass
	public static void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	protected boolean assertViolationsContains(Set<ConstraintViolation<T>> violations, String message) {
		for (ConstraintViolation<T> constraintViolation : violations) {
			if (constraintViolation.getMessage().equals(message)) {
				return true;
			}
		}
		return false;
	}
}
