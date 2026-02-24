package c2;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.opengl.GLSurfaceView;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.WindowManager;
import androidx.activity.e;
import j1.l0;
import java.util.concurrent.CopyOnWriteArrayList;

public final class m extends GLSurfaceView {

    /* renamed from: s  reason: collision with root package name */
    public static final /* synthetic */ int f2779s = 0;

    /* renamed from: h  reason: collision with root package name */
    public final CopyOnWriteArrayList f2780h = new CopyOnWriteArrayList();

    /* renamed from: i  reason: collision with root package name */
    public final SensorManager f2781i;

    /* renamed from: j  reason: collision with root package name */
    public final Sensor f2782j;

    /* renamed from: k  reason: collision with root package name */
    public final e f2783k;

    /* renamed from: l  reason: collision with root package name */
    public final Handler f2784l = new Handler(Looper.getMainLooper());

    /* renamed from: m  reason: collision with root package name */
    public final k f2785m;

    /* renamed from: n  reason: collision with root package name */
    public SurfaceTexture f2786n;

    /* renamed from: o  reason: collision with root package name */
    public Surface f2787o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f2788p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f2789q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f2790r;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public m(Context context) {
        super(context, (AttributeSet) null);
        Sensor sensor = null;
        Object systemService = context.getSystemService("sensor");
        systemService.getClass();
        SensorManager sensorManager = (SensorManager) systemService;
        this.f2781i = sensorManager;
        sensor = l0.f8453a >= 18 ? sensorManager.getDefaultSensor(15) : sensor;
        this.f2782j = sensor == null ? sensorManager.getDefaultSensor(11) : sensor;
        k kVar = new k();
        this.f2785m = kVar;
        l lVar = new l(this, kVar);
        n nVar = new n(context, lVar);
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        windowManager.getClass();
        this.f2783k = new e(windowManager.getDefaultDisplay(), nVar, lVar);
        this.f2788p = true;
        setEGLContextClientVersion(2);
        setRenderer(lVar);
        setOnTouchListener(nVar);
    }

    public final void a() {
        boolean z10 = this.f2788p && this.f2789q;
        Sensor sensor = this.f2782j;
        if (sensor != null && z10 != this.f2790r) {
            e eVar = this.f2783k;
            SensorManager sensorManager = this.f2781i;
            if (z10) {
                sensorManager.registerListener(eVar, sensor, 0);
            } else {
                sensorManager.unregisterListener(eVar);
            }
            this.f2790r = z10;
        }
    }

    public a getCameraMotionListener() {
        return this.f2785m;
    }

    public b2.m getVideoFrameMetadataListener() {
        return this.f2785m;
    }

    public Surface getVideoSurface() {
        return this.f2787o;
    }

    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f2784l.post(new e(13, this));
    }

    public final void onPause() {
        this.f2789q = false;
        a();
        super.onPause();
    }

    public final void onResume() {
        super.onResume();
        this.f2789q = true;
        a();
    }

    public void setDefaultStereoMode(int i10) {
        this.f2785m.f2765r = i10;
    }

    public void setUseSensorRotation(boolean z10) {
        this.f2788p = z10;
        a();
    }
}
