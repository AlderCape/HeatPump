package com.heatpump.client.model;

import java.lang.reflect.InvocationTargetException;

public class HeatpumpRegistry {

	private static HeatpumpRegistry instance = new HeatpumpRegistry();
	private Class<? extends HeatpumpInteractor> mainClass;

	public static Class<? extends HeatpumpInteractor> getMainClass() {
		return getInstance().mainClass;
	}

	public static void registerMainClass(Class<? extends HeatpumpInteractor> mainClass) {
		getInstance().mainClass = mainClass;
	}

	private static HeatpumpRegistry getInstance() {
		return instance ;
	}

	public static HeatpumpInteractor getInteractor() throws IllegalArgumentException, SecurityException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		return getInstance().getHeatpumpInteractor();
	}

	private HeatpumpInteractor getHeatpumpInteractor() throws IllegalArgumentException, SecurityException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		return mainClass.getConstructor(new Class[]{}).newInstance(new Object[]{});
	}

}
