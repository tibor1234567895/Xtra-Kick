package fb;

import cb.e;
import cb.l;
import java.util.List;
import java.util.regex.Matcher;
import ma.k0;
import xa.j;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    public final Matcher f6004a;

    /* renamed from: b  reason: collision with root package name */
    public final CharSequence f6005b;

    /* renamed from: c  reason: collision with root package name */
    public final g f6006c = new g(this);

    /* renamed from: d  reason: collision with root package name */
    public k0 f6007d;

    public h(Matcher matcher, CharSequence charSequence) {
        j.f("input", charSequence);
        this.f6004a = matcher;
        this.f6005b = charSequence;
    }

    public final List a() {
        if (this.f6007d == null) {
            this.f6007d = new k0(this);
        }
        k0 k0Var = this.f6007d;
        j.c(k0Var);
        return k0Var;
    }

    public final e b() {
        Matcher matcher = this.f6004a;
        return l.c(matcher.start(), matcher.end());
    }
}
