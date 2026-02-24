package androidx.emoji2.text;

import java.nio.ByteBuffer;
import l.h;
import v0.a;
import v0.b;

public final class u {

    /* renamed from: d  reason: collision with root package name */
    public static final ThreadLocal f1282d = new ThreadLocal();

    /* renamed from: a  reason: collision with root package name */
    public final int f1283a;

    /* renamed from: b  reason: collision with root package name */
    public final h f1284b;

    /* renamed from: c  reason: collision with root package name */
    public volatile int f1285c = 0;

    public u(h hVar, int i10) {
        this.f1284b = hVar;
        this.f1283a = i10;
    }

    public final int a(int i10) {
        a d10 = d();
        int a10 = d10.a(16);
        if (a10 == 0) {
            return 0;
        }
        ByteBuffer byteBuffer = d10.f15552b;
        int i11 = a10 + d10.f15551a;
        return byteBuffer.getInt((i10 * 4) + byteBuffer.getInt(i11) + i11 + 4);
    }

    public final int b() {
        a d10 = d();
        int a10 = d10.a(16);
        if (a10 == 0) {
            return 0;
        }
        int i10 = a10 + d10.f15551a;
        return d10.f15552b.getInt(d10.f15552b.getInt(i10) + i10);
    }

    public final int c() {
        a d10 = d();
        int a10 = d10.a(4);
        if (a10 != 0) {
            return d10.f15552b.getInt(a10 + d10.f15551a);
        }
        return 0;
    }

    public final a d() {
        short s10;
        ThreadLocal threadLocal = f1282d;
        a aVar = (a) threadLocal.get();
        if (aVar == null) {
            aVar = new a();
            threadLocal.set(aVar);
        }
        b bVar = (b) this.f1284b.f9447i;
        int a10 = bVar.a(6);
        if (a10 != 0) {
            int i10 = a10 + bVar.f15551a;
            int i11 = (this.f1283a * 4) + bVar.f15552b.getInt(i10) + i10 + 4;
            int i12 = bVar.f15552b.getInt(i11) + i11;
            ByteBuffer byteBuffer = bVar.f15552b;
            aVar.f15552b = byteBuffer;
            if (byteBuffer != null) {
                aVar.f15551a = i12;
                int i13 = i12 - byteBuffer.getInt(i12);
                aVar.f15553c = i13;
                s10 = aVar.f15552b.getShort(i13);
            } else {
                s10 = 0;
                aVar.f15551a = 0;
                aVar.f15553c = 0;
            }
            aVar.f15554d = s10;
        }
        return aVar;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        sb2.append(", id:");
        sb2.append(Integer.toHexString(c()));
        sb2.append(", codepoints:");
        int b10 = b();
        for (int i10 = 0; i10 < b10; i10++) {
            sb2.append(Integer.toHexString(a(i10)));
            sb2.append(" ");
        }
        return sb2.toString();
    }
}
