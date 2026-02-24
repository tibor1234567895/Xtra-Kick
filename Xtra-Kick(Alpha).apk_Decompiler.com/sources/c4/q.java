package c4;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;

public final class q extends Drawable.ConstantState {

    /* renamed from: a  reason: collision with root package name */
    public int f2936a;

    /* renamed from: b  reason: collision with root package name */
    public p f2937b;

    /* renamed from: c  reason: collision with root package name */
    public ColorStateList f2938c;

    /* renamed from: d  reason: collision with root package name */
    public PorterDuff.Mode f2939d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f2940e;

    /* renamed from: f  reason: collision with root package name */
    public Bitmap f2941f;

    /* renamed from: g  reason: collision with root package name */
    public ColorStateList f2942g;

    /* renamed from: h  reason: collision with root package name */
    public PorterDuff.Mode f2943h;

    /* renamed from: i  reason: collision with root package name */
    public int f2944i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f2945j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f2946k;

    /* renamed from: l  reason: collision with root package name */
    public Paint f2947l;

    public q() {
        this.f2938c = null;
        this.f2939d = s.f2949q;
        this.f2937b = new p();
    }

    public int getChangingConfigurations() {
        return this.f2936a;
    }

    public final Drawable newDrawable() {
        return new s(this);
    }

    public q(q qVar) {
        this.f2938c = null;
        this.f2939d = s.f2949q;
        if (qVar != null) {
            this.f2936a = qVar.f2936a;
            p pVar = new p(qVar.f2937b);
            this.f2937b = pVar;
            if (qVar.f2937b.f2925e != null) {
                pVar.f2925e = new Paint(qVar.f2937b.f2925e);
            }
            if (qVar.f2937b.f2924d != null) {
                this.f2937b.f2924d = new Paint(qVar.f2937b.f2924d);
            }
            this.f2938c = qVar.f2938c;
            this.f2939d = qVar.f2939d;
            this.f2940e = qVar.f2940e;
        }
    }

    public final Drawable newDrawable(Resources resources) {
        return new s(this);
    }
}
