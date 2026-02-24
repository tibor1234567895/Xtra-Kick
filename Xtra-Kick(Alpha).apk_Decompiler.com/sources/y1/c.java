package y1;

import android.os.Bundle;
import android.os.Parcel;
import i1.b;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import w2.a;
import w2.e;
import w2.h;
import w2.i;

public final class c implements e {

    /* renamed from: a  reason: collision with root package name */
    public final a f16862a = new a();

    /* renamed from: b  reason: collision with root package name */
    public final h f16863b = new h();

    /* renamed from: c  reason: collision with root package name */
    public final ArrayDeque f16864c = new ArrayDeque();

    /* renamed from: d  reason: collision with root package name */
    public int f16865d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f16866e;

    public c() {
        for (int i10 = 0; i10 < 2; i10++) {
            this.f16864c.addFirst(new a(this, 0));
        }
        this.f16865d = 0;
    }

    public final void a() {
        this.f16866e = true;
    }

    public final void b(long j10) {
    }

    public final void c(h hVar) {
        boolean z10 = true;
        j1.a.e(!this.f16866e);
        j1.a.e(this.f16865d == 1);
        if (this.f16863b != hVar) {
            z10 = false;
        }
        j1.a.b(z10);
        this.f16865d = 2;
    }

    public final Object d() {
        j1.a.e(!this.f16866e);
        if (this.f16865d == 2) {
            ArrayDeque arrayDeque = this.f16864c;
            if (!arrayDeque.isEmpty()) {
                i iVar = (i) arrayDeque.removeFirst();
                h hVar = this.f16863b;
                if (hVar.f(4)) {
                    iVar.e(4);
                } else {
                    long j10 = hVar.f9517l;
                    ByteBuffer byteBuffer = hVar.f9515j;
                    byteBuffer.getClass();
                    byte[] array = byteBuffer.array();
                    this.f16862a.getClass();
                    Parcel obtain = Parcel.obtain();
                    obtain.unmarshall(array, 0, array.length);
                    obtain.setDataPosition(0);
                    Bundle readBundle = obtain.readBundle(Bundle.class.getClassLoader());
                    obtain.recycle();
                    ArrayList parcelableArrayList = readBundle.getParcelableArrayList("c");
                    parcelableArrayList.getClass();
                    b bVar = new b(j10, j1.c.a(b.Q, parcelableArrayList));
                    iVar.i(hVar.f9517l, bVar, 0);
                }
                hVar.h();
                this.f16865d = 0;
                return iVar;
            }
        }
        return null;
    }

    public final Object e() {
        j1.a.e(!this.f16866e);
        if (this.f16865d != 0) {
            return null;
        }
        this.f16865d = 1;
        return this.f16863b;
    }

    public final void flush() {
        j1.a.e(!this.f16866e);
        this.f16863b.h();
        this.f16865d = 0;
    }
}
