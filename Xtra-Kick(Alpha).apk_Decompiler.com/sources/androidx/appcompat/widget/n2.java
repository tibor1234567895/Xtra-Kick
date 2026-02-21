package androidx.appcompat.widget;

import android.widget.AbsListView;
import java.lang.reflect.Field;

public final class n2 {

    /* renamed from: a  reason: collision with root package name */
    public static final Field f968a;

    static {
        Field field = null;
        try {
            field = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
            field.setAccessible(true);
        } catch (NoSuchFieldException e10) {
            e10.printStackTrace();
        }
        f968a = field;
    }

    private n2() {
    }
}
