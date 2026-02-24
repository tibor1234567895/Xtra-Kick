package m0;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import com.woxthebox.draglistview.R;
import e.a;
import g.a0;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import n0.g;
import n0.x;
import q0.b0;

public final class c1 {

    /* renamed from: a  reason: collision with root package name */
    public static WeakHashMap f10054a = null;

    /* renamed from: b  reason: collision with root package name */
    public static Field f10055b;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f10056c = false;

    /* renamed from: d  reason: collision with root package name */
    public static ThreadLocal f10057d;

    /* renamed from: e  reason: collision with root package name */
    public static final int[] f10058e = {R.id.accessibility_custom_action_0, R.id.accessibility_custom_action_1, R.id.accessibility_custom_action_2, R.id.accessibility_custom_action_3, R.id.accessibility_custom_action_4, R.id.accessibility_custom_action_5, R.id.accessibility_custom_action_6, R.id.accessibility_custom_action_7, R.id.accessibility_custom_action_8, R.id.accessibility_custom_action_9, R.id.accessibility_custom_action_10, R.id.accessibility_custom_action_11, R.id.accessibility_custom_action_12, R.id.accessibility_custom_action_13, R.id.accessibility_custom_action_14, R.id.accessibility_custom_action_15, R.id.accessibility_custom_action_16, R.id.accessibility_custom_action_17, R.id.accessibility_custom_action_18, R.id.accessibility_custom_action_19, R.id.accessibility_custom_action_20, R.id.accessibility_custom_action_21, R.id.accessibility_custom_action_22, R.id.accessibility_custom_action_23, R.id.accessibility_custom_action_24, R.id.accessibility_custom_action_25, R.id.accessibility_custom_action_26, R.id.accessibility_custom_action_27, R.id.accessibility_custom_action_28, R.id.accessibility_custom_action_29, R.id.accessibility_custom_action_30, R.id.accessibility_custom_action_31};

    /* renamed from: f  reason: collision with root package name */
    public static final d0 f10059f = new d0();

    /* renamed from: g  reason: collision with root package name */
    public static final f0 f10060g = new f0();

    static {
        new AtomicInteger(1);
    }

    public static n1 a(View view) {
        if (f10054a == null) {
            f10054a = new WeakHashMap();
        }
        n1 n1Var = (n1) f10054a.get(view);
        if (n1Var != null) {
            return n1Var;
        }
        n1 n1Var2 = new n1(view);
        f10054a.put(view, n1Var2);
        return n1Var2;
    }

