package DefiningClasses.Exercises.CatLady_09.breads;

import DefiningClasses.Exercises.CatLady_09.Cat;
import DefiningClasses.Exercises.CatLady_09.CatImpl;

public class Cymric  extends CatImpl {
    private double furLength;

    public Cymric(String name, double furLength) {
        super(name);
        this.furLength = furLength;
    }

    public double getFurLength() {
        return furLength;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f",
                this.getClass().getSimpleName(), this.getName(), this.getFurLength());
    }
}
