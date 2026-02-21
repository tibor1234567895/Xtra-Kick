package androidx.emoji2.text;

import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import java.util.stream.IntStream;

public final class j0 implements Spannable {

    /* renamed from: h  reason: collision with root package name */
    public boolean f1264h = false;

    /* renamed from: i  reason: collision with root package name */
    public Spannable f1265i;

    public j0(Spannable spannable) {
        this.f1265i = spannable;
    }

    public final void a() {
        h0 h0Var;
        Spannable spannable = this.f1265i;
        if (!this.f1264h) {
            if (Build.VERSION.SDK_INT < 28) {
                h0Var = new h0();
            } else {
                h0Var = new i0();
            }
            if (h0Var.a(spannable)) {
                this.f1265i = new SpannableString(spannable);
            }
        }
        this.f1264h = true;
    }

    public final char charAt(int i10) {
        return this.f1265i.charAt(i10);
    }

    public final IntStream chars() {
        return this.f1265i.chars();
    }

    public final IntStream codePoints() {
        return this.f1265i.codePoints();
    }

    public final int getSpanEnd(Object obj) {
        return this.f1265i.getSpanEnd(obj);
    }

    public final int getSpanFlags(Object obj) {
        return this.f1265i.getSpanFlags(obj);
    }

    public final int getSpanStart(Object obj) {
        return this.f1265i.getSpanStart(obj);
    }

    public final Object[] getSpans(int i10, int i11, Class cls) {
        return this.f1265i.getSpans(i10, i11, cls);
    }

    public final int length() {
        return this.f1265i.length();
    }

    public final int nextSpanTransition(int i10, int i11, Class cls) {
        return this.f1265i.nextSpanTransition(i10, i11, cls);
    }

    public final void removeSpan(Object obj) {
        a();
        this.f1265i.removeSpan(obj);
    }

    public final void setSpan(Object obj, int i10, int i11, int i12) {
        a();
        this.f1265i.setSpan(obj, i10, i11, i12);
    }

    public final CharSequence subSequence(int i10, int i11) {
        return this.f1265i.subSequence(i10, i11);
    }

    public final String toString() {
        return this.f1265i.toString();
    }

    public j0(CharSequence charSequence) {
        this.f1265i = new SpannableString(charSequence);
    }
}
