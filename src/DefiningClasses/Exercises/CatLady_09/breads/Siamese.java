package DefiningClasses.Exercises.CatLady_09.breads;

import DefiningClasses.Exercises.CatLady_09.Cat;
import DefiningClasses.Exercises.CatLady_09.CatImpl;

public class Siamese extends CatImpl {
    private double earSize;

    public Siamese(String name, double earSize) {
        super(name);
        this.earSize = earSize;
    }

    public double getEarSize() {
        return earSize;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f",
                this.getClass().getSimpleName(), this.getName(), this.getEarSize());
    }
}
