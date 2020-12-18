package com.codingdojo.javaoop.phone;

public class Galaxy extends Phone implements Ringable {

	public Galaxy(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
		super(versionNumber, batteryPercentage, carrier, ringTone);
	}
	@Override
	public String ring() {
//		original returns a string
		String string = "Galaxy " + this.getVersionNumber() + " says " + this.getRingTone();
		return string;
	}
	@Override
	public String unlock() {
//		original returns a string
		String string = "Unlocking via finger print";
		return string;
	}
	@Override
	public void displayInfo() {

		System.out.println("Galaxy " + this.getVersionNumber() + " from " + this.getCarrier());
	}
}
