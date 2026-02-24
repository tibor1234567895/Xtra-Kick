package a2;

import android.net.Uri;
import j1.l0;
import java.io.IOException;
import k1.e0;
import k1.h;
import k1.j;
import k1.l;
import k1.m;
import v1.r;

public final class s implements n {

    /* renamed from: a  reason: collision with root package name */
    public final long f77a;

    /* renamed from: b  reason: collision with root package name */
    public final m f78b;

    /* renamed from: c  reason: collision with root package name */
    public final int f79c = 4;

    /* renamed from: d  reason: collision with root package name */
    public final e0 f80d;

    /* renamed from: e  reason: collision with root package name */
    public final r f81e;

    /* renamed from: f  reason: collision with root package name */
    public volatile Object f82f;

    public s(h hVar, Uri uri, r rVar) {
        l lVar = new l();
        lVar.f9013a = uri;
        lVar.f9020h = 1;
        m a10 = lVar.a();
        this.f80d = new e0(hVar);
        this.f78b = a10;
        this.f81e = rVar;
        this.f77a = r.f15758a.getAndIncrement();
    }

    public final void a() {
        this.f80d.f8991b = 0;
        j jVar = new j(this.f80d, this.f78b);
        try {
            jVar.c();
            Uri j10 = this.f80d.j();
            j10.getClass();
            this.f82f = this.f81e.j(j10, jVar);
        } finally {
            int i10 = l0.f8453a;
            try {
                jVar.close();
            } catch (IOException unused) {
            }
        }
    }

    public final void b() {
    }
}
