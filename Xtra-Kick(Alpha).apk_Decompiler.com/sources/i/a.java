package i;

import android.graphics.drawable.Animatable;
import c4.f;

public final class a extends e {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f7887a;

    /* renamed from: b  reason: collision with root package name */
    public final Animatable f7888b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(Animatable animatable, int i10) {
        super(0);
        this.f7887a = i10;
        this.f7888b = animatable;
    }

    public final void c() {
        int i10 = this.f7887a;
        Animatable animatable = this.f7888b;
        switch (i10) {
            case 0:
                animatable.start();
                return;
            default:
                ((f) animatable).start();
                return;
        }
    }

    public final void d() {
        int i10 = this.f7887a;
        Animatable animatable = this.f7888b;
        switch (i10) {
            case 0:
                animatable.stop();
                return;
            default:
                ((f) animatable).stop();
                return;
        }
    }
}
