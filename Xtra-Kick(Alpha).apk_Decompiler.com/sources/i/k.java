package i;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.StateSet;

public class k extends i {

    /* renamed from: u  reason: collision with root package name */
    public j f7938u;

    /* renamed from: v  reason: collision with root package name */
    public boolean f7939v;

    public k() {
        this((j) null, (Resources) null);
    }

    public final void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
        onStateChange(getState());
    }

    public void e(h hVar) {
        super.e(hVar);
        if (hVar instanceof j) {
            this.f7938u = (j) hVar;
        }
    }

    /* renamed from: f */
    public j b() {
        return new j(this.f7938u, this, (Resources) null);
    }

    public boolean isStateful() {
        return true;
    }

    public Drawable mutate() {
        if (!this.f7939v) {
            super.mutate();
            this.f7938u.e();
            this.f7939v = true;
        }
        return this;
    }

    public boolean onStateChange(int[] iArr) {
        boolean onStateChange = super.onStateChange(iArr);
        int f10 = this.f7938u.f(iArr);
        if (f10 < 0) {
            f10 = this.f7938u.f(StateSet.WILD_CARD);
        }
        return d(f10) || onStateChange;
    }

    public k(int i10) {
    }

    public k(j jVar, Resources resources) {
        e(new j(jVar, this, resources));
        onStateChange(getState());
    }
}
