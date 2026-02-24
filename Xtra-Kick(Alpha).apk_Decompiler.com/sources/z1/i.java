package z1;

import android.content.Context;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.view.Display;
import android.view.WindowManager;
import android.view.accessibility.CaptioningManager;
import d9.r0;
import g1.w1;
import g1.x1;
import g1.y1;
import j1.l0;
import j1.v;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public final class i extends x1 {
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean E;
    public boolean F;
    public boolean G;
    public boolean H;
    public boolean I;
    public boolean J;
    public boolean K;
    public boolean L;
    public boolean M;
    public final SparseArray N;
    public final SparseBooleanArray O;

    @Deprecated
    public i() {
        this.N = new SparseArray();
        this.O = new SparseBooleanArray();
        l();
    }

    public final void a(w1 w1Var) {
        this.f6714y.put(w1Var.f6686h, w1Var);
    }

    public final x1 c() {
        super.c();
        return this;
    }

    public final x1 d(int i10) {
        super.d(i10);
        return this;
    }

    public final x1 g() {
        this.f6710u = -3;
        return this;
    }

    public final x1 h(w1 w1Var) {
        super.h(w1Var);
        return this;
    }

    public final x1 i(int i10, boolean z10) {
        super.i(i10, z10);
        return this;
    }

    public final x1 j(int i10, int i11) {
        super.j(i10, i11);
        return this;
    }

    /* renamed from: k */
    public final j b() {
        return new j(this);
    }

    public final void l() {
        this.A = true;
        this.B = false;
        this.C = true;
        this.D = false;
        this.E = true;
        this.F = false;
        this.G = false;
        this.H = false;
        this.I = false;
        this.J = true;
        this.K = true;
        this.L = false;
        this.M = true;
    }

    public final void m(Context context) {
        CaptioningManager captioningManager;
        String str;
        int i10 = l0.f8453a;
        if (i10 < 19) {
            return;
        }
        if ((i10 >= 23 || Looper.myLooper() != null) && (captioningManager = (CaptioningManager) context.getSystemService("captioning")) != null && captioningManager.isEnabled()) {
            this.f6709t = 1088;
            Locale locale = captioningManager.getLocale();
            if (locale != null) {
                if (i10 >= 21) {
                    str = locale.toLanguageTag();
                } else {
                    str = locale.toString();
                }
                this.f6708s = r0.n(str);
            }
        }
    }

    public final void n(Context context) {
        Display display;
        Point point;
        String str;
        DisplayManager displayManager;
        int i10 = l0.f8453a;
        String str2 = null;
        if (i10 < 17 || (displayManager = (DisplayManager) context.getSystemService("display")) == null) {
            display = null;
        } else {
            display = displayManager.getDisplay(0);
        }
        if (display == null) {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            windowManager.getClass();
            display = windowManager.getDefaultDisplay();
        }
        if (display.getDisplayId() == 0 && l0.F(context)) {
            if (i10 < 28) {
                str = "sys.display-size";
            } else {
                str = "vendor.display-size";
            }
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                str2 = (String) cls.getMethod("get", new Class[]{String.class}).invoke(cls, new Object[]{str});
            } catch (Exception e10) {
                v.d("Util", "Failed to read system property ".concat(str), e10);
            }
            if (!TextUtils.isEmpty(str2)) {
                try {
                    String[] split = str2.trim().split("x", -1);
                    if (split.length == 2) {
                        int parseInt = Integer.parseInt(split[0]);
                        int parseInt2 = Integer.parseInt(split[1]);
                        if (parseInt > 0 && parseInt2 > 0) {
                            point = new Point(parseInt, parseInt2);
                            j(point.x, point.y);
                        }
                    }
                } catch (NumberFormatException unused) {
                }
                v.c("Util", "Invalid display size: " + str2);
            }
            if ("Sony".equals(l0.f8455c) && l0.f8456d.startsWith("BRAVIA") && context.getPackageManager().hasSystemFeature("com.sony.dtv.hardware.panel.qfhd")) {
                point = new Point(3840, 2160);
                j(point.x, point.y);
            }
        }
        point = new Point();
        if (i10 >= 23) {
            Display.Mode k10 = display.getMode();
            point.x = k10.getPhysicalWidth();
            point.y = k10.getPhysicalHeight();
        } else if (i10 >= 17) {
            display.getRealSize(point);
        } else {
            display.getSize(point);
        }
        j(point.x, point.y);
    }

    public i(Context context) {
        m(context);
        n(context);
        this.N = new SparseArray();
        this.O = new SparseBooleanArray();
        l();
    }

    public i(j jVar) {
        super((y1) jVar);
        this.A = jVar.f17418i0;
        this.B = jVar.f17419j0;
        this.C = jVar.f17420k0;
        this.D = jVar.f17421l0;
        this.E = jVar.f17422m0;
        this.F = jVar.f17423n0;
        this.G = jVar.f17424o0;
        this.H = jVar.f17425p0;
        this.I = jVar.f17426q0;
        this.J = jVar.f17427r0;
        this.K = jVar.f17428s0;
        this.L = jVar.f17429t0;
        this.M = jVar.f17430u0;
        SparseArray sparseArray = new SparseArray();
        int i10 = 0;
        while (true) {
            SparseArray sparseArray2 = jVar.f17431v0;
            if (i10 < sparseArray2.size()) {
                sparseArray.put(sparseArray2.keyAt(i10), new HashMap((Map) sparseArray2.valueAt(i10)));
                i10++;
            } else {
                this.N = sparseArray;
                this.O = jVar.f17432w0.clone();
                return;
            }
        }
    }
}
