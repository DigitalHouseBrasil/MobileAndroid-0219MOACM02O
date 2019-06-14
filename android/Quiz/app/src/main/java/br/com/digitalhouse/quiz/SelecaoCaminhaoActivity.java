package br.com.digitalhouse.quiz;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class SelecaoCaminhaoActivity extends AppCompatActivity {

    private Quiz quiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecao_caminhao);

        Bundle bundle = getIntent().getExtras();

        quiz = (Quiz) bundle.getSerializable("QUIZ");

        Button buttonCaminhao = findViewById(R.id.button_caminhao);
        buttonCaminhao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irParaCores();
            }
        });
    }

    private void irParaCores(){
        Intent intent = new Intent(this, CoresActivity.class);

        Bundle bundle = new Bundle();

        RadioButton rbCarreto = findViewById(R.id.rb_carreto);
        RadioButton rbCegonha = findViewById(R.id.rb_cegonha);
        RadioButton rbLixo = findViewById(R.id.rb_lixo);
        RadioButton rbFrigorifico = findViewById(R.id.rb_frigorifico);

        if(rbCarreto.isChecked()){
            quiz.setCaminhao("Carreto");
        } else if (rbCegonha.isChecked()){
            quiz.setCaminhao("Cegonha");
        } else if (rbFrigorifico.isChecked()){
            quiz.setCaminhao("Frigorifico");
        } else if (rbLixo.isChecked()){
            quiz.setCaminhao("Caminhão de Lixo");
        }

        bundle.putSerializable("QUIZ", quiz);

        intent.putExtras(bundle);

        startActivity(intent);
    }

}
