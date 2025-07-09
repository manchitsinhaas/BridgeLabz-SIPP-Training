import java.util.Scanner;

class ProcessNode {
    int pid;
    int burstTime;
    int priority;
    int remainingTime;
    ProcessNode next;

    public ProcessNode(int pid, int burstTime, int priority) {
        this.pid = pid;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.priority = priority;
    }
}

public class Q6_RoundRobinScheduling {
    ProcessNode head = null;
    int timeQuantum = 4;

    public void addProcess(int pid, int burstTime, int priority) {
        ProcessNode p = new ProcessNode(pid, burstTime, priority);
        if (head == null) {
            head = p;
            p.next = head;
        } else {
            ProcessNode temp = head;
            while (temp.next != head) temp = temp.next;
            temp.next = p;
            p.next = head;
        }
    }

    public void simulateRoundRobin() {
        if (head == null) return;

        int time = 0, totalWaiting = 0, totalTurnaround = 0, count = 0;
        ProcessNode curr = head, prev = null;

        while (head != null) {
            if (curr.remainingTime <= timeQuantum) {
                time += curr.remainingTime;
                System.out.println("Process " + curr.pid + " completed at time: " + time);
                totalTurnaround += time;
                totalWaiting += time - curr.burstTime;

                removeProcess(curr.pid);
                if (head == null) break;
                curr = head;
            } else {
                time += timeQuantum;
                curr.remainingTime -= timeQuantum;
                curr = curr.next;
            }
            count++;
            displayProcesses();
        }

        System.out.println("Average Waiting Time: " + (totalWaiting / (double) count));
        System.out.println("Average Turnaround Time: " + (totalTurnaround / (double) count));
    }

    public void removeProcess(int pid) {
        if (head == null) return;

        if (head.pid == pid && head.next == head) {
            head = null;
            return;
        }

        ProcessNode curr = head, prev = null;
        do {
            if (curr.pid == pid) {
                if (curr == head) {
                    ProcessNode temp = head;
                    while (temp.next != head) temp = temp.next;
                    head = head.next;
                    temp.next = head;
                } else {
                    prev.next = curr.next;
                }
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);
    }

    public void displayProcesses() {
        if (head == null) return;
        System.out.println("Current Queue:");
        ProcessNode temp = head;
        do {
            System.out.println("PID: " + temp.pid + ", Remaining Time: " + temp.remainingTime);
            temp = temp.next;
        } while (temp != head);
    }

    public static void main(String[] args) {
        Q6_RoundRobinScheduling rr = new Q6_RoundRobinScheduling();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print("PID: ");
            int pid = sc.nextInt();
            System.out.print("Burst Time: ");
            int bt = sc.nextInt();
            System.out.print("Priority: ");
            int pr = sc.nextInt();
            rr.addProcess(pid, bt, pr);
        }

        System.out.println("\nSimulating Round Robin Scheduling...\n");
        rr.simulateRoundRobin();
    }
}
