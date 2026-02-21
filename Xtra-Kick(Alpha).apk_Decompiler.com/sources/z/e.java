package z;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.support.v4.media.h;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import y.a;

public final class e extends ViewGroup.MarginLayoutParams {

    /* renamed from: a  reason: collision with root package name */
    public b f17322a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f17323b = false;

    /* renamed from: c  reason: collision with root package name */
    public final int f17324c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f17325d = 0;

    /* renamed from: e  reason: collision with root package name */
    public final int f17326e = -1;

    /* renamed from: f  reason: collision with root package name */
    public final int f17327f = -1;

    /* renamed from: g  reason: collision with root package name */
    public final int f17328g = 0;

    /* renamed from: h  reason: collision with root package name */
    public int f17329h = 0;

    /* renamed from: i  reason: collision with root package name */
    public int f17330i;

    /* renamed from: j  reason: collision with root package name */
    public int f17331j;

    /* renamed from: k  reason: collision with root package name */
    public View f17332k;

    /* renamed from: l  reason: collision with root package name */
    public View f17333l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f17334m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f17335n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f17336o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f17337p;

    /* renamed from: q  reason: collision with root package name */
    public final Rect f17338q = new Rect();

    public e() {
        super(-2, -2);
    }

    public final boolean a(int i10) {
        if (i10 == 0) {
            return this.f17335n;
        }
        if (i10 != 1) {
            return false;
        }
        return this.f17336o;
    }

    public e(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b bVar;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.f16855b);
        this.f17324c = obtainStyledAttributes.getInteger(0, 0);
        this.f17327f = obtainStyledAttributes.getResourceId(1, -1);
        this.f17325d = obtainStyledAttributes.getInteger(2, 0);
        this.f17326e = obtainStyledAttributes.getInteger(6, -1);
        this.f17328g = obtainStyledAttributes.getInt(5, 0);
        this.f17329h = obtainStyledAttributes.getInt(4, 0);
        boolean hasValue = obtainStyledAttributes.hasValue(3);
        this.f17323b = hasValue;
        if (hasValue) {
            String string = obtainStyledAttributes.getString(3);
            String str = CoordinatorLayout.A;
            if (TextUtils.isEmpty(string)) {
                bVar = null;
            } else {
                if (string.startsWith(".")) {
                    string = context.getPackageName() + string;
                } else if (string.indexOf(46) < 0) {
                    String str2 = CoordinatorLayout.A;
                    if (!TextUtils.isEmpty(str2)) {
                        string = str2 + '.' + string;
                    }
                }
                try {
                    ThreadLocal threadLocal = CoordinatorLayout.C;
                    Map map = (Map) threadLocal.get();
                    if (map == null) {
                        map = new HashMap();
                        threadLocal.set(map);
                    }
                    Constructor<?> constructor = (Constructor) map.get(string);
                    if (constructor == null) {
                        constructor = Class.forName(string, false, context.getClassLoader()).getConstructor(CoordinatorLayout.B);
                        constructor.setAccessible(true);
                        map.put(string, constructor);
                    }
                    bVar = (b) constructor.newInstance(new Object[]{context, attributeSet});
                } catch (Exception e10) {
                    throw new RuntimeException(h.m("Could not inflate Behavior subclass ", string), e10);
                }
            }
            this.f17322a = bVar;
        }
        obtainStyledAttributes.recycle();
        b bVar2 = this.f17322a;
        if (bVar2 != null) {
            bVar2.c(this);
        }
    }

    public e(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
    }

    public e(ViewGroup.MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
    }

    public e(e eVar) {
        super(eVar);
    }
}
