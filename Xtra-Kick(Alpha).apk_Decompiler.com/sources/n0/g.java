package n0;

import android.os.Build;
import android.view.accessibility.AccessibilityNodeInfo;

public final class g {

    /* renamed from: e  reason: collision with root package name */
    public static final g f10903e = new g(16);

    /* renamed from: f  reason: collision with root package name */
    public static final g f10904f = new g(4096);

    /* renamed from: g  reason: collision with root package name */
    public static final g f10905g = new g(8192);

    /* renamed from: h  reason: collision with root package name */
    public static final g f10906h = new g(262144);

    /* renamed from: i  reason: collision with root package name */
    public static final g f10907i = new g(524288);

    /* renamed from: j  reason: collision with root package name */
    public static final g f10908j = new g(1048576);

    /* renamed from: k  reason: collision with root package name */
    public static final g f10909k;

    /* renamed from: l  reason: collision with root package name */
    public static final g f10910l;

    /* renamed from: a  reason: collision with root package name */
    public final Object f10911a;

    /* renamed from: b  reason: collision with root package name */
    public final int f10912b;

    /* renamed from: c  reason: collision with root package name */
    public final Class f10913c;

    /* renamed from: d  reason: collision with root package name */
    public final x f10914d;

    static {
        new g(1);
        new g(2);
        new g(4);
        new g(8);
        new g(32);
        new g(64);
        new g(128);
        Class<q> cls = q.class;
        new g(256, cls);
        new g(512, cls);
        Class<r> cls2 = r.class;
        new g(1024, cls2);
        new g(2048, cls2);
        new g(16384);
        new g(32768);
        new g(65536);
        new g(131072, v.class);
        new g(2097152, w.class);
        int i10 = Build.VERSION.SDK_INT;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction = null;
        new g(i10 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN : null, 16908342, (String) null, (x) null, (Class) null);
        new g(i10 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION : null, 16908343, (String) null, (x) null, t.class);
        f10909k = new g(i10 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP : null, 16908344, (String) null, (x) null, (Class) null);
        new g(i10 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT : null, 16908345, (String) null, (x) null, (Class) null);
        f10910l = new g(i10 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN : null, 16908346, (String) null, (x) null, (Class) null);
        new g(i10 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT : null, 16908347, (String) null, (x) null, (Class) null);
        new g(i10 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP : null, 16908358, (String) null, (x) null, (Class) null);
        new g(i10 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN : null, 16908359, (String) null, (x) null, (Class) null);
        new g(i10 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT : null, 16908360, (String) null, (x) null, (Class) null);
        new g(i10 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT : null, 16908361, (String) null, (x) null, (Class) null);
        new g(i10 >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK : null, 16908348, (String) null, (x) null, (Class) null);
        new g(i10 >= 24 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS : null, 16908349, (String) null, (x) null, u.class);
        new g(i10 >= 26 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW : null, 16908354, (String) null, (x) null, s.class);
        new g(i10 >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP : null, 16908356, (String) null, (x) null, (Class) null);
        new g(i10 >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP : null, 16908357, (String) null, (x) null, (Class) null);
        new g(i10 >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD : null, 16908362, (String) null, (x) null, (Class) null);
        new g(i10 >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER : null, 16908372, (String) null, (x) null, (Class) null);
        new g(i10 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_START : null, 16908373, (String) null, (x) null, (Class) null);
        new g(i10 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_DROP : null, 16908374, (String) null, (x) null, (Class) null);
        new g(i10 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_CANCEL : null, 16908375, (String) null, (x) null, (Class) null);
        if (i10 >= 33) {
            accessibilityAction = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TEXT_SUGGESTIONS;
        }
        new g(accessibilityAction, 16908376, (String) null, (x) null, (Class) null);
    }

    public g(int i10) {
        this((Object) null, i10, (String) null, (x) null, (Class) null);
    }

    public final int a() {
        return ((AccessibilityNodeInfo.AccessibilityAction) this.f10911a).getId();
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof g)) {
            return false;
        }
        Object obj2 = ((g) obj).f10911a;
        Object obj3 = this.f10911a;
        return obj3 == null ? obj2 == null : obj3.equals(obj2);
    }

    public final int hashCode() {
        Object obj = this.f10911a;
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("AccessibilityActionCompat: ");
        String d10 = i.d(this.f10912b);
        if (d10.equals("ACTION_UNKNOWN")) {
            Object obj = this.f10911a;
            if (((AccessibilityNodeInfo.AccessibilityAction) obj).getLabel() != null) {
                d10 = ((AccessibilityNodeInfo.AccessibilityAction) obj).getLabel().toString();
            }
        }
        sb2.append(d10);
        return sb2.toString();
    }

    public g(int i10, Class cls) {
        this((Object) null, i10, (String) null, (x) null, cls);
    }

    public g(Object obj, int i10, String str, x xVar, Class cls) {
        this.f10912b = i10;
        this.f10914d = xVar;
        this.f10911a = obj == null ? new AccessibilityNodeInfo.AccessibilityAction(i10, str) : obj;
        this.f10913c = cls;
    }
}
