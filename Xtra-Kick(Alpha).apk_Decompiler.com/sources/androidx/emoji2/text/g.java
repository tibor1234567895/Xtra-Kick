package androidx.emoji2.text;

import android.text.TextPaint;

public final class g implements k {

    /* renamed from: b  reason: collision with root package name */
    public static final ThreadLocal f1253b = new ThreadLocal();

    /* renamed from: a  reason: collision with root package name */
    public final TextPaint f1254a;

    public g() {
        TextPaint textPaint = new TextPaint();
        this.f1254a = textPaint;
        textPaint.setTextSize(10.0f);
    }
}
