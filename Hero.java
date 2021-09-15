package com.company.players;

public abstract class Hero extends GameEntity implements HavingAbility{
    private IAbility ability;

    public Hero(int health, int damage, IAbility ability) {
        super(health, damage);
        this.ability = ability;
    }
}
