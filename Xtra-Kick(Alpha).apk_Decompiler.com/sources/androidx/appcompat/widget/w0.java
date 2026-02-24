package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import com.woxthebox.draglistview.R;
import f.a;
import f0.b;
import f0.d;
import m0.c1;
import m0.j0;

public final class w0 extends r0 {

    /* renamed from: d  reason: collision with root package name */
    public final SeekBar f1113d;

    /* renamed from: e  reason: collision with root package name */
    public Drawable f1114e;

    /* renamed from: f  reason: collision with root package name */
    public ColorStateList f1115f = null;

    /* renamed from: g  reason: collision with root package name */
    public PorterDuff.Mode f1116g = null;

    /* renamed from: h  reason: collision with root package name */
    public boolean f1117h = false;

    /* renamed from: i  reason: collision with root package name */
    public boolean f1118i = false;

    public w0(SeekBar seekBar) {
        super(seekBar);
        this.f1113d = seekBar;
    }

    public final void a(AttributeSet attributeSet, int i10) {
        super.a(attributeSet, R.attr.seekBarStyle);
        SeekBar seekBar = this.f1113d;
        Context context = seekBar.getContext();
        int[] iArr = a.f5398h;
        u4 m10 = u4.m(context, attributeSet, iArr, R.attr.seekBarStyle);
        c1.o(seekBar, seekBar.getContext(), iArr, attributeSet, m10.f1100b, R.attr.seekBarStyle);
        Drawable f10 = m10.f(0);
        if (f10 != null) {
            seekBar.setThumb(f10);
        }
        Drawable e10 = m10.e(1);
        Drawable drawable = this.f1114e;
        if (drawable != null) {
            drawable.setCallback((Drawable.Callback) null);
        }
        this.f1114e = e10;
        if (e10 != null) {
            e10.setCallback(seekBar);
            d.c(e10, j0.d(seekBar));
            if (e10.isStateful()) {
                e10.setState(seekBar.getDrawableState());
            }
            c();
        }
        seekBar.invalidate();
        if (m10.l(3)) {
            this.f1116g = i2.d(m10.h(3, -1), this.f1116g);
            this.f1118i = true;
        }
        if (m10.l(2)) {
            this.f1115f = m10.b(2);
            this.f1117h = true;
        }
        m10.n();
        c();
    }

    public final void c() {
        Drawable drawable = this.f1114e;
        if (drawable == null) {
            return;
        }
        if (this.f1117h || this.f1118i) {
            Drawable g10 = d.g(drawable.mutate());
            this.f1114e = g10;
            if (this.f1117h) {
                b.h(g10, this.f1115f);
            }
            if (this.f1118i) {
                b.i(this.f1114e, this.f1116g);
            }
            if (this.f1114e.isStateful()) {
                this.f1114e.setState(this.f1113d.getDrawableState());
            }
        }
    }

    public final void d(Canvas canvas) {
        if (this.f1114e != null) {
            SeekBar seekBar = this.f1113d;
            int max = seekBar.getMax();
            int i10 = 1;
            if (max > 1) {
                int intrinsicWidth = this.f1114e.getIntrinsicWidth();
                int intrinsicHeight = this.f1114e.getIntrinsicHeight();
                int i11 = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                if (intrinsicHeight >= 0) {
                    i10 = intrinsicHeight / 2;
                }
                this.f1114e.setBounds(-i11, -i10, i11, i10);
                float width = ((float) ((seekBar.getWidth() - seekBar.getPaddingLeft()) - seekBar.getPaddingRight())) / ((float) max);
                int save = canvas.save();
                canvas.translate((float) seekBar.getPaddingLeft(), (float) (seekBar.getHeight() / 2));
                for (int i12 = 0; i12 <= max; i12++) {
                    this.f1114e.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(save);
            }
        }
    }
}
