package mx.edu.ittepic.dadm_u3_ejercicio3_arleyaquino;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.view.MotionEvent;
import android.view.View;

public class Lienzo2 extends View {
    Bitmap  tituloP3;
    Imagen2 a1, a2, a3, a4, a5, a6, regresar;
    Main3Activity p3;
    MediaPlayer au1, au2, au3, au4, au5, au6;
    public Lienzo2(Context context) {
        super(context);
        p3 = (Main3Activity) context;
        a1 = new Imagen2(R.drawable.aamarillo, 100,200, this);
        a2 = new Imagen2(R.drawable.aazul, 100,500, this);
        a3 = new Imagen2(R.drawable.arosa, 100,800, this);
        a4 = new Imagen2(R.drawable.averde, 500,200, this);
        a5 = new Imagen2(R.drawable.arojo, 500,500, this);
        a6 = new Imagen2(R.drawable.anaranja, 500,800, this);
        regresar = new Imagen2 (R.drawable.regresar, 100, 1150, this);



    }
    protected void onDraw (Canvas c){
        super.onDraw(c);
        Paint p= new Paint();
        tituloP3 =BitmapFactory.decodeResource(getResources(), R.drawable.titulopantalla3);
        c.drawBitmap(tituloP3, 50, 5, p);
        a1.pintar(c,p);
        a2.pintar(c,p);
        a3.pintar(c,p);
        a4.pintar(c,p);
        a5.pintar(c,p);
        a6.pintar(c,p);
        regresar.pintar(c,p);
    }
    public boolean onTouchEvent (MotionEvent e){
        float xp=e.getX();
        float yp=e.getY();

        switch (e.getAction()){
            case MotionEvent.ACTION_DOWN: //evento cuando se presiona
                if(regresar.estaEnArea(xp,yp)){
                    Intent otraVentana = new Intent(p3, MainActivity.class);
                    p3.startActivity(otraVentana);
                }
                if(a1.estaEnArea(xp,yp)){
                    au1= MediaPlayer.create(p3,R.raw.yelow);
                    au1.start();

                }
                if(a2.estaEnArea(xp,yp)){
                    au2= MediaPlayer.create(p3,R.raw.blue);
                    au2.start();

                }
                if(a3.estaEnArea(xp,yp)){
                    au3= MediaPlayer.create(p3,R.raw.pink);
                    au3.start();
                }
                if(a4.estaEnArea(xp,yp)){
                    au4= MediaPlayer.create(p3,R.raw.green);
                    au4.start();
                }
                if(a5.estaEnArea(xp,yp)){
                    au5= MediaPlayer.create(p3,R.raw.red);
                    au5.start();
                }
                if(a6.estaEnArea(xp,yp)){
                    au6= MediaPlayer.create(p3,R.raw.orange);
                    au6.start();
                }
                break;
            case MotionEvent.ACTION_MOVE://evento cuando mueves

                break;
            case MotionEvent.ACTION_UP: //evento cuando suelto

                break;
        }
        invalidate();
        return  true;
    }
}
