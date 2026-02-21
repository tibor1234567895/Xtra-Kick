package r7;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import xa.j;

public final class a extends ImageSpan {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(Drawable drawable) {
        super(drawable);
        j.f("drawable", drawable);
    }

    public final void draw(Canvas canvas, CharSequence charSequence, int i10, int i11, float f10, int i12, int i13, int i14, Paint paint) {
        j.f("canvas", canvas);
        j.f("text", charSequence);
        j.f("paint", paint);
        Drawable drawable = getDrawable();
        canvas.save();
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        int i15 = fontMetricsInt.descent;
        canvas.translate(f10, (float) (((i13 + i15) - ((i15 - fontMetricsInt.ascent) / 2)) - ((drawable.getBounds().bottom - drawable.getBounds().top) / 2)));
        drawable.draw(canvas);
        canvas.restore();
    }

    public final int getSize(Paint paint, CharSequence charSequence, int i10, int i11, Paint.FontMetricsInt fontMetricsInt) {
        j.f("paint", paint);
        j.f("text", charSequence);
        Rect bounds = getDrawable().getBounds();
        j.e("drawable.bounds", bounds);
        if (fontMetricsInt != null) {
            Paint.FontMetricsInt fontMetricsInt2 = paint.getFontMetricsInt();
            int i12 = fontMetricsInt2.descent;
            int i13 = fontMetricsInt2.ascent;
            int i14 = ((i12 - i13) / 2) + i13;
            int i15 = (bounds.bottom - bounds.top) / 2;
            int i16 = i14 - i15;
            fontMetricsInt.ascent = i16;
            fontMetricsInt.top = i16;
            int i17 = i14 + i15;
            fontMetricsInt.bottom = i17;
            fontMetricsInt.descent = i17;
        }
        return bounds.right;
    }
}
