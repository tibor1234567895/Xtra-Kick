package h3;

import android.os.Bundle;
import j1.a;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public f4 f6943a;

    /* renamed from: b  reason: collision with root package name */
    public int f6944b = -1;

    /* renamed from: c  reason: collision with root package name */
    public int f6945c;

    /* renamed from: d  reason: collision with root package name */
    public CharSequence f6946d = "";

    /* renamed from: e  reason: collision with root package name */
    public Bundle f6947e = Bundle.EMPTY;

    /* renamed from: f  reason: collision with root package name */
    public boolean f6948f;

    public final d a() {
        return new d(this.f6943a, this.f6944b, this.f6945c, this.f6946d, this.f6947e, this.f6948f);
    }

    public final void b(int i10) {
        a.a("sessionCommand is already set. Only one of sessionCommand and playerCommand should be set.", this.f6943a == null);
        this.f6944b = i10;
    }
}
