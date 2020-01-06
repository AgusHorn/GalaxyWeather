package model;

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
	
	private static boolean areTwoPlanetsInLine(double gradesPlanetOne, double gradesPlanetTwo) {
		if ((gradesPlanetOne - gradesPlanetTwo == 180) || (gradesPlanetOne - gradesPlanetTwo == -180)) {
			return true;
		}
		return false;
	}

}
