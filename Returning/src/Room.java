import java.util.Random;
import java.util.Scanner;

public class Room {
	// input
	Scanner scan = new Scanner(System.in);

	public void dungeon(int x, int y) {
		// for random number encounter
		int r;
		//switch movement variable
		int dir;
		Random rand = new Random();
		//for new room. loop breaker.
		boolean roomFound = false;

		System.out.println("you enter a dungeon");

		while (roomFound == false) {
			//direction under while to show each loop
			System.out.println("which way would you like to go? 1.)north 2.)east 3.)south 4.)west");
			
			//if this co-ordinate is found, go to new room. makes boolean at top true and stops the loop.
			if ((x == 2) && (y == 7)) {
				roomFound = true;
				System.out.println("you found a new room");
				break;
			}
			//variable for movement
			dir = scan.nextInt();
			//movement. max direction north and east = 10. 0 is most south and west.  making the room 10 by 10. if variable is 10 or somehow greater, movement not possible. same with 0 or lower.
			switch (dir) {
			case 1:
				if (x >= 10) {
					System.out.println("you cant go this way");
					break;
				}
				System.out.println("you go north");
				x += 1;
				break;
			case 2:
				if (y >= 10) {
					System.out.println("you cant go this way");
					break;
				}
				System.out.println("you go east");
				y+=1;
				break;
			case 3:
				if (x <= 0) {
					System.out.println("you cant go this way");
					break;
				}
				System.out.println("you go south");
				x-=1;
				break;
			case 4:

				if (y <= 0) {
					System.out.println("you cant go this way");
					break;
				}
				System.out.println("you go west");
				y-=1;
				break;
			}
			//map at end of loop so it takes into consideration move before display
			System.out.println(x + " "+ y);
			
			//random encounter
			r = rand.nextInt(10);
			//shows r for debugging
			System.out.println(r);
			if(r >= 5) {
				Fight fight = new Fight();
				fight.monsterEncounter();
				
			}

		}
	}

}
