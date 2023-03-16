package com.example.votacion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Eleccion extends AppCompatActivity {

    Button btn2, btn3;
    RadioButton rb1, rb2, rb3;
    EditText et2;
    TextView tv4;

    int numero;
    int numero1 = 0;
    int numero2= 0;
    int numero3 = 0;
    int contador = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eleccion);


        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);

        et2 = findViewById(R.id.et2);
        tv4 = findViewById(R.id.tv4);

        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        rb3 = findViewById(R.id.rb3);


        String voto = getIntent().getStringExtra("dato");
        numero = Integer.parseInt(voto);

        btn2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                int edad;
                String valor1 = et2.getText().toString();
                edad = Integer.parseInt(valor1);

                if (edad >= 18) {
                        Toast.makeText(Eleccion.this, "Está habilitado para votar", Toast.LENGTH_SHORT).show();
                        tv4.setVisibility(View.VISIBLE);
                        rb1.setVisibility(View.VISIBLE);
                        rb2.setVisibility(View.VISIBLE);
                        rb3.setVisibility(View.VISIBLE);
                        btn3.setVisibility(View.VISIBLE);

                        et2.setEnabled(false);
                        btn2.setVisibility(View.INVISIBLE);
                        et2.setText("");

                        contador += 1;

                    }

                else {
                    Toast.makeText(Eleccion.this, "No está habilitado para votar", Toast.LENGTH_SHORT).show();
                    et2.setText("");
                }
            }
        });


        btn3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if (contador <= numero) {

                    if (rb1.isChecked() == true && rb2.isChecked() == false && rb3.isChecked() == false) {
                        numero1 += 1;
                        contador += 1;

                        Toast.makeText(Eleccion.this, "Gracias por votar", Toast.LENGTH_SHORT).show();

                        rb1.setChecked(false);
                        rb2.setChecked(false);
                        rb3.setChecked(false);
                        tv4.setVisibility(View.INVISIBLE);
                        rb1.setVisibility(View.INVISIBLE);
                        rb2.setVisibility(View.INVISIBLE);
                        rb3.setVisibility(View.INVISIBLE);
                        btn3.setVisibility(View.INVISIBLE);

                        et2.setEnabled(true);
                        btn2.setVisibility(View.VISIBLE);

                    } else if (rb1.isChecked() == false && rb2.isChecked() == true && rb3.isChecked() == false) {

                        numero2 += 1;
                        contador += 1;

                        Toast.makeText(Eleccion.this, "Gracias por votar", Toast.LENGTH_SHORT).show();

                        rb1.setChecked(false);
                        rb2.setChecked(false);
                        rb3.setChecked(false);
                        tv4.setVisibility(View.INVISIBLE);
                        rb1.setVisibility(View.INVISIBLE);
                        rb2.setVisibility(View.INVISIBLE);
                        rb3.setVisibility(View.INVISIBLE);
                        btn3.setVisibility(View.INVISIBLE);

                        et2.setEnabled(true);
                        btn2.setVisibility(View.VISIBLE);
                        et2.setText("");

                    } else if (rb1.isChecked() == false && rb2.isChecked() == false && rb3.isChecked() == true) {

                        numero3 += 1;
                        contador += 1;
                        Toast.makeText(Eleccion.this, "Gracias por votar", Toast.LENGTH_SHORT).show();

                        rb1.setChecked(false);
                        rb2.setChecked(false);
                        rb3.setChecked(false);
                        tv4.setVisibility(View.INVISIBLE);
                        rb1.setVisibility(View.INVISIBLE);
                        rb2.setVisibility(View.INVISIBLE);
                        rb3.setVisibility(View.INVISIBLE);
                        btn3.setVisibility(View.INVISIBLE);

                        et2.setEnabled(true);
                        btn2.setVisibility(View.VISIBLE);
                        et2.setText("");

                    } else {
                        Toast.makeText(Eleccion.this, "Solo puede seleccionar un candidato", Toast.LENGTH_SHORT).show();
                        rb1.setChecked(false);
                        rb2.setChecked(false);
                        rb3.setChecked(false);

                    }

                }

                else {

                    tv4.setVisibility(View.VISIBLE);

                    if (numero1 > numero2 && numero1 > numero3) {
                        rb1.setVisibility(View.INVISIBLE);
                        rb2.setVisibility(View.INVISIBLE);
                        rb3.setVisibility(View.INVISIBLE);
                        btn3.setVisibility(View.INVISIBLE);
                        tv4.setText("EL GANADOR DE LAS ELECCIONES ES " + rb1.getText().toString());

                    } else {

                        if (numero2 > numero1 && numero2 > numero3) {

                            rb1.setVisibility(View.INVISIBLE);
                            rb2.setVisibility(View.INVISIBLE);
                            rb3.setVisibility(View.INVISIBLE);
                            btn3.setVisibility(View.INVISIBLE);
                            tv4.setText("EL GANADOR DE LAS ELECCIONES ES " + rb2.getText().toString());
                        }

                        else{
                                if (numero3 > numero1 && numero3 > numero2) {
                                    tv4.setText("EL GANADOR DE LAS ELECCIONES ES " + rb3.getText().toString());
                                    rb1.setVisibility(View.INVISIBLE);
                                    rb2.setVisibility(View.INVISIBLE);
                                    rb3.setVisibility(View.INVISIBLE);
                                    btn3.setVisibility(View.INVISIBLE);

                            }
                                else {
                                    rb1.setVisibility(View.INVISIBLE);
                                    rb2.setVisibility(View.INVISIBLE);
                                    rb3.setVisibility(View.INVISIBLE);
                                    btn3.setVisibility(View.INVISIBLE);
                                    tv4.setText("ES UN EMPATE");
                                }
                        }

                    }
                }
            }
        });
    }
}
