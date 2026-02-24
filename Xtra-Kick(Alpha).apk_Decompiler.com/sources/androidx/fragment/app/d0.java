package androidx.fragment.app;

import android.content.Intent;
import android.content.res.Configuration;
import androidx.activity.r;
import i0.b;
import l0.a;

public final /* synthetic */ class d0 implements a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f1397a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f1398b;

    public /* synthetic */ d0(int i10, Object obj) {
        this.f1397a = i10;
        this.f1398b = obj;
    }

    public final void b(Object obj) {
        int i10 = this.f1397a;
        Object obj2 = this.f1398b;
        switch (i10) {
            case 0:
                Configuration configuration = (Configuration) obj;
                ((f0) obj2).f1416x.i();
                return;
            case 1:
                Intent intent = (Intent) obj;
                ((f0) obj2).f1416x.i();
                return;
            default:
                r rVar = (r) obj2;
                Boolean bool = (Boolean) obj;
                rVar.getClass();
                if (b.a()) {
                    rVar.c();
                    return;
                }
                return;
        }
    }
}
