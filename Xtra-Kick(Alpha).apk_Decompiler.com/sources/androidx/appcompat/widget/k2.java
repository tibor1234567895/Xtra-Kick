package androidx.appcompat.widget;

import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import java.lang.reflect.Method;

public final class k2 {

    /* renamed from: a  reason: collision with root package name */
    public static final Method f909a;

    /* renamed from: b  reason: collision with root package name */
    public static final Method f910b;

    /* renamed from: c  reason: collision with root package name */
    public static final Method f911c;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f912d = true;

    static {
        Class<AdapterView> cls = AdapterView.class;
        Class<AbsListView> cls2 = AbsListView.class;
        try {
            Class cls3 = Integer.TYPE;
            Class cls4 = Float.TYPE;
            Method declaredMethod = cls2.getDeclaredMethod("positionSelector", new Class[]{cls3, View.class, Boolean.TYPE, cls4, cls4});
            f909a = declaredMethod;
            declaredMethod.setAccessible(true);
            Method declaredMethod2 = cls.getDeclaredMethod("setSelectedPositionInt", new Class[]{cls3});
            f910b = declaredMethod2;
            declaredMethod2.setAccessible(true);
            Method declaredMethod3 = cls.getDeclaredMethod("setNextSelectedPositionInt", new Class[]{cls3});
            f911c = declaredMethod3;
            declaredMethod3.setAccessible(true);
        } catch (NoSuchMethodException e10) {
            e10.printStackTrace();
        }
    }

    private k2() {
    }
}
