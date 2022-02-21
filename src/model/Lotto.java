package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
	private static final List<Integer> NUMBERS = init();
	private List<Integer> game;


	private Lotto(List<Integer> game) {
		this.game = game;
	}

	public static Lotto createLotto() {
		List<Integer> game = new ArrayList<>();
		Collections.shuffle(NUMBERS);
		for (int i = 0; i < 6; i++) {
			game.add(NUMBERS.get(i));
		}
		return new Lotto(game);
	}

	private static List<Integer> init() {
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i<46; i++){
			list.add(i);
		}
		return list;
	}
}
