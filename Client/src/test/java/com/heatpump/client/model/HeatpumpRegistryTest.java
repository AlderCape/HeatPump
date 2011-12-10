package com.heatpump.client.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class HeatpumpRegistryTest {

	@Test
	public void shouldReturnAnInstanceOfMainClass() throws Exception {
		HeatpumpRegistry.registerMainClass(HeatpumpInteractorFake.class);
		HeatpumpInteractor interractor = HeatpumpRegistry.getInteractor();
		assertEquals(HeatpumpInteractorFake.class, interractor.getClass());
	}
	
	@Test
	public void shouldReturnSameInstanceOfMainClass() throws Exception {
		HeatpumpRegistry.registerMainClass(HeatpumpInteractorFake.class);
		HeatpumpInteractor firstInterractor = HeatpumpRegistry.getInteractor();
		HeatpumpInteractor secondInterractor = HeatpumpRegistry.getInteractor();
		assertSame(secondInterractor, firstInterractor);
	}
	
	public static class HeatpumpInteractorFake implements HeatpumpInteractor {
		
	}

}
