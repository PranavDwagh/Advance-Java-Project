package groceryAssignment;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import study.entity.HiberApp;

public class GroceryOperation {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Session session = HiberApp.getSession();

		while(true)
		{
			showMenu();
			System.out.println("Enter Choice");

			int choice = sc.nextInt();
			if (choice == 6)
				break;

			switch (choice) {
			case 1:
				addProduct(session,sc);
				break;
			case 2:
				System.out.println("Enter Product ID");
				int id3 = sc.nextInt();
				ChangeProperties(session, id3, sc);
				break;
			case 3:
				System.out.println("Enter Product ID");
				int id = sc.nextInt();
				deleteProduct(session, id, sc);
				break;
			case 4:
				System.out.println("Enter Product ID");
				int id1 = sc.nextInt();
				showDetails(session, id1, sc);
				break;
				
			case 5:
				List<Grocery> list = showAll(session, sc);
				list.forEach(e->System.out.println(e));
				break;
			
			default:
				break;
			}
		}
	}
	
	private static List<Grocery> showAll(Session session, Scanner sc) {
		
			Query<Grocery> query = session.createQuery("select gr.id from groceryAssignment.Grocery gr");
			
			List<Grocery> list = query.list();
			
			return list;
	}

	private static void showDetails(Session session, int id1, Scanner sc) {
		Transaction tr = session.beginTransaction();
		
		Grocery gr = session.find(Grocery.class, id1);
		
		if(gr != null)
		System.out.println(gr);
		else
			System.out.println("No Groceries available for this product_no");
		tr.commit();
	}

	private static void deleteProduct(Session session, int id, Scanner sc) {
		Transaction tr = session.beginTransaction();
		
		Grocery gr = session.find(Grocery.class, id);
		
		if(gr != null)
		{
			session.delete(gr);
		}
		tr.commit();
	}

	private static void ChangeProperties(Session session, int id3, Scanner sc) {

		Transaction tr = session.beginTransaction();
		
		System.out.println("Enter new name");
		String name = sc.next();
		Grocery gr = session.find(Grocery.class, id3);
		gr.setName(name);
		
		tr.commit();
	}

	private static void addProduct(Session session, Scanner sc) {
		
		Transaction tr = session.beginTransaction();
	
		//int id, String name, String desc, String unit, int cost, String exDate
		System.out.println("Enter the details about the product");
		System.out.println("Enter product ID");
		int id = sc.nextInt();
		System.out.println("Enter Product Name");
		String name = sc.next();
		System.out.println("Enter description");
		String desc = sc.next();
		System.out.println("Enter unit of measurement");
		String unit = sc.next();
		System.out.println("Enter Cost");
		int cost = sc.nextInt();
		System.out.println("Enter String Date");
		String exDate = sc.next();
		
		Grocery gr = new Grocery(id, name, desc, unit, cost, exDate);
		//Grocery gr = new Grocery(3, "Banana", "Yellow", "dozen", 20, "2021-12-31");
		session.save(gr);
		session.getTransaction().commit();
		
	}

	private static void showMenu() {

		System.out.println("1. Add a new prod\n" + 
				"2. Change the product properties \r\n" + 
				"3. Delete a product\r\n" + 
				"4. Show details of a product with a given id\r\n" + 
				"5. Show All\n6. Quit");
	}

}
