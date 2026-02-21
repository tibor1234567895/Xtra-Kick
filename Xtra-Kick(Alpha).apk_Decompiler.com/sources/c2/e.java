package c2;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.opengl.Matrix;
import android.view.Display;

public final class e implements SensorEventListener {

    /* renamed from: a  reason: collision with root package name */
    public final float[] f2731a = new float[16];

    /* renamed from: b  reason: collision with root package name */
    public final float[] f2732b = new float[16];

    /* renamed from: c  reason: collision with root package name */
    public final float[] f2733c = new float[16];

    /* renamed from: d  reason: collision with root package name */
    public final float[] f2734d = new float[3];

    /* renamed from: e  reason: collision with root package name */
    public final Display f2735e;

    /* renamed from: f  reason: collision with root package name */
    public final d[] f2736f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f2737g;

    public e(Display display, d... dVarArr) {
        this.f2735e = display;
        this.f2736f = dVarArr;
    }

    public final void onAccuracyChanged(Sensor sensor, int i10) {
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        int i10;
        float[] fArr = sensorEvent.values;
        float[] fArr2 = this.f2731a;
        SensorManager.getRotationMatrixFromVector(fArr2, fArr);
        int rotation = this.f2735e.getRotation();
        float[] fArr3 = this.f2732b;
        if (rotation != 0) {
            int i11 = 129;
            if (rotation != 1) {
                i10 = 130;
                if (rotation != 2) {
                    if (rotation == 3) {
                        i11 = 130;
                        i10 = 1;
                    } else {
                        throw new IllegalStateException();
                    }
                }
            } else {
                i11 = 2;
                i10 = 129;
            }
            System.arraycopy(fArr2, 0, fArr3, 0, fArr3.length);
            SensorManager.remapCoordinateSystem(fArr3, i11, i10, fArr2);
        }
        SensorManager.remapCoordinateSystem(fArr2, 1, 131, fArr3);
        float[] fArr4 = this.f2734d;
        SensorManager.getOrientation(fArr3, fArr4);
        float f10 = fArr4[2];
        Matrix.rotateM(this.f2731a, 0, 90.0f, 1.0f, 0.0f, 0.0f);
        float[] fArr5 = this.f2731a;
        if (!this.f2737g) {
            c.a(this.f2733c, fArr5);
            this.f2737g = true;
        }
        System.arraycopy(fArr5, 0, fArr3, 0, fArr3.length);
        Matrix.multiplyMM(fArr5, 0, this.f2732b, 0, this.f2733c, 0);
        for (d a10 : this.f2736f) {
            a10.a(fArr2, f10);
        }
    }
}
