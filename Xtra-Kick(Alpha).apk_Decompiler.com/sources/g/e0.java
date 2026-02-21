package g;

import android.os.Build;
import android.support.v4.media.h;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;
import java.util.List;
import l.p;
import l.q;
import m.o;

public final class e0 implements Window.Callback {

    /* renamed from: h  reason: collision with root package name */
    public final Window.Callback f6060h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f6061i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f6062j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f6063k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ k0 f6064l;

    public e0(k0 k0Var, Window.Callback callback) {
        this.f6064l = k0Var;
        if (callback != null) {
            this.f6060h = callback;
            return;
        }
        throw new IllegalArgumentException("Window callback may not be null");
    }

    /* JADX INFO: finally extract failed */
    public final void a(Window.Callback callback) {
        try {
            this.f6061i = true;
            callback.onContentChanged();
            this.f6061i = false;
        } catch (Throwable th) {
            this.f6061i = false;
            throw th;
        }
    }

    /* renamed from: b */
    public final boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return this.f6060h.dispatchGenericMotionEvent(motionEvent);
    }

    public final boolean c(KeyEvent keyEvent) {
        return this.f6060h.dispatchKeyEvent(keyEvent);
    }

    public final boolean d(KeyEvent keyEvent) {
        return this.f6060h.dispatchKeyShortcutEvent(keyEvent);
    }

    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.f6062j ? this.f6060h.dispatchKeyEvent(keyEvent) : this.f6064l.K(keyEvent) || c(keyEvent);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0038, code lost:
        if (r0 != false) goto L_0x0067;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0065, code lost:
        if (r7 != false) goto L_0x0067;
     */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x006d A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean dispatchKeyShortcutEvent(android.view.KeyEvent r7) {
        /*
            r6 = this;
            boolean r0 = r6.d(r7)
            r1 = 1
            if (r0 != 0) goto L_0x006e
            int r0 = r7.getKeyCode()
            g.k0 r2 = r6.f6064l
            r2.S()
            g.b1 r3 = r2.f6171v
            r4 = 0
            if (r3 == 0) goto L_0x003b
            g.a1 r3 = r3.f6035i
            if (r3 != 0) goto L_0x001a
            goto L_0x0037
        L_0x001a:
            m.o r3 = r3.f6021k
            if (r3 == 0) goto L_0x0037
            int r5 = r7.getDeviceId()
            android.view.KeyCharacterMap r5 = android.view.KeyCharacterMap.load(r5)
            int r5 = r5.getKeyboardType()
            if (r5 == r1) goto L_0x002e
            r5 = 1
            goto L_0x002f
        L_0x002e:
            r5 = 0
        L_0x002f:
            r3.setQwertyMode(r5)
            boolean r0 = r3.performShortcut(r0, r7, r4)
            goto L_0x0038
        L_0x0037:
            r0 = 0
        L_0x0038:
            if (r0 == 0) goto L_0x003b
            goto L_0x0067
        L_0x003b:
            g.j0 r0 = r2.U
            if (r0 == 0) goto L_0x0050
            int r3 = r7.getKeyCode()
            boolean r0 = r2.W(r0, r3, r7)
            if (r0 == 0) goto L_0x0050
            g.j0 r7 = r2.U
            if (r7 == 0) goto L_0x0067
            r7.f6116l = r1
            goto L_0x0067
        L_0x0050:
            g.j0 r0 = r2.U
            if (r0 != 0) goto L_0x0069
            g.j0 r0 = r2.Q(r4)
            r2.X(r0, r7)
            int r3 = r7.getKeyCode()
            boolean r7 = r2.W(r0, r3, r7)
            r0.f6115k = r4
            if (r7 == 0) goto L_0x0069
        L_0x0067:
            r7 = 1
            goto L_0x006a
        L_0x0069:
            r7 = 0
        L_0x006a:
            if (r7 == 0) goto L_0x006d
            goto L_0x006e
        L_0x006d:
            r1 = 0
        L_0x006e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: g.e0.dispatchKeyShortcutEvent(android.view.KeyEvent):boolean");
    }

    /* renamed from: e */
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return this.f6060h.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    /* renamed from: f */
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.f6060h.dispatchTouchEvent(motionEvent);
    }

    /* renamed from: g */
    public final boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return this.f6060h.dispatchTrackballEvent(motionEvent);
    }

    /* renamed from: h */
    public final void onActionModeFinished(ActionMode actionMode) {
        this.f6060h.onActionModeFinished(actionMode);
    }

    /* renamed from: i */
    public final void onActionModeStarted(ActionMode actionMode) {
        this.f6060h.onActionModeStarted(actionMode);
    }

    /* renamed from: j */
    public final void onAttachedToWindow() {
        this.f6060h.onAttachedToWindow();
    }

    public final boolean k(int i10, Menu menu) {
        return this.f6060h.onCreatePanelMenu(i10, menu);
    }

    public final View l(int i10) {
        return this.f6060h.onCreatePanelView(i10);
    }

    /* renamed from: m */
    public final void onDetachedFromWindow() {
        this.f6060h.onDetachedFromWindow();
    }

    /* renamed from: n */
    public final boolean onMenuItemSelected(int i10, MenuItem menuItem) {
        return this.f6060h.onMenuItemSelected(i10, menuItem);
    }

    public final boolean o(int i10, Menu menu) {
        return this.f6060h.onMenuOpened(i10, menu);
    }

    public final void onContentChanged() {
        if (this.f6061i) {
            this.f6060h.onContentChanged();
        }
    }

    public final boolean onCreatePanelMenu(int i10, Menu menu) {
        if (i10 != 0 || (menu instanceof o)) {
            return k(i10, menu);
        }
        return false;
    }

    public final View onCreatePanelView(int i10) {
        return l(i10);
    }

    public final boolean onMenuOpened(int i10, Menu menu) {
        o(i10, menu);
        k0 k0Var = this.f6064l;
        if (i10 == 108) {
            k0Var.S();
            b1 b1Var = k0Var.f6171v;
            if (!(b1Var == null || true == b1Var.f6038l)) {
                b1Var.f6038l = true;
                ArrayList arrayList = b1Var.f6039m;
                if (arrayList.size() > 0) {
                    h.y(arrayList.get(0));
                    throw null;
                }
            }
        } else {
            k0Var.getClass();
        }
        return true;
    }

    public final void onPanelClosed(int i10, Menu menu) {
        if (this.f6063k) {
            this.f6060h.onPanelClosed(i10, menu);
            return;
        }
        p(i10, menu);
        k0 k0Var = this.f6064l;
        if (i10 == 108) {
            k0Var.S();
            b1 b1Var = k0Var.f6171v;
            if (b1Var != null && b1Var.f6038l) {
                b1Var.f6038l = false;
                ArrayList arrayList = b1Var.f6039m;
                if (arrayList.size() > 0) {
                    h.y(arrayList.get(0));
                    throw null;
                }
            }
        } else if (i10 == 0) {
            j0 Q = k0Var.Q(i10);
            if (Q.f6117m) {
                k0Var.I(Q, false);
            }
        } else {
            k0Var.getClass();
        }
    }

    public final boolean onPreparePanel(int i10, View view, Menu menu) {
        o oVar;
        if (menu instanceof o) {
            oVar = (o) menu;
        } else {
            oVar = null;
        }
        if (i10 == 0 && oVar == null) {
            return false;
        }
        if (oVar != null) {
            oVar.f9995x = true;
        }
        boolean r10 = r(i10, view, menu);
        if (oVar != null) {
            oVar.f9995x = false;
        }
        return r10;
    }

    public final void onProvideKeyboardShortcuts(List list, Menu menu, int i10) {
        o oVar = this.f6064l.Q(0).f6112h;
        if (oVar != null) {
            s(list, oVar, i10);
        } else {
            s(list, menu, i10);
        }
    }

    public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        if (Build.VERSION.SDK_INT >= 23) {
            return null;
        }
        return this.f6064l.G ? z(callback) : x(callback);
    }

    public final void p(int i10, Menu menu) {
        this.f6060h.onPanelClosed(i10, menu);
    }

    /* renamed from: q */
    public final void onPointerCaptureChanged(boolean z10) {
        q.a(this.f6060h, z10);
    }

    public final boolean r(int i10, View view, Menu menu) {
        return this.f6060h.onPreparePanel(i10, view, menu);
    }

    public final void s(List list, Menu menu, int i10) {
        p.a(this.f6060h, list, menu, i10);
    }

    /* renamed from: t */
    public final boolean onSearchRequested() {
        return this.f6060h.onSearchRequested();
    }

    /* renamed from: u */
    public final boolean onSearchRequested(SearchEvent searchEvent) {
        return l.o.a(this.f6060h, searchEvent);
    }

    /* renamed from: v */
    public final void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        this.f6060h.onWindowAttributesChanged(layoutParams);
    }

    /* renamed from: w */
    public final void onWindowFocusChanged(boolean z10) {
        this.f6060h.onWindowFocusChanged(z10);
    }

    public final ActionMode x(ActionMode.Callback callback) {
        return this.f6060h.onWindowStartingActionMode(callback);
    }

    public final ActionMode y(ActionMode.Callback callback, int i10) {
        return l.o.b(this.f6060h, callback, i10);
    }

    /* JADX WARNING: Removed duplicated region for block: B:70:0x0180  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x019a  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x01bf  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final l.i z(android.view.ActionMode.Callback r11) {
        /*
            r10 = this;
            l.h r0 = new l.h
            g.k0 r1 = r10.f6064l
            android.content.Context r2 = r1.f6167r
            r0.<init>((android.content.Context) r2, (android.view.ActionMode.Callback) r11)
            l.c r11 = r1.B
            if (r11 == 0) goto L_0x0010
            r11.a()
        L_0x0010:
            g.x r11 = new g.x
            r11.<init>(r1, r0)
            r1.S()
            g.b1 r2 = r1.f6171v
            r3 = 0
            r4 = 1
            r5 = 0
            g.p r6 = r1.f6170u
            if (r2 == 0) goto L_0x006b
            g.a1 r7 = r2.f6035i
            if (r7 == 0) goto L_0x0028
            r7.a()
        L_0x0028:
            androidx.appcompat.widget.ActionBarOverlayLayout r7 = r2.f6029c
            r7.setHideOnContentScrollEnabled(r5)
            androidx.appcompat.widget.ActionBarContextView r7 = r2.f6032f
            r7.e()
            g.a1 r7 = new g.a1
            androidx.appcompat.widget.ActionBarContextView r8 = r2.f6032f
            android.content.Context r8 = r8.getContext()
            r7.<init>(r2, r8, r11)
            m.o r8 = r7.f6021k
            r8.x()
            l.b r9 = r7.f6022l     // Catch:{ all -> 0x0066 }
            boolean r9 = r9.g(r7, r8)     // Catch:{ all -> 0x0066 }
            r8.w()
            if (r9 == 0) goto L_0x005b
            r2.f6035i = r7
            r7.h()
            androidx.appcompat.widget.ActionBarContextView r8 = r2.f6032f
            r8.c(r7)
            r2.a(r4)
            goto L_0x005c
        L_0x005b:
            r7 = r3
        L_0x005c:
            r1.B = r7
            if (r7 == 0) goto L_0x006b
            if (r6 == 0) goto L_0x006b
            r6.f()
            goto L_0x006b
        L_0x0066:
            r11 = move-exception
            r8.w()
            throw r11
        L_0x006b:
            l.c r2 = r1.B
            if (r2 != 0) goto L_0x01dd
            m0.n1 r2 = r1.F
            if (r2 == 0) goto L_0x0076
            r2.b()
        L_0x0076:
            l.c r2 = r1.B
            if (r2 == 0) goto L_0x007d
            r2.a()
        L_0x007d:
            if (r6 == 0) goto L_0x0086
            boolean r2 = r1.Y
            if (r2 != 0) goto L_0x0086
            r6.g()     // Catch:{ AbstractMethodError -> 0x0086 }
        L_0x0086:
            androidx.appcompat.widget.ActionBarContextView r2 = r1.C
            if (r2 != 0) goto L_0x013a
            boolean r2 = r1.Q
            android.content.Context r7 = r1.f6167r
            if (r2 == 0) goto L_0x010d
            android.util.TypedValue r2 = new android.util.TypedValue
            r2.<init>()
            android.content.res.Resources$Theme r8 = r7.getTheme()
            r9 = 2130968588(0x7f04000c, float:1.7545834E38)
            r8.resolveAttribute(r9, r2, r4)
            int r9 = r2.resourceId
            if (r9 == 0) goto L_0x00c0
            android.content.res.Resources r9 = r7.getResources()
            android.content.res.Resources$Theme r9 = r9.newTheme()
            r9.setTo(r8)
            int r8 = r2.resourceId
            r9.applyStyle(r8, r4)
            l.f r8 = new l.f
            r8.<init>((android.content.Context) r7, (int) r5)
            android.content.res.Resources$Theme r7 = r8.getTheme()
            r7.setTo(r9)
            r7 = r8
        L_0x00c0:
            androidx.appcompat.widget.ActionBarContextView r8 = new androidx.appcompat.widget.ActionBarContextView
            r8.<init>(r7, r3)
            r1.C = r8
            android.widget.PopupWindow r8 = new android.widget.PopupWindow
            r9 = 2130968603(0x7f04001b, float:1.7545864E38)
            r8.<init>(r7, r3, r9)
            r1.D = r8
            r9 = 2
            q0.s.b(r8, r9)
            android.widget.PopupWindow r8 = r1.D
            androidx.appcompat.widget.ActionBarContextView r9 = r1.C
            r8.setContentView(r9)
            android.widget.PopupWindow r8 = r1.D
            r9 = -1
            r8.setWidth(r9)
            android.content.res.Resources$Theme r8 = r7.getTheme()
            r9 = 2130968582(0x7f040006, float:1.7545822E38)
            r8.resolveAttribute(r9, r2, r4)
            int r2 = r2.data
            android.content.res.Resources r7 = r7.getResources()
            android.util.DisplayMetrics r7 = r7.getDisplayMetrics()
            int r2 = android.util.TypedValue.complexToDimensionPixelSize(r2, r7)
            androidx.appcompat.widget.ActionBarContextView r7 = r1.C
            r7.setContentHeight(r2)
            android.widget.PopupWindow r2 = r1.D
            r7 = -2
            r2.setHeight(r7)
            g.u r2 = new g.u
            r2.<init>(r1, r4)
            r1.E = r2
            goto L_0x013a
        L_0x010d:
            android.view.ViewGroup r2 = r1.I
            r8 = 2131361865(0x7f0a0049, float:1.8343494E38)
            android.view.View r2 = r2.findViewById(r8)
            androidx.appcompat.widget.ViewStubCompat r2 = (androidx.appcompat.widget.ViewStubCompat) r2
            if (r2 == 0) goto L_0x013a
            r1.S()
            g.b1 r8 = r1.f6171v
            if (r8 == 0) goto L_0x0126
            android.content.Context r8 = r8.c()
            goto L_0x0127
        L_0x0126:
            r8 = r3
        L_0x0127:
            if (r8 != 0) goto L_0x012a
            goto L_0x012b
        L_0x012a:
            r7 = r8
        L_0x012b:
            android.view.LayoutInflater r7 = android.view.LayoutInflater.from(r7)
            r2.setLayoutInflater(r7)
            android.view.View r2 = r2.a()
            androidx.appcompat.widget.ActionBarContextView r2 = (androidx.appcompat.widget.ActionBarContextView) r2
            r1.C = r2
        L_0x013a:
            androidx.appcompat.widget.ActionBarContextView r2 = r1.C
            if (r2 == 0) goto L_0x01cd
            m0.n1 r2 = r1.F
            if (r2 == 0) goto L_0x0145
            r2.b()
        L_0x0145:
            androidx.appcompat.widget.ActionBarContextView r2 = r1.C
            r2.e()
            l.g r2 = new l.g
            androidx.appcompat.widget.ActionBarContextView r7 = r1.C
            android.content.Context r7 = r7.getContext()
            androidx.appcompat.widget.ActionBarContextView r8 = r1.C
            r2.<init>(r7, r8, r11)
            m.o r7 = r2.f9445o
            boolean r11 = r11.g(r2, r7)
            if (r11 == 0) goto L_0x01cb
            r2.h()
            androidx.appcompat.widget.ActionBarContextView r11 = r1.C
            r11.c(r2)
            r1.B = r2
            boolean r11 = r1.H
            if (r11 == 0) goto L_0x017b
            android.view.ViewGroup r11 = r1.I
            if (r11 == 0) goto L_0x017b
            java.util.WeakHashMap r2 = m0.c1.f10054a
            boolean r11 = m0.l0.c(r11)
            if (r11 == 0) goto L_0x017b
            r11 = 1
            goto L_0x017c
        L_0x017b:
            r11 = 0
        L_0x017c:
            r2 = 1065353216(0x3f800000, float:1.0)
            if (r11 == 0) goto L_0x019a
            androidx.appcompat.widget.ActionBarContextView r11 = r1.C
            r5 = 0
            r11.setAlpha(r5)
            androidx.appcompat.widget.ActionBarContextView r11 = r1.C
            m0.n1 r11 = m0.c1.a(r11)
            r11.a(r2)
            r1.F = r11
            g.w r2 = new g.w
            r2.<init>(r4, r1)
            r11.d(r2)
            goto L_0x01bb
        L_0x019a:
            androidx.appcompat.widget.ActionBarContextView r11 = r1.C
            r11.setAlpha(r2)
            androidx.appcompat.widget.ActionBarContextView r11 = r1.C
            r11.setVisibility(r5)
            androidx.appcompat.widget.ActionBarContextView r11 = r1.C
            android.view.ViewParent r11 = r11.getParent()
            boolean r11 = r11 instanceof android.view.View
            if (r11 == 0) goto L_0x01bb
            androidx.appcompat.widget.ActionBarContextView r11 = r1.C
            android.view.ViewParent r11 = r11.getParent()
            android.view.View r11 = (android.view.View) r11
            java.util.WeakHashMap r2 = m0.c1.f10054a
            m0.m0.c(r11)
        L_0x01bb:
            android.widget.PopupWindow r11 = r1.D
            if (r11 == 0) goto L_0x01cd
            android.view.Window r11 = r1.f6168s
            android.view.View r11 = r11.getDecorView()
            g.u r2 = r1.E
            r11.post(r2)
            goto L_0x01cd
        L_0x01cb:
            r1.B = r3
        L_0x01cd:
            l.c r11 = r1.B
            if (r11 == 0) goto L_0x01d6
            if (r6 == 0) goto L_0x01d6
            r6.f()
        L_0x01d6:
            r1.Z()
            l.c r11 = r1.B
            r1.B = r11
        L_0x01dd:
            r1.Z()
            l.c r11 = r1.B
            if (r11 == 0) goto L_0x01e9
            l.i r11 = r0.m(r11)
            return r11
        L_0x01e9:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: g.e0.z(android.view.ActionMode$Callback):l.i");
    }

    public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i10) {
        return (!this.f6064l.G || i10 != 0) ? y(callback, i10) : z(callback);
    }
}
