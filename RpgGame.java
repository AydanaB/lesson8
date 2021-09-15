package com.company.game;

import com.company.players.*;

public class RpgGame {

    private static int roundCounter = 0;

    private static void printStatistics(Hero heroes[], Boss boss) {
        System.out.println("---------------------------");
        System.out.println("Round: " + roundCounter);
        roundCounter++;
        if (boss.getHealth() > 0) {
            System.out.println("Boss health: " + boss.getHealth());
        } else {
            boss.setHealth(0);
        }
        for (Hero hero : heroes) {
            System.out.println(hero.getClass().getSimpleName() + " current health: " + hero.getHealth());
        }
        System.out.println("---------------------------");
    }

    private static void bossHits(Hero heroes[], Boss boss){
        for (Hero hero : heroes) {
            if (hero.getHealth() > 0 && boss.getHealth() > 0){
                hero.setHealth(hero.getHealth() - boss.getDamage());
            }
        }
    }

    private static void heroesHits(Hero heroes[], Boss boss) {
        for (Hero hero : heroes) {
            if (boss.getDamage() > 0 && hero.getHealth() > 0){
                boss.setHealth(boss.getHealth() - hero.getDamage());
            }
        }
    }

    private static boolean isFinish(Hero heroes[], Boss boss){
        if (boss.getHealth() <= 0){
            System.out.println("Heroes won!!!");
            return true;
        }

        boolean allHeroesDead = true;
        for (Hero hero : heroes){
            if (hero.getHealth() > 0){
                allHeroesDead = false;
                break;
            }
        }

        if (allHeroesDead){
            System.out.println("Boss won!!!");
        }

        return allHeroesDead;
    }

    private static void round(Hero heroes[], Boss boss){
        if (boss.getHealth() > 0){
            heroesHits(heroes, boss);
            applyAbility(heroes, boss);
            bossHits(heroes, boss);
            printStatistics(heroes, boss);
        }
    }

    private static void applyAbility(Hero heroes[], Boss boss){
        for (Hero hero : heroes){
            if (hero.getHealth() > 0){
                hero.useAbility(heroes, boss);
            }
        }
    }

    public static void startGame(){
        Boss boss = new Boss(700,50);
        Golem golem = new Golem(250,15);
        Magical magical = new Magical(250,15);
        Tank tank = new Tank(250,15);
        Thor thor = new Thor(250,15);
        Warrior warrior = new Warrior(250,15);
        Witcher witcher = new Witcher(250,15);
        Hero heroes[] = {golem, magical, thor, tank, warrior, witcher};
        printStatistics(heroes, boss);

        while (!isFinish(heroes, boss)){
            round(heroes, boss);
        }
    }




}
