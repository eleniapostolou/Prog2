package mysteryLab;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PuzzlesTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test() {
		Puzzles test = new Puzzles();
		int output = test.getColumn();
		assertEquals(15, output);
	}

}
