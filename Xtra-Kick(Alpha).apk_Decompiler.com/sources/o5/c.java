package o5;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.SystemClock;
import android.util.Log;
import b5.b;
import b5.i;
import b5.n;
import b5.p;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import d5.o0;
import e5.k;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import k5.a;
import y4.d;
import y4.e;

public final class c implements p {

    /* renamed from: f  reason: collision with root package name */
    public static final a f12193f = new a();

    /* renamed from: g  reason: collision with root package name */
    public static final b f12194g = new b();

    /* renamed from: a  reason: collision with root package name */
    public final Context f12195a;

    /* renamed from: b  reason: collision with root package name */
    public final List f12196b;

    /* renamed from: c  reason: collision with root package name */
    public final b f12197c;

    /* renamed from: d  reason: collision with root package name */
    public final a f12198d = f12193f;

    /* renamed from: e  reason: collision with root package name */
    public final a f12199e;

    public c(Context context, ArrayList arrayList, e5.c cVar, k kVar) {
        this.f12195a = context.getApplicationContext();
        this.f12196b = arrayList;
        this.f12199e = new a((Object) cVar, 3, (Object) kVar);
        this.f12197c = f12194g;
    }

    public final boolean a(Object obj, n nVar) {
        ByteBuffer byteBuffer = (ByteBuffer) obj;
        if (((Boolean) nVar.c(k.f12233b)).booleanValue() || i.d(this.f12196b, byteBuffer) != ImageHeaderParser$ImageType.GIF) {
            return false;
        }
        return true;
    }

    public final o0 b(Object obj, int i10, int i11, n nVar) {
        d dVar;
        ByteBuffer byteBuffer = (ByteBuffer) obj;
        b bVar = this.f12197c;
        synchronized (bVar) {
            d dVar2 = (d) bVar.f12192a.poll();
            if (dVar2 == null) {
                dVar2 = new d();
            }
            dVar = dVar2;
            dVar.f16941b = null;
            Arrays.fill(dVar.f16940a, (byte) 0);
            dVar.f16942c = new y4.c();
            dVar.f16943d = 0;
            ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
            dVar.f16941b = asReadOnlyBuffer;
            asReadOnlyBuffer.position(0);
            dVar.f16941b.order(ByteOrder.LITTLE_ENDIAN);
        }
        try {
            return c(byteBuffer, i10, i11, dVar, nVar);
        } finally {
            this.f12197c.a(dVar);
        }
    }

    public final a5.p c(ByteBuffer byteBuffer, int i10, int i11, d dVar, n nVar) {
        Bitmap.Config config;
        int i12;
        int i13 = w5.i.f16115a;
        SystemClock.elapsedRealtimeNanos();
        try {
            y4.c b10 = dVar.b();
            if (b10.f16931c > 0) {
                if (b10.f16930b == 0) {
                    if (nVar.c(k.f12232a) == b.PREFER_RGB_565) {
                        config = Bitmap.Config.RGB_565;
                    } else {
                        config = Bitmap.Config.ARGB_8888;
                    }
                    int min = Math.min(b10.f16935g / i11, b10.f16934f / i10);
                    if (min == 0) {
                        i12 = 0;
                    } else {
                        i12 = Integer.highestOneBit(min);
                    }
                    int max = Math.max(1, i12);
                    Log.isLoggable("BufferGifDecoder", 2);
                    a aVar = this.f12198d;
                    a aVar2 = this.f12199e;
                    aVar.getClass();
                    ByteBuffer byteBuffer2 = byteBuffer;
                    e eVar = new e(aVar2, b10, byteBuffer, max);
                    eVar.h(config);
                    eVar.c();
                    Bitmap b11 = eVar.b();
                    if (b11 == null) {
                        if (Log.isLoggable("BufferGifDecoder", 2)) {
                            SystemClock.elapsedRealtimeNanos();
                        }
                        return null;
                    }
                    a5.p pVar = new a5.p(new e(new d(new j(com.bumptech.glide.c.a(this.f12195a), eVar, i10, i11, j5.c.f8808b, b11))), 2);
                    if (Log.isLoggable("BufferGifDecoder", 2)) {
                        SystemClock.elapsedRealtimeNanos();
                    }
                    return pVar;
                }
            }
            return null;
        } finally {
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                SystemClock.elapsedRealtimeNanos();
            }
        }
    }
}
