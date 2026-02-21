package h2;

import d2.u;
import j1.b0;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import k0.k;

public final class c extends k {

    /* renamed from: b  reason: collision with root package name */
    public long f6903b = -9223372036854775807L;

    /* renamed from: c  reason: collision with root package name */
    public long[] f6904c = new long[0];

    /* renamed from: d  reason: collision with root package name */
    public long[] f6905d = new long[0];

    public c() {
        super(new u());
    }

    public static Serializable e(int i10, b0 b0Var) {
        if (i10 == 0) {
            return Double.valueOf(Double.longBitsToDouble(b0Var.o()));
        }
        boolean z10 = true;
        if (i10 == 1) {
            if (b0Var.v() != 1) {
                z10 = false;
            }
            return Boolean.valueOf(z10);
        } else if (i10 == 2) {
            return g(b0Var);
        } else {
            if (i10 == 3) {
                HashMap hashMap = new HashMap();
                while (true) {
                    String g10 = g(b0Var);
                    int v10 = b0Var.v();
                    if (v10 == 9) {
                        return hashMap;
                    }
                    Serializable e10 = e(v10, b0Var);
                    if (e10 != null) {
                        hashMap.put(g10, e10);
                    }
                }
            } else if (i10 == 8) {
                return f(b0Var);
            } else {
                if (i10 == 10) {
                    int y10 = b0Var.y();
                    ArrayList arrayList = new ArrayList(y10);
                    for (int i11 = 0; i11 < y10; i11++) {
                        Serializable e11 = e(b0Var.v(), b0Var);
                        if (e11 != null) {
                            arrayList.add(e11);
                        }
                    }
                    return arrayList;
                } else if (i10 != 11) {
                    return null;
                } else {
                    Date date = new Date((long) Double.valueOf(Double.longBitsToDouble(b0Var.o())).doubleValue());
                    b0Var.H(2);
                    return date;
                }
            }
        }
    }

    public static HashMap f(b0 b0Var) {
        int y10 = b0Var.y();
        HashMap hashMap = new HashMap(y10);
        for (int i10 = 0; i10 < y10; i10++) {
            String g10 = g(b0Var);
            Serializable e10 = e(b0Var.v(), b0Var);
            if (e10 != null) {
                hashMap.put(g10, e10);
            }
        }
        return hashMap;
    }

    public static String g(b0 b0Var) {
        int A = b0Var.A();
        int i10 = b0Var.f8415b;
        b0Var.H(A);
        return new String(b0Var.f8414a, i10, A);
    }

    public final boolean c(b0 b0Var) {
        return true;
    }

    public final boolean d(long j10, b0 b0Var) {
        if (b0Var.v() != 2 || !"onMetaData".equals(g(b0Var)) || b0Var.f8416c - b0Var.f8415b == 0 || b0Var.v() != 8) {
            return false;
        }
        HashMap f10 = f(b0Var);
        Object obj = f10.get("duration");
        if (obj instanceof Double) {
            double doubleValue = ((Double) obj).doubleValue();
            if (doubleValue > 0.0d) {
                this.f6903b = (long) (doubleValue * 1000000.0d);
            }
        }
        Object obj2 = f10.get("keyframes");
        if (obj2 instanceof Map) {
            Map map = (Map) obj2;
            Object obj3 = map.get("filepositions");
            Object obj4 = map.get("times");
            if ((obj3 instanceof List) && (obj4 instanceof List)) {
                List list = (List) obj3;
                List list2 = (List) obj4;
                int size = list2.size();
                this.f6904c = new long[size];
                this.f6905d = new long[size];
                int i10 = 0;
                while (true) {
                    if (i10 >= size) {
                        break;
                    }
                    Object obj5 = list.get(i10);
                    Object obj6 = list2.get(i10);
                    if (!(obj6 instanceof Double) || !(obj5 instanceof Double)) {
                        this.f6904c = new long[0];
                        this.f6905d = new long[0];
                    } else {
                        this.f6904c[i10] = (long) (((Double) obj6).doubleValue() * 1000000.0d);
                        this.f6905d[i10] = ((Double) obj5).longValue();
                        i10++;
                    }
                }
                this.f6904c = new long[0];
                this.f6905d = new long[0];
            }
        }
        return false;
    }
}
