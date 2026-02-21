package l;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.LayoutInflater;

public final class f extends ContextWrapper {

    /* renamed from: f  reason: collision with root package name */
    public static Configuration f9434f;

    /* renamed from: a  reason: collision with root package name */
    public int f9435a;

    /* renamed from: b  reason: collision with root package name */
    public Resources.Theme f9436b;

    /* renamed from: c  reason: collision with root package name */
    public LayoutInflater f9437c;

    /* renamed from: d  reason: collision with root package name */
    public Configuration f9438d;

    /* renamed from: e  reason: collision with root package name */
    public Resources f9439e;

    public f() {
        super((Context) null);
    }

    public final void a(Configuration configuration) {
        if (this.f9439e != null) {
            throw new IllegalStateException("getResources() or getAssets() has already been called");
        } else if (this.f9438d == null) {
            this.f9438d = new Configuration(configuration);
        } else {
            throw new IllegalStateException("Override configuration has already been set");
        }
    }

    public final void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public final void b() {
        boolean z10;
        if (this.f9436b == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            this.f9436b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f9436b.setTo(theme);
            }
        }
        this.f9436b.applyStyle(this.f9435a, true);
    }

    public final AssetManager getAssets() {
        return getResources().getAssets();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0022, code lost:
        if (r0.equals(f9434f) != false) goto L_0x0030;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.content.res.Resources getResources() {
        /*
            r3 = this;
            android.content.res.Resources r0 = r3.f9439e
            if (r0 != 0) goto L_0x0036
            android.content.res.Configuration r0 = r3.f9438d
            if (r0 == 0) goto L_0x0030
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 26
            if (r1 < r2) goto L_0x0025
            android.content.res.Configuration r1 = f9434f
            if (r1 != 0) goto L_0x001c
            android.content.res.Configuration r1 = new android.content.res.Configuration
            r1.<init>()
            r2 = 0
            r1.fontScale = r2
            f9434f = r1
        L_0x001c:
            android.content.res.Configuration r1 = f9434f
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0025
            goto L_0x0030
        L_0x0025:
            android.content.res.Configuration r0 = r3.f9438d
            android.content.Context r0 = l.e.a(r3, r0)
            android.content.res.Resources r0 = r0.getResources()
            goto L_0x0034
        L_0x0030:
            android.content.res.Resources r0 = super.getResources()
        L_0x0034:
            r3.f9439e = r0
        L_0x0036:
            android.content.res.Resources r0 = r3.f9439e
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: l.f.getResources():android.content.res.Resources");
    }

    public final Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.f9437c == null) {
            this.f9437c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f9437c;
    }

    public final Resources.Theme getTheme() {
        Resources.Theme theme = this.f9436b;
        if (theme != null) {
            return theme;
        }
        if (this.f9435a == 0) {
            this.f9435a = 2132017816;
        }
        b();
        return this.f9436b;
    }

    public final void setTheme(int i10) {
        if (this.f9435a != i10) {
            this.f9435a = i10;
            b();
        }
    }

    public f(Context context, int i10) {
        super(context);
        this.f9435a = i10;
    }

    public f(Context context, Resources.Theme theme) {
        super(context);
        this.f9436b = theme;
    }
}
