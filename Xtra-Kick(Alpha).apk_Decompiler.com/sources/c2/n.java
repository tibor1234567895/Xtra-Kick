package c2;

import android.content.Context;
import android.graphics.PointF;
import android.opengl.Matrix;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public final class n extends GestureDetector.SimpleOnGestureListener implements View.OnTouchListener, d {

    /* renamed from: h  reason: collision with root package name */
    public final PointF f2791h = new PointF();

    /* renamed from: i  reason: collision with root package name */
    public final PointF f2792i = new PointF();

    /* renamed from: j  reason: collision with root package name */
    public final l f2793j;

    /* renamed from: k  reason: collision with root package name */
    public final float f2794k;

    /* renamed from: l  reason: collision with root package name */
    public final GestureDetector f2795l;

    /* renamed from: m  reason: collision with root package name */
    public volatile float f2796m;

    public n(Context context, l lVar) {
        this.f2793j = lVar;
        this.f2794k = 25.0f;
        this.f2795l = new GestureDetector(context, this);
        this.f2796m = 3.1415927f;
    }

    public final void a(float[] fArr, float f10) {
        this.f2796m = -f10;
    }

    public final boolean onDown(MotionEvent motionEvent) {
        this.f2791h.set(motionEvent.getX(), motionEvent.getY());
        return true;
    }

    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f10, float f11) {
        float x10 = (motionEvent2.getX() - this.f2791h.x) / this.f2794k;
        float y10 = motionEvent2.getY();
        PointF pointF = this.f2791h;
        float f12 = (y10 - pointF.y) / this.f2794k;
        pointF.set(motionEvent2.getX(), motionEvent2.getY());
        double d10 = (double) this.f2796m;
        float cos = (float) Math.cos(d10);
        float sin = (float) Math.sin(d10);
        PointF pointF2 = this.f2792i;
        pointF2.x -= (cos * x10) - (sin * f12);
        float f13 = (cos * f12) + (sin * x10) + pointF2.y;
        pointF2.y = f13;
        pointF2.y = Math.max(-45.0f, Math.min(45.0f, f13));
        l lVar = this.f2793j;
        PointF pointF3 = this.f2792i;
        synchronized (lVar) {
            float f14 = pointF3.y;
            lVar.f2774n = f14;
            Matrix.setRotateM(lVar.f2772l, 0, -f14, (float) Math.cos((double) lVar.f2775o), (float) Math.sin((double) lVar.f2775o), 0.0f);
            Matrix.setRotateM(lVar.f2773m, 0, -pointF3.x, 0.0f, 1.0f, 0.0f);
        }
        return true;
    }

    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        return this.f2793j.f2778r.performClick();
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f2795l.onTouchEvent(motionEvent);
    }
}
