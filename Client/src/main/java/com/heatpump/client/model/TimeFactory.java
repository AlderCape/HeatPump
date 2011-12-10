package com.heatpump.client.model;

public interface TimeFactory {

	public long currentTimeInMillis();

	public TimePoint currentTimePoint();
}
