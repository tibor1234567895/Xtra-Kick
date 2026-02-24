package m1;

import a2.h;
import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import c9.w;
import d9.r1;
import j1.d;
import j1.l0;
import java.util.HashMap;
import java.util.Locale;
import v1.n;
import z1.b;
import z1.i;
import z1.j;
import z1.q;

public final /* synthetic */ class r implements w {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f10449h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Context f10450i;

    public /* synthetic */ r(Context context, int i10) {
        this.f10449h = i10;
        this.f10450i = context;
    }

    public final Object get() {
        h hVar;
        Context context;
        String str;
        TelephonyManager telephonyManager;
        switch (this.f10449h) {
            case 0:
                return new o(this.f10450i);
            case 1:
                return new n(this.f10450i, new d2.r());
            case 2:
                b bVar = new b();
                Context context2 = this.f10450i;
                j jVar = j.f17415x0;
                return new q(new i(context2).b(), bVar, context2);
            default:
                Context context3 = this.f10450i;
                r1 r1Var = h.f34n;
                synchronized (h.class) {
                    if (h.f40t == null) {
                        if (context3 == null) {
                            context = null;
                        } else {
                            context = context3.getApplicationContext();
                        }
                        Context context4 = context;
                        int i10 = l0.f8453a;
                        if (!(context3 == null || (telephonyManager = (TelephonyManager) context3.getSystemService("phone")) == null)) {
                            str = telephonyManager.getNetworkCountryIso();
                            if (!TextUtils.isEmpty(str)) {
                                int[] a10 = h.a(c9.b.b(str));
                                HashMap hashMap = new HashMap(8);
                                hashMap.put(0, 1000000L);
                                r1 r1Var2 = h.f34n;
                                hashMap.put(2, (Long) r1Var2.get(a10[0]));
                                hashMap.put(3, (Long) h.f35o.get(a10[1]));
                                hashMap.put(4, (Long) h.f36p.get(a10[2]));
                                hashMap.put(5, (Long) h.f37q.get(a10[3]));
                                hashMap.put(10, (Long) h.f38r.get(a10[4]));
                                hashMap.put(9, (Long) h.f39s.get(a10[5]));
                                hashMap.put(7, (Long) r1Var2.get(a10[0]));
                                h.f40t = new h(context4, hashMap, 2000, d.f8420a, true);
                            }
                        }
                        str = Locale.getDefault().getCountry();
                        int[] a102 = h.a(c9.b.b(str));
                        HashMap hashMap2 = new HashMap(8);
                        hashMap2.put(0, 1000000L);
                        r1 r1Var22 = h.f34n;
                        hashMap2.put(2, (Long) r1Var22.get(a102[0]));
                        hashMap2.put(3, (Long) h.f35o.get(a102[1]));
                        hashMap2.put(4, (Long) h.f36p.get(a102[2]));
                        hashMap2.put(5, (Long) h.f37q.get(a102[3]));
                        hashMap2.put(10, (Long) h.f38r.get(a102[4]));
                        hashMap2.put(9, (Long) h.f39s.get(a102[5]));
                        hashMap2.put(7, (Long) r1Var22.get(a102[0]));
                        h.f40t = new h(context4, hashMap2, 2000, d.f8420a, true);
                    }
                    hVar = h.f40t;
                }
                return hVar;
        }
    }
}
