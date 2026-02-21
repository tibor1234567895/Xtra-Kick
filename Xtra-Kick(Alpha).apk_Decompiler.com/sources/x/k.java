package x;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

public final class k {

    /* renamed from: a  reason: collision with root package name */
    public int f16474a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f16475b = 0;

    /* renamed from: c  reason: collision with root package name */
    public float f16476c = 1.0f;

    /* renamed from: d  reason: collision with root package name */
    public float f16477d = Float.NaN;

    public final void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, p.f16504g);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i10 = 0; i10 < indexCount; i10++) {
            int index = obtainStyledAttributes.getIndex(i10);
            if (index == 1) {
                this.f16476c = obtainStyledAttributes.getFloat(index, this.f16476c);
            } else if (index == 0) {
                int i11 = obtainStyledAttributes.getInt(index, this.f16474a);
                this.f16474a = i11;
                this.f16474a = m.f16492d[i11];
            } else if (index == 4) {
                this.f16475b = obtainStyledAttributes.getInt(index, this.f16475b);
            } else if (index == 3) {
                this.f16477d = obtainStyledAttributes.getFloat(index, this.f16477d);
            }
        }
        obtainStyledAttributes.recycle();
    }
}
