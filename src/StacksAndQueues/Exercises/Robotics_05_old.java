package StacksAndQueues.Exercises;


import java.util.*;

public class Robotics_05_old {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] inputConsole = sc.nextLine().split(";");
        String[] timeInputConsole = sc.nextLine().split(":");
        int hours = Integer.parseInt(timeInputConsole[0]);
        int minutes = Integer.parseInt(timeInputConsole[1]);
        int seconds = Integer.parseInt(timeInputConsole[2]) + 1; // +1 sec for pricking the product from the line;

        Map<String, Integer> robotsAndTime = new HashMap<>();
        List<String> queueFreeRobots = new ArrayList<>();
        ArrayDeque<String> queueBusyRobots = new ArrayDeque<>();
        for (int i = 0; i < inputConsole.length; i++) {
            String[] data = inputConsole[i].split("-");
            String robotName = data[0];
            queueFreeRobots.add(robotName);
            int workTime = Integer.parseInt(data[1]);
            robotsAndTime.put(robotName, workTime);
        }

//        calculateTime(inputTime, robotsAndTime.get(queueFreeRobots.poll()));
        String productsInput;
        ArrayDeque<String> queueOfProducts = new ArrayDeque<>();
        while (!"End".equalsIgnoreCase(productsInput = sc.nextLine())) {
            queueOfProducts.add(productsInput);
        }
        while (!queueOfProducts.isEmpty()) {
//            String robot = queueFreeRobots.poll();
//            queueBusyRobots.add(robot);
//            String workedProduct = queueOfProducts.poll();
//            System.out.println(String.format("%s - %s [%d:%02d:%02d]", robot, workedProduct, hours, minutes, seconds));
            seconds++;
        }
    }

    private static void calculateTime(String inputTime, int robotWorkTime) {
        String[] time = inputTime.split(":");
        int hours = Integer.parseInt(time[0]);
        int minutes = Integer.parseInt(time[1]);
        int seconds = Integer.parseInt(time[2]);
        int workingTime = robotWorkTime;
        seconds += workingTime;
        while (seconds > 60) {
            seconds += workingTime - 60;
            minutes++;
        }
        while (minutes > 60) {
            minutes -= 60;
            hours++;
        }
        while (hours > 23) {
            hours -= 24;
        }

        System.out.println(String.format("%d:%02d:%02d", hours, minutes, seconds));
    }

}

