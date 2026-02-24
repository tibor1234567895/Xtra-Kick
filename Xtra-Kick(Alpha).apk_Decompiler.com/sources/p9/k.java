package p9;

import hb.h0;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import ma.o0;
import xa.j;
import y9.e;
import y9.f;
import y9.g;
import y9.h;
import z9.a;

public final class k implements h {

    /* renamed from: h  reason: collision with root package name */
    public final Map f12694h;

    /* renamed from: i  reason: collision with root package name */
    public final e f12695i;

    public k() {
        this(0);
    }

    /* JADX INFO: finally extract failed */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v17, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v23, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final y9.f B(y9.g r27, y9.q r28) {
        /*
            r26 = this;
            r0 = r27
            java.lang.String r1 = "interruptMonitor"
            r2 = r28
            xa.j.g(r1, r2)
            z9.a r12 = new z9.a
            r1 = 0
            r12.<init>(r1)
            java.lang.System.nanoTime()
            java.lang.String r3 = "Range"
            java.util.Map r4 = r0.f17258b
            java.lang.Object r3 = r4.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            if (r3 == 0) goto L_0x001f
            goto L_0x0021
        L_0x001f:
            java.lang.String r3 = "bytes=0-"
        L_0x0021:
            java.lang.String r5 = "="
            r6 = 6
            int r5 = fb.y.x(r3, r5, r6)
            java.lang.String r7 = "-"
            int r6 = fb.y.x(r3, r7, r6)
            r7 = 1
            int r5 = r5 + r7
            java.lang.String r5 = r3.substring(r5, r6)
            java.lang.String r8 = "(this as java.lang.Strin…ing(startIndex, endIndex)"
            xa.j.b(r8, r5)
            long r9 = java.lang.Long.parseLong(r5)
            int r6 = r6 + r7
            int r5 = r3.length()     // Catch:{ Exception -> 0x004e }
            java.lang.String r3 = r3.substring(r6, r5)     // Catch:{ Exception -> 0x004e }
            xa.j.b(r8, r3)     // Catch:{ Exception -> 0x004e }
            long r5 = java.lang.Long.parseLong(r3)     // Catch:{ Exception -> 0x004e }
            goto L_0x0050
        L_0x004e:
            r5 = -1
        L_0x0050:
            java.lang.Long r3 = java.lang.Long.valueOf(r9)
            java.lang.Long r5 = java.lang.Long.valueOf(r5)
            java.lang.String r6 = "Authorization"
            java.lang.Object r6 = r4.get(r6)
            java.lang.String r6 = (java.lang.String) r6
            if (r6 == 0) goto L_0x0063
            goto L_0x0065
        L_0x0063:
            java.lang.String r6 = ""
        L_0x0065:
            r20 = r6
            java.lang.String r6 = r0.f17257a
            int r8 = hb.h0.k0(r6)
            java.lang.String r9 = hb.h0.j0(r6)
            y9.j r10 = r0.f17262f
            r10.getClass()
            y9.s r11 = new y9.s
            java.util.Map r10 = r10.f17264h
            java.util.LinkedHashMap r10 = ma.j0.i(r10)
            r11.<init>(r10)
            java.util.Set r10 = r4.entrySet()
            java.util.Iterator r10 = r10.iterator()
        L_0x0089:
            boolean r13 = r10.hasNext()
            if (r13 == 0) goto L_0x00b1
            java.lang.Object r13 = r10.next()
            java.util.Map$Entry r13 = (java.util.Map.Entry) r13
            java.lang.Object r14 = r13.getKey()
            java.lang.String r14 = (java.lang.String) r14
            java.lang.Object r13 = r13.getValue()
            java.lang.String r13 = (java.lang.String) r13
            java.lang.String r15 = "key"
            xa.j.g(r15, r14)
            java.lang.String r15 = "value"
            xa.j.g(r15, r13)
            java.util.Map r15 = r11.f17281j
            r15.put(r14, r13)
            goto L_0x0089
        L_0x00b1:
            y9.m r10 = new y9.m
            r10.<init>()
            java.net.InetSocketAddress r13 = new java.net.InetSocketAddress
            r13.<init>(r9, r8)
            r10.f17267a = r13
            z9.c r8 = new z9.c
            r14 = 1
            android.net.Uri r6 = android.net.Uri.parse(r6)
            java.lang.String r9 = "Uri.parse(url)"
            xa.j.b(r9, r6)
            java.lang.String r6 = r6.getLastPathSegment()
            if (r6 == 0) goto L_0x00d0
            goto L_0x00d2
        L_0x00d0:
            java.lang.String r6 = "-1"
        L_0x00d2:
            r15 = r6
            long r16 = r3.longValue()
            long r18 = r5.longValue()
            java.lang.String r3 = "Client"
            java.lang.Object r3 = r4.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            if (r3 == 0) goto L_0x00e6
            goto L_0x00f3
        L_0x00e6:
            java.util.UUID r3 = java.util.UUID.randomUUID()
            java.lang.String r3 = r3.toString()
            java.lang.String r5 = "UUID.randomUUID().toString()"
            xa.j.b(r5, r3)
        L_0x00f3:
            r21 = r3
            java.lang.String r3 = "Page"
            java.lang.Object r3 = r4.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            if (r3 == 0) goto L_0x010c
            java.lang.Integer r3 = fb.v.d(r3)
            if (r3 == 0) goto L_0x010c
            int r3 = r3.intValue()
            r23 = r3
            goto L_0x010e
        L_0x010c:
            r23 = 0
        L_0x010e:
            java.lang.String r3 = "Size"
            java.lang.Object r3 = r4.get(r3)
            java.lang.String r3 = (java.lang.String) r3
            if (r3 == 0) goto L_0x0125
            java.lang.Integer r3 = fb.v.d(r3)
            if (r3 == 0) goto L_0x0125
            int r3 = r3.intValue()
            r24 = r3
            goto L_0x0127
        L_0x0125:
            r24 = 0
        L_0x0127:
            r25 = 0
            r13 = r8
            r22 = r11
            r13.<init>(r14, r15, r16, r18, r20, r21, r22, r23, r24, r25)
            r10.f17268b = r8
            java.net.InetSocketAddress r3 = r10.f17267a
            java.lang.String r4 = "socketAddress"
            xa.j.g(r4, r3)
            java.lang.Object r4 = r12.f17788c
            monitor-enter(r4)
            r12.e()     // Catch:{ all -> 0x022e }
            java.net.Socket r5 = r12.f17790e     // Catch:{ all -> 0x022e }
            r5.connect(r3)     // Catch:{ all -> 0x022e }
            java.io.DataInputStream r3 = new java.io.DataInputStream     // Catch:{ all -> 0x022e }
            java.net.Socket r5 = r12.f17790e     // Catch:{ all -> 0x022e }
            java.io.InputStream r5 = r5.getInputStream()     // Catch:{ all -> 0x022e }
            r3.<init>(r5)     // Catch:{ all -> 0x022e }
            r12.f17786a = r3     // Catch:{ all -> 0x022e }
            java.io.DataOutputStream r3 = new java.io.DataOutputStream     // Catch:{ all -> 0x022e }
            java.net.Socket r5 = r12.f17790e     // Catch:{ all -> 0x022e }
            java.io.OutputStream r5 = r5.getOutputStream()     // Catch:{ all -> 0x022e }
            r3.<init>(r5)     // Catch:{ all -> 0x022e }
            r12.f17787b = r3     // Catch:{ all -> 0x022e }
            la.v r3 = la.v.f9814a     // Catch:{ all -> 0x022e }
            monitor-exit(r4)
            z9.c r3 = r10.f17268b
            r12.d(r3)
            boolean r2 = r28.a()
            r3 = 0
            if (r2 != 0) goto L_0x022b
            z9.e r2 = r12.c()
            int r4 = r2.f17801h
            int r5 = r2.f17803j
            r6 = 206(0xce, float:2.89E-43)
            if (r5 != r7) goto L_0x0180
            int r5 = r2.f17802i
            if (r5 != r7) goto L_0x0180
            if (r4 != r6) goto L_0x0180
            r5 = 1
            goto L_0x0181
        L_0x0180:
            r5 = 0
        L_0x0181:
            long r8 = r2.f17805l
            java.io.DataInputStream r10 = r12.b()
            if (r5 != 0) goto L_0x018e
            java.lang.String r11 = hb.h0.G(r10)
            goto L_0x018f
        L_0x018e:
            r11 = r3
        L_0x018f:
            java.util.LinkedHashMap r13 = new java.util.LinkedHashMap
            r13.<init>()
            org.json.JSONObject r14 = new org.json.JSONObject     // Catch:{ Exception -> 0x01c8 }
            java.lang.String r15 = r2.u()     // Catch:{ Exception -> 0x01c8 }
            r14.<init>(r15)     // Catch:{ Exception -> 0x01c8 }
            java.util.Iterator r15 = r14.keys()     // Catch:{ Exception -> 0x01c8 }
            java.lang.String r1 = "json.keys()"
            xa.j.b(r1, r15)     // Catch:{ Exception -> 0x01c8 }
        L_0x01a6:
            boolean r1 = r15.hasNext()     // Catch:{ Exception -> 0x01c8 }
            if (r1 == 0) goto L_0x01c9
            java.lang.Object r1 = r15.next()     // Catch:{ Exception -> 0x01c8 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x01c8 }
            java.lang.String r7 = "it"
            xa.j.b(r7, r1)     // Catch:{ Exception -> 0x01c8 }
            java.lang.Object r7 = r14.get(r1)     // Catch:{ Exception -> 0x01c8 }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x01c8 }
            java.util.List r7 = ma.q.b(r7)     // Catch:{ Exception -> 0x01c8 }
            r13.put(r1, r7)     // Catch:{ Exception -> 0x01c8 }
            r7 = 1
            goto L_0x01a6
        L_0x01c8:
        L_0x01c9:
            java.lang.String r1 = "Content-MD5"
            boolean r1 = r13.containsKey(r1)
            if (r1 != 0) goto L_0x01dc
            java.lang.String r1 = "Content-MD5"
            java.lang.String r2 = r2.f17806m
            java.util.List r2 = ma.q.b(r2)
            r13.put(r1, r2)
        L_0x01dc:
            java.lang.String r1 = "Content-MD5"
            java.lang.Object r1 = r13.get(r1)
            java.util.List r1 = (java.util.List) r1
            if (r1 == 0) goto L_0x01ef
            java.lang.Object r1 = ma.z.u(r1)
            java.lang.String r1 = (java.lang.String) r1
            if (r1 == 0) goto L_0x01ef
            goto L_0x01f1
        L_0x01ef:
            java.lang.String r1 = ""
        L_0x01f1:
            r14 = r1
            if (r4 == r6) goto L_0x0211
            java.lang.String r1 = "Accept-Ranges"
            java.lang.Object r1 = r13.get(r1)
            java.util.List r1 = (java.util.List) r1
            if (r1 == 0) goto L_0x0205
            java.lang.Object r1 = ma.z.u(r1)
            r3 = r1
            java.lang.String r3 = (java.lang.String) r3
        L_0x0205:
            java.lang.String r1 = "bytes"
            boolean r1 = xa.j.a(r3, r1)
            if (r1 == 0) goto L_0x020e
            goto L_0x0211
        L_0x020e:
            r16 = 0
            goto L_0x0213
        L_0x0211:
            r16 = 1
        L_0x0213:
            y9.f r15 = new y9.f
            r1 = r15
            r2 = r4
            r3 = r5
            r4 = r8
            r6 = r10
            r7 = r27
            r8 = r14
            r9 = r13
            r10 = r16
            r1.<init>(r2, r3, r4, r6, r7, r8, r9, r10, r11)
            r1 = r26
            java.util.Map r0 = r1.f12694h
            r0.put(r15, r12)
            return r15
        L_0x022b:
            r1 = r26
            return r3
        L_0x022e:
            r0 = move-exception
            r1 = r26
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p9.k.B(y9.g, y9.q):y9.f");
    }

    public final void C(g gVar) {
    }

    public final boolean D(g gVar, String str) {
        String m02;
        j.g("request", gVar);
        j.g("hash", str);
        if (!(str.length() == 0) && (m02 = h0.m0(gVar.f17259c)) != null) {
            return m02.contentEquals(str);
        }
        return true;
    }

    public final Set J0(g gVar) {
        try {
            return h0.G0(gVar, this);
        } catch (Exception unused) {
            return o0.b(this.f12695i);
        }
    }

    public final void close() {
        Map map = this.f12694h;
        try {
            for (Map.Entry value : map.entrySet()) {
                ((a) value.getValue()).a();
            }
            map.clear();
        } catch (Exception unused) {
        }
    }

    public final e k0(g gVar, Set set) {
        j.g("supportedFileDownloaderTypes", set);
        return this.f12695i;
    }

    public final void q0(f fVar) {
        Map map = this.f12694h;
        if (map.containsKey(fVar)) {
            a aVar = (a) map.get(fVar);
            map.remove(fVar);
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    public final void s0(g gVar) {
    }

    public final void y0(g gVar) {
    }

    public k(int i10) {
        this.f12695i = e.SEQUENTIAL;
        Map synchronizedMap = Collections.synchronizedMap(new HashMap());
        j.b("Collections.synchronized…leResourceTransporter>())", synchronizedMap);
        this.f12694h = synchronizedMap;
    }
}
