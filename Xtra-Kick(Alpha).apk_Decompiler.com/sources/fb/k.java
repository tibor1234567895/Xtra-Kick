package fb;

import java.util.regex.Matcher;
import wa.l;
import xa.i;
import xa.j;

public final /* synthetic */ class k extends i implements l {

    /* renamed from: q  reason: collision with root package name */
    public static final k f6012q = new k();

    public k() {
        super(1, h.class, "next", "next()Lkotlin/text/MatchResult;", 0);
    }

    public final Object invoke(Object obj) {
        int i10;
        h hVar = (h) obj;
        j.f("p0", hVar);
        Matcher matcher = hVar.f6004a;
        int end = matcher.end();
        if (matcher.end() == matcher.start()) {
            i10 = 1;
        } else {
            i10 = 0;
        }
        int i11 = end + i10;
        CharSequence charSequence = hVar.f6005b;
        if (i11 > charSequence.length()) {
            return null;
        }
        Matcher matcher2 = matcher.pattern().matcher(charSequence);
        j.e("matcher.pattern().matcher(input)", matcher2);
        if (!matcher2.find(i11)) {
            return null;
        }
        return new h(matcher2, charSequence);
    }
}
