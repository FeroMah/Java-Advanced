package ExamPreparation.PractisExam.Exam2.Task03_HeroRepository.heroRepository;

public class Item {

    private int strength;
    private int agility;
    private int intelligence;

   public int getStrength() {
        return this.strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public Item(int strength, int agility, int intelligence) {
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    @Override
    public String toString() {
        return "Item:" +
                "\n  *  Strength: " + strength +
                "\n  *  Agility: " + agility +
                "\n  *  Intelligence: " + intelligence;
    }
}

