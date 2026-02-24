package j9;

import com.google.gson.internal.Excluder;
import com.google.gson.internal.bind.m;
import com.google.gson.internal.bind.s0;
import java.util.ArrayList;
import java.util.HashMap;
import o9.a;

public final class o {

    /* renamed from: a  reason: collision with root package name */
    public final Excluder f8867a = Excluder.f3971m;

    /* renamed from: b  reason: collision with root package name */
    public final y f8868b = a0.f8850h;

    /* renamed from: c  reason: collision with root package name */
    public final b f8869c = h.f8852h;

    /* renamed from: d  reason: collision with root package name */
    public final HashMap f8870d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    public final ArrayList f8871e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public final ArrayList f8872f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    public String f8873g;

    /* renamed from: h  reason: collision with root package name */
    public final int f8874h = 2;

    /* renamed from: i  reason: collision with root package name */
    public final int f8875i = 2;

    public final void a(Class cls, r rVar) {
        ArrayList arrayList = this.f8871e;
        arrayList.add(m.d(new a(cls), rVar));
        if (rVar instanceof b0) {
            arrayList.add(s0.c(new a(cls), (b0) rVar));
        }
    }
}
