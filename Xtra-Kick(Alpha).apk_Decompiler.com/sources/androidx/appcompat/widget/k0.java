package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.TextView;
import e.a;
import w0.l;

public final class k0 {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f903a;

    /* renamed from: b  reason: collision with root package name */
    public final a f904b;

    public k0(TextView textView) {
        this.f903a = textView;
        this.f904b = new a(textView);
    }

    public final InputFilter[] a(InputFilter[] inputFilterArr) {
        return ((l) this.f904b.f4852i).a(inputFilterArr);
    }

    /* JADX INFO: finally extract failed */
    public final void b(AttributeSet attributeSet, int i10) {
        TypedArray obtainStyledAttributes = this.f903a.getContext().obtainStyledAttributes(attributeSet, f.a.f5400j, i10, 0);
        try {
            boolean z10 = true;
            if (obtainStyledAttributes.hasValue(14)) {
                z10 = obtainStyledAttributes.getBoolean(14, true);
            }
            obtainStyledAttributes.recycle();
            d(z10);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    public final void c(boolean z10) {
        ((l) this.f904b.f4852i).c(z10);
    }

    public final void d(boolean z10) {
        ((l) this.f904b.f4852i).d(z10);
    }
}
