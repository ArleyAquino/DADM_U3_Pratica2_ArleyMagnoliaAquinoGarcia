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

public class Lienzo1 extends View {
    Bitmap tituloP2;
    Main2Activity p2;
    Imagen1  c1, c2, c3, tr, tv, ta, puntero, regresar, establecer;
    Canvas c; Paint p;
    public Lienzo1(Context context) {
        super(context);
        p2 = (Main2Activity) context;
        c1= new Imagen1(R.drawable.verde, 50,200, this);
        c2= new Imagen1(R.drawable.rojo, 50,500, this);
        c3= new Imagen1(R.drawable.azul, 50,800, this);
        tr= new Imagen1(R.drawable.trojo, 650,250, this);
        tv= new Imagen1(R.drawable.tverde, 650,550, this);
        ta= new Imagen1(R.drawable.tazul, 650,850, this);
        regresar = new Imagen1 (R.drawable.regresar, 100, 1150, this);
        establecer = new Imagen1 (R.drawable.establecer, 375, 1150, this);
        puntero=null;
    }
    protected void onDraw (Canvas c){
        super.onDraw(c);
        Paint p= new Paint();
        tituloP2 =BitmapFactory.decodeResource(getResources(), R.drawable.titulopantalla2);
        c.drawBitmap(tituloP2, 50, 5, p);


        c1.pintar(c,p);
        c2.pintar(c,p);
        c3.pintar(c,p);
        tr.pintar(c,p);
        tv.pintar(c,p);
        ta.pintar(c,p);
        regresar.pintar(c,p);
        establecer.pintar(c,p);
    }
    public boolean onTouchEvent (MotionEvent e){
        float xp=e.getX();
        float yp=e.getY();

        switch (e.getAction()){
            case MotionEvent.ACTION_DOWN: //evento cuando presiono
                if(regresar.estaEnArea(xp,yp)){
                    Intent otraVentana = new Intent(p2, MainActivity.class);
                    p2.startActivity(otraVentana);
                }
                if(establecer.estaEnArea(xp,yp)){
                    tr= new Imagen1(R.drawable.trojo, 650,250, this);
                    tv= new Imagen1(R.drawable.tverde, 650,550, this);
                    ta= new Imagen1(R.drawable.tazul, 650,850, this);

                }
                if(tr.estaEnArea(xp,yp)){
                    puntero=tr;
                }
                if(tv.estaEnArea(xp,yp)){
                    puntero=tv;
                }
                if(ta.estaEnArea(xp,yp)){
                    puntero=ta;
                }
                break;
            case MotionEvent.ACTION_MOVE://evento cuando mueves
                if(puntero!=null){
                    puntero.mover(xp, yp);
                    if(puntero.colision(c2) && puntero ==tr){
                        tr.hacerVisible(false);
                    }
                    if(puntero.colision(c1) && puntero ==tv){
                        tv.hacerVisible(false);
                    }
                    if(puntero.colision(c3) && puntero ==ta){
                        ta.hacerVisible(false);
                    }
                }
                break;
            case MotionEvent.ACTION_UP: //evento cuando suelto
                puntero=null;
                break;
        }
        invalidate();
        return  true;
    }
}
