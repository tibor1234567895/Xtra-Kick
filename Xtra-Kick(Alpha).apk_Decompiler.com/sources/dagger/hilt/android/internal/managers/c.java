package dagger.hilt.android.internal.managers;

import android.content.Context;
import androidx.lifecycle.b2;
import androidx.lifecycle.w1;
import b1.f;
import ca.b;
import y5.h;

public final class c implements b2 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f4732a;

    public c(Context context) {
        this.f4732a = context;
    }

    public final w1 a(Class cls) {
        return new e(new y5.c(((h) ((d) b.a(this.f4732a, d.class))).f16980d));
    }

    public final w1 b(Class cls, f fVar) {
        return a(cls);
    }
}
