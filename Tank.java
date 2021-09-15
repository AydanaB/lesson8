package com.company.players;

public class Tank extends Hero{

    public Tank(int health, int damage) {
        super(health, damage, IAbility.SAVE_HEROES_DAMAGE);
    }

    @Override
    public void useAbility(Hero[] heroes, Boss boss) {
        int savedDamage = (int) (boss.getDamage() * 0.20);
        this.setHealth(this.getHealth() - (boss.getDamage() + savedDamage));
        System.out.println("Tank accepted part damage from boss to other players: " + savedDamage);
    }
}
