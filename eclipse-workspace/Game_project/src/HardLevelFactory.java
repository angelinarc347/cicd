
public class HardLevelFactory implements GameItemFactory {

	@Override
	public Weapon createWeapon() {
		// TODO Auto-generated method stub
		return new Bow();
	}

	@Override
	public PowerUp createPowerUp() {
		// TODO Auto-generated method stub
		return new SpeedBoost();
	}

}
