package x;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final float f16397a = Float.NaN;

    /* renamed from: b  reason: collision with root package name */
    public final float f16398b = Float.NaN;

    /* renamed from: c  reason: collision with root package name */
    public final float f16399c = Float.NaN;

    /* renamed from: d  reason: collision with root package name */
    public final float f16400d = Float.NaN;

    /* renamed from: e  reason: collision with root package name */
    public final int f16401e = -1;

    public e(Context context, XmlResourceParser xmlResourceParser) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), p.f16507j);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i10 = 0; i10 < indexCount; i10++) {
            int index = obtainStyledAttributes.getIndex(i10);
            if (index == 0) {
                int resourceId = obtainStyledAttributes.getResourceId(index, this.f16401e);
                this.f16401e = resourceId;
                String resourceTypeName = context.getResources().getResourceTypeName(resourceId);
                context.getResources().getResourceName(resourceId);
                if ("layout".equals(resourceTypeName)) {
                    new m().b((ConstraintLayout) LayoutInflater.from(context).inflate(resourceId, (ViewGroup) null));
                }
            } else if (index == 1) {
                this.f16400d = obtainStyledAttributes.getDimension(index, this.f16400d);
            } else if (index == 2) {
                this.f16398b = obtainStyledAttributes.getDimension(index, this.f16398b);
            } else if (index == 3) {
                this.f16399c = obtainStyledAttributes.getDimension(index, this.f16399c);
            } else if (index == 4) {
                this.f16397a = obtainStyledAttributes.getDimension(index, this.f16397a);
            }
        }
        obtainStyledAttributes.recycle();
    }
}
