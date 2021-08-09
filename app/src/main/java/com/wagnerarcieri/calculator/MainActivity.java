package com.wagnerarcieri.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button numeroZero, numeroUm, numeroDois, numeroTres, numeroQuatro, numeroCinco, numeroSeis, numeroSete, numeroOito, numeroNove, ponto, soma, subtracao, multiplicacao, divisao,igual, botao_limpar;

    private TextView txtExpressao, txtResultado;

    private ImageView backspace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IniciarComponente();
        getSupportActionBar().hide();
        ListenersSetters();
    }




    private void ListenersSetters(){
        numeroZero.setOnClickListener(this);
        numeroUm.setOnClickListener(this);
        numeroDois.setOnClickListener(this);
        numeroTres.setOnClickListener(this);
        numeroQuatro.setOnClickListener(this);
        numeroCinco.setOnClickListener(this);
        numeroSeis.setOnClickListener(this);
        numeroSete.setOnClickListener(this);
        numeroOito.setOnClickListener(this);
        numeroNove.setOnClickListener(this);
        ponto.setOnClickListener(this);
        soma.setOnClickListener(this);
        subtracao.setOnClickListener(this);
        divisao.setOnClickListener(this);
        multiplicacao.setOnClickListener(this);

        botao_limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                txtExpressao.setText("");
                txtResultado.setText("");
            }
        });

        backspace.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView expressao = findViewById(R.id.txt_expressao);
                String string = expressao.getText().toString();

                if (!string.isEmpty()){

                    byte var0 = 0;
                    int var1 = string.length()-1;
                    String txtExpressão = string.substring(var0,var1);
                    expressao.setText(txtExpressão);
                }
                txtResultado.setText("");
            }
        }));


        igual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try{
                    Expression expression = new ExpressionBuilder(txtExpressao.getText().toString()).build();
                    double resultado = expression.evaluate();
                    long longResult = (long) resultado;

                    if (resultado == (double)longResult){
                        txtResultado.setText((CharSequence) String.valueOf(longResult));
                    } else {
                        txtExpressao.setText((CharSequence) String.valueOf(resultado));
                    }
                }catch (Exception e){

                }
            }
        });
    }

    @SuppressLint("WrongViewCast")
    private void IniciarComponente(){
        numeroZero = findViewById(R.id.num_zero);
        numeroUm = findViewById(R.id.num_um);
        numeroDois = findViewById(R.id.num_dois);
        numeroTres = findViewById(R.id.num_tres);
        numeroQuatro = findViewById(R.id.num_quatro);
        numeroCinco = findViewById(R.id.num_cinco);
        numeroSeis = findViewById(R.id.num_seis);
        numeroSete = findViewById(R.id.num_sete);
        numeroOito = findViewById(R.id.num_oito);
        numeroNove = findViewById(R.id.num_nove);
        ponto = findViewById(R.id.ponto);
        soma = findViewById(R.id.bt_soma);
        subtracao = findViewById(R.id.bt_subtracao);
        multiplicacao = findViewById(R.id.bt_multiplicacao);
        divisao = findViewById(R.id.bt_divisao);
        igual = findViewById(R.id.bt_igual);
        botao_limpar = findViewById(R.id.bt_limpar);
        txtExpressao = findViewById(R.id.txt_expressao);
        txtResultado = findViewById(R.id.txt_resultado);
        backspace = findViewById(R.id.backspace);
    }

    public void AcrescentarUmaExpressão(String string, Boolean limpar_dados){
        if (txtResultado.getText().equals("")){
            txtExpressao.setText(" ");
        }

        if (limpar_dados){
            txtResultado.setText(" ");
            txtExpressao.append(string);
        } else {
            txtExpressao.append(txtResultado.getText());
            txtExpressao.append(string);
            txtResultado.setText(" ");
        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.num_zero:
                AcrescentarUmaExpressão("0", true);
                break;
            case R.id.num_um:
                AcrescentarUmaExpressão("1", true);
                break;
            case R.id.num_dois:
                AcrescentarUmaExpressão("2", true);
                break;
            case R.id.num_tres:
                AcrescentarUmaExpressão("3", true);
                break;
            case R.id.num_quatro:
                AcrescentarUmaExpressão("4", true);
                break;
            case R.id.num_cinco:
                AcrescentarUmaExpressão("5", true);
                break;
            case R.id.num_seis:
                AcrescentarUmaExpressão("6", true);
                break;
            case R.id.num_sete:
                AcrescentarUmaExpressão("7", true);
                break;
            case R.id.num_oito:
                AcrescentarUmaExpressão("8", true);
                break;
            case R.id.num_nove:
                AcrescentarUmaExpressão("9", true);
                break;
            case R.id.ponto:
                AcrescentarUmaExpressão(".", true);
                break;
            case R.id.bt_soma:
                AcrescentarUmaExpressão("+", false);
                break;

            case R.id.bt_subtracao:
                AcrescentarUmaExpressão("-", false);
                break;

            case R.id.bt_multiplicacao:
                AcrescentarUmaExpressão("*", false);
                break;

            case R.id.bt_divisao:
                AcrescentarUmaExpressão("/", false);
                break;


        }
    }
}