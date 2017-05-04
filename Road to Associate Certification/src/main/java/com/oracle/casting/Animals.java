package com.oracle.casting;

/**
 * Created by vanmoj1 on 10/04/2017.
 */
class AnimalTrainer {
    public void teach(Animal anim) {
        anim.move();
        anim.eat();

        if (anim instanceof Dog) {
            Dog dog = (Dog) anim;
            dog.bark();
        } else if (anim instanceof Cat) {
            Cat cat = (Cat) anim;
            cat.meow();
        }
    }
}

public class Animals {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Animal anim = dog;
        anim.eat();

        Animal anim_ = new Cat();
        Cat cat = (Cat) anim_;
        anim_.eat();

        AnimalTrainer animalTrainer = new AnimalTrainer();
        animalTrainer.teach(anim_);

        Mammal ma;
        ma = dog;

        Animal animal = new Cat();

        animal = (Animal) ma;

        animal.eat();
    }
}
