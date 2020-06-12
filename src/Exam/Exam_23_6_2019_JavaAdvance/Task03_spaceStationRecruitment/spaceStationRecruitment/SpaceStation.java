package Exam.Exam_23_6_2019_JavaAdvance.Task03_spaceStationRecruitment.spaceStationRecruitment;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SpaceStation {
    private String name;
    private int capacity;
    private Map<String, Astronaut> data;

    public SpaceStation(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new LinkedHashMap<>();
    }

    public String getName() {
        return this.name;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int getCount() {
        return this.data.size();
    }

    public void add(Astronaut astronaut) {
        if (this.data.size() < this.capacity) {
            this.data.putIfAbsent(astronaut.getName(), astronaut);
        }
    }

    public boolean remove(String name) {
        if (this.data.containsKey(name)) {
            this.data.remove(name);
            return true;
        }
        return false;
    }

    public Astronaut getOldestAstronaut() {
        return this.data.values().stream().sorted((x, y) -> Integer.compare(y.getAge(), x.getAge())).collect(Collectors.toList()).get(0);
    }

    public Astronaut getAstronaut(String name) {
        return this.data.get(name);
    }

    //    report() – returns a string in the following format (print the astronauts in order of appearance):
//    "Astronauts working at Space Station {spaceStationName}:
//    {Astronaut1}
//    {Astronaut2}
//(…)"
    public String report() {
        if (this.data.size() > 0) {
            return String.format("Astronauts working at Space Station %s:\n", this.name) + String.join("\n",
                    this.data.values()
                            .stream()
                            .map(Astronaut::toString)
                            .collect(Collectors.toList()));
        } else return String.format("Astronauts working at Space Station %s:", this.name);
    }
//    public String report() {
//        return String.format("Astronauts working at Space Station %s:\n", this.name) + this.data.values()
//                .stream()
//                .map(Astronaut::toString)
//                .collect(Collectors.joining("\n"));
//    }
}

