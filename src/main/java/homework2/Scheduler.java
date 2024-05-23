package homework2;

import java.util.ArrayList;
import java.util.Comparator;

public class Scheduler {
    public static void scheduleAndRun(ArrayList<Process> processes) {
        ProcessQueue processQueue = new ProcessQueue();
        int currentTime = 0;
        processes.sort(Comparator.comparingInt(p -> p.arrivalTime));
        ArrayList<Process> readyQueue = new ArrayList<>();
        int totalWaitingTime = 0;

        while (!processes.isEmpty() || !processQueue.isEmpty()) {
            // Add processes to the queue as they arrive
            while (!processes.isEmpty() && processes.get(0).arrivalTime <= currentTime) {
                processQueue.addProcess(processes.remove(0));
            }

            if (!processQueue.isEmpty()) {
                Process currentProcess = processQueue.runNextProcess();
                if (currentProcess.startTime == -1) {
                    currentProcess.startTime = currentTime;
                }
                currentProcess.remainingTime -= 1;
                System.out.println("t = " + currentTime + " → " + currentProcess.name + " is running");

                if (currentProcess.remainingTime > 0) {
                    processQueue.addProcess(currentProcess);
                } else {
                    currentProcess.finishTime = currentTime + 1;
                    readyQueue.add(currentProcess);
                }
            } else {
                System.out.println("t = " + currentTime + " → CPU is idle");
            }

            currentTime++;
        }

        System.out.println("\nCompletion order:");
        for (Process process : readyQueue) {
            System.out.println(process.name);
        }

        // Calculate the average waiting time
        for (Process process : readyQueue) {
            int waitingTime = process.finishTime - process.burstTime - process.arrivalTime;
            totalWaitingTime += waitingTime;
        }

        double averageWaitingTime = (double) totalWaitingTime / readyQueue.size();
        System.out.println("\nTotal time: " + currentTime);
        System.out.println("Average waiting time: " + averageWaitingTime);
    }

    public static void main(String[] args) {
        ArrayList<Process> processes = new ArrayList<>();
        processes.add(new Process("P1", 2, 1, 0));
        processes.add(new Process("P2", 6, 7, 1));
        processes.add(new Process("P3", 3, 3, 2));
        processes.add(new Process("P4", 5, 6, 3));
        processes.add(new Process("P5", 4, 5, 4));
        processes.add(new Process("P6", 10, 15, 5));
        processes.add(new Process("P7", 9, 8, 15));

        scheduleAndRun(processes);
    }
}

