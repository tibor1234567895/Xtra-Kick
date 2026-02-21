package t7;

import c6.b;
import cc.g;
import com.github.andreyasadchy.xtra.model.chat.LiveChatMessage;
import fb.y;
import hb.h0;
import j9.v;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Objects;
import ma.b0;
import pa.e;
import pa.h;
import pb.r1;
import pb.y1;
import pb.z1;
import s.i;
import xa.j;

public final class f extends z1 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ k f14687a;

    public f(k kVar) {
        this.f14687a = kVar;
    }

    public final void a(y1 y1Var, Throwable th) {
        j.f("webSocket", y1Var);
        th.getLocalizedMessage();
        k kVar = this.f14687a;
        b bVar = kVar.f14707f;
        String th2 = th.toString();
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.flush();
        String stringWriter2 = stringWriter.toString();
        j.e("sw.toString()", stringWriter2);
        bVar.a(kVar.f14702a, th2, "disconnect", stringWriter2);
    }

    public final void b(g gVar, String str) {
        for (String str2 : y.y(str)) {
            try {
                k.f14701k.getClass();
                v a10 = c.a(str2);
                String e10 = a10.f("event").e();
                String e11 = a10.f("data").e();
                j.e("js.get(\"data\").asString", e11);
                d(e10, c.a(e11));
            } catch (Exception e12) {
                e12.toString();
            }
        }
    }

    public final void c(g gVar, r1 r1Var) {
        j.f("webSocket", gVar);
        k kVar = this.f14687a;
        kVar.f14709h = true;
        h0.b1(kVar.f14705d, (h) null, 0, new e(kVar, (e) null), 3);
        kVar.f14707f.a(kVar.f14702a, (String) null, "join", (String) null);
        k.a(kVar);
    }

    public final void d(String str, v vVar) {
        int i10;
        String str2 = str;
        v vVar2 = vVar;
        int i11 = 0;
        if (str2 != null) {
            k.f14701k.getClass();
            int[] b10 = i.b(7);
            int length = b10.length;
            int i12 = 0;
            while (true) {
                if (i12 >= length) {
                    break;
                }
                int i13 = b10[i12];
                if (j.a(q0.f.c(i13), str2)) {
                    i11 = i13;
                    break;
                }
                i12++;
            }
        }
        if (i11 == 0) {
            i10 = -1;
        } else {
            i10 = d.f14684a[i.a(i11)];
        }
        k kVar = this.f14687a;
        if (i10 == 1) {
            Objects.toString(vVar);
            kVar.f14711j = Math.min(100, vVar2.f("activity_timeout").a());
        } else if (i10 == 2) {
            kVar.f14710i = true;
        } else if (i10 == 3) {
            b bVar = kVar.f14707f;
            bVar.getClass();
            q0.f.j("event", i11);
            if (a.f14680a[i.a(i11)] == 1) {
                bVar.f14683c.getClass();
                v vVar3 = (v) vVar2.f8878h.get("sender");
                String e10 = vVar2.f("content").e();
                vVar.toString();
                String e11 = vVar2.f("id").e();
                int a10 = vVar3.f("id").a();
                String e12 = vVar3.f("slug").e();
                String e13 = vVar3.f("username").e();
                String e14 = ((v) vVar3.f8878h.get(Constants.DEFAULT_KEY_FORMAT)).f("color").e();
                j.e("msg", e10);
                bVar.f14681a.a(new LiveChatMessage(e11, a10, e12, e13, e10, e14, false, b.a(e10), b0.f10801h, e10, 0, false, (String) null, Long.valueOf(System.currentTimeMillis()), 5120, (xa.f) null));
            }
        }
    }
}
