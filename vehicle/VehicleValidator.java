package com.vehicle;

import java.util.Arrays;

public class VehicleValidator {
	public static void validateVehicle(Vehicle vehicle) throws ColorNotSupportedException {
		Color[] supportedColors = {Color.WHITE, Color.BLACK,Color.BLUE,Color.RED,Color.SILVER};
		if(!Arrays.asList(supportedColors).contains(vehicle.getColor())) {
			throw new ColorNotSupportedException("Color is not supported");
		}
	}
	public static void validatePollutionLevel(double pollutionLevel) throws PollutionLevelExceededException {
		if(pollutionLevel>=20) {
			throw new PollutionLevelExceededException("Pollution level should be less than 20%");
		}
	}
}
