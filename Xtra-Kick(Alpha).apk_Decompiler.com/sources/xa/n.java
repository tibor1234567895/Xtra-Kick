package xa;

import db.a;
import fb.h;
import wa.l;

public abstract class n extends p implements l {
    public n() {
    }

    public n(a aVar) {
        super(aVar, h.class, "value", "getValue()Ljava/lang/String;", 0);
    }

    public final a a() {
        v.f16819a.getClass();
        return this;
    }

    public final Object invoke(Object obj) {
        String group = ((h) obj).f6004a.group();
        j.e("matchResult.group()", group);
        return group;
    }
}
