package d5;

import b5.a;
import b5.j;
import b5.r;
import com.bumptech.glide.load.data.d;
import h5.h0;
import h5.i0;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public final class p0 implements h, d {

    /* renamed from: h  reason: collision with root package name */
    public final g f4463h;

    /* renamed from: i  reason: collision with root package name */
    public final i f4464i;

    /* renamed from: j  reason: collision with root package name */
    public int f4465j;

    /* renamed from: k  reason: collision with root package name */
    public int f4466k = -1;

    /* renamed from: l  reason: collision with root package name */
    public j f4467l;

    /* renamed from: m  reason: collision with root package name */
    public List f4468m;

    /* renamed from: n  reason: collision with root package name */
    public int f4469n;

    /* renamed from: o  reason: collision with root package name */
    public volatile h0 f4470o;

    /* renamed from: p  reason: collision with root package name */
    public File f4471p;

    /* renamed from: q  reason: collision with root package name */
    public q0 f4472q;

    public p0(i iVar, g gVar) {
        this.f4464i = iVar;
        this.f4463h = gVar;
    }

    public final boolean c() {
        boolean z10;
        boolean z11;
        boolean z12;
        ArrayList a10 = this.f4464i.a();
        if (a10.isEmpty()) {
            return false;
        }
        List d10 = this.f4464i.d();
        if (d10.isEmpty()) {
            if (File.class.equals(this.f4464i.f4402k)) {
                return false;
            }
            throw new IllegalStateException("Failed to find any load path from " + this.f4464i.f4395d.getClass() + " to " + this.f4464i.f4402k);
        }
        while (true) {
            List list = this.f4468m;
            if (list != null) {
                if (this.f4469n < list.size()) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (z10) {
                    this.f4470o = null;
                    boolean z13 = false;
                    while (!z13) {
                        if (this.f4469n < this.f4468m.size()) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        if (!z11) {
                            break;
                        }
                        List list2 = this.f4468m;
                        int i10 = this.f4469n;
                        this.f4469n = i10 + 1;
                        File file = this.f4471p;
                        i iVar = this.f4464i;
                        this.f4470o = ((i0) list2.get(i10)).a(file, iVar.f4396e, iVar.f4397f, iVar.f4400i);
                        if (this.f4470o != null) {
                            if (this.f4464i.c(this.f4470o.f7577c.a()) != null) {
                                z12 = true;
                            } else {
                                z12 = false;
                            }
                            if (z12) {
                                this.f4470o.f7577c.f(this.f4464i.f4406o, this);
                                z13 = true;
                            }
                        }
                    }
                    return z13;
                }
            }
            int i11 = this.f4466k + 1;
            this.f4466k = i11;
            if (i11 >= d10.size()) {
                int i12 = this.f4465j + 1;
                this.f4465j = i12;
                if (i12 >= a10.size()) {
                    return false;
                }
                this.f4466k = 0;
            }
            j jVar = (j) a10.get(this.f4465j);
            Class cls = (Class) d10.get(this.f4466k);
            r f10 = this.f4464i.f(cls);
            i iVar2 = this.f4464i;
            this.f4472q = new q0(iVar2.f4394c.f3188a, jVar, iVar2.f4405n, iVar2.f4396e, iVar2.f4397f, f10, cls, iVar2.f4400i);
            File b10 = iVar2.f4399h.a().b(this.f4472q);
            this.f4471p = b10;
            if (b10 != null) {
                this.f4467l = jVar;
                this.f4468m = this.f4464i.f4394c.b().g(b10);
                this.f4469n = 0;
            }
        }
    }

    public final void cancel() {
        h0 h0Var = this.f4470o;
        if (h0Var != null) {
            h0Var.f7577c.cancel();
        }
    }

    public final void e(Exception exc) {
        this.f4463h.d(this.f4472q, exc, this.f4470o.f7577c, a.RESOURCE_DISK_CACHE);
    }

    public final void g(Object obj) {
        this.f4463h.a(this.f4467l, obj, this.f4470o.f7577c, a.RESOURCE_DISK_CACHE, this.f4472q);
    }
}
