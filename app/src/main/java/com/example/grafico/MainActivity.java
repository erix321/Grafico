package com.example.grafico;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    ViewGroup linear;
    int[] niveles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //LISTA DE LOS NIVELES REGISTRADOS PARA LOS 7 DIAS (0 A 9)
        int[] lvl ={6,8,2,4,0,4,6};

        //SE CONVIERTEN A LOS VALORES REALES DENTRO DEL GRAFICO
        for(int i=0;i<lvl.length;i++){
            lvl[i]=400-lvl[i]*30;
        }
        niveles=lvl;

        //SE RECUPERA EL LAYOUT DONDE SE REAIZARÁ EL GRÁFICO
        linear = (ViewGroup) findViewById(R.id.grafico);
        Vista vista=new Vista(this);
        linear.addView(vista);
    }
    class Vista extends View {
        public Vista (Context context){
            super(context);
        }

        public void onDraw(Canvas canvas) {

            //DISTANCIAS DEL EJE X PARA CADA 'COLUMNA' DEL GRÁFICO
            int lin_hor[]={40,125,210,295,380,465,550};

            //FORMATO PARA EL TEXTO NORMAL
            Paint paint3=new Paint();
            paint3.setTextSize(22);

            //FORMATO PARA EL TEXTO TITULO
            Paint paint4=new Paint();
            paint4.setTextSize(30);

            //DIBUJO DE LOS LABELS PRINCIPALES
            canvas.drawText("Progreso",lin_hor[2],75,paint4);
            canvas.drawText("Días",lin_hor[3]-25,500,paint4);

            //DIBUJO DE LOS LABELS SECUNDARIOS
            canvas.drawText("Día 1",lin_hor[0]-15,450,paint3);
            canvas.drawText("Día 2",lin_hor[1]-15,450,paint3);
            canvas.drawText("Día 3",lin_hor[2]-15,450,paint3);
            canvas.drawText("Día 4",lin_hor[3]-15,450,paint3);
            canvas.drawText("Día 5",lin_hor[4]-15,450,paint3);
            canvas.drawText("Día 6",lin_hor[5]-15,450,paint3);
            canvas.drawText("Día 7",lin_hor[6]-15,450,paint3);

            //FORMATO PARA LAS LINEAS GRISES
            Paint paint = new Paint();
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(3);
            paint.setColor(Color.LTGRAY);

            //DIBUJO DE LAS LINEAS GRISES
            canvas.drawLine(0,130,600,130,paint);
            canvas.drawLine(0,160,600,160,paint);
            canvas.drawLine(0,190,600,190,paint);
            canvas.drawLine(0,220,600,220,paint);
            canvas.drawLine(0,250,600,250,paint);
            canvas.drawLine(0,280,600,280,paint);
            canvas.drawLine(0,310,600,310,paint);
            canvas.drawLine(0,340,600,340,paint);
            canvas.drawLine(0,370,600,370,paint);
            canvas.drawLine(0,400,600,400,paint);

            //FORMATO PARA LAS LINEAS ROJAS
            Paint paint2 = new Paint();
            paint2.setStyle(Paint.Style.STROKE);
            paint2.setStrokeWidth(10);
            paint2.setColor(Color.RED);

            //DIBUJO DE LAS LINEAS ROJAS
            canvas.drawLine(lin_hor[0],niveles[0],lin_hor[1],niveles[1],paint2);
            canvas.drawLine(lin_hor[1],niveles[1],lin_hor[2],niveles[2],paint2);
            canvas.drawLine(lin_hor[2],niveles[2],lin_hor[3],niveles[3],paint2);
            canvas.drawLine(lin_hor[3],niveles[3],lin_hor[4],niveles[4],paint2);
            canvas.drawLine(lin_hor[4],niveles[4],lin_hor[5],niveles[5],paint2);
            canvas.drawLine(lin_hor[5],niveles[5],lin_hor[6],niveles[6],paint2);

            //DIBUJO DE LOS NUMEROS
            canvas.drawText(""+(400-niveles[0])/60,lin_hor[0],niveles[0]-18,paint3);
            canvas.drawText(""+(400-niveles[1])/60,lin_hor[1],niveles[1]-18,paint3);
            canvas.drawText(""+(400-niveles[2])/60,lin_hor[2],niveles[2]-18,paint3);
            canvas.drawText(""+(400-niveles[3])/60,lin_hor[3],niveles[3]-18,paint3);
            canvas.drawText(""+(400-niveles[4])/60,lin_hor[4],niveles[4]-18,paint3);
            canvas.drawText(""+(400-niveles[5])/60,lin_hor[5],niveles[5]-18,paint3);
            canvas.drawText(""+(400-niveles[6])/60,lin_hor[6],niveles[6]-18,paint3);
        }
    }
}