package mx.edu.ittepic.dadm_u3_ejercicio3_arleyaquino;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Switch;

public class Lienzo extends View {
    Bitmap imagenFondo, bienvenida;
    MainActivity  p1;
    Imagen botonPlay, botonIniciar, puntero;


    public Lienzo(Context context) {
        super(context);
        p1 = (MainActivity) context; //para recibir el los atributos del mainActivity
        botonPlay = new Imagen(R.drawable.play, 200,1000, this);
        botonIniciar = new Imagen(R.drawable.inicia, 500,1000, this);
        puntero=null;

    }
    protected void onDraw (Canvas c){
        super.onDraw(c);
        Paint p= new Paint();

        imagenFondo =BitmapFactory.decodeResource(getResources(), R.drawable.tituloprincipal);
        //botonPlay =BitmapFactory.decodeResource(getResources(), R.drawable.play);
        //botonIniciar =BitmapFactory.decodeResource(getResources(), R.drawable.inicia);
        bienvenida =BitmapFactory.decodeResource(getResources(), R.drawable.titulobienvenida);
        c.drawBitmap(bienvenida, 50, 5, p);
        c.drawBitmap(imagenFondo, 5, 200, p);
        //c.drawBitmap(botonPlay, 200, 1000, p);
        //c.drawBitmap(botonIniciar, 500, 1000, p);
        botonPlay.pintar(c,p);
        botonIniciar.pintar(c,p);

    }
    public boolean onTouchEvent (MotionEvent e){
        float xp=e.getX();
        float yp=e.getY();

        switch(e.getAction()){
            case MotionEvent.ACTION_DOWN:
                if(botonIniciar.estaEnArea(xp,yp)){
                    puntero=botonIniciar;
                    Intent otraVentana = new Intent(p1, Main3Activity.class);
                    p1.startActivity(otraVentana);

                }
                if(botonPlay.estaEnArea(xp,yp)){
                    puntero=botonPlay;
                    Intent otraVentana = new Intent(p1, Main2Activity.class);
                    p1.startActivity(otraVentana);
                }
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        invalidate();
        return false;
    }
}
