package terraintd.object;

import terraintd.types.CollidableType;
import terraintd.types.ProjectileType;
import terraintd.types.TowerType;

public class Tower extends CollidableEntity implements Weapon {

	public final TowerType type;
	private double x, y;

	private final Gun gun;

	@Override
	public double getX() {
		return this.x;
	}

	@Override
	public double getY() {
		return this.y;
	}

	@Override
	public double getWidth() {
		return this.type.width;
	}

	@Override
	public double getHeight() {
		return this.type.height;
	}

	/**
	 * <ul>
	 * <li><b><i>getRotation</i></b><br>
	 * <br>
	 * {@code double getRotation()}<br>
	 * <br>
	 * @return this tower's rotation in radians.
	 *         </ul>
	 */
	public double getRotation() {
		return this.gun.getRotation();
	}

	public Tower(TowerType type, double x, double y) {
		this.type = type;
		this.x = x;
		this.y = y;
		this.gun = new Gun(type.projectiles, type.range, x + 0.5 * type.width, y + 0.5 * type.height);
	}

	@Override
	public CollidableType getType() {
		return this.type;
	}
	
	@Override
	public Gun getGun() {
		return gun;
	}

	@Override
	public Projectile[] createProjectiles(ProjectileType[] types) {
		Projectile[] ps = new Projectile[types.length];

		for (int n = 0; n < types.length; n++)
			ps[n] = new Projectile(types[n], this);

		return ps;
	}

}
