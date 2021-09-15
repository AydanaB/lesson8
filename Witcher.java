package com.company.players;

public class Witcher extends Hero{

    public Witcher(int health, int damage) {
        super(health, damage, IAbility.SAVE_HERO);
    }

    @Override
    public void useAbility(Hero[] heroes, Boss boss) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() <= 0 && this.getHealth() > 0){
               heroes[i].setHealth(this.getHealth());
               this.setHealth(0);
                System.out.println("Witcher saved " + heroes[i].getClass().getSimpleName());
                break;
            }
        }
    }
}
