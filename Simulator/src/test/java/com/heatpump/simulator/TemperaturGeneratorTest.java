package com.heatpump.simulator;
import static org.junit.Assert.*;


import org.junit.Test;

import com.heatpump.client.model.Temperatur;
import com.heatpump.simulator.TemperaturGenerator;


public class TemperaturGeneratorTest {

	private String values = "10\n11\n";;

	@Test
	public void shouldReturnTheValuesInOrder() {
		TemperaturGenerator temperaturGenerator = new TemperaturGenerator(values);
		assertEquals(Temperatur.celcius(10), temperaturGenerator.next());
		assertEquals(Temperatur.celcius(11), temperaturGenerator.next());
	}

	@Test
	public void shouldStartOverWhenFinished() {
		TemperaturGenerator temperaturGenerator = new TemperaturGenerator(values);
		assertEquals(Temperatur.celcius(10), temperaturGenerator.next());
		assertEquals(Temperatur.celcius(11), temperaturGenerator.next());
		assertEquals(Temperatur.celcius(10), temperaturGenerator.next());
		assertEquals(Temperatur.celcius(11), temperaturGenerator.next());
	}
	
	@Test
	public void shouldBeAbleToReadValuesFromFile() throws Exception {
		try {
			FileHelper.createTemperatureFile("testValues.dat", values);
			
			TemperaturGenerator temperaturGenerator = TemperaturGenerator.basedOn("testValues.dat");
			assertEquals(Temperatur.celcius(10), temperaturGenerator.next());
			assertEquals(Temperatur.celcius(11), temperaturGenerator.next());
			assertEquals(Temperatur.celcius(10), temperaturGenerator.next());
			assertEquals(Temperatur.celcius(11), temperaturGenerator.next());
		} finally {
			FileHelper.deleteFile("testValues.dat");
		}
		
	}

}
