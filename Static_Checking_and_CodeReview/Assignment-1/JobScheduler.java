import java.util.Scanner;

public class JobScheduler {

	/**
	 * Completion time Time taken for the execution to complete, starting from
	 * arrival time of first process
	 * 
	 * @param burstTime
	 * @param completionTime
	 */
	void findCompletionTime(int burstTime[], int completionTime[]) {
		completionTime[0] = burstTime[0];

		for (int i = 1; i < burstTime.length; i++) {

			completionTime[i] = completionTime[i - 1] + burstTime[i];

		}
	}

	/**
	 * Turn around time the difference between the Completion time and the
	 * Arrival time
	 * 
	 * @param arrivalTime
	 * @param completionTime
	 * @param turnAroundTime
	 */
	void findTurnAroundTime(int arrivalTime[], int completionTime[],
			int turnAroundTime[]) {
		for (int i = 0; i < turnAroundTime.length; i++) {
			turnAroundTime[i] = completionTime[i] - arrivalTime[i];
		}
	}

	/**
	 * Wait time the difference between the Turn Around time and the Burst time
	 * of the process
	 * 
	 * @param turnAroundTime
	 * @param burstTime
	 * @param waitingTime
	 */

	void findWaitingTime(int turnAroundTime[], int burstTime[],
			int waitingTime[]) {
		for (int i = 0; i < waitingTime.length; i++) {
			waitingTime[i] = turnAroundTime[i] - burstTime[i];
		}
	}

	/**
	 * Sorting using bubble sort
	 * 
	 * @param arrivalTime
	 * @param burstTime
	 * @param processID
	 */
	void sortAccordingToArrivalTimes(int arrivalTime[], int burstTime[],
			int processID[]) {
		int temp;
		for (int i = 0; i < arrivalTime.length; i++) {
			for (int j = 0; j < (arrivalTime.length) - (i + 1); j++) {
				if (arrivalTime[j] > arrivalTime[j + 1]) {
					temp = arrivalTime[j];
					arrivalTime[j] = arrivalTime[j + 1];
					arrivalTime[j + 1] = temp;

					temp = burstTime[j];
					burstTime[j] = burstTime[j + 1];
					burstTime[j + 1] = temp;

					temp = processID[j];
					processID[j] = processID[j + 1];
					processID[j + 1] = temp;
				}
			}
		}
	}

	public static void main(String argsp[]) {
		int totalProcess;
		Scanner sc = new Scanner(System.in);
		JobScheduler jobschedule = new JobScheduler();
		System.out.println("Enter number of process : ");
		totalProcess = sc.nextInt();

		int processID[] = new int[totalProcess];
		int arrivalTime[] = new int[totalProcess];
		int burstTime[] = new int[totalProcess];
		int waitingTime[] = new int[totalProcess];
		int turnAroundTime[] = new int[totalProcess];
		int completionTime[] = new int[totalProcess];

		System.out.println("Enter the Process Arrival Time and Burst time");
		for (int i = 0; i < totalProcess; i++) {
			processID[i] = i + 1;
			System.out.println("Process ID " + processID[i]);
			System.out.println("Arrival Time : ");
			arrivalTime[i] = sc.nextInt();
			System.out.println("Burst Time : ");
			burstTime[i] = sc.nextInt();

		}
		System.out.println("----Process Description----");
		for (int i = 0; i < totalProcess; i++) {
			System.out.print("Pid : " + processID[i] + "   ");
			System.out.print("AT : " + arrivalTime[i] + "   ");
			System.out.print("BT : " + burstTime[i] + "    ");
			System.out.println();

		}
		System.out.println("----------------------------");
		jobschedule.sortAccordingToArrivalTimes(arrivalTime, burstTime,
				processID);
		jobschedule.findCompletionTime(burstTime, completionTime);
		jobschedule.findTurnAroundTime(arrivalTime, completionTime,
				turnAroundTime);
		jobschedule.findWaitingTime(turnAroundTime, burstTime, waitingTime);

		System.out.println("------------Final Output-----------");
		for (int i = 0; i < totalProcess; i++) {
			System.out.print("Pid : " + processID[i] + "    ");
			System.out.print("AT : " + arrivalTime[i] + "   ");
			System.out.print("BT : " + burstTime[i] + "     ");
			System.out.print("WT : " + waitingTime[i] + "    ");
			System.out.print("TAT : " + turnAroundTime[i] + "    ");
			System.out.print("CT : " + completionTime[i] + "    ");
			System.out.println();
		}

		System.out.println("------------Average waiting time-----------");
		int WaitingTime = 0, AverageWaitingTime = 0;
		for (int i = 0; i < waitingTime.length; i++) {
			WaitingTime += waitingTime[i];
		}
		AverageWaitingTime = WaitingTime / totalProcess;
		System.out.println("Average waiting time : " + AverageWaitingTime);

		System.out.println("------------Max waiting time period-----------");
		System.out.println("Max Wait Time Period : "
				+ waitingTime[totalProcess - 1]);
	}
}
