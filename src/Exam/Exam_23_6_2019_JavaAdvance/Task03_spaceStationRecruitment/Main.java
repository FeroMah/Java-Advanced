package Exam.Exam_23_6_2019_JavaAdvance.Task03_spaceStationRecruitment;


import Exam.Exam_23_6_2019_JavaAdvance.Task03_spaceStationRecruitment.spaceStationRecruitment.Astronaut;
import Exam.Exam_23_6_2019_JavaAdvance.Task03_spaceStationRecruitment.spaceStationRecruitment.SpaceStation;

public class Main {
    public static void main(String[] args) {
        SpaceStation spaceStation = new SpaceStation("Apolo", 1);
        Astronaut astronaut = new Astronaut("Fero", 30, "BG");
        Astronaut astronaut1 = new Astronaut("Beny", 23, "cosmos");
        spaceStation.add(astronaut);
        spaceStation.add(astronaut1);
        System.out.println(spaceStation.report());
    }
}
