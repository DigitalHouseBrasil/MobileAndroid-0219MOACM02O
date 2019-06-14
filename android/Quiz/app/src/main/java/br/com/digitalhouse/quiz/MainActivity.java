package br.com.digitalhouse.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView percentual;
    private SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        percentual = findViewById(R.id.percent_text);

        seekBar = findViewById(R.id.seekbar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                percentual.setText(progress + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        Button buttonPercentual = findViewById(R.id.button_percentual);
        buttonPercentual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irParaCaminhao();
            }
        });
    }

    public void irParaCaminhao() {
        Intent intent = new Intent(this, SelecaoCaminhaoActivity.class);

        Bundle bundle = new Bundle();
        Quiz quiz = new Quiz();

        quiz.setPercentual(seekBar.getProgress());

        bundle.putSerializable("QUIZ", quiz);

        intent.putExtras(bundle);

        startActivity(intent);
    }
}
