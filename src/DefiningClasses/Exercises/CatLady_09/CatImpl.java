package DefiningClasses.Exercises.CatLady_09;

public abstract class CatImpl implements Cat{
    private String name;

    public CatImpl(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
