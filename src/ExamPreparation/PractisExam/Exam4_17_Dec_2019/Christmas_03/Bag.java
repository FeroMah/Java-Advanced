package ExamPreparation.PractisExam.Exam4_17_Dec_2019.Christmas_03;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Bag {
    private String color;
    private int capacity;
    private List<Present> data;

    public Bag(String color, int capacity) {
        this.color = color;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getColor() {
        return color;
    }

    public int getCapacity() {
        return capacity;
    }

    public int count() {
        return this.data.size();
    }

    public void add(Present present) {
        if (this.data.size() < this.getCapacity()) {
            this.data.add(present);
        }
    }

    public boolean remove(String name) {
        return this.data.removeIf(p -> p.getName().equals(name));
    }

    public Present heaviestPresent() {
        return this.data.stream()
                .sorted((p1, p2) -> Double.compare(p2.getWeight(), p1.getWeight()))
                .collect(Collectors.toList()).get(0);
    }

    public Present getPresent(String name) {
        return this.data.stream()
                .filter(p -> p.getName().equals(name))
                .collect(Collectors.toList())
                .get(0);
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s bag contains:",this.getColor()))
                .append(System.lineSeparator());
        this.data.forEach(p->sb.append(p.toString()));
        return sb.toString().trim();
    }
}
