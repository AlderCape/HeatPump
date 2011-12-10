package com.heatpump.client.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Temperatur {

	private int degrees;

	public Temperatur(int degrees) {
		this.degrees = degrees;
	}

	public static Temperatur celcius(int degrees) {
		return new Temperatur(degrees);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + degrees;
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
		Temperatur other = (Temperatur) obj;
		if (degrees != other.degrees)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return degrees + " C";
	}

	public static List<Temperatur> createFrom(String values) {
		List<Temperatur> result = new ArrayList<Temperatur>();
		for (String value : Arrays.asList(values.split("\n"))) {
			result.add(celcius(value));
		}
		return result;
	}

	public static Temperatur celcius(String value) {
		return celcius(Integer.parseInt(value));
	}

}
