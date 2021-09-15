package com.company.players;

public class Golem extends Hero{

    public Golem(int health, int damage) {
        super(health, damage, IAbility.SAVE_DAMAGE_AND_REVERT);
    }

    @Override
    public void useAbility(Hero[] heroes, Boss boss) {
        int bossDamage = boss.getDamage() + this.getDamage();
        boss.setHealth(boss.getHealth() - bossDamage);
        System.out.println("Golem saved damage and reverted: " + bossDamage);
    }
}
