package edu.neumont;

import static org.junit.Assert.*;

import org.junit.Test;

public class AITests {

	@Test
	public void test() {
		LearningAIPlayer ai = new LearningAIPlayer();
		ai.makeMove(null);
	}

}
