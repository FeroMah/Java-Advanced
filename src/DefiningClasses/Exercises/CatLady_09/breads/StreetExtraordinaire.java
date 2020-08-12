package DefiningClasses.Exercises.CatLady_09.breads;

import DefiningClasses.Exercises.CatLady_09.Cat;
import DefiningClasses.Exercises.CatLady_09.CatImpl;

public class StreetExtraordinaire extends CatImpl {
    private double decibelsOfMeows;

    public StreetExtraordinaire(String name, int decibelsOfMeows) {
        super(name);
        this.decibelsOfMeows = decibelsOfMeows;
    }

    public double getDecibelsOfMeows() {
        return decibelsOfMeows;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f",
                this.getClass().getSimpleName(), this.getName(), this.getDecibelsOfMeows());
    }
}
