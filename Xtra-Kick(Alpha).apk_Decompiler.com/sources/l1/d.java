package l1;

import android.media.MediaCodec;
import j1.l0;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f9504a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f9505b;

    /* renamed from: c  reason: collision with root package name */
    public int f9506c;

    /* renamed from: d  reason: collision with root package name */
    public int[] f9507d;

    /* renamed from: e  reason: collision with root package name */
    public int[] f9508e;

    /* renamed from: f  reason: collision with root package name */
    public int f9509f;

    /* renamed from: g  reason: collision with root package name */
    public int f9510g;

    /* renamed from: h  reason: collision with root package name */
    public int f9511h;

    /* renamed from: i  reason: collision with root package name */
    public final MediaCodec.CryptoInfo f9512i;

    /* renamed from: j  reason: collision with root package name */
    public final c f9513j;

    public d() {
        MediaCodec.CryptoInfo cryptoInfo = new MediaCodec.CryptoInfo();
        this.f9512i = cryptoInfo;
        this.f9513j = l0.f8453a >= 24 ? new c(cryptoInfo) : null;
    }
}
