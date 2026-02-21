package com.google.gson.internal.bind;

import com.google.gson.stream.JsonWriter;
import j9.b0;
import java.util.BitSet;

public final class j0 extends b0 {
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002a, code lost:
        if (java.lang.Integer.parseInt(r1) != 0) goto L_0x005a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0056, code lost:
        if (r7.nextInt() != 0) goto L_0x005a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x005f A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object b(com.google.gson.stream.JsonReader r7) {
        /*
            r6 = this;
            java.util.BitSet r0 = new java.util.BitSet
            r0.<init>()
            r7.beginArray()
            com.google.gson.stream.JsonToken r1 = r7.peek()
            r2 = 0
        L_0x000d:
            com.google.gson.stream.JsonToken r3 = com.google.gson.stream.JsonToken.END_ARRAY
            if (r1 == r3) goto L_0x0066
            int[] r3 = com.google.gson.internal.bind.k0.f4037a
            int r4 = r1.ordinal()
            r3 = r3[r4]
            r4 = 1
            if (r3 == r4) goto L_0x0052
            r5 = 2
            if (r3 == r5) goto L_0x004d
            r5 = 3
            if (r3 != r5) goto L_0x0039
            java.lang.String r1 = r7.nextString()
            int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ NumberFormatException -> 0x002d }
            if (r1 == 0) goto L_0x0059
            goto L_0x005a
        L_0x002d:
            j9.t r7 = new j9.t
            java.lang.String r0 = "Error: Expecting: bitset number value (1, 0), Found: "
            java.lang.String r0 = android.support.v4.media.h.m(r0, r1)
            r7.<init>((java.lang.String) r0)
            throw r7
        L_0x0039:
            j9.t r7 = new j9.t
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "Invalid bitset value type: "
            r0.<init>(r2)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r7.<init>((java.lang.String) r0)
            throw r7
        L_0x004d:
            boolean r4 = r7.nextBoolean()
            goto L_0x005a
        L_0x0052:
            int r1 = r7.nextInt()
            if (r1 == 0) goto L_0x0059
            goto L_0x005a
        L_0x0059:
            r4 = 0
        L_0x005a:
            if (r4 == 0) goto L_0x005f
            r0.set(r2)
        L_0x005f:
            int r2 = r2 + 1
            com.google.gson.stream.JsonToken r1 = r7.peek()
            goto L_0x000d
        L_0x0066:
            r7.endArray()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.bind.j0.b(com.google.gson.stream.JsonReader):java.lang.Object");
    }

    public final void c(JsonWriter jsonWriter, Object obj) {
        BitSet bitSet = (BitSet) obj;
        jsonWriter.beginArray();
        int length = bitSet.length();
        for (int i10 = 0; i10 < length; i10++) {
            jsonWriter.value(bitSet.get(i10) ? 1 : 0);
        }
        jsonWriter.endArray();
    }
}
