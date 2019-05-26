package com.example.mybingo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView historyView;
    private TextView numberView;
    private View button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        historyView = findViewById(R.id.historyView);
        numberView = findViewById(R.id.numberView);
        button = findViewById(R.id.button);

        final MainViewModel viewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int nextNumber = viewModel.pickNextNumber();
                numberView.setText("" + nextNumber);
                historyView.setText(viewModel.createHistoryText());
                if (viewModel.isAllPicked()) {
                    button.setEnabled(false);
                }
            }
        });
    }
}
