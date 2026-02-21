package g;

import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.media.session.u;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.app.a;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.d5;
import androidx.appcompat.widget.e2;
import androidx.appcompat.widget.h;
import androidx.appcompat.widget.h0;
import androidx.appcompat.widget.l5;
import androidx.appcompat.widget.n;
import com.woxthebox.draglistview.R;
import i0.i;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.WeakHashMap;
import l.c;
import l.f;
import l.l;
import m.m;
import m.o;
import m0.c1;
import m0.i0;
import m0.l0;
import m0.n1;
import m0.o0;
import q.k;

public final class k0 extends t implements m, LayoutInflater.Factory2 {

    /* renamed from: p0  reason: collision with root package name */
    public static final k f6147p0 = new k();

    /* renamed from: q0  reason: collision with root package name */
    public static final int[] f6148q0 = {16842836};

    /* renamed from: r0  reason: collision with root package name */
    public static final boolean f6149r0 = (!"robolectric".equals(Build.FINGERPRINT));

    /* renamed from: s0  reason: collision with root package name */
    public static final boolean f6150s0 = true;
    public v A;
    public c B;
    public ActionBarContextView C;
    public PopupWindow D;
    public u E;
    public n1 F = null;
    public final boolean G = true;
    public boolean H;
    public ViewGroup I;
    public TextView J;
    public View K;
    public boolean L;
    public boolean M;
    public boolean N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public boolean R;
    public boolean S;
    public j0[] T;
    public j0 U;
    public boolean V;
    public boolean W;
    public boolean X;
    public boolean Y;
    public Configuration Z;

    /* renamed from: a0  reason: collision with root package name */
    public final int f6151a0 = -100;

    /* renamed from: b0  reason: collision with root package name */
    public int f6152b0;

    /* renamed from: c0  reason: collision with root package name */
    public int f6153c0;

    /* renamed from: d0  reason: collision with root package name */
    public boolean f6154d0;

    /* renamed from: e0  reason: collision with root package name */
    public f0 f6155e0;

    /* renamed from: f0  reason: collision with root package name */
    public f0 f6156f0;

    /* renamed from: g0  reason: collision with root package name */
    public boolean f6157g0;

    /* renamed from: h0  reason: collision with root package name */
    public int f6158h0;

    /* renamed from: i0  reason: collision with root package name */
    public final u f6159i0 = new u(this, 0);

    /* renamed from: j0  reason: collision with root package name */
    public boolean f6160j0;

    /* renamed from: k0  reason: collision with root package name */
    public Rect f6161k0;

    /* renamed from: l0  reason: collision with root package name */
    public Rect f6162l0;

    /* renamed from: m0  reason: collision with root package name */
    public p0 f6163m0;

    /* renamed from: n0  reason: collision with root package name */
    public OnBackInvokedDispatcher f6164n0;

    /* renamed from: o0  reason: collision with root package name */
    public OnBackInvokedCallback f6165o0;

    /* renamed from: q  reason: collision with root package name */
    public final Object f6166q;

    /* renamed from: r  reason: collision with root package name */
    public final Context f6167r;

    /* renamed from: s  reason: collision with root package name */
    public Window f6168s;

    /* renamed from: t  reason: collision with root package name */
    public e0 f6169t;

    /* renamed from: u  reason: collision with root package name */
    public final p f6170u;

    /* renamed from: v  reason: collision with root package name */
    public b1 f6171v;

    /* renamed from: w  reason: collision with root package name */
    public l f6172w;

    /* renamed from: x  reason: collision with root package name */
    public CharSequence f6173x;

    /* renamed from: y  reason: collision with root package name */
    public e2 f6174y;

    /* renamed from: z  reason: collision with root package name */
    public v f6175z;

    public k0(Context context, Window window, p pVar, Object obj) {
        a aVar;
        this.f6167r = context;
        this.f6170u = pVar;
        this.f6166q = obj;
        if (obj instanceof Dialog) {
            while (true) {
                if (context != null) {
                    if (!(context instanceof a)) {
                        if (!(context instanceof ContextWrapper)) {
                            break;
                        }
                        context = ((ContextWrapper) context).getBaseContext();
                    } else {
                        aVar = (a) context;
                        break;
                    }
                } else {
                    break;
                }
            }
            aVar = null;
            if (aVar != null) {
                this.f6151a0 = aVar.D().h();
            }
        }
        if (this.f6151a0 == -100) {
            k kVar = f6147p0;
            Integer num = (Integer) kVar.getOrDefault(this.f6166q.getClass().getName(), (Object) null);
            if (num != null) {
                this.f6151a0 = num.intValue();
                kVar.remove(this.f6166q.getClass().getName());
            }
        }
        if (window != null) {
            E(window);
        }
        h0.d();
    }

