package com.example.mybingo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView historyView;
    private TextView numberView;
    private View button;

    private final Random random = new Random();
    private final List<Integer> histories = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        historyView = findViewById(R.id.historyView);
        numberView = findViewById(R.id.numberView);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int nextNumber = random.nextInt(75) + 1;
                numberView.setText("" + nextNumber);

                histories.add(nextNumber);
                historyView.setText(createHistoryText());
            }
        });
    }

    private String createHistoryText() {
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
}
