package com.company.players;

import java.util.Random;

public class Warrior extends Hero{

    public Warrior(int health, int damage) {
        super(health, damage, IAbility.CRITICAL_DAMAGE);
    }

    @Override
    public void useAbility(Hero[] heroes, Boss boss) {
        int randomBoostDamage = new Random().nextInt(4) + 2;
        boss.setHealth(boss.getHealth() - this.getDamage() * randomBoostDamage);
        System.out.println("Warrior multiplied his damage by: " + randomBoostDamage);
    }
}
