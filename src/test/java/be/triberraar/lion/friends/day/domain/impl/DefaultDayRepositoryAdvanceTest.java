package be.triberraar.lion.friends.day.domain.impl;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class DefaultDayRepositoryAdvanceTest {

	private DefaultDayRepository defaultDayRepository = new DefaultDayRepository();

	@Test
	public void advancesCurrentDayWith1() {
		assertThat(defaultDayRepository.getCurrentDay()).isEqualTo(0);

		defaultDayRepository.advance();

		assertThat(defaultDayRepository.getCurrentDay()).isEqualTo(1);
	}
}
