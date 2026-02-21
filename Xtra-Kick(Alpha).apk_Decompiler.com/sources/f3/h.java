package f3;

import android.support.v4.media.n;
import android.support.v4.media.session.u;
import d9.p0;
import d9.r0;
import d9.r1;
import g1.a0;
import j1.b0;
import j1.z;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    public final int f5587a;

    /* renamed from: b  reason: collision with root package name */
    public final List f5588b;

    public h() {
        this(0);
    }

    public final k0 a(int i10, z zVar) {
        if (i10 != 2) {
            Object obj = zVar.f8484b;
            if (i10 == 3 || i10 == 4) {
                return new z(new x((String) obj));
            }
            if (i10 == 21) {
                return new z(new v());
            }
            if (i10 != 27) {
                if (i10 == 36) {
                    return new z(new u(new n(b(zVar))));
                }
                if (i10 == 89) {
                    return new z(new j((List) zVar.f8485c));
                }
                if (i10 != 138) {
                    if (i10 == 172) {
                        return new z(new e((String) obj));
                    }
                    if (i10 == 257) {
                        return new e0(new u("application/vnd.dvb.ait"));
                    }
                    if (i10 != 134) {
                        if (i10 != 135) {
                            switch (i10) {
                                case 15:
                                    if (c(2)) {
                                        return null;
                                    }
                                    return new z(new g((String) obj, false));
                                case Constants.IV_SIZE:
                                    return new z(new p(new m0(b(zVar))));
                                case 17:
                                    if (c(2)) {
                                        return null;
                                    }
                                    return new z(new w((String) obj));
                                default:
                                    switch (i10) {
                                        case 128:
                                            break;
                                        case 129:
                                            break;
                                        case 130:
                                            if (!c(64)) {
                                                return null;
                                            }
                                            break;
                                        default:
                                            return null;
                                    }
                            }
                        }
                        return new z(new c((String) obj));
                    } else if (c(16)) {
                        return null;
                    } else {
                        return new e0(new u("application/x-scte35"));
                    }
                }
                return new z(new i((String) obj));
            } else if (c(4)) {
                return null;
            } else {
                return new z(new s(new n(b(zVar)), c(1), c(8)));
            }
        }
        return new z(new m(new m0(b(zVar))));
    }

    public final List b(z zVar) {
        boolean z10;
        String str;
        int i10;
        List list;
        boolean z11;
        boolean c10 = c(32);
        List list2 = this.f5588b;
        if (c10) {
            return list2;
        }
        b0 b0Var = new b0((byte[]) zVar.f8486d);
        while (b0Var.f8416c - b0Var.f8415b > 0) {
            int v10 = b0Var.v();
            int v11 = b0Var.f8415b + b0Var.v();
            if (v10 == 134) {
                ArrayList arrayList = new ArrayList();
                int v12 = b0Var.v() & 31;
                for (int i11 = 0; i11 < v12; i11++) {
                    String s10 = b0Var.s(3);
                    int v13 = b0Var.v();
                    if ((v13 & 128) != 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (z10) {
                        i10 = v13 & 63;
                        str = "application/cea-708";
                    } else {
                        str = "application/cea-608";
                        i10 = 1;
                    }
                    byte v14 = (byte) b0Var.v();
                    b0Var.H(1);
                    if (z10) {
                        if ((v14 & 64) != 0) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        list = Collections.singletonList(z11 ? new byte[]{1} : new byte[]{0});
                    } else {
                        list = null;
                    }
                    g1.z zVar2 = new g1.z();
                    zVar2.f6754k = str;
                    zVar2.f6746c = s10;
                    zVar2.C = i10;
                    zVar2.f6756m = list;
                    arrayList.add(new a0(zVar2));
                }
                list2 = arrayList;
            }
            b0Var.G(v11);
        }
        return list2;
    }

    public final boolean c(int i10) {
        return (i10 & this.f5587a) != 0;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public h(int i10) {
        this(r1.f4658l, 0);
        p0 p0Var = r0.f4657i;
    }

    public h(List list, int i10) {
        this.f5587a = i10;
        this.f5588b = list;
    }
}
