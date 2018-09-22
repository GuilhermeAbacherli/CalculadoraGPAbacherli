package br.com.fatecid.guilhermeabacherli.calculadoragpabacherli;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void pressionarNumero(View v) {
        Button botaoPressionado = (Button) findViewById(v.getId());
        TextView resultado = (TextView) findViewById(R.id.txtResultado);
        String txtNumero = botaoPressionado.getText().toString();
        String txtConcatenar = resultado.getText().toString();
        resultado.setText(txtConcatenar + txtNumero);
    }

    public void limpar(View v) {
        TextView resultado = (TextView) findViewById(R.id.txtResultado);
    }

    public void pressionarOperacao(View v) {
        Button botaoPressionado = (Button) findViewById(v.getId());

        TextView operacao = (TextView) findViewById(R.id.txtOperacao);
        TextView resultado = (TextView) findViewById(R.id.txtResultado);

        String calcular = operacao.getText().toString();

        if (TextUtils.isEmpty(calcular)) {
            resultado.setText(calcular + botaoPressionado.getText().toString());
            operacao.setText("");
        }
    }

    public void calcular(View v) {

        TextView operacao = (TextView) findViewById(R.id.txtOperacao);
        TextView resultado = (TextView) findViewById(R.id.txtResultado);

        String txtOperacao = operacao.getText().toString();
        String txtResultado = resultado.getText().toString();

        if (!TextUtils.isEmpty(txtOperacao) && !TextUtils.isEmpty(txtResultado) && !txtOperacao.contains("=")) {

            operacao.setText(txtOperacao + txtResultado + "=");
            double valor1 = Double.parseDouble(txtResultado);
            double valor2 = Double.parseDouble(txtOperacao.substring(0, txtOperacao.length() - 1));
            double valorResultado = 0;

            switch (txtOperacao.substring(txtOperacao.length() - 1, txtOperacao.length())) {
                case "+":
                    valorResultado = valor1 + valor2;
                    break;

                case "-":
                    valorResultado = valor1 - valor2;
                    break;

                case "/":
                    valorResultado = valor1 / valor2;
                    break;

                case "*":
                    if (valor2 == 0) {
                        valorResultado = 0;
                    } else {
                        valorResultado = valor1 * valor2;
                    }
                    break;
            }
            String txtResultadoCalculo = String.valueOf(valorResultado);
            resultado.setText(txtResultadoCalculo);

        }
    }
}