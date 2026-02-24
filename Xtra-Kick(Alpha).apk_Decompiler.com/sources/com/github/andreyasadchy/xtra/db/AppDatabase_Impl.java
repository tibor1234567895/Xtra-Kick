package com.github.andreyasadchy.xtra.db;

import a6.a;
import a6.b;
import a6.c0;
import a6.d0;
import a6.e0;
import a6.f;
import a6.g;
import a6.i;
import a6.l;
import a6.m;
import a6.o;
import a6.p;
import a6.s;
import a6.t;
import a6.u;
import a6.v;
import a6.w;
import a6.x;
import a6.y;
import a6.z;
import android.content.Context;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import r3.j;
import r3.q0;
import v3.k;

public final class AppDatabase_Impl extends AppDatabase {

    /* renamed from: y  reason: collision with root package name */
    public static final /* synthetic */ int f3322y = 0;

    /* renamed from: o  reason: collision with root package name */
    public volatile c0 f3323o;

    /* renamed from: p  reason: collision with root package name */
    public volatile s f3324p;

    /* renamed from: q  reason: collision with root package name */
    public volatile o f3325q;

    /* renamed from: r  reason: collision with root package name */
    public volatile y f3326r;

    /* renamed from: s  reason: collision with root package name */
    public volatile i f3327s;

    /* renamed from: t  reason: collision with root package name */
    public volatile l f3328t;

    /* renamed from: u  reason: collision with root package name */
    public volatile f f3329u;

    /* renamed from: v  reason: collision with root package name */
    public volatile e0 f3330v;

    /* renamed from: w  reason: collision with root package name */
    public volatile u f3331w;

    /* renamed from: x  reason: collision with root package name */
    public volatile w f3332x;

    public final x A() {
        y yVar;
        if (this.f3326r != null) {
            return this.f3326r;
        }
        synchronized (this) {
            if (this.f3326r == null) {
                this.f3326r = new y(this);
            }
            yVar = this.f3326r;
        }
        return yVar;
    }

    public final z B() {
        c0 c0Var;
        if (this.f3323o != null) {
            return this.f3323o;
        }
        synchronized (this) {
            if (this.f3323o == null) {
                this.f3323o = new c0(this);
            }
            c0Var = this.f3323o;
        }
        return c0Var;
    }

    public final d0 C() {
        e0 e0Var;
        if (this.f3330v != null) {
            return this.f3330v;
        }
        synchronized (this) {
            if (this.f3330v == null) {
                this.f3330v = new e0(this);
            }
            e0Var = this.f3330v;
        }
        return e0Var;
    }

    public final r3.y e() {
        return new r3.y(this, new HashMap(0), new HashMap(0), "videos", "requests", "recent_emotes", "video_positions", "local_follows", "local_follows_games", "bookmarks", "vod_bookmark_ignored_users", "sort_channel", "sort_game");
    }

    public final u3.l f(j jVar) {
        q0 q0Var = new q0(jVar, new a(this, 2, 0), "a5893511da8448365cfc906dacc8e89a", "3bc64434d52af2fa291d76bd47307344");
        u3.j.f15352f.getClass();
        Context context = jVar.f13697a;
        xa.j.f("context", context);
        return ((k) jVar.f13699c).a(new u3.j(context, jVar.f13698b, q0Var));
    }

    public final List h(LinkedHashMap linkedHashMap) {
        return new ArrayList();
    }

    public final Set j() {
        return new HashSet();
    }

    public final Map k() {
        HashMap hashMap = new HashMap();
        hashMap.put(z.class, Collections.emptyList());
        hashMap.put(p.class, Collections.emptyList());
        hashMap.put(m.class, Collections.emptyList());
        hashMap.put(x.class, Collections.emptyList());
        hashMap.put(g.class, Collections.emptyList());
        hashMap.put(a6.j.class, Collections.emptyList());
        hashMap.put(b.class, Collections.emptyList());
        hashMap.put(d0.class, Collections.emptyList());
        hashMap.put(t.class, Collections.emptyList());
        hashMap.put(v.class, Collections.emptyList());
        return hashMap;
    }

    public final b t() {
        f fVar;
        if (this.f3329u != null) {
            return this.f3329u;
        }
        synchronized (this) {
            if (this.f3329u == null) {
                this.f3329u = new f(this);
            }
            fVar = this.f3329u;
        }
        return fVar;
    }

    public final g u() {
        i iVar;
        if (this.f3327s != null) {
            return this.f3327s;
        }
        synchronized (this) {
            if (this.f3327s == null) {
                this.f3327s = new i(this);
            }
            iVar = this.f3327s;
        }
        return iVar;
    }

    public final a6.j v() {
        l lVar;
        if (this.f3328t != null) {
            return this.f3328t;
        }
        synchronized (this) {
            if (this.f3328t == null) {
                this.f3328t = new l(this);
            }
            lVar = this.f3328t;
        }
        return lVar;
    }

    public final m w() {
        o oVar;
        if (this.f3325q != null) {
            return this.f3325q;
        }
        synchronized (this) {
            if (this.f3325q == null) {
                this.f3325q = new o(this);
            }
            oVar = this.f3325q;
        }
        return oVar;
    }

    public final p x() {
        s sVar;
        if (this.f3324p != null) {
            return this.f3324p;
        }
        synchronized (this) {
            if (this.f3324p == null) {
                this.f3324p = new s(this);
            }
            sVar = this.f3324p;
        }
        return sVar;
    }

    public final t y() {
        u uVar;
        if (this.f3331w != null) {
            return this.f3331w;
        }
        synchronized (this) {
            if (this.f3331w == null) {
                this.f3331w = new u(this);
            }
            uVar = this.f3331w;
        }
        return uVar;
    }

    public final v z() {
        w wVar;
        if (this.f3332x != null) {
            return this.f3332x;
        }
        synchronized (this) {
            if (this.f3332x == null) {
                this.f3332x = new w(this);
            }
            wVar = this.f3332x;
        }
        return wVar;
    }
}
