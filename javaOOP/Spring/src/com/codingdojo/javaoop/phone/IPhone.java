package com.codingdojo.javaoop.phone;

public class IPhone extends Phone implements Ringable {

	public IPhone(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
		super(versionNumber, batteryPercentage, carrier, ringTone);
	}
	@Override
	public String ring() {
//		original returns a string
		String string = "iPhone " + this.getVersionNumber() + " says " + this.getRingTone();
		return string;
	}
	@Override
	public String unlock() {
//		original returns a string
		String string = "Unlocking via facial recognition";
		return string;
	}
	@Override
	public void displayInfo() {
//		
		System.out.println("iPhone " + this.getVersionNumber() + " from " + this.getCarrier());
	}
}
