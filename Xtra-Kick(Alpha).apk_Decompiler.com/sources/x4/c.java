package x4;

import java.io.File;
import p1.i0;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final String f16651a;

    /* renamed from: b  reason: collision with root package name */
    public final long[] f16652b;

    /* renamed from: c  reason: collision with root package name */
    public final File[] f16653c;

    /* renamed from: d  reason: collision with root package name */
    public final File[] f16654d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f16655e;

    /* renamed from: f  reason: collision with root package name */
    public i0 f16656f;

    /* renamed from: g  reason: collision with root package name */
    public long f16657g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ d f16658h;

    public c(d dVar, String str) {
        this.f16658h = dVar;
        this.f16651a = str;
        int i10 = dVar.f16665n;
        this.f16652b = new long[i10];
        this.f16653c = new File[i10];
        this.f16654d = new File[i10];
        StringBuilder sb2 = new StringBuilder(str);
        sb2.append('.');
        int length = sb2.length();
        for (int i11 = 0; i11 < dVar.f16665n; i11++) {
            sb2.append(i11);
            File[] fileArr = this.f16653c;
            String sb3 = sb2.toString();
            File file = dVar.f16659h;
            fileArr[i11] = new File(file, sb3);
            sb2.append(".tmp");
            this.f16654d[i11] = new File(file, sb2.toString());
            sb2.setLength(length);
        }
    }

    public final String a() {
        StringBuilder sb2 = new StringBuilder();
        for (long append : this.f16652b) {
            sb2.append(' ');
            sb2.append(append);
        }
        return sb2.toString();
    }
}
