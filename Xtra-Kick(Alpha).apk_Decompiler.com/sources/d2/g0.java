package d2;

import g1.y0;
import g1.z0;
import j1.l0;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import o2.j;
import o2.r;

public final class g0 {

    /* renamed from: c  reason: collision with root package name */
    public static final Pattern f4185c = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");

    /* renamed from: a  reason: collision with root package name */
    public int f4186a = -1;

    /* renamed from: b  reason: collision with root package name */
    public int f4187b = -1;

    public final boolean a(String str) {
        Matcher matcher = f4185c.matcher(str);
        if (!matcher.find()) {
            return false;
        }
        try {
            String group = matcher.group(1);
            int i10 = l0.f8453a;
            int parseInt = Integer.parseInt(group, 16);
            int parseInt2 = Integer.parseInt(matcher.group(2), 16);
            if (parseInt <= 0 && parseInt2 <= 0) {
                return false;
            }
            this.f4186a = parseInt;
            this.f4187b = parseInt2;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public final void b(z0 z0Var) {
        int i10 = 0;
        while (true) {
            y0[] y0VarArr = z0Var.f6770h;
            if (i10 < y0VarArr.length) {
                y0 y0Var = y0VarArr[i10];
                if (y0Var instanceof j) {
                    j jVar = (j) y0Var;
                    if ("iTunSMPB".equals(jVar.f12079j) && a(jVar.f12080k)) {
                        return;
                    }
                } else if (y0Var instanceof r) {
                    r rVar = (r) y0Var;
                    if ("com.apple.iTunes".equals(rVar.f12091i) && "iTunSMPB".equals(rVar.f12092j) && a(rVar.f12093k)) {
                        return;
                    }
                } else {
                    continue;
                }
                i10++;
            } else {
                return;
            }
        }
    }
}
