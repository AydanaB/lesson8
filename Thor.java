package com.company.players;

public class Thor extends Hero{

    public Thor(int health, int damage) {
        super(health, damage, IAbility.KNOCKOUT);
    }

    @Override
    public void useAbility(Hero[] heroes, Boss boss) {
        for (Hero hero : heroes) {
            if (boss.getHealth() - this.getDamage() > 0){
                hero.setHealth(hero.getHealth());
                System.out.println("Thor knocked out boss");
                break;
            }
        }
    }
}
