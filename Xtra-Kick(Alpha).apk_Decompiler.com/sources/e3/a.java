package e3;

import c9.h;
import i1.b;
import j1.b0;
import j1.l0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;
import w2.c;
import w2.d;
import w2.f;
import x2.j;

public final class a extends c {

    /* renamed from: m  reason: collision with root package name */
    public final b0 f4986m = new b0();

    public final d f(byte[] bArr, int i10, boolean z10) {
        b bVar;
        b0 b0Var = this.f4986m;
        b0Var.E(i10, bArr);
        ArrayList arrayList = new ArrayList();
        while (true) {
            int i11 = b0Var.f8416c - b0Var.f8415b;
            if (i11 <= 0) {
                return new j(arrayList);
            }
            if (i11 >= 8) {
                int f10 = b0Var.f() - 8;
                if (b0Var.f() == 1987343459) {
                    CharSequence charSequence = null;
                    i1.a aVar = null;
                    while (f10 > 0) {
                        if (f10 >= 8) {
                            int f11 = b0Var.f();
                            int f12 = b0Var.f();
                            int i12 = f11 - 8;
                            byte[] bArr2 = b0Var.f8414a;
                            int i13 = b0Var.f8415b;
                            int i14 = l0.f8453a;
                            String str = new String(bArr2, i13, i12, h.f3035c);
                            b0Var.H(i12);
                            f10 = (f10 - 8) - i12;
                            if (f12 == 1937011815) {
                                Pattern pattern = i.f5031a;
                                h hVar = new h();
                                i.e(str, hVar);
                                aVar = hVar.a();
                            } else if (f12 == 1885436268) {
                                charSequence = i.f((String) null, str.trim(), Collections.emptyList());
                            }
                        } else {
                            throw new f("Incomplete vtt cue box header found.");
                        }
                    }
                    if (charSequence == null) {
                        charSequence = "";
                    }
                    if (aVar != null) {
                        aVar.f7953a = charSequence;
                        bVar = aVar.a();
                    } else {
                        Pattern pattern2 = i.f5031a;
                        h hVar2 = new h();
                        hVar2.f5022c = charSequence;
                        bVar = hVar2.a().a();
                    }
                    arrayList.add(bVar);
                } else {
                    b0Var.H(f10);
                }
            } else {
                throw new f("Incomplete Mp4Webvtt Top Level box header found.");
            }
        }
    }
}
