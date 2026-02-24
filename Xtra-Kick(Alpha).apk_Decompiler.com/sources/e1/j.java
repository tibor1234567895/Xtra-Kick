package e1;

import android.os.IBinder;
import com.google.gson.internal.bind.l;
import java.util.HashMap;

public final class j implements IBinder.DeathRecipient {

    /* renamed from: a  reason: collision with root package name */
    public final String f4916a;

    /* renamed from: b  reason: collision with root package name */
    public final int f4917b;

    /* renamed from: c  reason: collision with root package name */
    public final int f4918c;

    /* renamed from: d  reason: collision with root package name */
    public final c0 f4919d;

    /* renamed from: e  reason: collision with root package name */
    public final l f4920e;

    /* renamed from: f  reason: collision with root package name */
    public final HashMap f4921f = new HashMap();

    /* renamed from: g  reason: collision with root package name */
    public h f4922g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ a0 f4923h;

    public j(a0 a0Var, String str, int i10, int i11, l lVar) {
        this.f4923h = a0Var;
        this.f4916a = str;
        this.f4917b = i10;
        this.f4918c = i11;
        this.f4919d = new c0(str, i10, i11);
        this.f4920e = lVar;
    }

    public final void binderDied() {
        this.f4923h.f4892m.post(new i(this));
    }
}
