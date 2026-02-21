package androidx.appcompat.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ListView;
import f.a;

public class AlertController$RecycleListView extends ListView {

    /* renamed from: h  reason: collision with root package name */
    public final int f543h;

    /* renamed from: i  reason: collision with root package name */
    public final int f544i;

    public AlertController$RecycleListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.f5411u);
        this.f544i = obtainStyledAttributes.getDimensionPixelOffset(0, -1);
        this.f543h = obtainStyledAttributes.getDimensionPixelOffset(1, -1);
    }
}
