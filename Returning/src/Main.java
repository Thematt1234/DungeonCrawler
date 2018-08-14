import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		new Main();
		
	}
	public Main() {
		Player warrior = new Player(100,0);
		Room room = new Room();
		room.dungeon(0,0);
	}

}
