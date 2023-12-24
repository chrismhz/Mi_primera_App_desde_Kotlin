package com.example.miprimeraappdesdekotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.miprimeraappdesdekotlin.model.TerrenoModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println("--- Hola Mundo desde Kotlin ---")
        println("--- Creado por Christian ---")
        println("--- Casi inge ---")

        /*VARIABLES DE KOTLIN*/
        //Kotlin puede ser tipado o no
        //var: declara una variable
        //     permite redeclarar en un mismo scope
        var nombre:String = "TESJI"
        var salario = 25000.5
        if(true){
            var nombre = "Linces"
        }

        //val: Definir constantes
        val PI = 3.1416
        // PI = PI + 1
        // -----CONTROLADOR PARA LA GUI Y EL MODEL
        // Declarar Views y referenciarlos por su ID
        val txtNombre = findViewById<EditText>(R.id.txtNombre);
        val txtMedidaAncho = findViewById<EditText>(R.id.txtMedidaAncho);
        val txtMedidaLargo = findViewById<EditText>(R.id.txtMedidaLargo);
        val txtPrecioMetro = findViewById<EditText>(R.id.txtPrecioMetro);
        val btnCalcular = findViewById<Button>(R.id.btnCalcular);

        //Crear el evento clic del boton
        btnCalcular.setOnClickListener{
            if(txtNombre.text.toString().trim().isEmpty()){
                txtNombre.setError("Ingresa Nombre");
            }else if(txtMedidaAncho.text.toString().trim().isEmpty()){
                txtMedidaAncho.setError("Ingresa Medida de Ancho");
            }else if(txtMedidaLargo.text.toString().trim().isEmpty()){
                txtMedidaLargo.setError("Ingresa Medida de Largo");
            }else if(txtPrecioMetro.text.toString().trim().isEmpty()){
                txtPrecioMetro.setError("Ingresa Precio por Metro");
            }else{
                //Conectar con el Modelo
                val terreno = TerrenoModel()
                terreno.nombre = txtNombre.text.toString();
                terreno.medidaLargo = txtMedidaLargo.text.toString().toDouble();
                terreno.medidaAncho = txtMedidaAncho.text.toString().toDouble();
                terreno.precioMetro = txtPrecioMetro.text.toString().toDouble();

                Toast.makeText(applicationContext,
                    terreno.calcularVenta(),
                    Toast.LENGTH_LONG).show();
            }
        }
    }
}