    public static boolean b(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        ArrayList arrayList = b1.f10043d;
        b1 b1Var = (b1) view.getTag(R.id.tag_unhandled_key_event_manager);
        if (b1Var == null) {
            b1Var = new b1();
            view.setTag(R.id.tag_unhandled_key_event_manager, b1Var);
        }
        if (keyEvent.getAction() == 0) {
            WeakHashMap weakHashMap = b1Var.f10044a;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            ArrayList arrayList2 = b1.f10043d;
            if (!arrayList2.isEmpty()) {
                synchronized (arrayList2) {
                    if (b1Var.f10044a == null) {
                        b1Var.f10044a = new WeakHashMap();
                    }
                    int size = arrayList2.size();
                    while (true) {
                        size--;
                        if (size < 0) {
                            break;
                        }
                        ArrayList arrayList3 = b1.f10043d;
                        View view2 = (View) ((WeakReference) arrayList3.get(size)).get();
                        if (view2 == null) {
                            arrayList3.remove(size);
                        } else {
                            b1Var.f10044a.put(view2, Boolean.TRUE);
                            for (ViewParent parent = view2.getParent(); parent instanceof View; parent = parent.getParent()) {
                                b1Var.f10044a.put((View) parent, Boolean.TRUE);
                            }
                        }
                    }
                }
            }
        }
        View a10 = b1Var.a(view);
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (a10 != null && !KeyEvent.isModifierKey(keyCode)) {
                if (b1Var.f10045b == null) {
                    b1Var.f10045b = new SparseArray();
                }
                b1Var.f10045b.put(keyCode, new WeakReference(a10));
            }
        }
        if (a10 != null) {
            return true;
        }
        return false;
    }

    public static View.AccessibilityDelegate c(View view) {
        if (Build.VERSION.SDK_INT >= 29) {
            return w0.a(view);
        }
        if (f10056c) {
            return null;
        }
        if (f10055b == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                f10055b = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable unused) {
                f10056c = true;
                return null;
            }
        }
        Object obj = f10055b.get(view);
        if (obj instanceof View.AccessibilityDelegate) {
            return (View.AccessibilityDelegate) obj;
        }
        return null;
    }

    public static CharSequence d(View view) {
        return (CharSequence) new e0(R.id.tag_accessibility_pane_title, 8, 28, 1).b(view);
    }

    public static ArrayList e(View view) {
        ArrayList arrayList = (ArrayList) view.getTag(R.id.tag_accessibility_actions);
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        view.setTag(R.id.tag_accessibility_actions, arrayList2);
        return arrayList2;
    }

    public static Rect f() {
        if (f10057d == null) {
            f10057d = new ThreadLocal();
        }
        Rect rect = (Rect) f10057d.get();
        if (rect == null) {
            rect = new Rect();
            f10057d.set(rect);
        }
        rect.setEmpty();
        return rect;
    }

    public static String[] g(View view) {
        return Build.VERSION.SDK_INT >= 31 ? y0.a(view) : (String[]) view.getTag(R.id.tag_on_receive_content_mime_types);
    }

    public static q2 h(View view) {
        return Build.VERSION.SDK_INT >= 23 ? p0.a(view) : o0.j(view);
    }

    public static void i(View view, int i10) {
        boolean z10;
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            if (d(view) == null || !view.isShown() || view.getWindowVisibility() != 0) {
                z10 = false;
            } else {
                z10 = true;
            }
            int i11 = 32;
            if (l0.a(view) != 0 || z10) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain();
                if (!z10) {
                    i11 = 2048;
                }
                obtain.setEventType(i11);
                l0.g(obtain, i10);
                if (z10) {
                    obtain.getText().add(d(view));
                    if (i0.c(view) == 0) {
                        i0.s(view, 1);
                    }
                    ViewParent parent = view.getParent();
                    while (true) {
                        if (!(parent instanceof View)) {
                            break;
                        } else if (i0.c((View) parent) == 4) {
                            i0.s(view, 2);
                            break;
                        } else {
                            parent = parent.getParent();
                        }
                    }
                }
                view.sendAccessibilityEventUnchecked(obtain);
            } else if (i10 == 32) {
                AccessibilityEvent obtain2 = AccessibilityEvent.obtain();
                view.onInitializeAccessibilityEvent(obtain2);
                obtain2.setEventType(32);
                l0.g(obtain2, i10);
                obtain2.setSource(view);
                view.onPopulateAccessibilityEvent(obtain2);
                obtain2.getText().add(d(view));
                accessibilityManager.sendAccessibilityEvent(obtain2);
            } else if (view.getParent() != null) {
                try {
                    l0.e(view.getParent(), view, view, i10);
                } catch (AbstractMethodError e10) {
                    Log.e("ViewCompat", view.getParent().getClass().getSimpleName().concat(" does not fully implement ViewParent"), e10);
                }
            }
        }
    }

    public static void j(View view, int i10) {
        boolean z10;
        if (Build.VERSION.SDK_INT >= 23) {
            view.offsetLeftAndRight(i10);
            return;
        }
        Rect f10 = f();
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            f10.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            z10 = !f10.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        } else {
            z10 = false;
        }
        view.offsetLeftAndRight(i10);
        if (view.getVisibility() == 0) {
            t(view);
            ViewParent parent2 = view.getParent();
            if (parent2 instanceof View) {
                t((View) parent2);
            }
        }
        if (z10 && f10.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            ((View) parent).invalidate(f10);
        }
    }

    public static void k(View view, int i10) {
        boolean z10;
        if (Build.VERSION.SDK_INT >= 23) {
            view.offsetTopAndBottom(i10);
            return;
        }
        Rect f10 = f();
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            f10.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            z10 = !f10.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        } else {
            z10 = false;
        }
        view.offsetTopAndBottom(i10);
        if (view.getVisibility() == 0) {
            t(view);
            ViewParent parent2 = view.getParent();
            if (parent2 instanceof View) {
                t((View) parent2);
            }
        }
        if (z10 && f10.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            ((View) parent).invalidate(f10);
        }
    }

    public static i l(View view, i iVar) {
        if (Log.isLoggable("ViewCompat", 3)) {
            Objects.toString(iVar);
            view.getClass();
            view.getId();
        }
        if (Build.VERSION.SDK_INT >= 31) {
            return y0.b(view, iVar);
        }
        z zVar = (z) view.getTag(R.id.tag_on_receive_content_listener);
        a0 a0Var = f10059f;
        if (zVar != null) {
            i a10 = ((b0) zVar).a(view, iVar);
            if (a10 == null) {
                return null;
            }
            if (view instanceof a0) {
                a0Var = (a0) view;
            }
            return a0Var.a(a10);
        }
        if (view instanceof a0) {
            a0Var = (a0) view;
        }
        return a0Var.a(iVar);
    }

    public static void m(View view, int i10) {
        ArrayList e10 = e(view);
        for (int i11 = 0; i11 < e10.size(); i11++) {
            if (((g) e10.get(i11)).a() == i10) {
                e10.remove(i11);
                return;
            }
        }
    }

    public static void n(View view, g gVar, x xVar) {
        c cVar;
        if (xVar == null) {
            m(view, gVar.a());
            i(view, 0);
            return;
        }
        g gVar2 = new g((Object) null, gVar.f10912b, (String) null, xVar, gVar.f10913c);
        View.AccessibilityDelegate c10 = c(view);
        if (c10 == null) {
            cVar = null;
        } else if (c10 instanceof a) {
            cVar = ((a) c10).f10038a;
        } else {
            cVar = new c(c10);
        }
        if (cVar == null) {
            cVar = new c();
        }
        p(view, cVar);
        m(view, gVar2.a());
        e(view).add(gVar2);
        i(view, 0);
    }

    public static void o(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i10) {
        if (Build.VERSION.SDK_INT >= 29) {
            w0.c(view, context, iArr, attributeSet, typedArray, i10, 0);
        }
    }

    public static void p(View view, c cVar) {
        a aVar;
        if (cVar == null && (c(view) instanceof a)) {
            cVar = new c();
        }
        if (cVar == null) {
            aVar = null;
        } else {
            aVar = cVar.f10053b;
        }
        view.setAccessibilityDelegate(aVar);
    }

    public static void q(View view, CharSequence charSequence) {
        boolean z10 = true;
        new e0(R.id.tag_accessibility_pane_title, 8, 28, 1).c(view, charSequence);
        f0 f0Var = f10060g;
        if (charSequence != null) {
            WeakHashMap weakHashMap = f0Var.f10073h;
            if (!view.isShown() || view.getWindowVisibility() != 0) {
                z10 = false;
            }
            weakHashMap.put(view, Boolean.valueOf(z10));
            view.addOnAttachStateChangeListener(f0Var);
            if (l0.b(view)) {
                view.getViewTreeObserver().addOnGlobalLayoutListener(f0Var);
                return;
            }
            return;
        }
        f0Var.f10073h.remove(view);
        view.removeOnAttachStateChangeListener(f0Var);
        i0.o(view.getViewTreeObserver(), f0Var);
    }

    public static void r(View view, ColorStateList colorStateList) {
        int i10 = Build.VERSION.SDK_INT;
        o0.q(view, colorStateList);
        if (i10 == 21) {
            Drawable background = view.getBackground();
            boolean z10 = (o0.g(view) == null && o0.h(view) == null) ? false : true;
            if (background != null && z10) {
                if (background.isStateful()) {
                    background.setState(view.getDrawableState());
                }
                i0.q(view, background);
            }
        }
    }

    public static void s(View view, a aVar) {
        PointerIcon pointerIcon;
        if (Build.VERSION.SDK_INT >= 24) {
            if (aVar != null) {
                pointerIcon = (PointerIcon) aVar.f4852i;
            } else {
                pointerIcon = null;
            }
            r0.d(view, a0.n(pointerIcon));
        }
    }

    public static void t(View view) {
        float translationY = view.getTranslationY();
        view.setTranslationY(1.0f + translationY);
        view.setTranslationY(translationY);
    }
}
