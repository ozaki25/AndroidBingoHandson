package com.example.mybingo;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainViewModel extends ViewModel {
    private final Random random = new Random();
    private final List<Integer> pickNumbers = new ArrayList<>();
    private final List<Integer> histories = new ArrayList<>();

    public MainViewModel() {
        pickNumbers.clear();
        for (int i = 1; i <= 75; i++) {
            pickNumbers.add(i);
        }
    }

    int pickNextNumber() {
        final int index = random.nextInt(pickNumbers.size());
        final int nextNumber = pickNumbers.remove(index);

        histories.add(nextNumber);

        return nextNumber;
    }

    String createHistoryText() {
        final StringBuilder sb = new StringBuilder();
        boolean isFirst = true;

        for (int history : histories) {
            if (isFirst) {
                isFirst = false;
            } else {
                sb.append(", ");
            }
            sb.append(history);
        }

        return sb.toString();
    }

    boolean isAllPicked() {
        return pickNumbers.isEmpty();
    }
}
