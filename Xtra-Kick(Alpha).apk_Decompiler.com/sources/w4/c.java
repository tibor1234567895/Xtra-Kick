package w4;

import android.graphics.drawable.Drawable;
import coil.target.GenericViewTarget;
import hb.h0;
import la.g;
import s4.a;
import s4.i;
import t4.d;
import t4.e;
import t4.h;

public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    public static final a f16078a = new a(0);

    public static final boolean a(i iVar) {
        int a10 = s.i.a(iVar.I);
        if (a10 != 0) {
            if (a10 == 1) {
                return true;
            }
            if (a10 == 2) {
                h hVar = iVar.G.f14204b;
                h hVar2 = iVar.f14272x;
                if (hVar == null && (hVar2 instanceof d)) {
                    return true;
                }
                u4.a aVar = iVar.f14251c;
                if ((aVar instanceof GenericViewTarget) && (hVar2 instanceof e)) {
                    ((GenericViewTarget) aVar).k();
                }
            } else {
                throw new g();
            }
        }
        return false;
    }

    public static final Drawable b(i iVar, Drawable drawable, Integer num, Drawable drawable2) {
        if (drawable != null) {
            return drawable;
        }
        if (num == null) {
            return drawable2;
        }
        if (num.intValue() == 0) {
            return null;
        }
        return h0.g0(iVar.f14249a, num.intValue());
    }
}
