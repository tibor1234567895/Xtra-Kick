package f6;

import la.h;
import n3.g4;
import n3.h4;
import n3.k4;
import n3.n4;
import n3.o4;
import pa.e;
import xa.j;

public final class y extends n4 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f5901b;

    public y(String str) {
        this.f5901b = 2;
        j.f("query", str);
    }

    public final /* bridge */ /* synthetic */ Integer a(o4 o4Var) {
        switch (this.f5901b) {
            case 0:
                return c(o4Var);
            case 1:
                return c(o4Var);
            default:
                return c(o4Var);
        }
    }

    public final Object b(g4 g4Var, e eVar) {
        switch (this.f5901b) {
            case 0:
                return new h4(new h("ChannelVideosDataSource"));
            case 1:
                return new h4(new h("SearchVideosDataSource"));
            default:
                return new h4(new h("TagsDataSourceGQL"));
        }
    }

    public final Integer c(o4 o4Var) {
        int i10;
        Integer num;
        Integer num2;
        int i11;
        Integer num3;
        Integer num4;
        int i12;
        Integer num5;
        Integer num6;
        Integer num7 = o4Var.f11383b;
        switch (this.f5901b) {
            case 0:
                if (num7 == null) {
                    return null;
                }
                k4 a10 = o4Var.a(num7.intValue());
                if (a10 != null && (num4 = (Integer) a10.f11288b) != null) {
                    i11 = num4.intValue() + 1;
                } else if (a10 == null || (num3 = (Integer) a10.f11289c) == null) {
                    return null;
                } else {
                    i11 = num3.intValue() - 1;
                }
                return Integer.valueOf(i11);
            case 1:
                if (num7 == null) {
                    return null;
                }
                k4 a11 = o4Var.a(num7.intValue());
                if (a11 != null && (num6 = (Integer) a11.f11288b) != null) {
                    i12 = num6.intValue() + 1;
                } else if (a11 == null || (num5 = (Integer) a11.f11289c) == null) {
                    return null;
                } else {
                    i12 = num5.intValue() - 1;
                }
                return Integer.valueOf(i12);
            default:
                if (num7 == null) {
                    return null;
                }
                k4 a12 = o4Var.a(num7.intValue());
                if (a12 != null && (num2 = (Integer) a12.f11288b) != null) {
                    i10 = num2.intValue() + 1;
                } else if (a12 == null || (num = (Integer) a12.f11289c) == null) {
                    return null;
                } else {
                    i10 = num.intValue() - 1;
                }
                return Integer.valueOf(i10);
        }
    }

    public y(String str, int i10) {
        this.f5901b = i10;
        if (i10 != 1) {
            j.f("query", str);
        } else {
            j.f("query", str);
        }
    }
}
