package model;

public class Planet {
	
	private String name;
	private Float distance;
	private Integer angularVelocity;
	
	public Planet(String name, float distance, int angularVelocity) {
		this.name = name;
		this.distance = distance;
		this.angularVelocity = angularVelocity;
	}
	
	public String getName() {
		return this.name;
	}
	
	public float getDistance() {
		return this.distance;
	}
	
	public int getAngularVelocity() {
		return this.angularVelocity;
	}
	
	public double getPositionInGrades(int dayNumber) {
		return (dayNumber * this.angularVelocity) % 360;
	}
	
	public Position getPosition(int dayNumber) {
		double positionInGrades = this.getPositionInGrades(dayNumber);
		double positionInRadians = Math.toRadians(positionInGrades);
		
		double tempX = this.distance * Math.sin(positionInRadians);
		double tempY = this.distance * Math.cos(positionInRadians);
		
		return new Position(tempX, tempY);
	}
}
