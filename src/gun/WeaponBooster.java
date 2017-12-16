package gun;

import characters.Player;

public class WeaponBooster extends Weapon{
	
	private Weapon wrapped;

	public WeaponBooster(final Weapon wrapped) {
		super(wrapped.shooter);
		this.wrapped = wrapped;
	}

	@Override
	public void fire() {
		this.wrapped.fire();
	}

	@Override
	public void reload() {
		this.wrapped.reload();
	}

	@Override
	public String toString() {
		return this.wrapped.toString() + " BOOSTED";
	}

	@Override
	public int getDamage() {
		return (int)(this.wrapped.getDamage() * 1.5);
	}
}
