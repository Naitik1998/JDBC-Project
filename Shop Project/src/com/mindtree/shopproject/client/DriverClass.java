package com.mindtree.shopproject.client;

import java.util.Scanner;

import com.mindtree.shopproject.entity.Shop;
import com.mindtree.shopproject.service.ShopService;
import com.mindtree.shopproject.service.serviceimplementation.ShopServiceImp;

public class DriverClass {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ShopService service = new ShopServiceImp();
		boolean flag = true;

		do {
			System.out.println("1.	Insert the a shop Details.");
			System.out.println("2.	Display shop Details.");
			System.out.println("3.	Upadte A shop");
			System.out.println("4.	Delete a shop whose total product<10.");
			System.out.println("5.	Exit.");

			System.out.println("Enter the choice:");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				Shop shop = new Shop();
				
				System.out.println("Enter the shop id: ");
				int shopid = scanner.nextInt();

				System.out.println("Enter the shop name:");
				scanner.nextLine();
				String shopname = scanner.nextLine();

				System.out.println("Enter the total product in shop:");
				int totalproduct = scanner.nextInt();

				shop.setShopId(shopid);
				shop.setShopName(shopname);
				shop.setTotalProduct(totalproduct);

				service.addShopDetail(shop);

				break;
			case 2:

				break;
			case 3:

				break;
			case 4:

				break;
			case 5:
				System.out.println("Thank You");
				flag = false;
				break;

			default:
				System.out.println("You Entered Wrong Choice !!! ");
				break;
			}

		} while (flag);
	}

}
