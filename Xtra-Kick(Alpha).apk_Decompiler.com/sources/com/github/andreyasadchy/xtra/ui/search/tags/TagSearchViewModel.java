package com.github.andreyasadchy.xtra.ui.search.tags;

import androidx.lifecycle.j1;
import androidx.lifecycle.w1;
import f7.k;
import hb.h0;
import javax.inject.Inject;
import kb.e1;
import kb.f1;
import kb.m0;
import n3.t;
import pa.e;
import xa.j;

public final class TagSearchViewModel extends w1 {

    /* renamed from: d  reason: collision with root package name */
    public final k f3489d;

    /* renamed from: e  reason: collision with root package name */
    public final e1 f3490e;

    /* renamed from: f  reason: collision with root package name */
    public final m0 f3491f;

    @Inject
    public TagSearchViewModel(j1 j1Var) {
        Integer num;
        String str;
        String str2;
        String str3;
        Boolean bool;
        j.f("savedStateHandle", j1Var);
        k.f5932f.getClass();
        if (j1Var.b("gameId")) {
            num = (Integer) j1Var.c("gameId");
            if (num == null) {
                throw new IllegalArgumentException("Argument \"gameId\" of type integer does not support null values");
            }
        } else {
            num = 0;
        }
        if (j1Var.b("gameSlug")) {
            str = (String) j1Var.c("gameSlug");
        } else {
            str = null;
        }
        if (j1Var.b("gameName")) {
            str2 = (String) j1Var.c("gameName");
        } else {
            str2 = null;
        }
        if (j1Var.b("boxArt")) {
            str3 = (String) j1Var.c("boxArt");
        } else {
            str3 = null;
        }
        if (j1Var.b("getGameTags")) {
            bool = (Boolean) j1Var.c("getGameTags");
            if (bool == null) {
                throw new IllegalArgumentException("Argument \"getGameTags\" of type boolean does not support null values");
            }
        } else {
            bool = Boolean.FALSE;
        }
        this.f3489d = new k(num.intValue(), str, str2, str3, bool.booleanValue());
        e1 a10 = f1.a("");
        this.f3490e = a10;
        this.f3491f = h0.s(h0.Y1(a10, new t((e) null, (Object) this, 6)), h0.I0(this));
    }
}
