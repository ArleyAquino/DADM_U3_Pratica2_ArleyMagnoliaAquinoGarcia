package mx.edu.ittepic.dadm_u3_ejercicio3_arleyaquino;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.CountDownTimer;

public class Imagen2 {
    private Bitmap icono;
    private float x, y;
    private boolean visible;
    private CountDownTimer timer;


    public Imagen2(int resource, float _x, float _y, Lienzo2 l ){
        icono =BitmapFactory.decodeResource(l.getResources(), resource);
        x=_x;
        y=_y;
        visible = true;

    }
    public void hacerVisible(boolean v){
        visible=v;
    }
    public  void pintar (Canvas c, Paint p){
        if (visible) c.drawBitmap(icono, x, y, p); //si visible es igual a verdadero dibuja

    }

    public boolean estaEnArea(float xp, float yp){
        if (!visible) return false;
        float x2, y2;
        x2=x+icono.getWidth();
        y2=y+icono.getHeight();

        if(xp>=x && xp<x2){
            if(yp>=y && yp<y2){

                return true;
            }
        }
        return false;
    }

}
