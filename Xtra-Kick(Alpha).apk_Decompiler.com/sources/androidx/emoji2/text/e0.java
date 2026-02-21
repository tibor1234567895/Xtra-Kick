package androidx.emoji2.text;

import android.os.Build;
import android.text.Editable;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.TextWatcher;
import java.util.concurrent.atomic.AtomicInteger;

public final class e0 implements TextWatcher, SpanWatcher {

    /* renamed from: h  reason: collision with root package name */
    public final Object f1249h;

    /* renamed from: i  reason: collision with root package name */
    public final AtomicInteger f1250i = new AtomicInteger(0);

    public e0(Object obj) {
        this.f1249h = obj;
    }

    public final void afterTextChanged(Editable editable) {
        ((TextWatcher) this.f1249h).afterTextChanged(editable);
    }

    public final void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        ((TextWatcher) this.f1249h).beforeTextChanged(charSequence, i10, i11, i12);
    }

    public final void onSpanAdded(Spannable spannable, Object obj, int i10, int i11) {
        if (this.f1250i.get() <= 0 || !(obj instanceof g0)) {
            ((SpanWatcher) this.f1249h).onSpanAdded(spannable, obj, i10, i11);
        }
    }

    public final void onSpanChanged(Spannable spannable, Object obj, int i10, int i11, int i12, int i13) {
        int i14;
        int i15;
        if (this.f1250i.get() <= 0 || !(obj instanceof g0)) {
            if (Build.VERSION.SDK_INT < 28) {
                if (i10 > i11) {
                    i10 = 0;
                }
                if (i12 > i13) {
                    i15 = i10;
                    i14 = 0;
                    ((SpanWatcher) this.f1249h).onSpanChanged(spannable, obj, i15, i11, i14, i13);
                }
            }
            i15 = i10;
            i14 = i12;
            ((SpanWatcher) this.f1249h).onSpanChanged(spannable, obj, i15, i11, i14, i13);
        }
    }

    public final void onSpanRemoved(Spannable spannable, Object obj, int i10, int i11) {
        if (this.f1250i.get() <= 0 || !(obj instanceof g0)) {
            ((SpanWatcher) this.f1249h).onSpanRemoved(spannable, obj, i10, i11);
        }
    }

    public final void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        ((TextWatcher) this.f1249h).onTextChanged(charSequence, i10, i11, i12);
    }
}
