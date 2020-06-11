package StacksAndQueues.Exercises;

import java.util.*;

// working with the examples in judge 0/100 !!
public class Robotics_05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] inputConsoleRobots = sc.nextLine().split(";");
        String[] inputConsoleTime = sc.nextLine().split(":");
        int globalTime = convertInSec(inputConsoleTime);

//        Extracting robot name and work time form the console input;
        Map<String, Integer> mapRobotInfoTableInput = new HashMap<>();
        Map<String, Integer> mapRobotTimeCountDown = new HashMap<>(); // count down working time ;
        List<String> listOfBusyRobots = new ArrayList<>();
        List<String> listOfFreeRobots = new ArrayList<>();
        for (int i = 0; i < inputConsoleRobots.length; i++) {
            String[] robotInfo = inputConsoleRobots[i].split("-"); // robotInfo.length = 2 always
            String name = robotInfo[0];
            int workTimeSeconds = Integer.parseInt(robotInfo[1]);
            mapRobotInfoTableInput.put(name, workTimeSeconds);
            mapRobotTimeCountDown.put(name, workTimeSeconds);
            listOfFreeRobots.add(name);
        }

        String isItEnd;
        ArrayDeque<String> productsQueue = new ArrayDeque<>();

        while (!"End".equalsIgnoreCase(isItEnd = sc.nextLine())) {
            String product = isItEnd;
            productsQueue.offer(product);
        }
        while (!productsQueue.isEmpty()) {
            globalTime++;
            String product = productsQueue.poll();
            for (int i = 0; i < listOfBusyRobots.size(); i++) {
                String robotAtWork = listOfBusyRobots.get(i);
                int timeLeft = mapRobotTimeCountDown.get(robotAtWork);
                if (timeLeft == 1) {
                    listOfBusyRobots.remove(robotAtWork);
                    listOfFreeRobots.add(robotAtWork);
                    mapRobotTimeCountDown.put(robotAtWork, mapRobotInfoTableInput.get(robotAtWork));
                } else {
                    mapRobotTimeCountDown.put(robotAtWork, timeLeft - 1);  // working time goes down every 1 sec.

                }
            }
            if (!listOfFreeRobots.isEmpty()) {
                String workingRobot = listOfFreeRobots.get(0);
                listOfFreeRobots.remove(0);
                listOfBusyRobots.add(workingRobot);
                String currentClockTime = convertInHours(globalTime);
                System.out.println(String.format("%s - %s %s", workingRobot, product, currentClockTime));

            } else {
                productsQueue.offer(product);
            }

        }
    }

    private static int convertInSec(String[] clock) {
        int hours = Integer.parseInt(clock[0]);
        int minutes = Integer.parseInt(clock[1]);
        int seconds = Integer.parseInt(clock[2]);
        int clockInSeconds = seconds + minutes * 60 + hours * 3600;
        return clockInSeconds;
    }

    private static String convertInHours(int timeInSec) {
        // problem if hours>24
        int hours = 0;
        int minutes = 0;
        int seconds = 0;

        hours = timeInSec / 3600;
        minutes = (timeInSec % 3600) / 60;
        timeInSec = timeInSec % 60;

        if (hours > 23) {
            hours = hours % 24;
        }

        seconds = timeInSec;
        String resultTime = String.format("[%02d:%02d:%02d]", hours, minutes, seconds);
        return resultTime;
    }
}
