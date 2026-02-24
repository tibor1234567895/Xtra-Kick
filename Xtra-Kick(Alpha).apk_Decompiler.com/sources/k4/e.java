package k4;

import dc.f0;
import java.io.IOException;
import java.util.ArrayList;
import p1.i0;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final String f9085a;

    /* renamed from: b  reason: collision with root package name */
    public final long[] f9086b = new long[2];

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList f9087c;

    /* renamed from: d  reason: collision with root package name */
    public final ArrayList f9088d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f9089e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f9090f;

    /* renamed from: g  reason: collision with root package name */
    public i0 f9091g;

    /* renamed from: h  reason: collision with root package name */
    public int f9092h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ i f9093i;

    public e(i iVar, String str) {
        this.f9093i = iVar;
        this.f9085a = str;
        iVar.getClass();
        iVar.getClass();
        this.f9087c = new ArrayList(2);
        iVar.getClass();
        this.f9088d = new ArrayList(2);
        StringBuilder sb2 = new StringBuilder(str);
        sb2.append('.');
        int length = sb2.length();
        iVar.getClass();
        for (int i10 = 0; i10 < 2; i10++) {
            sb2.append(i10);
            this.f9087c.add(this.f9093i.f9100h.c(sb2.toString()));
            sb2.append(".tmp");
            this.f9088d.add(this.f9093i.f9100h.c(sb2.toString()));
            sb2.setLength(length);
        }
    }

    public final f a() {
        if (!this.f9089e || this.f9091g != null || this.f9090f) {
            return null;
        }
        ArrayList arrayList = this.f9087c;
        int size = arrayList.size();
        int i10 = 0;
        while (true) {
            i iVar = this.f9093i;
            if (i10 < size) {
                if (!iVar.f9115w.f((f0) arrayList.get(i10))) {
                    try {
                        iVar.a0(this);
                    } catch (IOException unused) {
                    }
                    return null;
                }
                i10++;
            } else {
                this.f9092h++;
                return new f(iVar, this);
            }
        }
    }
}
