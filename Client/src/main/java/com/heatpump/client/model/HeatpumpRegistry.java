package com.heatpump.client.model;

import java.lang.reflect.InvocationTargetException;

public class HeatpumpRegistry {

	private static HeatpumpRegistry instance = new HeatpumpRegistry();
	private static Class mainClass;

	public static Class getMainClass() {
		return mainClass;
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

	@SuppressWarnings("unchecked")
	private HeatpumpInteractor getHeatpumpInteractor() throws IllegalArgumentException, SecurityException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		return (HeatpumpInteractor) mainClass.getConstructor(new Class[]{}).newInstance(new Object[]{});
	}

}
