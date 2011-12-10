package com.heatpump.client.model;

import java.util.ArrayList;
import java.util.List;

public class Scheduler {
	
	class TaskExecutor {

		private SchedulerTask task;
		private TimePoint lastExecutionTime;
		private TimeInterval interval;

		public TaskExecutor(SchedulerTask task, TimeInterval timeInterval) {
			this.task = task;
			this.interval = timeInterval;
			lastExecutionTime = TimePoint.UNDEFINED;
		}

		public void execute() {
			if (shouldExecute()) {
				task.execute();
				lastExecutionTime = now();
			}
		}

		private boolean shouldExecute() {
			return notExecuted() || newInterval();
		}

		private boolean newInterval() {
			return nextExecutionTime().isBefore(now());
		}

		private TimePoint now() {
			return timeFactory.currentTimePoint();
		}

		private TimePoint nextExecutionTime() {
			return lastExecutionTime.plus(interval);
		}

		private boolean notExecuted() {
			return lastExecutionTime == TimePoint.UNDEFINED;
		}
		
	}

	private List<TaskExecutor> tasks = new ArrayList<TaskExecutor>();
	private TimeFactory timeFactory;

	public Scheduler(TimeFactory timeFactory) {
		this.timeFactory = timeFactory;
	}

	public void addTask(TimeInterval timeInterval, SchedulerTask schedulerTask) {
		tasks.add(new TaskExecutor(schedulerTask, timeInterval));
	}

	public void start() {
		wakeup();
	}

	public void wakeup() {
		for (TaskExecutor task : tasks) {
			task.execute();
		}
	}

}
