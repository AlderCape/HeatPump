package com.heatpump.client.model;

public class TimeInterval {

	private int intervalInMillis;

	public TimeInterval(int milliSeconds) {
		this.intervalInMillis = milliSeconds;
	}

	public long getMilliseconds() {
		return intervalInMillis;
	}

	public TimePoint nextExecutionTime(long lastExecutionTime) {
		return new TimePoint(lastExecutionTime + getMilliseconds());
	}

}
