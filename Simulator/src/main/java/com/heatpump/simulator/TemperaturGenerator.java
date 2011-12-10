package com.heatpump.simulator;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import com.heatpump.client.model.Temperatur;
import com.heatpump.client.model.TemperaturSource;


public class TemperaturGenerator implements TemperaturSource {

	private List<Temperatur> values;
	private Iterator<Temperatur> iter;
	

	public TemperaturGenerator(String values) {
		this.values = Temperatur.createFrom(values);
		iter = this.values.iterator();
	}

	public Temperatur next() {
		if(!iter.hasNext()) {
			iter = values.iterator();
		}
		return iter.next();
	}

	public static TemperaturGenerator basedOn(String fileName) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		StringBuilder values = new StringBuilder();
		String line;
		while((line = reader.readLine()) != null){
			values.append(line).append("\n");
		}
		return new TemperaturGenerator(values.toString());
	}

}
