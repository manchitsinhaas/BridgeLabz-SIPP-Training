public class EarthVolume {
    public static void main(String[] args) {
        double radiusKm = 6378;
        double volumeKm = (4.0 / 3.0) * Math.PI * Math.pow(radiusKm, 3);
        double kmToMiles = 0.621371;
        double radiusMiles = radiusKm * kmToMiles;
        double volumeMiles = (4.0 / 3.0) * Math.PI * Math.pow(radiusMiles, 3);
        System.out.println("The volume of earth in cubic kilometers is " + volumeKm + " and cubic miles is " + volumeMiles);
    }
}
