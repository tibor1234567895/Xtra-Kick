package d5;

import b5.a;
import b5.j;
import com.bumptech.glide.load.data.d;
import h5.h0;
import h5.i0;
import java.io.File;
import java.util.List;

public final class e implements h, d {

    /* renamed from: h  reason: collision with root package name */
    public final List f4372h;

    /* renamed from: i  reason: collision with root package name */
    public final i f4373i;

    /* renamed from: j  reason: collision with root package name */
    public final g f4374j;

    /* renamed from: k  reason: collision with root package name */
    public int f4375k = -1;

    /* renamed from: l  reason: collision with root package name */
    public j f4376l;

    /* renamed from: m  reason: collision with root package name */
    public List f4377m;

    /* renamed from: n  reason: collision with root package name */
    public int f4378n;

    /* renamed from: o  reason: collision with root package name */
    public volatile h0 f4379o;

    /* renamed from: p  reason: collision with root package name */
    public File f4380p;

    public e(List list, i iVar, g gVar) {
        this.f4372h = list;
        this.f4373i = iVar;
        this.f4374j = gVar;
    }

    public final boolean c() {
        boolean z10;
        boolean z11;
        boolean z12;
        while (true) {
            List list = this.f4377m;
            if (list != null) {
                if (this.f4378n < list.size()) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (z10) {
                    this.f4379o = null;
                    boolean z13 = false;
                    while (!z13) {
                        if (this.f4378n < this.f4377m.size()) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        if (!z11) {
                            break;
                        }
                        List list2 = this.f4377m;
                        int i10 = this.f4378n;
                        this.f4378n = i10 + 1;
                        File file = this.f4380p;
                        i iVar = this.f4373i;
                        this.f4379o = ((i0) list2.get(i10)).a(file, iVar.f4396e, iVar.f4397f, iVar.f4400i);
                        if (this.f4379o != null) {
                            if (this.f4373i.c(this.f4379o.f7577c.a()) != null) {
                                z12 = true;
                            } else {
                                z12 = false;
                            }
                            if (z12) {
                                this.f4379o.f7577c.f(this.f4373i.f4406o, this);
                                z13 = true;
                            }
                        }
                    }
                    return z13;
                }
            }
            int i11 = this.f4375k + 1;
            this.f4375k = i11;
            if (i11 >= this.f4372h.size()) {
                return false;
            }
            j jVar = (j) this.f4372h.get(this.f4375k);
            i iVar2 = this.f4373i;
            File b10 = iVar2.f4399h.a().b(new f(jVar, iVar2.f4405n));
            this.f4380p = b10;
            if (b10 != null) {
                this.f4376l = jVar;
                this.f4377m = this.f4373i.f4394c.b().g(b10);
                this.f4378n = 0;
            }
        }
    }

    public final void cancel() {
        h0 h0Var = this.f4379o;
        if (h0Var != null) {
            h0Var.f7577c.cancel();
        }
    }

    public final void e(Exception exc) {
        this.f4374j.d(this.f4376l, exc, this.f4379o.f7577c, a.DATA_DISK_CACHE);
    }

    public final void g(Object obj) {
        this.f4374j.a(this.f4376l, obj, this.f4379o.f7577c, a.DATA_DISK_CACHE, this.f4376l);
    }
}
