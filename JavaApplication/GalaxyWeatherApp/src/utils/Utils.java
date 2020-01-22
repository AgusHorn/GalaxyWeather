package utils;

import model.Planet;
import model.Position;
import model.Triangle;
import utils.MathUtils;

public class Utils {
		
	public static boolean arePlanetsInLineWithSun(Planet planetOne, Planet planetTwo, Planet planetThree, int dayNumber) {
		double gradesPlanetOne = planetOne.getPositionInGrades(dayNumber);
		double gradesPlanetTwo = planetTwo.getPositionInGrades(dayNumber);
		double gradesPlanetThree = planetThree.getPositionInGrades(dayNumber);

		if ((gradesPlanetOne == gradesPlanetTwo ) && (gradesPlanetOne == gradesPlanetThree)) {
			return true;
		}
		
		if (Utils.areTwoPlanetsInLine(gradesPlanetOne, gradesPlanetTwo) &&
			Utils.areTwoPlanetsInLine(gradesPlanetOne, gradesPlanetThree)) {
				return true;
		}
		return false;
	}
	
	public static boolean arePlanetsInLine(Planet planetOne, Planet planetTwo, Planet planetThree, int dayNumber) {
		Triangle planetTriangle = new Triangle(planetOne.getPosition(dayNumber), planetTwo.getPosition(dayNumber), planetThree.getPosition(dayNumber));
		return (planetTriangle.getArea() == 0.0);
	}
	
	public static boolean isSunInTriangle(Position posOne, Position posTwo, Position posThree) {
		Position sunPosition = new Position(0,0);
		Triangle planetTriangle = new Triangle(posOne, posTwo, posThree);
		if (planetTriangle.getArea() == 0.0) return false;
		return planetTriangle.isPointInside(sunPosition);
	}
	
	private static boolean areTwoPlanetsInLine(double gradesPlanetOne, double gradesPlanetTwo) {
		if ((gradesPlanetOne - gradesPlanetTwo == 180) || (gradesPlanetOne - gradesPlanetTwo == -180)) {
			return true;
		}
		return false;
	}
}
