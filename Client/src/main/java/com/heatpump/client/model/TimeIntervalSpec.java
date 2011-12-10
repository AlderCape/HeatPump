package com.heatpump.client.model;

public class TimeIntervalSpec {

	private int interval;

	public TimeIntervalSpec(int i) {
		this.interval = i;
	}

	public TimeInterval minutes() {
		return new TimeInterval(interval*60*1000);
	}

}
