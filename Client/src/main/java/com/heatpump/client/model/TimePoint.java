package com.heatpump.client.model;

public class TimePoint {

	public static final TimePoint UNDEFINED = new TimePoint(-1);
	
	private long time;

	public TimePoint(long timeInMillis) {
		this.time = timeInMillis;
	}

	public boolean isBefore(TimePoint currentTimeInMillis) {
		return time < currentTimeInMillis.time;
	}

	public TimePoint plus(TimeInterval interval) {
		return new TimePoint(time + interval.getMilliseconds());
	}

}
