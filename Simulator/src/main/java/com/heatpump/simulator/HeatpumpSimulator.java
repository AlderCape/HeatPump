package com.heatpump.simulator;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import com.heatpump.client.model.HeatpumpInteractor;
import com.heatpump.client.model.HeatpumpRegistry;
import com.heatpump.client.model.TemperaturSource;

public class HeatpumpSimulator implements HeatpumpInteractor {

	static {
		HeatpumpRegistry.registerMainClass(HeatpumpSimulator.class);
	}

	private Set<TemperaturSource> sources;
	
	public HeatpumpSimulator(String baseFileName) throws IOException {
		sources = new HashSet<TemperaturSource>();
		for (int i=0; i<6; i++) {
			sources.add(TemperaturGenerator.basedOn(baseFileName + i + ".sim"));
		}
	}

	public int getNumberOfTemperaturs() {
		return 6;
	}

	public Set<TemperaturSource> getTemperaturSources() {
		return sources;
	}
}
