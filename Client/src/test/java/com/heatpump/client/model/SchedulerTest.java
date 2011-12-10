package com.heatpump.client.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class SchedulerTest {
	
	private static final TimeInterval INTERVAL = new TimeIntervalSpec(15).minutes();
	private static final long MINUTES_15 = 15*60*1000;
	private boolean executeCalled = false;


	@Test
	public void testThatItForwardsToCorrectCommandOnStart() {
		Scheduler scheduler = new Scheduler(new FakeTimeFactory());
		scheduler.addTask(INTERVAL, new SchedulerTask(){
			@Override
			public void execute() {
				executeCalled = true;
			}});
		scheduler.start();
		assertTrue(executeCalled);
	}

	@Test
	public void testThatItCallsCommandRegulary() {
		FakeTimeFactory timeFactory = new FakeTimeFactory();
		timeFactory.setCurrentTimeInMillis(0);
		Scheduler scheduler = new Scheduler(timeFactory);
		scheduler.addTask(INTERVAL, new SchedulerTask(){
			@Override
			public void execute() {
				executeCalled = true;
			}});
		scheduler.start();
		assertTrue(executeCalled);
		executeCalled = false;
		timeFactory.setCurrentTimeInMillis(MINUTES_15+1);
		scheduler.wakeup();
		assertTrue(executeCalled);
	}
	
	@Test
	public void testThatItCallsCommandRegularyOnlyIfTimeIsPassed() {
		FakeTimeFactory timeFactory = new FakeTimeFactory();
		timeFactory.setCurrentTimeInMillis(0);
		Scheduler scheduler = new Scheduler(timeFactory);
		scheduler.addTask(INTERVAL, new SchedulerTask(){
			@Override
			public void execute() {
				executeCalled = true;
			}});
		scheduler.start();
		assertTrue(executeCalled);
		executeCalled = false;
		timeFactory.setCurrentTimeInMillis(MINUTES_15-1);
		scheduler.wakeup();
		assertFalse(executeCalled);
	}
	
	private class FakeTimeFactory implements TimeFactory {
		
		private long currentTimeInMillis;

		@Override
		public long currentTimeInMillis() {
			return currentTimeInMillis;
		}

		public void setCurrentTimeInMillis(long currentTimeInMillis) {
			this.currentTimeInMillis = currentTimeInMillis;
		}

		@Override
		public TimePoint currentTimePoint() {
			return new TimePoint(currentTimeInMillis);
		}
		
	}

}
