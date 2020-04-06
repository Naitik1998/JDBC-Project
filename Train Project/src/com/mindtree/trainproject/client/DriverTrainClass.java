package com.mindtree.trainproject.client;

import java.util.Iterator;
import java.util.Scanner;

import com.mindtree.trainproject.entity.Train;
import com.mindtree.trainproject.exception.DuplicateTrainIdException;
import com.mindtree.trainproject.service.ServiceImplement;


public class DriverTrainClass {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		ServiceImplement serviceobj = new ServiceImplement();

		boolean flag = true;
		do {
			System.out.println("1.	Insert Train Record.");
			System.out.println("2.	Display all Train record.");
			System.out.println("3.	Exit.");

			System.out.println("Enter the choice:");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				try {

					System.out.println(serviceobj.addTrainRecord(getTrainInput()));

				} catch (DuplicateTrainIdException e) {
					System.err.println(e.getMessage());

				}

				break;
			case 2:
				System.out.println("All Train record is: ");

				// System.out.println(serviceobj.displayTrainRecord());

				Iterator<Train> iterate = serviceobj.displayTrainRecord().iterator();
				while (iterate.hasNext()) {
					System.out.println(iterate.next());
				}

				break;

			case 3:
				System.out.println("Thank You !!!!");
				flag = false;
				break;
			default:
				System.out.println("You enterd Wrong choice !!! ");
				break;
			}

		} while (flag);

	}

	/**
	 * case 1
	 *
	 */
	public static Train getTrainInput() {
		Train train = new Train();

		System.out.println("Enter the train Id:");
		int trainid = scanner.nextInt();
		train.setTrainId(trainid);

		System.out.println("Enter the train Name:");
		scanner.nextLine();
		String trainname = scanner.nextLine();
		train.setTrainName(trainname);

		return train;
	}

}
