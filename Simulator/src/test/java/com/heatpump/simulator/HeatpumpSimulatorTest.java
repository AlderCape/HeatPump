package com.heatpump.simulator;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import com.heatpump.client.model.HeatpumpRegistry;

public class HeatpumpSimulatorTest {

	@Test
	public void shouldRegisterItSelfOnLoading() throws ClassNotFoundException {
		Class.forName("com.heatpump.simulator.HeatpumpSimulator");
		assertEquals(HeatpumpSimulator.class, HeatpumpRegistry.getMainClass());
	}
	
	@Test
	public void numberOfTemperaturSourcesShouldBeBasedOnFileName() throws Exception {
		try {
			FileHelper.createTemperatureFile("basedata0.sim", "10\n11\n");
			FileHelper.createTemperatureFile("basedata1.sim", "10\n11\n");
			FileHelper.createTemperatureFile("basedata2.sim", "10\n11\n");
			FileHelper.createTemperatureFile("basedata3.sim", "10\n11\n");
			FileHelper.createTemperatureFile("basedata4.sim", "10\n11\n");
			FileHelper.createTemperatureFile("basedata5.sim", "10\n11\n");
			
			HeatpumpSimulator simulator = new HeatpumpSimulator("basedata");
			assertEquals(6, simulator.getTemperaturSources().size());
		} finally {
			FileHelper.deleteFile("basedata0.sim");
			FileHelper.deleteFile("basedata1.sim");
			FileHelper.deleteFile("basedata2.sim");
			FileHelper.deleteFile("basedata3.sim");
			FileHelper.deleteFile("basedata4.sim");
			FileHelper.deleteFile("basedata5.sim");
		}
	}

}
