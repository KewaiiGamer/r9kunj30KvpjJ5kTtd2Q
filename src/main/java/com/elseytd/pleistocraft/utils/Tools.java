package com.elseytd.pleistocraft.utils;

import java.util.Random;

public class Tools {
	public static int randint(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
}
