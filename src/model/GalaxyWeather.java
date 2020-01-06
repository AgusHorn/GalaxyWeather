package model;

public class GalaxyWeather {
	
	public static void main(String args[]) {
		Planet ferengi = new Planet("Ferengi", 500, 1);
		Planet betasoide = new Planet("Betasoide", 2000, 3);
		Planet vulcano = new Planet("Vulcano", 1000, -5);
		
		System.out.println(Utils.arePlanetsInLineWithSun(ferengi, betasoide,vulcano,1080));
	}
}
