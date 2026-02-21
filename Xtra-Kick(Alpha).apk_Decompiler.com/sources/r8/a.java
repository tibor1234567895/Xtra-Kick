package r8;

import android.graphics.drawable.Drawable;
import t8.i;

public final class a extends Drawable.ConstantState {

    /* renamed from: a  reason: collision with root package name */
    public final i f13881a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f13882b;

    public a(a aVar) {
        this.f13881a = (i) aVar.f13881a.f14744h.newDrawable();
        this.f13882b = aVar.f13882b;
    }

    public final int getChangingConfigurations() {
        return 0;
    }

    public final Drawable newDrawable() {
        return new b(new a(this));
    }

    public a(i iVar) {
        this.f13881a = iVar;
        this.f13882b = false;
    }
}
