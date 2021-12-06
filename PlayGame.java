package mysteryLab;
import java.util.Scanner;
import org.apache.commons.lang3.time.StopWatch;


public class PlayGame {

	private static BigInteger Fibonacci(int n) {
	        if (n < 2)
	            return BigInteger.ONE;
	        else
	            return Fibonacci(n - 1).add(Fibonacci(n - 2));
	    }
	}

	public static void main(String[] args) {

		StopWatch1 stopwatch = new StopWatch1();
		Scanner input = new Scanner(System.in)
		int room = 0;
		String roomName = null;

		System.out.println(" ����������� ��� �������. ������ ��� ����� �� ������������ ����������� ����� ����������.");
		System.out.println(" ���� ���� ���� ���������� �� ��� �������� �������.");
		System.out.println(" ����� 20 ����� ��� �� ������������!");
		System.out.println(" ������ ������� ��� ��������� ��� ��������������� ��� ���������� ������.");
		System.out.println(" 1. �����");
		System.out.println(" 2. ������");
		System.out.println(" 3. ���������");
		System.out.println(" 4. ������");

		do {
			room = input.nextInt();

			if (room!=1 & room!=2 & room!=3 & room!=4) {
				System.out.println(" � ������� ��� ��������� ��� ����������� �� ������ ���������.");
				System.out.println(" ���������� ����! �������:");
				System.out.println(" 1. �����");
				System.out.println(" 2. ������");
				System.out.println(" 3. ���������");
				System.out.println(" 4. ������");
			}

		} while(room!=1 & room!=2 & room!=3 & room!=4)

		if (room == 1) {
			roomName = " �����";
		} else if (room == 2) {
			roomName = "������";
		}else if (room == 3) {
			roomName = "���������";
		}else {
			roomName = "������";
		}

		Crossword crossword = new Crossword(roomName);
		GuessWho guesswho = new GuessWho();
		Gallows gallows = new Gallows(room);
		Puzzles puzzles = new puzzles();

		System.out.println(" � ������ ��� �������� ��� ����! ������������� ��� ������!");

		stopwatch.start();
		Fibonacci(45);

		crossword.playGame(room);
		guesswho.startGuessing();
		gallows.startGame();
		puzzles.playPuzzle(room);

		stopwatch.stop();
	}
}


