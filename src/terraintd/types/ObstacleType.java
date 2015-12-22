package terraintd.types;

import java.util.HashMap;

public class ObstacleType extends CollidableType {

	public final int removeCost;
	public final HashMap<Terrain, Double> spawnRates;

	ObstacleType(String id, int width, int height, int cost, int removeCost, HashMap<Terrain, Double> spawnRates, ImageType image, ImageType icon) {
		super(id, width, height, removeCost, image, icon);
		
		this.removeCost = removeCost;
		this.spawnRates = spawnRates;
	}
	
	public static ObstacleType[] values() {
		return TypeGenerator.obstacles();
	}
}
