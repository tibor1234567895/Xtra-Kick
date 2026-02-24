package androidx.emoji2.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.style.ReplacementSpan;
import l.h;
import v0.a;

public final class g0 extends ReplacementSpan {

    /* renamed from: a  reason: collision with root package name */
    public final Paint.FontMetricsInt f1255a = new Paint.FontMetricsInt();

    /* renamed from: b  reason: collision with root package name */
    public final u f1256b;

    /* renamed from: c  reason: collision with root package name */
    public float f1257c = 1.0f;

    public g0(u uVar) {
        if (uVar != null) {
            this.f1256b = uVar;
            return;
        }
        throw new NullPointerException("metadata cannot be null");
    }

    /* renamed from: a */
    public final int getSize(Paint paint, CharSequence charSequence, int i10, int i11, Paint.FontMetricsInt fontMetricsInt) {
        short s10;
        Paint.FontMetricsInt fontMetricsInt2 = this.f1255a;
        paint.getFontMetricsInt(fontMetricsInt2);
        float abs = ((float) Math.abs(fontMetricsInt2.descent - fontMetricsInt2.ascent)) * 1.0f;
        u uVar = this.f1256b;
        a d10 = uVar.d();
        int a10 = d10.a(14);
        short s11 = 0;
        if (a10 != 0) {
            s10 = d10.f15552b.getShort(a10 + d10.f15551a);
        } else {
            s10 = 0;
        }
        this.f1257c = abs / ((float) s10);
        a d11 = uVar.d();
        int a11 = d11.a(14);
        if (a11 != 0) {
            d11.f15552b.getShort(a11 + d11.f15551a);
        }
        a d12 = uVar.d();
        int a12 = d12.a(12);
        if (a12 != 0) {
            s11 = d12.f15552b.getShort(a12 + d12.f15551a);
        }
        short s12 = (short) ((int) (((float) s11) * this.f1257c));
        if (fontMetricsInt != null) {
            fontMetricsInt.ascent = fontMetricsInt2.ascent;
            fontMetricsInt.descent = fontMetricsInt2.descent;
            fontMetricsInt.top = fontMetricsInt2.top;
            fontMetricsInt.bottom = fontMetricsInt2.bottom;
        }
        return s12;
    }

    public final void draw(Canvas canvas, CharSequence charSequence, int i10, int i11, float f10, int i12, int i13, int i14, Paint paint) {
        Paint paint2 = paint;
        p.a().getClass();
        u uVar = this.f1256b;
        h hVar = uVar.f1284b;
        Typeface typeface = paint.getTypeface();
        paint2.setTypeface((Typeface) hVar.f9450l);
        int i15 = uVar.f1283a * 2;
        Canvas canvas2 = canvas;
        canvas2.drawText((char[]) hVar.f9448j, i15, 2, f10, (float) i13, paint);
        paint2.setTypeface(typeface);
    }
}
