import java.util.Random;
import java.util.Scanner;

public class Fight {
	
	Player warrior = new Player(100,10);
	
	Scanner scan = new Scanner(System.in);
	Enemy enemy = new Enemy();

	public void decision() {

	}

	public void enemyAttack() {

		warrior.hp -= enemy.attack;
		System.out.println("The enemy hit you for " + enemy.attack + " damage");
		sleep();
		System.out.println("You have " + warrior.hp + " hp remaining");
		sleep();

	}

	public void playerAttack() {
		enemy.hp -= warrior.attack();
		System.out.println("you hit the enemy for " + warrior.attack + " damage");
		sleep();
		System.out.println("The enemy has " + enemy.hp + " hp remaining");
		sleep();

	}

	public void fightScene() {

		boolean enemyIsAlive = true;
		boolean playerIsAlive = true;
		int choice;
		int chance;
		Random rand = new Random();

		//both conditions have to be true for a fight.
	while((enemyIsAlive == true) && (playerIsAlive== true)) {
			System.out.println("1.) attack 2.) run");
			choice = scan.nextInt();
			switch (choice) {

			case 1:
				playerAttack();
				if (enemy.hp <= 0) {
					enemyIsAlive = false;
					warrior.hp(warrior.hp);
					System.out.println("enemy died");
					break;
				}
				enemyAttack();
				if(warrior.hp <= 0) {
					playerIsAlive = false;
					System.out.println("you died");
				}
				break;
				
			case 2:
				chance = rand.nextInt(10);
				System.out.println(chance);
				if(chance >= 5) {
					System.out.println("you cant escape");
					enemyAttack();
					break;
				}
				System.out.println("you get away safely");
				break;
			}
	}
			
	

	}

	public void monsterEncounter() {
		int r;
		Random rand = new Random();
		r = rand.nextInt(10);
		System.out.println(r);
		if (r >= 5) {
			enemy = new Dog();
			fightScene();
		} else {
			enemy = new Chicken();
			fightScene();
		}

	}

	// small pause between wherever i put it
	public void sleep() {
		try {
			Thread.sleep(750);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