    public static i F(Context context) {
        i iVar;
        i iVar2;
        Locale locale;
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 33 || (iVar = t.f6210j) == null) {
            return null;
        }
        i P2 = P(context.getApplicationContext().getResources().getConfiguration());
        int i11 = 0;
        if (i10 >= 24) {
            if (iVar.d()) {
                iVar2 = i.f7946b;
            } else {
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                while (true) {
                    i0.k kVar = iVar.f7947a;
                    if (i11 >= P2.f7947a.size() + kVar.size()) {
                        break;
                    }
                    if (i11 < kVar.size()) {
                        locale = iVar.c(i11);
                    } else {
                        locale = P2.c(i11 - kVar.size());
                    }
                    if (locale != null) {
                        linkedHashSet.add(locale);
                    }
                    i11++;
                }
                iVar2 = i.a((Locale[]) linkedHashSet.toArray(new Locale[linkedHashSet.size()]));
            }
        } else if (iVar.d()) {
            iVar2 = i.f7946b;
        } else {
            iVar2 = i.b(z.b(iVar.c(0)));
        }
        if (iVar2.d()) {
            return P2;
        }
        return iVar2;
    }

    public static Configuration J(Context context, int i10, i iVar, Configuration configuration, boolean z10) {
        int i11;
        if (i10 == 1) {
            i11 = 16;
        } else if (i10 == 2) {
            i11 = 32;
        } else if (z10) {
            i11 = 0;
        } else {
            i11 = context.getApplicationContext().getResources().getConfiguration().uiMode & 48;
        }
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = 0.0f;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i11 | (configuration2.uiMode & -49);
        if (iVar != null) {
            if (Build.VERSION.SDK_INT >= 24) {
                b0.d(configuration2, iVar);
            } else {
                y.e(configuration2, iVar.c(0));
                y.c(configuration2, iVar.c(0));
            }
        }
        return configuration2;
    }

    public static i P(Configuration configuration) {
        return Build.VERSION.SDK_INT >= 24 ? b0.b(configuration) : i.b(z.b(configuration.locale));
    }

    public final void A(int i10) {
        this.f6152b0 = i10;
    }

    public final void B(CharSequence charSequence) {
        this.f6173x = charSequence;
        e2 e2Var = this.f6174y;
        if (e2Var != null) {
            e2Var.setWindowTitle(charSequence);
            return;
        }
        b1 b1Var = this.f6171v;
        if (b1Var != null) {
            b1Var.g(charSequence);
            return;
        }
        TextView textView = this.J;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:119:0x01b1  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x01e3  */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x0263  */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x026d  */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x0274  */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x0294  */
    /* JADX WARNING: Removed duplicated region for block: B:190:0x029c  */
    /* JADX WARNING: Removed duplicated region for block: B:195:0x02a6  */
    /* JADX WARNING: Removed duplicated region for block: B:199:0x02b7  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00ff A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean D(boolean r18, boolean r19) {
        /*
            r17 = this;
            r1 = r17
            boolean r0 = r1.Y
            r2 = 0
            if (r0 == 0) goto L_0x0008
            return r2
        L_0x0008:
            r0 = -100
            int r3 = r1.f6151a0
            if (r3 == r0) goto L_0x000f
            goto L_0x0011
        L_0x000f:
            int r3 = g.t.f6209i
        L_0x0011:
            android.content.Context r4 = r1.f6167r
            int r0 = r1.T(r4, r3)
            int r5 = android.os.Build.VERSION.SDK_INT
            r6 = 33
            r7 = 0
            if (r5 >= r6) goto L_0x0023
            i0.i r6 = F(r4)
            goto L_0x0024
        L_0x0023:
            r6 = r7
        L_0x0024:
            if (r19 != 0) goto L_0x0034
            if (r6 == 0) goto L_0x0034
            android.content.res.Resources r6 = r4.getResources()
            android.content.res.Configuration r6 = r6.getConfiguration()
            i0.i r6 = P(r6)
        L_0x0034:
            android.content.res.Configuration r0 = J(r4, r0, r6, r7, r2)
            boolean r8 = r1.f6154d0
            r9 = 24
            r10 = 1
            java.lang.Object r11 = r1.f6166q
            if (r8 != 0) goto L_0x0070
            boolean r8 = r11 instanceof android.app.Activity
            if (r8 == 0) goto L_0x0070
            android.content.pm.PackageManager r8 = r4.getPackageManager()
            if (r8 != 0) goto L_0x004d
            r5 = 0
            goto L_0x0074
        L_0x004d:
            r12 = 29
            if (r5 < r12) goto L_0x0054
            r5 = 269221888(0x100c0000, float:2.7610132E-29)
            goto L_0x005a
        L_0x0054:
            if (r5 < r9) goto L_0x0059
            r5 = 786432(0xc0000, float:1.102026E-39)
            goto L_0x005a
        L_0x0059:
            r5 = 0
        L_0x005a:
            android.content.ComponentName r12 = new android.content.ComponentName     // Catch:{ NameNotFoundException -> 0x006e }
            java.lang.Class r13 = r11.getClass()     // Catch:{ NameNotFoundException -> 0x006e }
            r12.<init>(r4, r13)     // Catch:{ NameNotFoundException -> 0x006e }
            android.content.pm.ActivityInfo r5 = r8.getActivityInfo(r12, r5)     // Catch:{ NameNotFoundException -> 0x006e }
            if (r5 == 0) goto L_0x0070
            int r5 = r5.configChanges     // Catch:{ NameNotFoundException -> 0x006e }
            r1.f6153c0 = r5     // Catch:{ NameNotFoundException -> 0x006e }
            goto L_0x0070
        L_0x006e:
            r1.f6153c0 = r2
        L_0x0070:
            r1.f6154d0 = r10
            int r5 = r1.f6153c0
        L_0x0074:
            android.content.res.Configuration r8 = r1.Z
            if (r8 != 0) goto L_0x0080
            android.content.res.Resources r8 = r4.getResources()
            android.content.res.Configuration r8 = r8.getConfiguration()
        L_0x0080:
            int r12 = r8.uiMode
            r12 = r12 & 48
            int r13 = r0.uiMode
            r13 = r13 & 48
            i0.i r8 = P(r8)
            if (r6 != 0) goto L_0x0090
            r6 = r7
            goto L_0x0094
        L_0x0090:
            i0.i r6 = P(r0)
        L_0x0094:
            if (r12 == r13) goto L_0x0099
            r12 = 512(0x200, float:7.175E-43)
            goto L_0x009a
        L_0x0099:
            r12 = 0
        L_0x009a:
            if (r6 == 0) goto L_0x00a6
            boolean r8 = r8.equals(r6)
            if (r8 != 0) goto L_0x00a6
            r8 = r12 | 4
            r12 = r8 | 8192(0x2000, float:1.14794E-41)
        L_0x00a6:
            int r8 = ~r5
            r8 = r8 & r12
            r14 = 3
            r15 = 28
            if (r8 == 0) goto L_0x00fc
            if (r18 == 0) goto L_0x00fc
            boolean r8 = r1.W
            if (r8 == 0) goto L_0x00fc
            boolean r8 = f6149r0
            if (r8 != 0) goto L_0x00bb
            boolean r8 = r1.X
            if (r8 == 0) goto L_0x00fc
        L_0x00bb:
            boolean r8 = r11 instanceof android.app.Activity
            if (r8 == 0) goto L_0x00fc
            r8 = r11
            android.app.Activity r8 = (android.app.Activity) r8
            boolean r16 = r8.isChild()
            if (r16 != 0) goto L_0x00fc
            int r10 = android.os.Build.VERSION.SDK_INT
            r7 = 31
            if (r10 < r7) goto L_0x00e1
            r7 = r12 & 8192(0x2000, float:1.14794E-41)
            if (r7 == 0) goto L_0x00e1
            android.view.Window r7 = r8.getWindow()
            android.view.View r7 = r7.getDecorView()
            int r0 = g.y.b(r0)
            g.y.d(r7, r0)
        L_0x00e1:
            int r0 = b0.e.f2338b
            if (r10 < r15) goto L_0x00e9
            r8.recreate()
            goto L_0x00fa
        L_0x00e9:
            android.os.Handler r0 = new android.os.Handler
            android.os.Looper r7 = r8.getMainLooper()
            r0.<init>(r7)
            androidx.activity.e r7 = new androidx.activity.e
            r7.<init>(r14, r8)
            r0.post(r7)
        L_0x00fa:
            r0 = 1
            goto L_0x00fd
        L_0x00fc:
            r0 = 0
        L_0x00fd:
            if (r0 != 0) goto L_0x0258
            if (r12 == 0) goto L_0x0258
            r0 = r5 & r12
            if (r0 != r12) goto L_0x0107
            r5 = 1
            goto L_0x0108
        L_0x0107:
            r5 = 0
        L_0x0108:
            android.content.res.Resources r7 = r4.getResources()
            android.content.res.Configuration r8 = new android.content.res.Configuration
            android.content.res.Configuration r0 = r7.getConfiguration()
            r8.<init>(r0)
            android.content.res.Configuration r0 = r7.getConfiguration()
            int r0 = r0.uiMode
            r0 = r0 & -49
            r0 = r0 | r13
            r8.uiMode = r0
            if (r6 == 0) goto L_0x0138
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 < r9) goto L_0x012a
            g.b0.d(r8, r6)
            goto L_0x0138
        L_0x012a:
            java.util.Locale r0 = r6.c(r2)
            g.y.e(r8, r0)
            java.util.Locale r0 = r6.c(r2)
            g.y.c(r8, r0)
        L_0x0138:
            r10 = 0
            r7.updateConfiguration(r8, r10)
            int r0 = android.os.Build.VERSION.SDK_INT
            r13 = 26
            r10 = 23
            if (r0 >= r13) goto L_0x0213
            if (r0 < r15) goto L_0x0148
            goto L_0x0213
        L_0x0148:
            java.lang.String r13 = "mDrawableCache"
            java.lang.Class<android.content.res.Resources> r15 = android.content.res.Resources.class
            java.lang.String r14 = "ResourcesFlusher"
            if (r0 < r9) goto L_0x01b5
            boolean r0 = g.w0.f6230h
            if (r0 != 0) goto L_0x016a
            java.lang.String r0 = "mResourcesImpl"
            java.lang.reflect.Field r0 = r15.getDeclaredField(r0)     // Catch:{ NoSuchFieldException -> 0x0161 }
            g.w0.f6229g = r0     // Catch:{ NoSuchFieldException -> 0x0161 }
            r15 = 1
            r0.setAccessible(r15)     // Catch:{ NoSuchFieldException -> 0x0161 }
            goto L_0x0167
        L_0x0161:
            r0 = move-exception
            java.lang.String r15 = "Could not retrieve Resources#mResourcesImpl field"
            android.util.Log.e(r14, r15, r0)
        L_0x0167:
            r15 = 1
            g.w0.f6230h = r15
        L_0x016a:
            java.lang.reflect.Field r0 = g.w0.f6229g
            if (r0 != 0) goto L_0x0170
            goto L_0x0213
        L_0x0170:
            java.lang.Object r0 = r0.get(r7)     // Catch:{ IllegalAccessException -> 0x0176 }
            r7 = r0
            goto L_0x017e
        L_0x0176:
            r0 = move-exception
            r7 = r0
            java.lang.String r0 = "Could not retrieve value from Resources#mResourcesImpl"
            android.util.Log.e(r14, r0, r7)
            r7 = 0
        L_0x017e:
            if (r7 != 0) goto L_0x0182
            goto L_0x0213
        L_0x0182:
            boolean r0 = g.w0.f6224b
            if (r0 != 0) goto L_0x019e
            java.lang.Class r0 = r7.getClass()     // Catch:{ NoSuchFieldException -> 0x0195 }
            java.lang.reflect.Field r0 = r0.getDeclaredField(r13)     // Catch:{ NoSuchFieldException -> 0x0195 }
            g.w0.f6223a = r0     // Catch:{ NoSuchFieldException -> 0x0195 }
            r13 = 1
            r0.setAccessible(r13)     // Catch:{ NoSuchFieldException -> 0x0195 }
            goto L_0x019b
        L_0x0195:
            r0 = move-exception
            java.lang.String r13 = "Could not retrieve ResourcesImpl#mDrawableCache field"
            android.util.Log.e(r14, r13, r0)
        L_0x019b:
            r13 = 1
            g.w0.f6224b = r13
        L_0x019e:
            java.lang.reflect.Field r0 = g.w0.f6223a
            if (r0 == 0) goto L_0x01ae
            java.lang.Object r7 = r0.get(r7)     // Catch:{ IllegalAccessException -> 0x01a7 }
            goto L_0x01af
        L_0x01a7:
            r0 = move-exception
            r7 = r0
            java.lang.String r0 = "Could not retrieve value from ResourcesImpl#mDrawableCache"
            android.util.Log.e(r14, r0, r7)
        L_0x01ae:
            r7 = 0
        L_0x01af:
            if (r7 == 0) goto L_0x0213
            g.w0.a(r7)
            goto L_0x0213
        L_0x01b5:
            java.lang.String r2 = "Could not retrieve Resources#mDrawableCache field"
            java.lang.String r9 = "Could not retrieve value from Resources#mDrawableCache"
            if (r0 < r10) goto L_0x01e7
            boolean r0 = g.w0.f6224b
            if (r0 != 0) goto L_0x01d1
            java.lang.reflect.Field r0 = r15.getDeclaredField(r13)     // Catch:{ NoSuchFieldException -> 0x01ca }
            g.w0.f6223a = r0     // Catch:{ NoSuchFieldException -> 0x01ca }
            r13 = 1
            r0.setAccessible(r13)     // Catch:{ NoSuchFieldException -> 0x01ca }
            goto L_0x01ce
        L_0x01ca:
            r0 = move-exception
            android.util.Log.e(r14, r2, r0)
        L_0x01ce:
            r2 = 1
            g.w0.f6224b = r2
        L_0x01d1:
            java.lang.reflect.Field r0 = g.w0.f6223a
            if (r0 == 0) goto L_0x01df
            java.lang.Object r7 = r0.get(r7)     // Catch:{ IllegalAccessException -> 0x01da }
            goto L_0x01e0
        L_0x01da:
            r0 = move-exception
            r2 = r0
            android.util.Log.e(r14, r9, r2)
        L_0x01df:
            r7 = 0
        L_0x01e0:
            if (r7 != 0) goto L_0x01e3
            goto L_0x0213
        L_0x01e3:
            g.w0.a(r7)
            goto L_0x0213
        L_0x01e7:
            boolean r0 = g.w0.f6224b
            if (r0 != 0) goto L_0x01fd
            java.lang.reflect.Field r0 = r15.getDeclaredField(r13)     // Catch:{ NoSuchFieldException -> 0x01f6 }
            g.w0.f6223a = r0     // Catch:{ NoSuchFieldException -> 0x01f6 }
            r13 = 1
            r0.setAccessible(r13)     // Catch:{ NoSuchFieldException -> 0x01f6 }
            goto L_0x01fa
        L_0x01f6:
            r0 = move-exception
            android.util.Log.e(r14, r2, r0)
        L_0x01fa:
            r2 = 1
            g.w0.f6224b = r2
        L_0x01fd:
            java.lang.reflect.Field r0 = g.w0.f6223a
            if (r0 == 0) goto L_0x0213
            java.lang.Object r0 = r0.get(r7)     // Catch:{ IllegalAccessException -> 0x0209 }
            java.util.Map r0 = (java.util.Map) r0     // Catch:{ IllegalAccessException -> 0x0209 }
            r7 = r0
            goto L_0x020e
        L_0x0209:
            r0 = move-exception
            android.util.Log.e(r14, r9, r0)
            r7 = 0
        L_0x020e:
            if (r7 == 0) goto L_0x0213
            r7.clear()
        L_0x0213:
            int r0 = r1.f6152b0
            if (r0 == 0) goto L_0x0229
            r4.setTheme(r0)
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 < r10) goto L_0x0229
            android.content.res.Resources$Theme r0 = r4.getTheme()
            int r2 = r1.f6152b0
            r7 = 1
            r0.applyStyle(r2, r7)
            goto L_0x022a
        L_0x0229:
            r7 = 1
        L_0x022a:
            if (r5 == 0) goto L_0x0256
            boolean r0 = r11 instanceof android.app.Activity
            if (r0 == 0) goto L_0x0256
            r0 = r11
            android.app.Activity r0 = (android.app.Activity) r0
            boolean r2 = r0 instanceof androidx.lifecycle.d0
            if (r2 == 0) goto L_0x024b
            r2 = r0
            androidx.lifecycle.d0 r2 = (androidx.lifecycle.d0) r2
            androidx.lifecycle.t r2 = r2.o()
            androidx.lifecycle.s r2 = r2.b()
            androidx.lifecycle.s r5 = androidx.lifecycle.s.CREATED
            boolean r2 = r2.a(r5)
            if (r2 == 0) goto L_0x0256
            goto L_0x0253
        L_0x024b:
            boolean r2 = r1.X
            if (r2 == 0) goto L_0x0256
            boolean r2 = r1.Y
            if (r2 != 0) goto L_0x0256
        L_0x0253:
            r0.onConfigurationChanged(r8)
        L_0x0256:
            r10 = 1
            goto L_0x0259
        L_0x0258:
            r10 = r0
        L_0x0259:
            if (r10 == 0) goto L_0x0272
            boolean r0 = r11 instanceof androidx.appcompat.app.a
            if (r0 == 0) goto L_0x0272
            r0 = r12 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x0269
            r0 = r11
            androidx.appcompat.app.a r0 = (androidx.appcompat.app.a) r0
            r0.getClass()
        L_0x0269:
            r0 = r12 & 4
            if (r0 == 0) goto L_0x0272
            androidx.appcompat.app.a r11 = (androidx.appcompat.app.a) r11
            r11.getClass()
        L_0x0272:
            if (r6 == 0) goto L_0x0292
            android.content.res.Resources r0 = r4.getResources()
            android.content.res.Configuration r0 = r0.getConfiguration()
            i0.i r0 = P(r0)
            int r2 = android.os.Build.VERSION.SDK_INT
            r5 = 24
            if (r2 < r5) goto L_0x028a
            g.b0.c(r0)
            goto L_0x0292
        L_0x028a:
            r2 = 0
            java.util.Locale r0 = r0.c(r2)
            java.util.Locale.setDefault(r0)
        L_0x0292:
            if (r3 != 0) goto L_0x029c
            g.h0 r0 = r1.O(r4)
            r0.g()
            goto L_0x02a3
        L_0x029c:
            g.f0 r0 = r1.f6155e0
            if (r0 == 0) goto L_0x02a3
            r0.a()
        L_0x02a3:
            r2 = 3
            if (r3 != r2) goto L_0x02b7
            g.f0 r0 = r1.f6156f0
            if (r0 != 0) goto L_0x02b1
            g.f0 r0 = new g.f0
            r0.<init>((g.k0) r1, (android.content.Context) r4)
            r1.f6156f0 = r0
        L_0x02b1:
            g.f0 r0 = r1.f6156f0
            r0.g()
            goto L_0x02be
        L_0x02b7:
            g.f0 r0 = r1.f6156f0
            if (r0 == 0) goto L_0x02be
            r0.a()
        L_0x02be:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: g.k0.D(boolean, boolean):boolean");
    }

    public final void E(Window window) {
        Drawable drawable;
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        OnBackInvokedCallback onBackInvokedCallback;
        int resourceId;
        if (this.f6168s == null) {
            Window.Callback callback = window.getCallback();
            if (!(callback instanceof e0)) {
                e0 e0Var = new e0(this, callback);
                this.f6169t = e0Var;
                window.setCallback(e0Var);
                Context context = this.f6167r;
                OnBackInvokedDispatcher onBackInvokedDispatcher2 = null;
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, f6148q0);
                if (!obtainStyledAttributes.hasValue(0) || (resourceId = obtainStyledAttributes.getResourceId(0, 0)) == 0) {
                    drawable = null;
                } else {
                    h0 a10 = h0.a();
                    synchronized (a10) {
                        drawable = a10.f845a.g(context, resourceId, true);
                    }
                }
                if (drawable != null) {
                    window.setBackgroundDrawable(drawable);
                }
                obtainStyledAttributes.recycle();
                this.f6168s = window;
                if (Build.VERSION.SDK_INT >= 33 && (onBackInvokedDispatcher = this.f6164n0) == null) {
                    if (!(onBackInvokedDispatcher == null || (onBackInvokedCallback = this.f6165o0) == null)) {
                        d0.c(onBackInvokedDispatcher, onBackInvokedCallback);
                        this.f6165o0 = null;
                    }
                    Object obj = this.f6166q;
                    if (obj instanceof Activity) {
                        Activity activity = (Activity) obj;
                        if (activity.getWindow() != null) {
                            onBackInvokedDispatcher2 = d0.a(activity);
                        }
                    }
                    this.f6164n0 = onBackInvokedDispatcher2;
                    Z();
                    return;
                }
                return;
            }
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        throw new IllegalStateException("AppCompat has already installed itself into the Window");
    }

    /* JADX INFO: finally extract failed */
    public final void G(int i10, j0 j0Var, o oVar) {
        if (oVar == null) {
            if (j0Var == null && i10 >= 0) {
                j0[] j0VarArr = this.T;
                if (i10 < j0VarArr.length) {
                    j0Var = j0VarArr[i10];
                }
            }
            if (j0Var != null) {
                oVar = j0Var.f6112h;
            }
        }
        if ((j0Var == null || j0Var.f6117m) && !this.Y) {
            e0 e0Var = this.f6169t;
            Window.Callback callback = this.f6168s.getCallback();
            e0Var.getClass();
            try {
                e0Var.f6063k = true;
                callback.onPanelClosed(i10, oVar);
                e0Var.f6063k = false;
            } catch (Throwable th) {
                e0Var.f6063k = false;
                throw th;
            }
        }
    }

    public final void H(o oVar) {
        n nVar;
        if (!this.S) {
            this.S = true;
            ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) this.f6174y;
            actionBarOverlayLayout.l();
            ActionMenuView actionMenuView = ((d5) actionBarOverlayLayout.f608l).f791a.f691h;
            if (!(actionMenuView == null || (nVar = actionMenuView.A) == null)) {
                nVar.d();
                h hVar = nVar.B;
                if (hVar != null && hVar.b()) {
                    hVar.f9899j.dismiss();
                }
            }
            Window.Callback R2 = R();
            if (R2 != null && !this.Y) {
                R2.onPanelClosed(108, oVar);
            }
            this.S = false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x002f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void I(g.j0 r6, boolean r7) {
        /*
            r5 = this;
            r0 = 1
            r1 = 0
            if (r7 == 0) goto L_0x0035
            int r2 = r6.f6105a
            if (r2 != 0) goto L_0x0035
            androidx.appcompat.widget.e2 r2 = r5.f6174y
            if (r2 == 0) goto L_0x0035
            androidx.appcompat.widget.ActionBarOverlayLayout r2 = (androidx.appcompat.widget.ActionBarOverlayLayout) r2
            r2.l()
            androidx.appcompat.widget.f2 r2 = r2.f608l
            androidx.appcompat.widget.d5 r2 = (androidx.appcompat.widget.d5) r2
            androidx.appcompat.widget.Toolbar r2 = r2.f791a
            androidx.appcompat.widget.ActionMenuView r2 = r2.f691h
            if (r2 == 0) goto L_0x002c
            androidx.appcompat.widget.n r2 = r2.A
            if (r2 == 0) goto L_0x0027
            boolean r2 = r2.f()
            if (r2 == 0) goto L_0x0027
            r2 = 1
            goto L_0x0028
        L_0x0027:
            r2 = 0
        L_0x0028:
            if (r2 == 0) goto L_0x002c
            r2 = 1
            goto L_0x002d
        L_0x002c:
            r2 = 0
        L_0x002d:
            if (r2 == 0) goto L_0x0035
            m.o r6 = r6.f6112h
            r5.H(r6)
            return
        L_0x0035:
            android.content.Context r2 = r5.f6167r
            java.lang.String r3 = "window"
            java.lang.Object r2 = r2.getSystemService(r3)
            android.view.WindowManager r2 = (android.view.WindowManager) r2
            r3 = 0
            if (r2 == 0) goto L_0x0054
            boolean r4 = r6.f6117m
            if (r4 == 0) goto L_0x0054
            g.i0 r4 = r6.f6109e
            if (r4 == 0) goto L_0x0054
            r2.removeView(r4)
            if (r7 == 0) goto L_0x0054
            int r7 = r6.f6105a
            r5.G(r7, r6, r3)
        L_0x0054:
            r6.f6115k = r1
            r6.f6116l = r1
            r6.f6117m = r1
            r6.f6110f = r3
            r6.f6118n = r0
            g.j0 r7 = r5.U
            if (r7 != r6) goto L_0x0064
            r5.U = r3
        L_0x0064:
            int r6 = r6.f6105a
            if (r6 != 0) goto L_0x006b
            r5.Z()
        L_0x006b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: g.k0.I(g.j0, boolean):void");
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x00ff, code lost:
        if (r7 != false) goto L_0x0129;
     */
    /* JADX WARNING: Removed duplicated region for block: B:106:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00d7  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0133  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean K(android.view.KeyEvent r7) {
        /*
            r6 = this;
            java.lang.Object r0 = r6.f6166q
            boolean r1 = r0 instanceof m0.n
            r2 = 1
            if (r1 != 0) goto L_0x000b
            boolean r0 = r0 instanceof g.m0
            if (r0 == 0) goto L_0x001a
        L_0x000b:
            android.view.Window r0 = r6.f6168s
            android.view.View r0 = r0.getDecorView()
            if (r0 == 0) goto L_0x001a
            boolean r0 = m0.o.a(r0, r7)
            if (r0 == 0) goto L_0x001a
            return r2
        L_0x001a:
            int r0 = r7.getKeyCode()
            r1 = 0
            r3 = 82
            if (r0 != r3) goto L_0x003d
            g.e0 r0 = r6.f6169t
            android.view.Window r4 = r6.f6168s
            android.view.Window$Callback r4 = r4.getCallback()
            r0.getClass()
            r0.f6062j = r2     // Catch:{ all -> 0x0039 }
            boolean r4 = r4.dispatchKeyEvent(r7)     // Catch:{ all -> 0x0039 }
            r0.f6062j = r1
            if (r4 == 0) goto L_0x003d
            return r2
        L_0x0039:
            r7 = move-exception
            r0.f6062j = r1
            throw r7
        L_0x003d:
            int r0 = r7.getKeyCode()
            int r4 = r7.getAction()
            if (r4 != 0) goto L_0x0049
            r4 = 1
            goto L_0x004a
        L_0x0049:
            r4 = 0
        L_0x004a:
            r5 = 4
            if (r4 == 0) goto L_0x0074
            if (r0 == r5) goto L_0x0066
            if (r0 == r3) goto L_0x0053
            goto L_0x0154
        L_0x0053:
            int r0 = r7.getRepeatCount()
            if (r0 != 0) goto L_0x0155
            g.j0 r0 = r6.Q(r1)
            boolean r1 = r0.f6117m
            if (r1 != 0) goto L_0x0155
            r6.X(r0, r7)
            goto L_0x0155
        L_0x0066:
            int r7 = r7.getFlags()
            r7 = r7 & 128(0x80, float:1.794E-43)
            if (r7 == 0) goto L_0x006f
            goto L_0x0070
        L_0x006f:
            r2 = 0
        L_0x0070:
            r6.V = r2
            goto L_0x0154
        L_0x0074:
            if (r0 == r5) goto L_0x014d
            if (r0 == r3) goto L_0x007a
            goto L_0x0154
        L_0x007a:
            l.c r0 = r6.B
            if (r0 == 0) goto L_0x0080
            goto L_0x0155
        L_0x0080:
            g.j0 r0 = r6.Q(r1)
            androidx.appcompat.widget.e2 r3 = r6.f6174y
            android.content.Context r4 = r6.f6167r
            if (r3 == 0) goto L_0x010b
            androidx.appcompat.widget.ActionBarOverlayLayout r3 = (androidx.appcompat.widget.ActionBarOverlayLayout) r3
            r3.l()
            androidx.appcompat.widget.f2 r3 = r3.f608l
            androidx.appcompat.widget.d5 r3 = (androidx.appcompat.widget.d5) r3
            androidx.appcompat.widget.Toolbar r3 = r3.f791a
            int r5 = r3.getVisibility()
            if (r5 != 0) goto L_0x00a5
            androidx.appcompat.widget.ActionMenuView r3 = r3.f691h
            if (r3 == 0) goto L_0x00a5
            boolean r3 = r3.f626z
            if (r3 == 0) goto L_0x00a5
            r3 = 1
            goto L_0x00a6
        L_0x00a5:
            r3 = 0
        L_0x00a6:
            if (r3 == 0) goto L_0x010b
            android.view.ViewConfiguration r3 = android.view.ViewConfiguration.get(r4)
            boolean r3 = r3.hasPermanentMenuKey()
            if (r3 != 0) goto L_0x010b
            androidx.appcompat.widget.e2 r3 = r6.f6174y
            androidx.appcompat.widget.ActionBarOverlayLayout r3 = (androidx.appcompat.widget.ActionBarOverlayLayout) r3
            r3.l()
            androidx.appcompat.widget.f2 r3 = r3.f608l
            androidx.appcompat.widget.d5 r3 = (androidx.appcompat.widget.d5) r3
            androidx.appcompat.widget.Toolbar r3 = r3.f791a
            androidx.appcompat.widget.ActionMenuView r3 = r3.f691h
            if (r3 == 0) goto L_0x00d4
            androidx.appcompat.widget.n r3 = r3.A
            if (r3 == 0) goto L_0x00cf
            boolean r3 = r3.f()
            if (r3 == 0) goto L_0x00cf
            r3 = 1
            goto L_0x00d0
        L_0x00cf:
            r3 = 0
        L_0x00d0:
            if (r3 == 0) goto L_0x00d4
            r3 = 1
            goto L_0x00d5
        L_0x00d4:
            r3 = 0
        L_0x00d5:
            if (r3 != 0) goto L_0x0102
            boolean r3 = r6.Y
            if (r3 != 0) goto L_0x012b
            boolean r7 = r6.X(r0, r7)
            if (r7 == 0) goto L_0x012b
            androidx.appcompat.widget.e2 r7 = r6.f6174y
            androidx.appcompat.widget.ActionBarOverlayLayout r7 = (androidx.appcompat.widget.ActionBarOverlayLayout) r7
            r7.l()
            androidx.appcompat.widget.f2 r7 = r7.f608l
            androidx.appcompat.widget.d5 r7 = (androidx.appcompat.widget.d5) r7
            androidx.appcompat.widget.Toolbar r7 = r7.f791a
            androidx.appcompat.widget.ActionMenuView r7 = r7.f691h
            if (r7 == 0) goto L_0x012b
            androidx.appcompat.widget.n r7 = r7.A
            if (r7 == 0) goto L_0x00fe
            boolean r7 = r7.n()
            if (r7 == 0) goto L_0x00fe
            r7 = 1
            goto L_0x00ff
        L_0x00fe:
            r7 = 0
        L_0x00ff:
            if (r7 == 0) goto L_0x012b
            goto L_0x0129
        L_0x0102:
            androidx.appcompat.widget.e2 r7 = r6.f6174y
            androidx.appcompat.widget.ActionBarOverlayLayout r7 = (androidx.appcompat.widget.ActionBarOverlayLayout) r7
            boolean r7 = r7.i()
            goto L_0x0131
        L_0x010b:
            boolean r3 = r0.f6117m
            if (r3 != 0) goto L_0x012d
            boolean r5 = r0.f6116l
            if (r5 == 0) goto L_0x0114
            goto L_0x012d
        L_0x0114:
            boolean r3 = r0.f6115k
            if (r3 == 0) goto L_0x012b
            boolean r3 = r0.f6119o
            if (r3 == 0) goto L_0x0123
            r0.f6115k = r1
            boolean r3 = r6.X(r0, r7)
            goto L_0x0124
        L_0x0123:
            r3 = 1
        L_0x0124:
            if (r3 == 0) goto L_0x012b
            r6.V(r0, r7)
        L_0x0129:
            r7 = 1
            goto L_0x0131
        L_0x012b:
            r7 = 0
            goto L_0x0131
        L_0x012d:
            r6.I(r0, r2)
            r7 = r3
        L_0x0131:
            if (r7 == 0) goto L_0x0155
            android.content.Context r7 = r4.getApplicationContext()
            java.lang.String r0 = "audio"
            java.lang.Object r7 = r7.getSystemService(r0)
            android.media.AudioManager r7 = (android.media.AudioManager) r7
            if (r7 == 0) goto L_0x0145
            r7.playSoundEffect(r1)
            goto L_0x0155
        L_0x0145:
            java.lang.String r7 = "AppCompatDelegate"
            java.lang.String r0 = "Couldn't get audio manager"
            android.util.Log.w(r7, r0)
            goto L_0x0155
        L_0x014d:
            boolean r7 = r6.U()
            if (r7 == 0) goto L_0x0154
            goto L_0x0155
        L_0x0154:
            r2 = 0
        L_0x0155:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: g.k0.K(android.view.KeyEvent):boolean");
    }

    public final void L(int i10) {
        j0 Q2 = Q(i10);
        if (Q2.f6112h != null) {
            Bundle bundle = new Bundle();
            Q2.f6112h.t(bundle);
            if (bundle.size() > 0) {
                Q2.f6120p = bundle;
            }
            Q2.f6112h.x();
            Q2.f6112h.clear();
        }
        Q2.f6119o = true;
        Q2.f6118n = true;
        if ((i10 == 108 || i10 == 0) && this.f6174y != null) {
            j0 Q3 = Q(0);
            Q3.f6115k = false;
            X(Q3, (KeyEvent) null);
        }
    }

    public final void M() {
        ViewGroup viewGroup;
        CharSequence charSequence;
        int i10;
        Context context;
        if (!this.H) {
            int[] iArr = f.a.f5401k;
            Context context2 = this.f6167r;
            TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(iArr);
            if (obtainStyledAttributes.hasValue(117)) {
                if (obtainStyledAttributes.getBoolean(126, false)) {
                    v(1);
                } else if (obtainStyledAttributes.getBoolean(117, false)) {
                    v(108);
                }
                if (obtainStyledAttributes.getBoolean(118, false)) {
                    v(109);
                }
                if (obtainStyledAttributes.getBoolean(119, false)) {
                    v(10);
                }
                this.Q = obtainStyledAttributes.getBoolean(0, false);
                obtainStyledAttributes.recycle();
                N();
                this.f6168s.getDecorView();
                LayoutInflater from = LayoutInflater.from(context2);
                if (this.R) {
                    if (this.P) {
                        i10 = R.layout.abc_screen_simple_overlay_action_mode;
                    } else {
                        i10 = R.layout.abc_screen_simple;
                    }
                    viewGroup = (ViewGroup) from.inflate(i10, (ViewGroup) null);
                } else if (this.Q) {
                    viewGroup = (ViewGroup) from.inflate(R.layout.abc_dialog_title_material, (ViewGroup) null);
                    this.O = false;
                    this.N = false;
                } else if (this.N) {
                    TypedValue typedValue = new TypedValue();
                    context2.getTheme().resolveAttribute(R.attr.actionBarTheme, typedValue, true);
                    if (typedValue.resourceId != 0) {
                        context = new f(context2, typedValue.resourceId);
                    } else {
                        context = context2;
                    }
                    viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.abc_screen_toolbar, (ViewGroup) null);
                    e2 e2Var = (e2) viewGroup.findViewById(R.id.decor_content_parent);
                    this.f6174y = e2Var;
                    e2Var.setWindowCallback(R());
                    if (this.O) {
                        ((ActionBarOverlayLayout) this.f6174y).k(109);
                    }
                    if (this.L) {
                        ((ActionBarOverlayLayout) this.f6174y).k(2);
                    }
                    if (this.M) {
                        ((ActionBarOverlayLayout) this.f6174y).k(5);
                    }
                } else {
                    viewGroup = null;
                }
                if (viewGroup != null) {
                    v vVar = new v(this, 0);
                    WeakHashMap weakHashMap = c1.f10054a;
                    o0.u(viewGroup, vVar);
                    if (this.f6174y == null) {
                        this.J = (TextView) viewGroup.findViewById(R.id.title);
                    }
                    Method method = l5.f924a;
                    try {
                        Method method2 = viewGroup.getClass().getMethod("makeOptionalFitsSystemWindows", new Class[0]);
                        if (!method2.isAccessible()) {
                            method2.setAccessible(true);
                        }
                        method2.invoke(viewGroup, new Object[0]);
                    } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                    }
                    ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(R.id.action_bar_activity_content);
                    ViewGroup viewGroup2 = (ViewGroup) this.f6168s.findViewById(16908290);
                    if (viewGroup2 != null) {
                        while (viewGroup2.getChildCount() > 0) {
                            View childAt = viewGroup2.getChildAt(0);
                            viewGroup2.removeViewAt(0);
                            contentFrameLayout.addView(childAt);
                        }
                        viewGroup2.setId(-1);
                        contentFrameLayout.setId(16908290);
                        if (viewGroup2 instanceof FrameLayout) {
                            ((FrameLayout) viewGroup2).setForeground((Drawable) null);
                        }
                    }
                    this.f6168s.setContentView(viewGroup);
                    contentFrameLayout.setAttachListener(new v(this, 2));
                    this.I = viewGroup;
                    Object obj = this.f6166q;
                    if (obj instanceof Activity) {
                        charSequence = ((Activity) obj).getTitle();
                    } else {
                        charSequence = this.f6173x;
                    }
                    if (!TextUtils.isEmpty(charSequence)) {
                        e2 e2Var2 = this.f6174y;
                        if (e2Var2 != null) {
                            e2Var2.setWindowTitle(charSequence);
                        } else {
                            b1 b1Var = this.f6171v;
                            if (b1Var != null) {
                                b1Var.g(charSequence);
                            } else {
                                TextView textView = this.J;
                                if (textView != null) {
                                    textView.setText(charSequence);
                                }
                            }
                        }
                    }
                    ContentFrameLayout contentFrameLayout2 = (ContentFrameLayout) this.I.findViewById(16908290);
                    View decorView = this.f6168s.getDecorView();
                    contentFrameLayout2.f637n.set(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
                    WeakHashMap weakHashMap2 = c1.f10054a;
                    if (l0.c(contentFrameLayout2)) {
                        contentFrameLayout2.requestLayout();
                    }
                    TypedArray obtainStyledAttributes2 = context2.obtainStyledAttributes(iArr);
                    obtainStyledAttributes2.getValue(124, contentFrameLayout2.getMinWidthMajor());
                    obtainStyledAttributes2.getValue(125, contentFrameLayout2.getMinWidthMinor());
                    if (obtainStyledAttributes2.hasValue(122)) {
                        obtainStyledAttributes2.getValue(122, contentFrameLayout2.getFixedWidthMajor());
                    }
                    if (obtainStyledAttributes2.hasValue(123)) {
                        obtainStyledAttributes2.getValue(123, contentFrameLayout2.getFixedWidthMinor());
                    }
                    if (obtainStyledAttributes2.hasValue(120)) {
                        obtainStyledAttributes2.getValue(120, contentFrameLayout2.getFixedHeightMajor());
                    }
                    if (obtainStyledAttributes2.hasValue(121)) {
                        obtainStyledAttributes2.getValue(121, contentFrameLayout2.getFixedHeightMinor());
                    }
                    obtainStyledAttributes2.recycle();
                    contentFrameLayout2.requestLayout();
                    this.H = true;
                    j0 Q2 = Q(0);
                    if (!this.Y && Q2.f6112h == null) {
                        this.f6158h0 |= 4096;
                        if (!this.f6157g0) {
                            i0.m(this.f6168s.getDecorView(), this.f6159i0);
                            this.f6157g0 = true;
                            return;
                        }
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.N + ", windowActionBarOverlay: " + this.O + ", android:windowIsFloating: " + this.Q + ", windowActionModeOverlay: " + this.P + ", windowNoTitle: " + this.R + " }");
            }
            obtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
    }

    public final void N() {
        if (this.f6168s == null) {
            Object obj = this.f6166q;
            if (obj instanceof Activity) {
                E(((Activity) obj).getWindow());
            }
        }
        if (this.f6168s == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    public final h0 O(Context context) {
        if (this.f6155e0 == null) {
            if (u.f426m == null) {
                Context applicationContext = context.getApplicationContext();
                u.f426m = new u(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
            }
            this.f6155e0 = new f0(this, u.f426m);
        }
        return this.f6155e0;
    }

    public final j0 Q(int i10) {
        j0[] j0VarArr = this.T;
        if (j0VarArr == null || j0VarArr.length <= i10) {
            j0[] j0VarArr2 = new j0[(i10 + 1)];
            if (j0VarArr != null) {
                System.arraycopy(j0VarArr, 0, j0VarArr2, 0, j0VarArr.length);
            }
            this.T = j0VarArr2;
            j0VarArr = j0VarArr2;
        }
        j0 j0Var = j0VarArr[i10];
        if (j0Var != null) {
            return j0Var;
        }
        j0 j0Var2 = new j0(i10);
        j0VarArr[i10] = j0Var2;
        return j0Var2;
    }

    public final Window.Callback R() {
        return this.f6168s.getCallback();
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void S() {
        /*
            r3 = this;
            r3.M()
            boolean r0 = r3.N
            if (r0 == 0) goto L_0x0032
            g.b1 r0 = r3.f6171v
            if (r0 == 0) goto L_0x000c
            goto L_0x0032
        L_0x000c:
            java.lang.Object r0 = r3.f6166q
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L_0x001c
            g.b1 r1 = new g.b1
            android.app.Activity r0 = (android.app.Activity) r0
            boolean r2 = r3.O
            r1.<init>(r0, r2)
            goto L_0x0027
        L_0x001c:
            boolean r1 = r0 instanceof android.app.Dialog
            if (r1 == 0) goto L_0x0029
            g.b1 r1 = new g.b1
            android.app.Dialog r0 = (android.app.Dialog) r0
            r1.<init>(r0)
        L_0x0027:
            r3.f6171v = r1
        L_0x0029:
            g.b1 r0 = r3.f6171v
            if (r0 == 0) goto L_0x0032
            boolean r1 = r3.f6160j0
            r0.e(r1)
        L_0x0032:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: g.k0.S():void");
    }

    public final int T(Context context, int i10) {
        h0 h0Var;
        if (i10 == -100) {
            return -1;
        }
        if (i10 != -1) {
            if (i10 != 0) {
                if (!(i10 == 1 || i10 == 2)) {
                    if (i10 == 3) {
                        if (this.f6156f0 == null) {
                            this.f6156f0 = new f0(this, context);
                        }
                        h0Var = this.f6156f0;
                    } else {
                        throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
                    }
                }
            } else if (Build.VERSION.SDK_INT >= 23 && ((UiModeManager) context.getApplicationContext().getSystemService("uimode")).getNightMode() == 0) {
                return -1;
            } else {
                h0Var = O(context);
            }
            return h0Var.d();
        }
        return i10;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x004f A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean U() {
        /*
            r5 = this;
            boolean r0 = r5.V
            r1 = 0
            r5.V = r1
            g.j0 r2 = r5.Q(r1)
            boolean r3 = r2.f6117m
            r4 = 1
            if (r3 == 0) goto L_0x0014
            if (r0 != 0) goto L_0x0013
            r5.I(r2, r4)
        L_0x0013:
            return r4
        L_0x0014:
            l.c r0 = r5.B
            if (r0 == 0) goto L_0x001c
            r0.a()
            return r4
        L_0x001c:
            r5.S()
            g.b1 r0 = r5.f6171v
            if (r0 == 0) goto L_0x0050
            androidx.appcompat.widget.f2 r0 = r0.f6031e
            if (r0 == 0) goto L_0x004c
            r2 = r0
            androidx.appcompat.widget.d5 r2 = (androidx.appcompat.widget.d5) r2
            androidx.appcompat.widget.Toolbar r2 = r2.f791a
            androidx.appcompat.widget.y4 r2 = r2.S
            if (r2 == 0) goto L_0x0036
            m.q r2 = r2.f1134i
            if (r2 == 0) goto L_0x0036
            r2 = 1
            goto L_0x0037
        L_0x0036:
            r2 = 0
        L_0x0037:
            if (r2 == 0) goto L_0x004c
            androidx.appcompat.widget.d5 r0 = (androidx.appcompat.widget.d5) r0
            androidx.appcompat.widget.Toolbar r0 = r0.f791a
            androidx.appcompat.widget.y4 r0 = r0.S
            if (r0 != 0) goto L_0x0043
            r0 = 0
            goto L_0x0045
        L_0x0043:
            m.q r0 = r0.f1134i
        L_0x0045:
            if (r0 == 0) goto L_0x004a
            r0.collapseActionView()
        L_0x004a:
            r0 = 1
            goto L_0x004d
        L_0x004c:
            r0 = 0
        L_0x004d:
            if (r0 == 0) goto L_0x0050
            return r4
        L_0x0050:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: g.k0.U():boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0151, code lost:
        if (r2 != null) goto L_0x0153;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0175, code lost:
        if (r2.f9964m.getCount() > 0) goto L_0x0177;
     */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x01d9  */
    /* JADX WARNING: Removed duplicated region for block: B:103:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0158  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x017d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void V(g.j0 r19, android.view.KeyEvent r20) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            boolean r2 = r1.f6117m
            if (r2 != 0) goto L_0x01df
            boolean r2 = r0.Y
            if (r2 == 0) goto L_0x000e
            goto L_0x01df
        L_0x000e:
            android.content.Context r2 = r0.f6167r
            r3 = 1
            r4 = 0
            r5 = 4
            int r6 = r1.f6105a
            if (r6 != 0) goto L_0x002b
            android.content.res.Resources r7 = r2.getResources()
            android.content.res.Configuration r7 = r7.getConfiguration()
            int r7 = r7.screenLayout
            r7 = r7 & 15
            if (r7 != r5) goto L_0x0027
            r7 = 1
            goto L_0x0028
        L_0x0027:
            r7 = 0
        L_0x0028:
            if (r7 == 0) goto L_0x002b
            return
        L_0x002b:
            android.view.Window$Callback r7 = r18.R()
            if (r7 == 0) goto L_0x003d
            m.o r8 = r1.f6112h
            boolean r7 = r7.onMenuOpened(r6, r8)
            if (r7 != 0) goto L_0x003d
            r0.I(r1, r3)
            return
        L_0x003d:
            java.lang.String r7 = "window"
            java.lang.Object r7 = r2.getSystemService(r7)
            android.view.WindowManager r7 = (android.view.WindowManager) r7
            if (r7 != 0) goto L_0x0048
            return
        L_0x0048:
            boolean r8 = r18.X(r19, r20)
            if (r8 != 0) goto L_0x004f
            return
        L_0x004f:
            g.i0 r8 = r1.f6109e
            r9 = -2
            if (r8 == 0) goto L_0x006b
            boolean r10 = r1.f6118n
            if (r10 == 0) goto L_0x0059
            goto L_0x006b
        L_0x0059:
            android.view.View r2 = r1.f6111g
            if (r2 == 0) goto L_0x01b6
            android.view.ViewGroup$LayoutParams r2 = r2.getLayoutParams()
            if (r2 == 0) goto L_0x01b6
            int r2 = r2.width
            r5 = -1
            if (r2 != r5) goto L_0x01b6
            r11 = -1
            goto L_0x01b7
        L_0x006b:
            if (r8 != 0) goto L_0x00e3
            r18.S()
            g.b1 r8 = r0.f6171v
            if (r8 == 0) goto L_0x0079
            android.content.Context r8 = r8.c()
            goto L_0x007a
        L_0x0079:
            r8 = 0
        L_0x007a:
            if (r8 != 0) goto L_0x007d
            goto L_0x007e
        L_0x007d:
            r2 = r8
        L_0x007e:
            android.util.TypedValue r8 = new android.util.TypedValue
            r8.<init>()
            android.content.res.Resources r10 = r2.getResources()
            android.content.res.Resources$Theme r10 = r10.newTheme()
            android.content.res.Resources$Theme r11 = r2.getTheme()
            r10.setTo(r11)
            r11 = 2130968581(0x7f040005, float:1.754582E38)
            r10.resolveAttribute(r11, r8, r3)
            int r11 = r8.resourceId
            if (r11 == 0) goto L_0x009f
            r10.applyStyle(r11, r3)
        L_0x009f:
            r11 = 2130969516(0x7f0403ac, float:1.7547716E38)
            r10.resolveAttribute(r11, r8, r3)
            int r8 = r8.resourceId
            if (r8 == 0) goto L_0x00aa
            goto L_0x00ad
        L_0x00aa:
            r8 = 2132017803(0x7f14028b, float:1.9673895E38)
        L_0x00ad:
            r10.applyStyle(r8, r3)
            l.f r8 = new l.f
            r8.<init>((android.content.Context) r2, (int) r4)
            android.content.res.Resources$Theme r2 = r8.getTheme()
            r2.setTo(r10)
            r1.f6114j = r8
            int[] r2 = f.a.f5401k
            android.content.res.TypedArray r2 = r8.obtainStyledAttributes(r2)
            r8 = 86
            int r8 = r2.getResourceId(r8, r4)
            r1.f6106b = r8
            int r8 = r2.getResourceId(r3, r4)
            r1.f6108d = r8
            r2.recycle()
            g.i0 r2 = new g.i0
            l.f r8 = r1.f6114j
            r2.<init>(r0, r8)
            r1.f6109e = r2
            r2 = 81
            r1.f6107c = r2
            goto L_0x00f2
        L_0x00e3:
            boolean r2 = r1.f6118n
            if (r2 == 0) goto L_0x00f2
            int r2 = r8.getChildCount()
            if (r2 <= 0) goto L_0x00f2
            g.i0 r2 = r1.f6109e
            r2.removeAllViews()
        L_0x00f2:
            android.view.View r2 = r1.f6111g
            if (r2 == 0) goto L_0x00f9
            r1.f6110f = r2
            goto L_0x0153
        L_0x00f9:
            m.o r2 = r1.f6112h
            if (r2 != 0) goto L_0x00fe
            goto L_0x0155
        L_0x00fe:
            g.v r2 = r0.A
            if (r2 != 0) goto L_0x0109
            g.v r2 = new g.v
            r2.<init>(r0, r5)
            r0.A = r2
        L_0x0109:
            g.v r2 = r0.A
            m.k r5 = r1.f6113i
            if (r5 != 0) goto L_0x0121
            m.k r5 = new m.k
            l.f r8 = r1.f6114j
            r5.<init>(r8)
            r1.f6113i = r5
            r5.f9963l = r2
            m.o r2 = r1.f6112h
            android.content.Context r8 = r2.f9972a
            r2.b(r5, r8)
        L_0x0121:
            m.k r2 = r1.f6113i
            g.i0 r5 = r1.f6109e
            androidx.appcompat.view.menu.ExpandedMenuView r8 = r2.f9962k
            if (r8 != 0) goto L_0x014d
            android.view.LayoutInflater r8 = r2.f9960i
            r10 = 2131558413(0x7f0d000d, float:1.8742141E38)
            android.view.View r5 = r8.inflate(r10, r5, r4)
            androidx.appcompat.view.menu.ExpandedMenuView r5 = (androidx.appcompat.view.menu.ExpandedMenuView) r5
            r2.f9962k = r5
            m.j r5 = r2.f9964m
            if (r5 != 0) goto L_0x0141
            m.j r5 = new m.j
            r5.<init>(r2)
            r2.f9964m = r5
        L_0x0141:
            androidx.appcompat.view.menu.ExpandedMenuView r5 = r2.f9962k
            m.j r8 = r2.f9964m
            r5.setAdapter(r8)
            androidx.appcompat.view.menu.ExpandedMenuView r5 = r2.f9962k
            r5.setOnItemClickListener(r2)
        L_0x014d:
            androidx.appcompat.view.menu.ExpandedMenuView r2 = r2.f9962k
            r1.f6110f = r2
            if (r2 == 0) goto L_0x0155
        L_0x0153:
            r2 = 1
            goto L_0x0156
        L_0x0155:
            r2 = 0
        L_0x0156:
            if (r2 == 0) goto L_0x01dd
            android.view.View r2 = r1.f6110f
            if (r2 != 0) goto L_0x015d
            goto L_0x0179
        L_0x015d:
            android.view.View r2 = r1.f6111g
            if (r2 == 0) goto L_0x0162
            goto L_0x0177
        L_0x0162:
            m.k r2 = r1.f6113i
            m.j r5 = r2.f9964m
            if (r5 != 0) goto L_0x016f
            m.j r5 = new m.j
            r5.<init>(r2)
            r2.f9964m = r5
        L_0x016f:
            m.j r2 = r2.f9964m
            int r2 = r2.getCount()
            if (r2 <= 0) goto L_0x0179
        L_0x0177:
            r2 = 1
            goto L_0x017a
        L_0x0179:
            r2 = 0
        L_0x017a:
            if (r2 != 0) goto L_0x017d
            goto L_0x01dd
        L_0x017d:
            android.view.View r2 = r1.f6110f
            android.view.ViewGroup$LayoutParams r2 = r2.getLayoutParams()
            if (r2 != 0) goto L_0x018a
            android.view.ViewGroup$LayoutParams r2 = new android.view.ViewGroup$LayoutParams
            r2.<init>(r9, r9)
        L_0x018a:
            int r5 = r1.f6106b
            g.i0 r8 = r1.f6109e
            r8.setBackgroundResource(r5)
            android.view.View r5 = r1.f6110f
            android.view.ViewParent r5 = r5.getParent()
            boolean r8 = r5 instanceof android.view.ViewGroup
            if (r8 == 0) goto L_0x01a2
            android.view.ViewGroup r5 = (android.view.ViewGroup) r5
            android.view.View r8 = r1.f6110f
            r5.removeView(r8)
        L_0x01a2:
            g.i0 r5 = r1.f6109e
            android.view.View r8 = r1.f6110f
            r5.addView(r8, r2)
            android.view.View r2 = r1.f6110f
            boolean r2 = r2.hasFocus()
            if (r2 != 0) goto L_0x01b6
            android.view.View r2 = r1.f6110f
            r2.requestFocus()
        L_0x01b6:
            r11 = -2
        L_0x01b7:
            r1.f6116l = r4
            android.view.WindowManager$LayoutParams r2 = new android.view.WindowManager$LayoutParams
            r12 = -2
            r13 = 0
            r14 = 0
            r15 = 1002(0x3ea, float:1.404E-42)
            r16 = 8519680(0x820000, float:1.1938615E-38)
            r17 = -3
            r10 = r2
            r10.<init>(r11, r12, r13, r14, r15, r16, r17)
            int r4 = r1.f6107c
            r2.gravity = r4
            int r4 = r1.f6108d
            r2.windowAnimations = r4
            g.i0 r4 = r1.f6109e
            r7.addView(r4, r2)
            r1.f6117m = r3
            if (r6 != 0) goto L_0x01dc
            r18.Z()
        L_0x01dc:
            return
        L_0x01dd:
            r1.f6118n = r3
        L_0x01df:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: g.k0.V(g.j0, android.view.KeyEvent):void");
    }

    public final boolean W(j0 j0Var, int i10, KeyEvent keyEvent) {
        o oVar;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((j0Var.f6115k || X(j0Var, keyEvent)) && (oVar = j0Var.f6112h) != null) {
            return oVar.performShortcut(i10, keyEvent, 1);
        }
        return false;
    }

    public final boolean X(j0 j0Var, KeyEvent keyEvent) {
        boolean z10;
        int i10;
        boolean z11;
        e2 e2Var;
        e2 e2Var2;
        e2 e2Var3;
        Resources.Theme theme;
        e2 e2Var4;
        if (this.Y) {
            return false;
        }
        if (j0Var.f6115k) {
            return true;
        }
        j0 j0Var2 = this.U;
        if (!(j0Var2 == null || j0Var2 == j0Var)) {
            I(j0Var2, false);
        }
        Window.Callback R2 = R();
        int i11 = j0Var.f6105a;
        if (R2 != null) {
            j0Var.f6111g = R2.onCreatePanelView(i11);
        }
        if (i11 == 0 || i11 == 108) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10 && (e2Var4 = this.f6174y) != null) {
            ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) e2Var4;
            actionBarOverlayLayout.l();
            ((d5) actionBarOverlayLayout.f608l).f802l = true;
        }
        if (j0Var.f6111g == null) {
            o oVar = j0Var.f6112h;
            if (oVar == null || j0Var.f6119o) {
                if (oVar == null) {
                    Context context = this.f6167r;
                    if ((i11 == 0 || i11 == 108) && this.f6174y != null) {
                        TypedValue typedValue = new TypedValue();
                        Resources.Theme theme2 = context.getTheme();
                        theme2.resolveAttribute(R.attr.actionBarTheme, typedValue, true);
                        if (typedValue.resourceId != 0) {
                            theme = context.getResources().newTheme();
                            theme.setTo(theme2);
                            theme.applyStyle(typedValue.resourceId, true);
                            theme.resolveAttribute(R.attr.actionBarWidgetTheme, typedValue, true);
                        } else {
                            theme2.resolveAttribute(R.attr.actionBarWidgetTheme, typedValue, true);
                            theme = null;
                        }
                        if (typedValue.resourceId != 0) {
                            if (theme == null) {
                                theme = context.getResources().newTheme();
                                theme.setTo(theme2);
                            }
                            theme.applyStyle(typedValue.resourceId, true);
                        }
                        if (theme != null) {
                            f fVar = new f(context, 0);
                            fVar.getTheme().setTo(theme);
                            context = fVar;
                        }
                    }
                    o oVar2 = new o(context);
                    oVar2.f9976e = this;
                    o oVar3 = j0Var.f6112h;
                    if (oVar2 != oVar3) {
                        if (oVar3 != null) {
                            oVar3.r(j0Var.f6113i);
                        }
                        j0Var.f6112h = oVar2;
                        m.k kVar = j0Var.f6113i;
                        if (kVar != null) {
                            oVar2.b(kVar, oVar2.f9972a);
                        }
                    }
                    if (j0Var.f6112h == null) {
                        return false;
                    }
                }
                if (z10 && (e2Var3 = this.f6174y) != null) {
                    if (this.f6175z == null) {
                        this.f6175z = new v(this, 3);
                    }
                    ((ActionBarOverlayLayout) e2Var3).m(j0Var.f6112h, this.f6175z);
                }
                j0Var.f6112h.x();
                if (!R2.onCreatePanelMenu(i11, j0Var.f6112h)) {
                    o oVar4 = j0Var.f6112h;
                    if (oVar4 != null) {
                        if (oVar4 != null) {
                            oVar4.r(j0Var.f6113i);
                        }
                        j0Var.f6112h = null;
                    }
                    if (z10 && (e2Var2 = this.f6174y) != null) {
                        ((ActionBarOverlayLayout) e2Var2).m((o) null, this.f6175z);
                    }
                    return false;
                }
                j0Var.f6119o = false;
            }
            j0Var.f6112h.x();
            Bundle bundle = j0Var.f6120p;
            if (bundle != null) {
                j0Var.f6112h.s(bundle);
                j0Var.f6120p = null;
            }
            if (!R2.onPreparePanel(0, j0Var.f6111g, j0Var.f6112h)) {
                if (z10 && (e2Var = this.f6174y) != null) {
                    ((ActionBarOverlayLayout) e2Var).m((o) null, this.f6175z);
                }
                j0Var.f6112h.w();
                return false;
            }
            if (keyEvent != null) {
                i10 = keyEvent.getDeviceId();
            } else {
                i10 = -1;
            }
            if (KeyCharacterMap.load(i10).getKeyboardType() != 1) {
                z11 = true;
            } else {
                z11 = false;
            }
            j0Var.f6112h.setQwertyMode(z11);
            j0Var.f6112h.w();
        }
        j0Var.f6115k = true;
        j0Var.f6116l = false;
        this.U = j0Var;
        return true;
    }

    public final void Y() {
        if (this.H) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    public final void Z() {
        OnBackInvokedCallback onBackInvokedCallback;
        if (Build.VERSION.SDK_INT >= 33) {
            boolean z10 = false;
            if (this.f6164n0 != null && (Q(0).f6117m || this.B != null)) {
                z10 = true;
            }
            if (z10 && this.f6165o0 == null) {
                this.f6165o0 = d0.b(this.f6164n0, this);
            } else if (!z10 && (onBackInvokedCallback = this.f6165o0) != null) {
                d0.c(this.f6164n0, onBackInvokedCallback);
            }
        }
    }

    public final void a(View view, ViewGroup.LayoutParams layoutParams) {
        M();
        ((ViewGroup) this.I.findViewById(16908290)).addView(view, layoutParams);
        this.f6169t.a(this.f6168s.getCallback());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00ca, code lost:
        r12 = (android.view.ViewGroup.MarginLayoutParams) r12.getLayoutParams();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a0(m0.q2 r12, android.graphics.Rect r13) {
        /*
            r11 = this;
            r0 = 0
            if (r12 == 0) goto L_0x0008
            int r1 = r12.e()
            goto L_0x000e
        L_0x0008:
            if (r13 == 0) goto L_0x000d
            int r1 = r13.top
            goto L_0x000e
        L_0x000d:
            r1 = 0
        L_0x000e:
            androidx.appcompat.widget.ActionBarContextView r2 = r11.C
            r3 = 8
            if (r2 == 0) goto L_0x012e
            android.view.ViewGroup$LayoutParams r2 = r2.getLayoutParams()
            boolean r2 = r2 instanceof android.view.ViewGroup.MarginLayoutParams
            if (r2 == 0) goto L_0x012e
            androidx.appcompat.widget.ActionBarContextView r2 = r11.C
            android.view.ViewGroup$LayoutParams r2 = r2.getLayoutParams()
            android.view.ViewGroup$MarginLayoutParams r2 = (android.view.ViewGroup.MarginLayoutParams) r2
            androidx.appcompat.widget.ActionBarContextView r4 = r11.C
            boolean r4 = r4.isShown()
            r5 = 1
            if (r4 == 0) goto L_0x011c
            android.graphics.Rect r4 = r11.f6161k0
            if (r4 != 0) goto L_0x003f
            android.graphics.Rect r4 = new android.graphics.Rect
            r4.<init>()
            r11.f6161k0 = r4
            android.graphics.Rect r4 = new android.graphics.Rect
            r4.<init>()
            r11.f6162l0 = r4
        L_0x003f:
            android.graphics.Rect r4 = r11.f6161k0
            android.graphics.Rect r6 = r11.f6162l0
            if (r12 != 0) goto L_0x0049
            r4.set(r13)
            goto L_0x005c
        L_0x0049:
            int r13 = r12.c()
            int r7 = r12.e()
            int r8 = r12.d()
            int r12 = r12.b()
            r4.set(r13, r7, r8, r12)
        L_0x005c:
            android.view.ViewGroup r12 = r11.I
            java.lang.reflect.Method r13 = androidx.appcompat.widget.l5.f924a
            if (r13 == 0) goto L_0x006c
            r7 = 2
            java.lang.Object[] r7 = new java.lang.Object[r7]     // Catch:{ Exception -> 0x006c }
            r7[r0] = r4     // Catch:{ Exception -> 0x006c }
            r7[r5] = r6     // Catch:{ Exception -> 0x006c }
            r13.invoke(r12, r7)     // Catch:{ Exception -> 0x006c }
        L_0x006c:
            int r12 = r4.top
            int r13 = r4.left
            int r4 = r4.right
            android.view.ViewGroup r6 = r11.I
            m0.q2 r6 = m0.c1.h(r6)
            if (r6 != 0) goto L_0x007c
            r7 = 0
            goto L_0x0080
        L_0x007c:
            int r7 = r6.c()
        L_0x0080:
            if (r6 != 0) goto L_0x0084
            r6 = 0
            goto L_0x0088
        L_0x0084:
            int r6 = r6.d()
        L_0x0088:
            int r8 = r2.topMargin
            if (r8 != r12) goto L_0x0097
            int r8 = r2.leftMargin
            if (r8 != r13) goto L_0x0097
            int r8 = r2.rightMargin
            if (r8 == r4) goto L_0x0095
            goto L_0x0097
        L_0x0095:
            r13 = 0
            goto L_0x009e
        L_0x0097:
            r2.topMargin = r12
            r2.leftMargin = r13
            r2.rightMargin = r4
            r13 = 1
        L_0x009e:
            android.content.Context r4 = r11.f6167r
            if (r12 <= 0) goto L_0x00c6
            android.view.View r12 = r11.K
            if (r12 != 0) goto L_0x00c6
            android.view.View r12 = new android.view.View
            r12.<init>(r4)
            r11.K = r12
            r12.setVisibility(r3)
            android.widget.FrameLayout$LayoutParams r12 = new android.widget.FrameLayout$LayoutParams
            int r8 = r2.topMargin
            r9 = -1
            r10 = 51
            r12.<init>(r9, r8, r10)
            r12.leftMargin = r7
            r12.rightMargin = r6
            android.view.ViewGroup r6 = r11.I
            android.view.View r7 = r11.K
            r6.addView(r7, r9, r12)
            goto L_0x00e9
        L_0x00c6:
            android.view.View r12 = r11.K
            if (r12 == 0) goto L_0x00e9
            android.view.ViewGroup$LayoutParams r12 = r12.getLayoutParams()
            android.view.ViewGroup$MarginLayoutParams r12 = (android.view.ViewGroup.MarginLayoutParams) r12
            int r8 = r12.height
            int r9 = r2.topMargin
            if (r8 != r9) goto L_0x00de
            int r8 = r12.leftMargin
            if (r8 != r7) goto L_0x00de
            int r8 = r12.rightMargin
            if (r8 == r6) goto L_0x00e9
        L_0x00de:
            r12.height = r9
            r12.leftMargin = r7
            r12.rightMargin = r6
            android.view.View r6 = r11.K
            r6.setLayoutParams(r12)
        L_0x00e9:
            android.view.View r12 = r11.K
            if (r12 == 0) goto L_0x00ef
            r6 = 1
            goto L_0x00f0
        L_0x00ef:
            r6 = 0
        L_0x00f0:
            if (r6 == 0) goto L_0x0114
            int r12 = r12.getVisibility()
            if (r12 == 0) goto L_0x0114
            android.view.View r12 = r11.K
            int r7 = m0.i0.g(r12)
            r7 = r7 & 8192(0x2000, float:1.14794E-41)
            if (r7 == 0) goto L_0x0103
            goto L_0x0104
        L_0x0103:
            r5 = 0
        L_0x0104:
            if (r5 == 0) goto L_0x010a
            r5 = 2131099654(0x7f060006, float:1.7811667E38)
            goto L_0x010d
        L_0x010a:
            r5 = 2131099653(0x7f060005, float:1.7811665E38)
        L_0x010d:
            int r4 = c0.g.b(r4, r5)
            r12.setBackgroundColor(r4)
        L_0x0114:
            boolean r12 = r11.P
            if (r12 != 0) goto L_0x0126
            if (r6 == 0) goto L_0x0126
            r1 = 0
            goto L_0x0126
        L_0x011c:
            int r12 = r2.topMargin
            if (r12 == 0) goto L_0x0123
            r2.topMargin = r0
            goto L_0x0124
        L_0x0123:
            r5 = 0
        L_0x0124:
            r13 = r5
            r6 = 0
        L_0x0126:
            if (r13 == 0) goto L_0x012f
            androidx.appcompat.widget.ActionBarContextView r12 = r11.C
            r12.setLayoutParams(r2)
            goto L_0x012f
        L_0x012e:
            r6 = 0
        L_0x012f:
            android.view.View r12 = r11.K
            if (r12 == 0) goto L_0x013b
            if (r6 == 0) goto L_0x0136
            goto L_0x0138
        L_0x0136:
            r0 = 8
        L_0x0138:
            r12.setVisibility(r0)
        L_0x013b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: g.k0.a0(m0.q2, android.graphics.Rect):int");
    }

    public final void b() {
        i iVar;
        Context context = this.f6167r;
        if (t.n(context) && (iVar = t.f6210j) != null && !iVar.equals(t.f6211k)) {
            t.f6208h.execute(new q(context, 0));
        }
        D(true, true);
    }

    /* JADX WARNING: Removed duplicated region for block: B:109:0x01b5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.content.Context c(android.content.Context r12) {
        /*
            r11 = this;
            r0 = 1
            r11.W = r0
            int r1 = r11.f6151a0
            r2 = -100
            if (r1 == r2) goto L_0x000a
            goto L_0x000c
        L_0x000a:
            int r1 = g.t.f6209i
        L_0x000c:
            int r1 = r11.T(r12, r1)
            boolean r2 = g.t.n(r12)
            if (r2 == 0) goto L_0x0019
            g.t.C(r12)
        L_0x0019:
            i0.i r2 = F(r12)
            boolean r3 = f6150s0
            r4 = 0
            r5 = 0
            if (r3 == 0) goto L_0x0033
            boolean r3 = r12 instanceof android.view.ContextThemeWrapper
            if (r3 == 0) goto L_0x0033
            android.content.res.Configuration r3 = J(r12, r1, r2, r4, r5)
            r6 = r12
            android.view.ContextThemeWrapper r6 = (android.view.ContextThemeWrapper) r6     // Catch:{ IllegalStateException -> 0x0032 }
            r6.applyOverrideConfiguration(r3)     // Catch:{ IllegalStateException -> 0x0032 }
            return r12
        L_0x0032:
        L_0x0033:
            boolean r3 = r12 instanceof l.f
            if (r3 == 0) goto L_0x0043
            android.content.res.Configuration r3 = J(r12, r1, r2, r4, r5)
            r6 = r12
            l.f r6 = (l.f) r6     // Catch:{ IllegalStateException -> 0x0042 }
            r6.a(r3)     // Catch:{ IllegalStateException -> 0x0042 }
            return r12
        L_0x0042:
        L_0x0043:
            boolean r3 = f6149r0
            if (r3 != 0) goto L_0x0048
            return r12
        L_0x0048:
            int r3 = android.os.Build.VERSION.SDK_INT
            android.content.res.Configuration r6 = new android.content.res.Configuration
            r6.<init>()
            r7 = -1
            r6.uiMode = r7
            r7 = 0
            r6.fontScale = r7
            android.content.Context r6 = g.y.a(r12, r6)
            android.content.res.Resources r6 = r6.getResources()
            android.content.res.Configuration r6 = r6.getConfiguration()
            android.content.res.Resources r8 = r12.getResources()
            android.content.res.Configuration r8 = r8.getConfiguration()
            int r9 = r8.uiMode
            r6.uiMode = r9
            boolean r9 = r6.equals(r8)
            if (r9 != 0) goto L_0x0199
            android.content.res.Configuration r9 = new android.content.res.Configuration
            r9.<init>()
            r9.fontScale = r7
            int r7 = r6.diff(r8)
            if (r7 != 0) goto L_0x0082
            goto L_0x019a
        L_0x0082:
            float r7 = r6.fontScale
            float r10 = r8.fontScale
            int r7 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
            if (r7 == 0) goto L_0x008c
            r9.fontScale = r10
        L_0x008c:
            int r7 = r6.mcc
            int r10 = r8.mcc
            if (r7 == r10) goto L_0x0094
            r9.mcc = r10
        L_0x0094:
            int r7 = r6.mnc
            int r10 = r8.mnc
            if (r7 == r10) goto L_0x009c
            r9.mnc = r10
        L_0x009c:
            r7 = 24
            if (r3 < r7) goto L_0x00a4
            g.b0.a(r6, r8, r9)
            goto L_0x00b2
        L_0x00a4:
            java.util.Locale r7 = r6.locale
            java.util.Locale r10 = r8.locale
            boolean r7 = l0.b.a(r7, r10)
            if (r7 != 0) goto L_0x00b2
            java.util.Locale r7 = r8.locale
            r9.locale = r7
        L_0x00b2:
            int r7 = r6.touchscreen
            int r10 = r8.touchscreen
            if (r7 == r10) goto L_0x00ba
            r9.touchscreen = r10
        L_0x00ba:
            int r7 = r6.keyboard
            int r10 = r8.keyboard
            if (r7 == r10) goto L_0x00c2
            r9.keyboard = r10
        L_0x00c2:
            int r7 = r6.keyboardHidden
            int r10 = r8.keyboardHidden
            if (r7 == r10) goto L_0x00ca
            r9.keyboardHidden = r10
        L_0x00ca:
            int r7 = r6.navigation
            int r10 = r8.navigation
            if (r7 == r10) goto L_0x00d2
            r9.navigation = r10
        L_0x00d2:
            int r7 = r6.navigationHidden
            int r10 = r8.navigationHidden
            if (r7 == r10) goto L_0x00da
            r9.navigationHidden = r10
        L_0x00da:
            int r7 = r6.orientation
            int r10 = r8.orientation
            if (r7 == r10) goto L_0x00e2
            r9.orientation = r10
        L_0x00e2:
            int r7 = r6.screenLayout
            r7 = r7 & 15
            int r10 = r8.screenLayout
            r10 = r10 & 15
            if (r7 == r10) goto L_0x00f1
            int r7 = r9.screenLayout
            r7 = r7 | r10
            r9.screenLayout = r7
        L_0x00f1:
            int r7 = r6.screenLayout
            r7 = r7 & 192(0xc0, float:2.69E-43)
            int r10 = r8.screenLayout
            r10 = r10 & 192(0xc0, float:2.69E-43)
            if (r7 == r10) goto L_0x0100
            int r7 = r9.screenLayout
            r7 = r7 | r10
            r9.screenLayout = r7
        L_0x0100:
            int r7 = r6.screenLayout
            r7 = r7 & 48
            int r10 = r8.screenLayout
            r10 = r10 & 48
            if (r7 == r10) goto L_0x010f
            int r7 = r9.screenLayout
            r7 = r7 | r10
            r9.screenLayout = r7
        L_0x010f:
            int r7 = r6.screenLayout
            r7 = r7 & 768(0x300, float:1.076E-42)
            int r10 = r8.screenLayout
            r10 = r10 & 768(0x300, float:1.076E-42)
            if (r7 == r10) goto L_0x011e
            int r7 = r9.screenLayout
            r7 = r7 | r10
            r9.screenLayout = r7
        L_0x011e:
            r7 = 26
            if (r3 < r7) goto L_0x015a
            int r3 = r6.colorMode
            r3 = r3 & 3
            int r7 = r8.colorMode
            r7 = r7 & 3
            if (r3 == r7) goto L_0x013e
            int r3 = r9.colorMode
            int r7 = r8.colorMode
            r7 = r7 & 3
            r3 = r3 | r7
            r9.colorMode = r3
        L_0x013e:
            int r3 = r6.colorMode
            r3 = r3 & 12
            int r7 = r8.colorMode
            r7 = r7 & 12
            if (r3 == r7) goto L_0x015a
            int r3 = r9.colorMode
            int r7 = r8.colorMode
            r7 = r7 & 12
            r3 = r3 | r7
            r9.colorMode = r3
        L_0x015a:
            int r3 = r6.uiMode
            r3 = r3 & 15
            int r7 = r8.uiMode
            r7 = r7 & 15
            if (r3 == r7) goto L_0x0169
            int r3 = r9.uiMode
            r3 = r3 | r7
            r9.uiMode = r3
        L_0x0169:
            int r3 = r6.uiMode
            r3 = r3 & 48
            int r7 = r8.uiMode
            r7 = r7 & 48
            if (r3 == r7) goto L_0x0178
            int r3 = r9.uiMode
            r3 = r3 | r7
            r9.uiMode = r3
        L_0x0178:
            int r3 = r6.screenWidthDp
            int r7 = r8.screenWidthDp
            if (r3 == r7) goto L_0x0180
            r9.screenWidthDp = r7
        L_0x0180:
            int r3 = r6.screenHeightDp
            int r7 = r8.screenHeightDp
            if (r3 == r7) goto L_0x0188
            r9.screenHeightDp = r7
        L_0x0188:
            int r3 = r6.smallestScreenWidthDp
            int r7 = r8.smallestScreenWidthDp
            if (r3 == r7) goto L_0x0190
            r9.smallestScreenWidthDp = r7
        L_0x0190:
            int r3 = r6.densityDpi
            int r6 = r8.densityDpi
            if (r3 == r6) goto L_0x019a
            r9.densityDpi = r6
            goto L_0x019a
        L_0x0199:
            r9 = r4
        L_0x019a:
            android.content.res.Configuration r1 = J(r12, r1, r2, r9, r0)
            l.f r2 = new l.f
            r3 = 2132017815(0x7f140297, float:1.967392E38)
            r2.<init>((android.content.Context) r12, (int) r3)
            r2.a(r1)
            android.content.res.Resources$Theme r12 = r12.getTheme()     // Catch:{ NullPointerException -> 0x01b1 }
            if (r12 == 0) goto L_0x01b2
            r12 = 1
            goto L_0x01b3
        L_0x01b1:
        L_0x01b2:
            r12 = 0
        L_0x01b3:
            if (r12 == 0) goto L_0x0203
            android.content.res.Resources$Theme r12 = r2.getTheme()
            int r1 = android.os.Build.VERSION.SDK_INT
            r3 = 29
            if (r1 < r3) goto L_0x01c3
            d0.r.a(r12)
            goto L_0x0203
        L_0x01c3:
            r3 = 23
            if (r1 < r3) goto L_0x0203
            java.lang.Object r1 = d0.q.f4112a
            monitor-enter(r1)
            boolean r3 = d0.q.f4114c     // Catch:{ all -> 0x0200 }
            if (r3 != 0) goto L_0x01e8
            java.lang.Class<android.content.res.Resources$Theme> r3 = android.content.res.Resources.Theme.class
            java.lang.String r6 = "rebase"
            java.lang.Class[] r7 = new java.lang.Class[r5]     // Catch:{ NoSuchMethodException -> 0x01de }
            java.lang.reflect.Method r3 = r3.getDeclaredMethod(r6, r7)     // Catch:{ NoSuchMethodException -> 0x01de }
            d0.q.f4113b = r3     // Catch:{ NoSuchMethodException -> 0x01de }
            r3.setAccessible(r0)     // Catch:{ NoSuchMethodException -> 0x01de }
            goto L_0x01e6
        L_0x01de:
            r3 = move-exception
            java.lang.String r6 = "ResourcesCompat"
            java.lang.String r7 = "Failed to retrieve rebase() method"
            android.util.Log.i(r6, r7, r3)     // Catch:{ all -> 0x0200 }
        L_0x01e6:
            d0.q.f4114c = r0     // Catch:{ all -> 0x0200 }
        L_0x01e8:
            java.lang.reflect.Method r0 = d0.q.f4113b     // Catch:{ all -> 0x0200 }
            if (r0 == 0) goto L_0x01fe
            java.lang.Object[] r3 = new java.lang.Object[r5]     // Catch:{ IllegalAccessException -> 0x01f4, InvocationTargetException -> 0x01f2 }
            r0.invoke(r12, r3)     // Catch:{ IllegalAccessException -> 0x01f4, InvocationTargetException -> 0x01f2 }
            goto L_0x01fe
        L_0x01f2:
            r12 = move-exception
            goto L_0x01f5
        L_0x01f4:
            r12 = move-exception
        L_0x01f5:
            java.lang.String r0 = "ResourcesCompat"
            java.lang.String r3 = "Failed to invoke rebase() method via reflection"
            android.util.Log.i(r0, r3, r12)     // Catch:{ all -> 0x0200 }
            d0.q.f4113b = r4     // Catch:{ all -> 0x0200 }
        L_0x01fe:
            monitor-exit(r1)     // Catch:{ all -> 0x0200 }
            goto L_0x0203
        L_0x0200:
            r12 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0200 }
            throw r12
        L_0x0203:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: g.k0.c(android.content.Context):android.content.Context");
    }

    public final View d(int i10) {
        M();
        return this.f6168s.findViewById(i10);
    }

    public final boolean e(o oVar, MenuItem menuItem) {
        int i10;
        j0 j0Var;
        Window.Callback R2 = R();
        if (R2 != null && !this.Y) {
            o k10 = oVar.k();
            j0[] j0VarArr = this.T;
            if (j0VarArr != null) {
                i10 = j0VarArr.length;
            } else {
                i10 = 0;
            }
            int i11 = 0;
            while (true) {
                if (i11 < i10) {
                    j0Var = j0VarArr[i11];
                    if (j0Var != null && j0Var.f6112h == k10) {
                        break;
                    }
                    i11++;
                } else {
                    j0Var = null;
                    break;
                }
            }
            if (j0Var != null) {
                return R2.onMenuItemSelected(j0Var.f6105a, menuItem);
            }
        }
        return false;
    }

    public final Context g() {
        return this.f6167r;
    }

    public final int h() {
        return this.f6151a0;
    }

    public final MenuInflater j() {
        if (this.f6172w == null) {
            S();
            b1 b1Var = this.f6171v;
            this.f6172w = new l(b1Var != null ? b1Var.c() : this.f6167r);
        }
        return this.f6172w;
    }

    public final void k() {
        LayoutInflater from = LayoutInflater.from(this.f6167r);
        if (from.getFactory() == null) {
            from.setFactory2(this);
        } else if (!(from.getFactory2() instanceof k0)) {
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x005d, code lost:
        if (r6 == false) goto L_0x00ee;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x009f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void l(m.o r6) {
        /*
            r5 = this;
            androidx.appcompat.widget.e2 r6 = r5.f6174y
            r0 = 0
            r1 = 1
            if (r6 == 0) goto L_0x00ee
            androidx.appcompat.widget.ActionBarOverlayLayout r6 = (androidx.appcompat.widget.ActionBarOverlayLayout) r6
            r6.l()
            androidx.appcompat.widget.f2 r6 = r6.f608l
            androidx.appcompat.widget.d5 r6 = (androidx.appcompat.widget.d5) r6
            androidx.appcompat.widget.Toolbar r6 = r6.f791a
            int r2 = r6.getVisibility()
            if (r2 != 0) goto L_0x0021
            androidx.appcompat.widget.ActionMenuView r6 = r6.f691h
            if (r6 == 0) goto L_0x0021
            boolean r6 = r6.f626z
            if (r6 == 0) goto L_0x0021
            r6 = 1
            goto L_0x0022
        L_0x0021:
            r6 = 0
        L_0x0022:
            if (r6 == 0) goto L_0x00ee
            android.content.Context r6 = r5.f6167r
            android.view.ViewConfiguration r6 = android.view.ViewConfiguration.get(r6)
            boolean r6 = r6.hasPermanentMenuKey()
            if (r6 == 0) goto L_0x005f
            androidx.appcompat.widget.e2 r6 = r5.f6174y
            androidx.appcompat.widget.ActionBarOverlayLayout r6 = (androidx.appcompat.widget.ActionBarOverlayLayout) r6
            r6.l()
            androidx.appcompat.widget.f2 r6 = r6.f608l
            androidx.appcompat.widget.d5 r6 = (androidx.appcompat.widget.d5) r6
            androidx.appcompat.widget.Toolbar r6 = r6.f791a
            androidx.appcompat.widget.ActionMenuView r6 = r6.f691h
            if (r6 == 0) goto L_0x005c
            androidx.appcompat.widget.n r6 = r6.A
            if (r6 == 0) goto L_0x0057
            android.support.v4.media.j r2 = r6.C
            if (r2 != 0) goto L_0x0052
            boolean r6 = r6.f()
            if (r6 == 0) goto L_0x0050
            goto L_0x0052
        L_0x0050:
            r6 = 0
            goto L_0x0053
        L_0x0052:
            r6 = 1
        L_0x0053:
            if (r6 == 0) goto L_0x0057
            r6 = 1
            goto L_0x0058
        L_0x0057:
            r6 = 0
        L_0x0058:
            if (r6 == 0) goto L_0x005c
            r6 = 1
            goto L_0x005d
        L_0x005c:
            r6 = 0
        L_0x005d:
            if (r6 == 0) goto L_0x00ee
        L_0x005f:
            android.view.Window$Callback r6 = r5.R()
            androidx.appcompat.widget.e2 r2 = r5.f6174y
            androidx.appcompat.widget.ActionBarOverlayLayout r2 = (androidx.appcompat.widget.ActionBarOverlayLayout) r2
            r2.l()
            androidx.appcompat.widget.f2 r2 = r2.f608l
            androidx.appcompat.widget.d5 r2 = (androidx.appcompat.widget.d5) r2
            androidx.appcompat.widget.Toolbar r2 = r2.f791a
            androidx.appcompat.widget.ActionMenuView r2 = r2.f691h
            if (r2 == 0) goto L_0x0085
            androidx.appcompat.widget.n r2 = r2.A
            if (r2 == 0) goto L_0x0080
            boolean r2 = r2.f()
            if (r2 == 0) goto L_0x0080
            r2 = 1
            goto L_0x0081
        L_0x0080:
            r2 = 0
        L_0x0081:
            if (r2 == 0) goto L_0x0085
            r2 = 1
            goto L_0x0086
        L_0x0085:
            r2 = 0
        L_0x0086:
            r3 = 108(0x6c, float:1.51E-43)
            if (r2 == 0) goto L_0x009f
            androidx.appcompat.widget.e2 r1 = r5.f6174y
            androidx.appcompat.widget.ActionBarOverlayLayout r1 = (androidx.appcompat.widget.ActionBarOverlayLayout) r1
            r1.i()
            boolean r1 = r5.Y
            if (r1 != 0) goto L_0x00fb
            g.j0 r0 = r5.Q(r0)
            m.o r0 = r0.f6112h
            r6.onPanelClosed(r3, r0)
            goto L_0x00fb
        L_0x009f:
            if (r6 == 0) goto L_0x00fb
            boolean r2 = r5.Y
            if (r2 != 0) goto L_0x00fb
            boolean r2 = r5.f6157g0
            if (r2 == 0) goto L_0x00bc
            int r2 = r5.f6158h0
            r1 = r1 & r2
            if (r1 == 0) goto L_0x00bc
            android.view.Window r1 = r5.f6168s
            android.view.View r1 = r1.getDecorView()
            g.u r2 = r5.f6159i0
            r1.removeCallbacks(r2)
            r2.run()
        L_0x00bc:
            g.j0 r1 = r5.Q(r0)
            m.o r2 = r1.f6112h
            if (r2 == 0) goto L_0x00fb
            boolean r4 = r1.f6119o
            if (r4 != 0) goto L_0x00fb
            android.view.View r4 = r1.f6111g
            boolean r0 = r6.onPreparePanel(r0, r4, r2)
            if (r0 == 0) goto L_0x00fb
            m.o r0 = r1.f6112h
            r6.onMenuOpened(r3, r0)
            androidx.appcompat.widget.e2 r6 = r5.f6174y
            androidx.appcompat.widget.ActionBarOverlayLayout r6 = (androidx.appcompat.widget.ActionBarOverlayLayout) r6
            r6.l()
            androidx.appcompat.widget.f2 r6 = r6.f608l
            androidx.appcompat.widget.d5 r6 = (androidx.appcompat.widget.d5) r6
            androidx.appcompat.widget.Toolbar r6 = r6.f791a
            androidx.appcompat.widget.ActionMenuView r6 = r6.f691h
            if (r6 == 0) goto L_0x00fb
            androidx.appcompat.widget.n r6 = r6.A
            if (r6 == 0) goto L_0x00fb
            r6.n()
            goto L_0x00fb
        L_0x00ee:
            g.j0 r6 = r5.Q(r0)
            r6.f6118n = r1
            r5.I(r6, r0)
            r0 = 0
            r5.V(r6, r0)
        L_0x00fb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: g.k0.l(m.o):void");
    }

    public final void m() {
        if (this.f6171v != null) {
            S();
            this.f6171v.getClass();
            this.f6158h0 |= 1;
            if (!this.f6157g0) {
                View decorView = this.f6168s.getDecorView();
                WeakHashMap weakHashMap = c1.f10054a;
                i0.m(decorView, this.f6159i0);
                this.f6157g0 = true;
            }
        }
    }

    public final void o() {
        if (this.N && this.H) {
            S();
            b1 b1Var = this.f6171v;
            if (b1Var != null) {
                b1Var.f(b1Var.f6027a.getResources().getBoolean(R.bool.abc_action_bar_embed_tabs));
            }
        }
        h0 a10 = h0.a();
        Context context = this.f6167r;
        synchronized (a10) {
            a10.f845a.k(context);
        }
        this.Z = new Configuration(this.f6167r.getResources().getConfiguration());
        D(false, false);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: androidx.appcompat.widget.j0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: androidx.appcompat.widget.j0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v15, resolved type: androidx.appcompat.widget.c0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v73, resolved type: androidx.appcompat.widget.t0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v74, resolved type: androidx.appcompat.widget.e0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v75, resolved type: androidx.appcompat.widget.p0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v76, resolved type: androidx.appcompat.widget.c0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v77, resolved type: androidx.appcompat.widget.m0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v78, resolved type: androidx.appcompat.widget.v0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v79, resolved type: androidx.appcompat.widget.h1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v80, resolved type: androidx.appcompat.widget.s0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v81, resolved type: androidx.appcompat.widget.c2} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v82, resolved type: androidx.appcompat.widget.o0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v83, resolved type: androidx.appcompat.widget.a0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v84, resolved type: androidx.appcompat.widget.d0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v85, resolved type: androidx.appcompat.widget.j0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v86, resolved type: androidx.appcompat.widget.c0} */
    /* JADX WARNING: type inference failed for: r2v6 */
    /* JADX WARNING: type inference failed for: r9v13, types: [android.view.View] */
    /* JADX WARNING: type inference failed for: r4v3, types: [android.view.View] */
    /* JADX WARNING: type inference failed for: r2v16, types: [androidx.appcompat.widget.t1] */
    /* JADX WARNING: type inference failed for: r2v27 */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0110, code lost:
        if (r10.equals("ImageButton") == false) goto L_0x013f;
     */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View onCreateView(android.view.View r9, java.lang.String r10, android.content.Context r11, android.util.AttributeSet r12) {
        /*
            r8 = this;
            g.p0 r9 = r8.f6163m0
            r0 = 0
            if (r9 != 0) goto L_0x0054
            int[] r9 = f.a.f5401k
            android.content.Context r1 = r8.f6167r
            android.content.res.TypedArray r9 = r1.obtainStyledAttributes(r9)
            r2 = 116(0x74, float:1.63E-43)
            java.lang.String r9 = r9.getString(r2)
            if (r9 != 0) goto L_0x001b
            g.p0 r9 = new g.p0
            r9.<init>()
            goto L_0x0052
        L_0x001b:
            java.lang.ClassLoader r1 = r1.getClassLoader()     // Catch:{ all -> 0x0034 }
            java.lang.Class r1 = r1.loadClass(r9)     // Catch:{ all -> 0x0034 }
            java.lang.Class[] r2 = new java.lang.Class[r0]     // Catch:{ all -> 0x0034 }
            java.lang.reflect.Constructor r1 = r1.getDeclaredConstructor(r2)     // Catch:{ all -> 0x0034 }
            java.lang.Object[] r2 = new java.lang.Object[r0]     // Catch:{ all -> 0x0034 }
            java.lang.Object r1 = r1.newInstance(r2)     // Catch:{ all -> 0x0034 }
            g.p0 r1 = (g.p0) r1     // Catch:{ all -> 0x0034 }
            r8.f6163m0 = r1     // Catch:{ all -> 0x0034 }
            goto L_0x0054
        L_0x0034:
            r1 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Failed to instantiate custom view inflater "
            r2.<init>(r3)
            r2.append(r9)
            java.lang.String r9 = ". Falling back to default."
            r2.append(r9)
            java.lang.String r9 = r2.toString()
            java.lang.String r2 = "AppCompatDelegate"
            android.util.Log.i(r2, r9, r1)
            g.p0 r9 = new g.p0
            r9.<init>()
        L_0x0052:
            r8.f6163m0 = r9
        L_0x0054:
            g.p0 r9 = r8.f6163m0
            int r1 = androidx.appcompat.widget.j5.f901a
            r9.getClass()
            int[] r1 = f.a.A
            android.content.res.TypedArray r1 = r11.obtainStyledAttributes(r12, r1, r0, r0)
            r2 = 4
            int r3 = r1.getResourceId(r2, r0)
            if (r3 == 0) goto L_0x006f
            java.lang.String r4 = "AppCompatViewInflater"
            java.lang.String r5 = "app:theme is now deprecated. Please move to using android:theme instead."
            android.util.Log.i(r4, r5)
        L_0x006f:
            r1.recycle()
            if (r3 == 0) goto L_0x0085
            boolean r1 = r11 instanceof l.f
            if (r1 == 0) goto L_0x007f
            r1 = r11
            l.f r1 = (l.f) r1
            int r1 = r1.f9435a
            if (r1 == r3) goto L_0x0085
        L_0x007f:
            l.f r1 = new l.f
            r1.<init>((android.content.Context) r11, (int) r3)
            goto L_0x0086
        L_0x0085:
            r1 = r11
        L_0x0086:
            r10.getClass()
            int r3 = r10.hashCode()
            r4 = -1
            r5 = 1
            r6 = 3
            switch(r3) {
                case -1946472170: goto L_0x0134;
                case -1455429095: goto L_0x0129;
                case -1346021293: goto L_0x011e;
                case -938935918: goto L_0x0113;
                case -937446323: goto L_0x010a;
                case -658531749: goto L_0x00ff;
                case -339785223: goto L_0x00f4;
                case 776382189: goto L_0x00e9;
                case 799298502: goto L_0x00db;
                case 1125864064: goto L_0x00cd;
                case 1413872058: goto L_0x00bf;
                case 1601505219: goto L_0x00b1;
                case 1666676343: goto L_0x00a3;
                case 2001146706: goto L_0x0095;
                default: goto L_0x0093;
            }
        L_0x0093:
            goto L_0x013f
        L_0x0095:
            java.lang.String r2 = "Button"
            boolean r2 = r10.equals(r2)
            if (r2 != 0) goto L_0x009f
            goto L_0x013f
        L_0x009f:
            r2 = 13
            goto L_0x0140
        L_0x00a3:
            java.lang.String r2 = "EditText"
            boolean r2 = r10.equals(r2)
            if (r2 != 0) goto L_0x00ad
            goto L_0x013f
        L_0x00ad:
            r2 = 12
            goto L_0x0140
        L_0x00b1:
            java.lang.String r2 = "CheckBox"
            boolean r2 = r10.equals(r2)
            if (r2 != 0) goto L_0x00bb
            goto L_0x013f
        L_0x00bb:
            r2 = 11
            goto L_0x0140
        L_0x00bf:
            java.lang.String r2 = "AutoCompleteTextView"
            boolean r2 = r10.equals(r2)
            if (r2 != 0) goto L_0x00c9
            goto L_0x013f
        L_0x00c9:
            r2 = 10
            goto L_0x0140
        L_0x00cd:
            java.lang.String r2 = "ImageView"
            boolean r2 = r10.equals(r2)
            if (r2 != 0) goto L_0x00d7
            goto L_0x013f
        L_0x00d7:
            r2 = 9
            goto L_0x0140
        L_0x00db:
            java.lang.String r2 = "ToggleButton"
            boolean r2 = r10.equals(r2)
            if (r2 != 0) goto L_0x00e5
            goto L_0x013f
        L_0x00e5:
            r2 = 8
            goto L_0x0140
        L_0x00e9:
            java.lang.String r2 = "RadioButton"
            boolean r2 = r10.equals(r2)
            if (r2 != 0) goto L_0x00f2
            goto L_0x013f
        L_0x00f2:
            r2 = 7
            goto L_0x0140
        L_0x00f4:
            java.lang.String r2 = "Spinner"
            boolean r2 = r10.equals(r2)
            if (r2 != 0) goto L_0x00fd
            goto L_0x013f
        L_0x00fd:
            r2 = 6
            goto L_0x0140
        L_0x00ff:
            java.lang.String r2 = "SeekBar"
            boolean r2 = r10.equals(r2)
            if (r2 != 0) goto L_0x0108
            goto L_0x013f
        L_0x0108:
            r2 = 5
            goto L_0x0140
        L_0x010a:
            java.lang.String r3 = "ImageButton"
            boolean r3 = r10.equals(r3)
            if (r3 != 0) goto L_0x0140
            goto L_0x013f
        L_0x0113:
            java.lang.String r2 = "TextView"
            boolean r2 = r10.equals(r2)
            if (r2 != 0) goto L_0x011c
            goto L_0x013f
        L_0x011c:
            r2 = 3
            goto L_0x0140
        L_0x011e:
            java.lang.String r2 = "MultiAutoCompleteTextView"
            boolean r2 = r10.equals(r2)
            if (r2 != 0) goto L_0x0127
            goto L_0x013f
        L_0x0127:
            r2 = 2
            goto L_0x0140
        L_0x0129:
            java.lang.String r2 = "CheckedTextView"
            boolean r2 = r10.equals(r2)
            if (r2 != 0) goto L_0x0132
            goto L_0x013f
        L_0x0132:
            r2 = 1
            goto L_0x0140
        L_0x0134:
            java.lang.String r2 = "RatingBar"
            boolean r2 = r10.equals(r2)
            if (r2 != 0) goto L_0x013d
            goto L_0x013f
        L_0x013d:
            r2 = 0
            goto L_0x0140
        L_0x013f:
            r2 = -1
        L_0x0140:
            r3 = 0
            switch(r2) {
                case 0: goto L_0x01bd;
                case 1: goto L_0x01b7;
                case 2: goto L_0x01b1;
                case 3: goto L_0x0183;
                case 4: goto L_0x017a;
                case 5: goto L_0x0174;
                case 6: goto L_0x016e;
                case 7: goto L_0x0169;
                case 8: goto L_0x0163;
                case 9: goto L_0x015d;
                case 10: goto L_0x0158;
                case 11: goto L_0x0153;
                case 12: goto L_0x014c;
                case 13: goto L_0x0147;
                default: goto L_0x0144;
            }
        L_0x0144:
            r2 = r3
            goto L_0x01c2
        L_0x0147:
            androidx.appcompat.widget.c0 r2 = r9.b(r1, r12)
            goto L_0x0187
        L_0x014c:
            androidx.appcompat.widget.j0 r2 = new androidx.appcompat.widget.j0
            r2.<init>(r1, r12, r0)
            goto L_0x01c2
        L_0x0153:
            androidx.appcompat.widget.d0 r2 = r9.c(r1, r12)
            goto L_0x0187
        L_0x0158:
            androidx.appcompat.widget.a0 r2 = r9.a(r1, r12)
            goto L_0x0187
        L_0x015d:
            androidx.appcompat.widget.o0 r2 = new androidx.appcompat.widget.o0
            r2.<init>(r1, r12, r0)
            goto L_0x01c2
        L_0x0163:
            androidx.appcompat.widget.c2 r2 = new androidx.appcompat.widget.c2
            r2.<init>(r1, r12)
            goto L_0x01c2
        L_0x0169:
            androidx.appcompat.widget.s0 r2 = r9.d(r1, r12)
            goto L_0x0187
        L_0x016e:
            androidx.appcompat.widget.h1 r2 = new androidx.appcompat.widget.h1
            r2.<init>(r1, r12)
            goto L_0x01c2
        L_0x0174:
            androidx.appcompat.widget.v0 r2 = new androidx.appcompat.widget.v0
            r2.<init>(r1, r12)
            goto L_0x01c2
        L_0x017a:
            androidx.appcompat.widget.m0 r2 = new androidx.appcompat.widget.m0
            r7 = 2130969184(0x7f040260, float:1.7547043E38)
            r2.<init>(r1, r12, r7)
            goto L_0x01c2
        L_0x0183:
            androidx.appcompat.widget.t1 r2 = r9.e(r1, r12)
        L_0x0187:
            if (r2 == 0) goto L_0x018a
            goto L_0x01c2
        L_0x018a:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.Class r9 = r9.getClass()
            java.lang.String r9 = r9.getName()
            r12.append(r9)
            java.lang.String r9 = " asked to inflate view for <"
            r12.append(r9)
            r12.append(r10)
            java.lang.String r9 = ">, but returned null"
            r12.append(r9)
            java.lang.String r9 = r12.toString()
            r11.<init>(r9)
            throw r11
        L_0x01b1:
            androidx.appcompat.widget.p0 r2 = new androidx.appcompat.widget.p0
            r2.<init>(r1, r12)
            goto L_0x01c2
        L_0x01b7:
            androidx.appcompat.widget.e0 r2 = new androidx.appcompat.widget.e0
            r2.<init>(r1, r12)
            goto L_0x01c2
        L_0x01bd:
            androidx.appcompat.widget.t0 r2 = new androidx.appcompat.widget.t0
            r2.<init>(r1, r12)
        L_0x01c2:
            if (r2 != 0) goto L_0x0212
            if (r11 == r1) goto L_0x0212
            java.lang.Object[] r11 = r9.f6197a
            java.lang.String r2 = "view"
            boolean r2 = r10.equals(r2)
            if (r2 == 0) goto L_0x01d6
            java.lang.String r10 = "class"
            java.lang.String r10 = r12.getAttributeValue(r3, r10)
        L_0x01d6:
            r11[r0] = r1     // Catch:{ Exception -> 0x020d, all -> 0x0207 }
            r11[r5] = r12     // Catch:{ Exception -> 0x020d, all -> 0x0207 }
            r2 = 46
            int r2 = r10.indexOf(r2)     // Catch:{ Exception -> 0x020d, all -> 0x0207 }
            if (r4 != r2) goto L_0x01fd
            r2 = 0
        L_0x01e3:
            java.lang.String[] r4 = g.p0.f6195g     // Catch:{ Exception -> 0x020d, all -> 0x0207 }
            if (r2 >= r6) goto L_0x01f8
            r4 = r4[r2]     // Catch:{ Exception -> 0x020d, all -> 0x0207 }
            android.view.View r4 = r9.f(r1, r10, r4)     // Catch:{ Exception -> 0x020d, all -> 0x0207 }
            if (r4 == 0) goto L_0x01f5
            r11[r0] = r3
            r11[r5] = r3
            r3 = r4
            goto L_0x0211
        L_0x01f5:
            int r2 = r2 + 1
            goto L_0x01e3
        L_0x01f8:
            r11[r0] = r3
            r11[r5] = r3
            goto L_0x0211
        L_0x01fd:
            android.view.View r9 = r9.f(r1, r10, r3)     // Catch:{ Exception -> 0x020d, all -> 0x0207 }
            r11[r0] = r3
            r11[r5] = r3
            r3 = r9
            goto L_0x0211
        L_0x0207:
            r9 = move-exception
            r11[r0] = r3
            r11[r5] = r3
            throw r9
        L_0x020d:
            r11[r0] = r3
            r11[r5] = r3
        L_0x0211:
            r2 = r3
        L_0x0212:
            if (r2 == 0) goto L_0x02a1
            android.content.Context r9 = r2.getContext()
            boolean r10 = r9 instanceof android.content.ContextWrapper
            if (r10 == 0) goto L_0x023c
            java.util.WeakHashMap r10 = m0.c1.f10054a
            boolean r10 = m0.h0.a(r2)
            if (r10 != 0) goto L_0x0225
            goto L_0x023c
        L_0x0225:
            int[] r10 = g.p0.f6191c
            android.content.res.TypedArray r9 = r9.obtainStyledAttributes(r12, r10)
            java.lang.String r10 = r9.getString(r0)
            if (r10 == 0) goto L_0x0239
            g.o0 r11 = new g.o0
            r11.<init>(r2, r10)
            r2.setOnClickListener(r11)
        L_0x0239:
            r9.recycle()
        L_0x023c:
            int r9 = android.os.Build.VERSION.SDK_INT
            r10 = 28
            if (r9 <= r10) goto L_0x0243
            goto L_0x02a1
        L_0x0243:
            int[] r9 = g.p0.f6192d
            android.content.res.TypedArray r9 = r1.obtainStyledAttributes(r12, r9)
            boolean r10 = r9.hasValue(r0)
            if (r10 == 0) goto L_0x0264
            boolean r10 = r9.getBoolean(r0, r0)
            java.util.WeakHashMap r11 = m0.c1.f10054a
            m0.e0 r11 = new m0.e0
            r3 = 2131362509(0x7f0a02cd, float:1.83448E38)
            r11.<init>(r3, r6)
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r10)
            r11.c(r2, r10)
        L_0x0264:
            r9.recycle()
            int[] r9 = g.p0.f6193e
            android.content.res.TypedArray r9 = r1.obtainStyledAttributes(r12, r9)
            boolean r10 = r9.hasValue(r0)
            if (r10 == 0) goto L_0x027a
            java.lang.String r10 = r9.getString(r0)
            m0.c1.q(r2, r10)
        L_0x027a:
            r9.recycle()
            int[] r9 = g.p0.f6194f
            android.content.res.TypedArray r9 = r1.obtainStyledAttributes(r12, r9)
            boolean r10 = r9.hasValue(r0)
            if (r10 == 0) goto L_0x029e
            boolean r10 = r9.getBoolean(r0, r0)
            java.util.WeakHashMap r11 = m0.c1.f10054a
            m0.e0 r11 = new m0.e0
            r12 = 2131362514(0x7f0a02d2, float:1.834481E38)
            r11.<init>(r12, r0)
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r10)
            r11.c(r2, r10)
        L_0x029e:
            r9.recycle()
        L_0x02a1:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: g.k0.onCreateView(android.view.View, java.lang.String, android.content.Context, android.util.AttributeSet):android.view.View");
    }

    public final void p() {
        String str;
        this.W = true;
        D(false, true);
        N();
        Object obj = this.f6166q;
        if (obj instanceof Activity) {
            try {
                Activity activity = (Activity) obj;
                str = b0.n.c(activity, activity.getComponentName());
            } catch (PackageManager.NameNotFoundException e10) {
                throw new IllegalArgumentException(e10);
            } catch (IllegalArgumentException unused) {
                str = null;
            }
            if (str != null) {
                b1 b1Var = this.f6171v;
                if (b1Var == null) {
                    this.f6160j0 = true;
                } else {
                    b1Var.e(true);
                }
            }
            synchronized (t.f6215o) {
                t.u(this);
                t.f6214n.add(new WeakReference(this));
            }
        }
        this.Z = new Configuration(this.f6167r.getResources().getConfiguration());
        this.X = true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void q() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f6166q
            boolean r0 = r0 instanceof android.app.Activity
            if (r0 == 0) goto L_0x0011
            java.lang.Object r0 = g.t.f6215o
            monitor-enter(r0)
            g.t.u(r3)     // Catch:{ all -> 0x000e }
            monitor-exit(r0)     // Catch:{ all -> 0x000e }
            goto L_0x0011
        L_0x000e:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x000e }
            throw r1
        L_0x0011:
            boolean r0 = r3.f6157g0
            if (r0 == 0) goto L_0x0020
            android.view.Window r0 = r3.f6168s
            android.view.View r0 = r0.getDecorView()
            g.u r1 = r3.f6159i0
            r0.removeCallbacks(r1)
        L_0x0020:
            r0 = 1
            r3.Y = r0
            int r0 = r3.f6151a0
            r1 = -100
            if (r0 == r1) goto L_0x004d
            java.lang.Object r0 = r3.f6166q
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L_0x004d
            android.app.Activity r0 = (android.app.Activity) r0
            boolean r0 = r0.isChangingConfigurations()
            if (r0 == 0) goto L_0x004d
            q.k r0 = f6147p0
            java.lang.Object r1 = r3.f6166q
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            int r2 = r3.f6151a0
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.put(r1, r2)
            goto L_0x005c
        L_0x004d:
            q.k r0 = f6147p0
            java.lang.Object r1 = r3.f6166q
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            r0.remove(r1)
        L_0x005c:
            g.f0 r0 = r3.f6155e0
            if (r0 == 0) goto L_0x0063
            r0.a()
        L_0x0063:
            g.f0 r0 = r3.f6156f0
            if (r0 == 0) goto L_0x006a
            r0.a()
        L_0x006a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: g.k0.q():void");
    }

    public final void r() {
        S();
        b1 b1Var = this.f6171v;
        if (b1Var != null) {
            b1Var.f6046t = true;
        }
    }

    public final void s() {
        D(true, false);
    }

    public final void t() {
        S();
        b1 b1Var = this.f6171v;
        if (b1Var != null) {
            b1Var.f6046t = false;
            l.n nVar = b1Var.f6045s;
            if (nVar != null) {
                nVar.a();
            }
        }
    }

    public final boolean v(int i10) {
        if (i10 == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            i10 = 108;
        } else if (i10 == 9) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            i10 = 109;
        }
        if (this.R && i10 == 108) {
            return false;
        }
        if (this.N && i10 == 1) {
            this.N = false;
        }
        if (i10 == 1) {
            Y();
            this.R = true;
            return true;
        } else if (i10 == 2) {
            Y();
            this.L = true;
            return true;
        } else if (i10 == 5) {
            Y();
            this.M = true;
            return true;
        } else if (i10 == 10) {
            Y();
            this.P = true;
            return true;
        } else if (i10 == 108) {
            Y();
            this.N = true;
            return true;
        } else if (i10 != 109) {
            return this.f6168s.requestFeature(i10);
        } else {
            Y();
            this.O = true;
            return true;
        }
    }

    public final void x(int i10) {
        M();
        ViewGroup viewGroup = (ViewGroup) this.I.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f6167r).inflate(i10, viewGroup);
        this.f6169t.a(this.f6168s.getCallback());
    }

    public final void y(View view) {
        M();
        ViewGroup viewGroup = (ViewGroup) this.I.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.f6169t.a(this.f6168s.getCallback());
    }

    public final void z(View view, ViewGroup.LayoutParams layoutParams) {
        M();
        ViewGroup viewGroup = (ViewGroup) this.I.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.f6169t.a(this.f6168s.getCallback());
    }

    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView((View) null, str, context, attributeSet);
    }
}
