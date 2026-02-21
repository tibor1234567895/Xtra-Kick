package p1;

import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaDrm;
import c9.h;
import g1.n;
import j1.a;
import j1.l0;
import j1.v;
import java.util.Map;
import java.util.UUID;
import l1.b;
import n1.f0;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class h0 implements c0 {

    /* renamed from: d  reason: collision with root package name */
    public static final e0 f12459d = new e0();

    /* renamed from: a  reason: collision with root package name */
    public final UUID f12460a;

    /* renamed from: b  reason: collision with root package name */
    public final MediaDrm f12461b;

    /* renamed from: c  reason: collision with root package name */
    public int f12462c;

    public h0(UUID uuid) {
        UUID uuid2;
        uuid.getClass();
        a.a("Use C.CLEARKEY_UUID instead", !n.f6474b.equals(uuid));
        this.f12460a = uuid;
        MediaDrm mediaDrm = new MediaDrm((l0.f8453a >= 27 || !n.f6475c.equals(uuid)) ? uuid : uuid2);
        this.f12461b = mediaDrm;
        this.f12462c = 1;
        if (n.f6476d.equals(uuid) && "ASUS_Z00AD".equals(l0.f8456d)) {
            mediaDrm.setPropertyString("securityLevel", "L3");
        }
    }

    public final synchronized void a() {
        int i10 = this.f12462c - 1;
        this.f12462c = i10;
        if (i10 == 0) {
            this.f12461b.release();
        }
    }

    public final void b(byte[] bArr, byte[] bArr2) {
        this.f12461b.restoreKeys(bArr, bArr2);
    }

    public final Map c(byte[] bArr) {
        return this.f12461b.queryKeyStatus(bArr);
    }

    public final void d(byte[] bArr) {
        this.f12461b.closeSession(bArr);
    }

    public final byte[] e(byte[] bArr, byte[] bArr2) {
        if (n.f6475c.equals(this.f12460a) && l0.f8453a < 27) {
            try {
                JSONObject jSONObject = new JSONObject(new String(bArr2, h.f3035c));
                StringBuilder sb2 = new StringBuilder("{\"keys\":[");
                JSONArray jSONArray = jSONObject.getJSONArray("keys");
                for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                    if (i10 != 0) {
                        sb2.append(",");
                    }
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i10);
                    sb2.append("{\"k\":\"");
                    sb2.append(jSONObject2.getString("k").replace('-', '+').replace('_', '/'));
                    sb2.append("\",\"kid\":\"");
                    sb2.append(jSONObject2.getString("kid").replace('-', '+').replace('_', '/'));
                    sb2.append("\",\"kty\":\"");
                    sb2.append(jSONObject2.getString("kty"));
                    sb2.append("\"}");
                }
                sb2.append("]}");
                bArr2 = l0.z(sb2.toString());
            } catch (JSONException e10) {
                v.d("ClearKeyUtil", "Failed to adjust response data: ".concat(new String(bArr2, h.f3035c)), e10);
            }
        }
        return this.f12461b.provideKeyResponse(bArr, bArr2);
    }

    public final b0 f() {
        MediaDrm.ProvisionRequest provisionRequest = this.f12461b.getProvisionRequest();
        return new b0(provisionRequest.getDefaultUrl(), provisionRequest.getData());
    }

    public final void g(byte[] bArr) {
        this.f12461b.provideProvisionResponse(bArr);
    }

    public final void h(g gVar) {
        this.f12461b.setOnEventListener(new f0(this, gVar));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:75:0x019a, code lost:
        if ("AFTT".equals(r7) == false) goto L_0x01a3;
     */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0184  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x01a2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final p1.a0 i(byte[] r17, java.util.List r18, int r19, java.util.HashMap r20) {
        /*
            r16 = this;
            r0 = r16
            r1 = r18
            java.lang.String r2 = "<LA_URL>https://x</LA_URL>"
            r3 = 23
            java.util.UUID r4 = r0.f12460a
            if (r1 == 0) goto L_0x01c5
            java.util.UUID r5 = g1.n.f6476d
            boolean r5 = r5.equals(r4)
            r6 = -1
            r7 = 1
            r8 = 0
            if (r5 != 0) goto L_0x0019
            goto L_0x00bc
        L_0x0019:
            int r5 = j1.l0.f8453a
            r9 = 28
            if (r5 < r9) goto L_0x0090
            int r5 = r18.size()
            if (r5 <= r7) goto L_0x0090
            java.lang.Object r5 = r1.get(r8)
            g1.t r5 = (g1.t) r5
            r9 = 0
            r10 = 0
        L_0x002d:
            int r11 = r18.size()
            if (r9 >= r11) goto L_0x0064
            java.lang.Object r11 = r1.get(r9)
            g1.t r11 = (g1.t) r11
            byte[] r12 = r11.f6570l
            r12.getClass()
            java.lang.String r13 = r5.f6569k
            java.lang.String r14 = r11.f6569k
            boolean r13 = j1.l0.a(r14, r13)
            if (r13 == 0) goto L_0x0062
            java.lang.String r11 = r11.f6568j
            java.lang.String r13 = r5.f6568j
            boolean r11 = j1.l0.a(r11, r13)
            if (r11 == 0) goto L_0x0062
            d0.d r11 = u2.q.b(r12)
            if (r11 == 0) goto L_0x005a
            r11 = 1
            goto L_0x005b
        L_0x005a:
            r11 = 0
        L_0x005b:
            if (r11 == 0) goto L_0x0062
            int r11 = r12.length
            int r10 = r10 + r11
            int r9 = r9 + 1
            goto L_0x002d
        L_0x0062:
            r9 = 0
            goto L_0x0065
        L_0x0064:
            r9 = 1
        L_0x0065:
            if (r9 == 0) goto L_0x0090
            byte[] r9 = new byte[r10]
            r10 = 0
            r11 = 0
        L_0x006b:
            int r12 = r18.size()
            if (r10 >= r12) goto L_0x0084
            java.lang.Object r12 = r1.get(r10)
            g1.t r12 = (g1.t) r12
            byte[] r12 = r12.f6570l
            r12.getClass()
            int r13 = r12.length
            java.lang.System.arraycopy(r12, r8, r9, r11, r13)
            int r11 = r11 + r13
            int r10 = r10 + 1
            goto L_0x006b
        L_0x0084:
            g1.t r1 = new g1.t
            java.lang.String r10 = r5.f6568j
            java.lang.String r11 = r5.f6569k
            java.util.UUID r5 = r5.f6567i
            r1.<init>(r5, r10, r11, r9)
            goto L_0x00c2
        L_0x0090:
            r5 = 0
        L_0x0091:
            int r9 = r18.size()
            if (r5 >= r9) goto L_0x00bc
            java.lang.Object r9 = r1.get(r5)
            g1.t r9 = (g1.t) r9
            byte[] r10 = r9.f6570l
            r10.getClass()
            d0.d r10 = u2.q.b(r10)
            if (r10 != 0) goto L_0x00aa
            r10 = -1
            goto L_0x00ac
        L_0x00aa:
            int r10 = r10.f4090h
        L_0x00ac:
            int r11 = j1.l0.f8453a
            if (r11 >= r3) goto L_0x00b3
            if (r10 != 0) goto L_0x00b3
            goto L_0x00b7
        L_0x00b3:
            if (r11 < r3) goto L_0x00b9
            if (r10 != r7) goto L_0x00b9
        L_0x00b7:
            r1 = r9
            goto L_0x00c2
        L_0x00b9:
            int r5 = r5 + 1
            goto L_0x0091
        L_0x00bc:
            java.lang.Object r1 = r1.get(r8)
            g1.t r1 = (g1.t) r1
        L_0x00c2:
            byte[] r5 = r1.f6570l
            r5.getClass()
            java.util.UUID r9 = g1.n.f6477e
            boolean r10 = r9.equals(r4)
            if (r10 == 0) goto L_0x015e
            byte[] r10 = u2.q.c(r4, r5)
            if (r10 != 0) goto L_0x00d6
            goto L_0x00d7
        L_0x00d6:
            r5 = r10
        L_0x00d7:
            j1.b0 r10 = new j1.b0
            r10.<init>((byte[]) r5)
            int r11 = r10.i()
            short r12 = r10.k()
            short r13 = r10.k()
            java.lang.String r14 = "FrameworkMediaDrm"
            if (r12 != r7) goto L_0x0155
            if (r13 == r7) goto L_0x00ef
            goto L_0x0155
        L_0x00ef:
            short r7 = r10.k()
            java.nio.charset.Charset r15 = c9.h.f3037e
            java.lang.String r7 = r10.t(r7, r15)
            java.lang.String r10 = "<LA_URL>"
            boolean r10 = r7.contains(r10)
            if (r10 == 0) goto L_0x0102
            goto L_0x015a
        L_0x0102:
            java.lang.String r5 = "</DATA>"
            int r5 = r7.indexOf(r5)
            if (r5 != r6) goto L_0x010f
            java.lang.String r6 = "Could not find the </DATA> tag. Skipping LA_URL workaround."
            j1.v.g(r14, r6)
        L_0x010f:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r8 = r7.substring(r8, r5)
            r6.append(r8)
            r6.append(r2)
            java.lang.String r5 = r7.substring(r5)
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            int r11 = r11 + 52
            java.nio.ByteBuffer r6 = java.nio.ByteBuffer.allocate(r11)
            java.nio.ByteOrder r7 = java.nio.ByteOrder.LITTLE_ENDIAN
            r6.order(r7)
            r6.putInt(r11)
            short r7 = (short) r12
            r6.putShort(r7)
            short r7 = (short) r13
            r6.putShort(r7)
            int r7 = r5.length()
            int r7 = r7 * 2
            short r7 = (short) r7
            r6.putShort(r7)
            byte[] r5 = r5.getBytes(r15)
            r6.put(r5)
            byte[] r5 = r6.array()
            goto L_0x015a
        L_0x0155:
            java.lang.String r6 = "Unexpected record count or type. Skipping LA_URL workaround."
            j1.v.f(r14, r6)
        L_0x015a:
            byte[] r5 = u2.q.a(r9, r5)
        L_0x015e:
            int r6 = j1.l0.f8453a
            if (r6 >= r3) goto L_0x016a
            java.util.UUID r7 = g1.n.f6476d
            boolean r7 = r7.equals(r4)
            if (r7 != 0) goto L_0x019c
        L_0x016a:
            boolean r7 = r9.equals(r4)
            if (r7 == 0) goto L_0x01a3
            java.lang.String r7 = "Amazon"
            java.lang.String r8 = j1.l0.f8455c
            boolean r7 = r7.equals(r8)
            if (r7 == 0) goto L_0x01a3
            java.lang.String r7 = j1.l0.f8456d
            java.lang.String r8 = "AFTB"
            boolean r8 = r8.equals(r7)
            if (r8 != 0) goto L_0x019c
            java.lang.String r8 = "AFTS"
            boolean r8 = r8.equals(r7)
            if (r8 != 0) goto L_0x019c
            java.lang.String r8 = "AFTM"
            boolean r8 = r8.equals(r7)
            if (r8 != 0) goto L_0x019c
            java.lang.String r8 = "AFTT"
            boolean r7 = r8.equals(r7)
            if (r7 == 0) goto L_0x01a3
        L_0x019c:
            byte[] r7 = u2.q.c(r4, r5)
            if (r7 == 0) goto L_0x01a3
            r5 = r7
        L_0x01a3:
            r7 = 26
            java.lang.String r8 = r1.f6569k
            if (r6 >= r7) goto L_0x01c3
            java.util.UUID r6 = g1.n.f6475c
            boolean r6 = r6.equals(r4)
            if (r6 == 0) goto L_0x01c3
            java.lang.String r6 = "video/mp4"
            boolean r6 = r6.equals(r8)
            if (r6 != 0) goto L_0x01c1
            java.lang.String r6 = "audio/mp4"
            boolean r6 = r6.equals(r8)
            if (r6 == 0) goto L_0x01c3
        L_0x01c1:
            java.lang.String r8 = "cenc"
        L_0x01c3:
            r7 = r5
            goto L_0x01c8
        L_0x01c5:
            r1 = 0
            r7 = r1
            r8 = r7
        L_0x01c8:
            android.media.MediaDrm r5 = r0.f12461b
            r6 = r17
            r9 = r19
            r10 = r20
            android.media.MediaDrm$KeyRequest r5 = r5.getKeyRequest(r6, r7, r8, r9, r10)
            byte[] r6 = r5.getData()
            java.util.UUID r7 = g1.n.f6475c
            boolean r4 = r7.equals(r4)
            if (r4 == 0) goto L_0x0202
            int r4 = j1.l0.f8453a
            r7 = 27
            if (r4 < r7) goto L_0x01e7
            goto L_0x0202
        L_0x01e7:
            java.lang.String r4 = new java.lang.String
            java.nio.charset.Charset r7 = c9.h.f3035c
            r4.<init>(r6, r7)
            r6 = 43
            r7 = 45
            java.lang.String r4 = r4.replace(r6, r7)
            r6 = 47
            r7 = 95
            java.lang.String r4 = r4.replace(r6, r7)
            byte[] r6 = j1.l0.z(r4)
        L_0x0202:
            java.lang.String r4 = r5.getDefaultUrl()
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x020d
            goto L_0x021b
        L_0x020d:
            int r2 = j1.l0.f8453a
            r7 = 33
            if (r2 != r7) goto L_0x021d
            java.lang.String r2 = "https://default.url"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x021d
        L_0x021b:
            java.lang.String r4 = ""
        L_0x021d:
            boolean r2 = android.text.TextUtils.isEmpty(r4)
            if (r2 == 0) goto L_0x022e
            if (r1 == 0) goto L_0x022e
            java.lang.String r1 = r1.f6568j
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L_0x022e
            r4 = r1
        L_0x022e:
            int r1 = j1.l0.f8453a
            if (r1 < r3) goto L_0x0235
            int unused = r5.getRequestType()
        L_0x0235:
            p1.a0 r1 = new p1.a0
            r1.<init>(r4, r6)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p1.h0.i(byte[], java.util.List, int, java.util.HashMap):p1.a0");
    }

    public final int j() {
        return 2;
    }

    public final b k(byte[] bArr) {
        boolean z10;
        int i10 = l0.f8453a;
        UUID uuid = this.f12460a;
        if (i10 >= 21 || !n.f6476d.equals(uuid) || !"L3".equals(this.f12461b.getPropertyString("securityLevel"))) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (i10 < 27 && n.f6475c.equals(uuid)) {
            uuid = n.f6474b;
        }
        return new d0(uuid, bArr, z10);
    }

    public final void l(byte[] bArr, f0 f0Var) {
        if (l0.f8453a >= 31) {
            try {
                g0.b(this.f12461b, bArr, f0Var);
            } catch (UnsupportedOperationException unused) {
                v.g("FrameworkMediaDrm", "setLogSessionId failed.");
            }
        }
    }

    public final boolean m(String str, byte[] bArr) {
        if (l0.f8453a >= 31) {
            return g0.a(this.f12461b, str);
        }
        try {
            MediaCrypto mediaCrypto = new MediaCrypto(this.f12460a, bArr);
            try {
                return mediaCrypto.requiresSecureDecoderComponent(str);
            } finally {
                mediaCrypto.release();
            }
        } catch (MediaCryptoException unused) {
            return true;
        }
    }

    public final byte[] n() {
        return this.f12461b.openSession();
    }
}
