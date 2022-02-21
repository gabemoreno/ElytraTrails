package me.gabriel.elytratrails.enums;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public enum Scale {
    MAJOR(new Integer[]{1, 3, 5, 6, 8, 10, 11}),
    MINOR(new Integer[]{1, 2, 4, 6, 8, 9, 11});

    private final List<Float> pitches;

    Scale(Integer[] notes) {
        pitches = Arrays.stream(notes).map(note -> (Float) (float) Math.pow(2, (double)note/12)).collect(Collectors.toList());
    }

    public float getRandomPitch() {
        return pitches.get(new Random().nextInt(pitches.size()));
    }

}
