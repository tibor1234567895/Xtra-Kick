package x;

import android.util.SparseArray;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public final SparseArray f16402a = new SparseArray();

    /* renamed from: b  reason: collision with root package name */
    public final SparseArray f16403b = new SparseArray();

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public f(android.content.Context r8, int r9) {
        /*
            r7 = this;
            r7.<init>()
            android.util.SparseArray r0 = new android.util.SparseArray
            r0.<init>()
            r7.f16402a = r0
            android.util.SparseArray r0 = new android.util.SparseArray
            r0.<init>()
            r7.f16403b = r0
            android.content.res.Resources r0 = r8.getResources()
            android.content.res.XmlResourceParser r9 = r0.getXml(r9)
            int r0 = r9.getEventType()     // Catch:{ XmlPullParserException -> 0x009d, IOException -> 0x0098 }
            r1 = 0
        L_0x001e:
            r2 = 1
            if (r0 == r2) goto L_0x00a1
            if (r0 == 0) goto L_0x0090
            r3 = 2
            if (r0 == r3) goto L_0x0028
            goto L_0x0093
        L_0x0028:
            java.lang.String r0 = r9.getName()     // Catch:{ XmlPullParserException -> 0x009d, IOException -> 0x0098 }
            int r4 = r0.hashCode()     // Catch:{ XmlPullParserException -> 0x009d, IOException -> 0x0098 }
            r5 = 4
            r6 = 3
            switch(r4) {
                case -1349929691: goto L_0x005d;
                case 80204913: goto L_0x0053;
                case 1382829617: goto L_0x004a;
                case 1657696882: goto L_0x0040;
                case 1901439077: goto L_0x0036;
                default: goto L_0x0035;
            }     // Catch:{ XmlPullParserException -> 0x009d, IOException -> 0x0098 }
        L_0x0035:
            goto L_0x0067
        L_0x0036:
            java.lang.String r2 = "Variant"
            boolean r0 = r0.equals(r2)     // Catch:{ XmlPullParserException -> 0x009d, IOException -> 0x0098 }
            if (r0 == 0) goto L_0x0067
            r2 = 3
            goto L_0x0068
        L_0x0040:
            java.lang.String r2 = "layoutDescription"
            boolean r0 = r0.equals(r2)     // Catch:{ XmlPullParserException -> 0x009d, IOException -> 0x0098 }
            if (r0 == 0) goto L_0x0067
            r2 = 0
            goto L_0x0068
        L_0x004a:
            java.lang.String r4 = "StateSet"
            boolean r0 = r0.equals(r4)     // Catch:{ XmlPullParserException -> 0x009d, IOException -> 0x0098 }
            if (r0 == 0) goto L_0x0067
            goto L_0x0068
        L_0x0053:
            java.lang.String r2 = "State"
            boolean r0 = r0.equals(r2)     // Catch:{ XmlPullParserException -> 0x009d, IOException -> 0x0098 }
            if (r0 == 0) goto L_0x0067
            r2 = 2
            goto L_0x0068
        L_0x005d:
            java.lang.String r2 = "ConstraintSet"
            boolean r0 = r0.equals(r2)     // Catch:{ XmlPullParserException -> 0x009d, IOException -> 0x0098 }
            if (r0 == 0) goto L_0x0067
            r2 = 4
            goto L_0x0068
        L_0x0067:
            r2 = -1
        L_0x0068:
            if (r2 == r3) goto L_0x0082
            if (r2 == r6) goto L_0x0073
            if (r2 == r5) goto L_0x006f
            goto L_0x0093
        L_0x006f:
            r7.a(r8, r9)     // Catch:{ XmlPullParserException -> 0x009d, IOException -> 0x0098 }
            goto L_0x0093
        L_0x0073:
            x.e r0 = new x.e     // Catch:{ XmlPullParserException -> 0x009d, IOException -> 0x0098 }
            r0.<init>(r8, r9)     // Catch:{ XmlPullParserException -> 0x009d, IOException -> 0x0098 }
            if (r1 == 0) goto L_0x0093
            java.lang.Object r2 = r1.f519j     // Catch:{ XmlPullParserException -> 0x009d, IOException -> 0x0098 }
            java.util.ArrayList r2 = (java.util.ArrayList) r2     // Catch:{ XmlPullParserException -> 0x009d, IOException -> 0x0098 }
            r2.add(r0)     // Catch:{ XmlPullParserException -> 0x009d, IOException -> 0x0098 }
            goto L_0x0093
        L_0x0082:
            androidx.activity.result.j r0 = new androidx.activity.result.j     // Catch:{ XmlPullParserException -> 0x009d, IOException -> 0x0098 }
            r0.<init>((android.content.Context) r8, (android.content.res.XmlResourceParser) r9)     // Catch:{ XmlPullParserException -> 0x009d, IOException -> 0x0098 }
            android.util.SparseArray r1 = r7.f16402a     // Catch:{ XmlPullParserException -> 0x009d, IOException -> 0x0098 }
            int r2 = r0.f517h     // Catch:{ XmlPullParserException -> 0x009d, IOException -> 0x0098 }
            r1.put(r2, r0)     // Catch:{ XmlPullParserException -> 0x009d, IOException -> 0x0098 }
            r1 = r0
            goto L_0x0093
        L_0x0090:
            r9.getName()     // Catch:{ XmlPullParserException -> 0x009d, IOException -> 0x0098 }
        L_0x0093:
            int r0 = r9.next()     // Catch:{ XmlPullParserException -> 0x009d, IOException -> 0x0098 }
            goto L_0x001e
        L_0x0098:
            r8 = move-exception
            r8.printStackTrace()
            goto L_0x00a1
        L_0x009d:
            r8 = move-exception
            r8.printStackTrace()
        L_0x00a1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: x.f.<init>(android.content.Context, int):void");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x0225, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00aa, code lost:
        r5 = 65535;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00ab, code lost:
        if (r5 == 0) goto L_0x0234;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00ad, code lost:
        if (r5 == 1) goto L_0x00b5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00af, code lost:
        if (r5 == 2) goto L_0x00b5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00b1, code lost:
        if (r5 == 3) goto L_0x00b5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00b5, code lost:
        r0.f16497c.put(java.lang.Integer.valueOf(r7.f16416a), r7);
        r7 = null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.content.Context r12, android.content.res.XmlResourceParser r13) {
        /*
            r11 = this;
            x.m r0 = new x.m
            r0.<init>()
            int r1 = r13.getAttributeCount()
            r2 = 0
            r3 = 0
        L_0x000b:
            if (r3 >= r1) goto L_0x023e
            java.lang.String r4 = r13.getAttributeName(r3)
            java.lang.String r5 = r13.getAttributeValue(r3)
            if (r4 == 0) goto L_0x023a
            if (r5 != 0) goto L_0x001b
            goto L_0x023a
        L_0x001b:
            java.lang.String r6 = "id"
            boolean r4 = r6.equals(r4)
            if (r4 == 0) goto L_0x023a
            java.lang.String r1 = "/"
            boolean r1 = r5.contains(r1)
            r3 = -1
            r4 = 1
            if (r1 == 0) goto L_0x0045
            r1 = 47
            int r1 = r5.indexOf(r1)
            int r1 = r1 + r4
            java.lang.String r1 = r5.substring(r1)
            android.content.res.Resources r7 = r12.getResources()
            java.lang.String r8 = r12.getPackageName()
            int r1 = r7.getIdentifier(r1, r6, r8)
            goto L_0x0046
        L_0x0045:
            r1 = -1
        L_0x0046:
            if (r1 != r3) goto L_0x005e
            int r6 = r5.length()
            if (r6 <= r4) goto L_0x0057
            java.lang.String r1 = r5.substring(r4)
            int r1 = java.lang.Integer.parseInt(r1)
            goto L_0x005e
        L_0x0057:
            java.lang.String r5 = "ConstraintLayoutStates"
            java.lang.String r6 = "error in parsing id"
            android.util.Log.e(r5, r6)
        L_0x005e:
            int r5 = r13.getEventType()     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
            r6 = 0
            r7 = r6
        L_0x0064:
            if (r5 == r4) goto L_0x0234
            if (r5 == 0) goto L_0x0222
            r8 = 2
            r9 = 3
            if (r5 == r8) goto L_0x00c3
            if (r5 == r9) goto L_0x0070
            goto L_0x0225
        L_0x0070:
            java.lang.String r5 = r13.getName()     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
            java.util.Locale r10 = java.util.Locale.ROOT     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
            java.lang.String r5 = r5.toLowerCase(r10)     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
            int r10 = r5.hashCode()     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
            switch(r10) {
                case -2075718416: goto L_0x00a0;
                case -190376483: goto L_0x0096;
                case 426575017: goto L_0x008c;
                case 2146106725: goto L_0x0082;
                default: goto L_0x0081;
            }     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
        L_0x0081:
            goto L_0x00aa
        L_0x0082:
            java.lang.String r10 = "constraintset"
            boolean r5 = r5.equals(r10)     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
            if (r5 == 0) goto L_0x00aa
            r5 = 0
            goto L_0x00ab
        L_0x008c:
            java.lang.String r10 = "constraintoverride"
            boolean r5 = r5.equals(r10)     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
            if (r5 == 0) goto L_0x00aa
            r5 = 2
            goto L_0x00ab
        L_0x0096:
            java.lang.String r10 = "constraint"
            boolean r5 = r5.equals(r10)     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
            if (r5 == 0) goto L_0x00aa
            r5 = 1
            goto L_0x00ab
        L_0x00a0:
            java.lang.String r10 = "guideline"
            boolean r5 = r5.equals(r10)     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
            if (r5 == 0) goto L_0x00aa
            r5 = 3
            goto L_0x00ab
        L_0x00aa:
            r5 = -1
        L_0x00ab:
            if (r5 == 0) goto L_0x0234
            if (r5 == r4) goto L_0x00b5
            if (r5 == r8) goto L_0x00b5
            if (r5 == r9) goto L_0x00b5
            goto L_0x0225
        L_0x00b5:
            java.util.HashMap r5 = r0.f16497c     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
            int r8 = r7.f16416a     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
            r5.put(r8, r7)     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
            r7 = r6
            goto L_0x0225
        L_0x00c3:
            java.lang.String r5 = r13.getName()     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
            int r10 = r5.hashCode()     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
            switch(r10) {
                case -2025855158: goto L_0x012b;
                case -1984451626: goto L_0x0121;
                case -1962203927: goto L_0x0117;
                case -1269513683: goto L_0x010d;
                case -1238332596: goto L_0x0103;
                case -71750448: goto L_0x00fa;
                case 366511058: goto L_0x00ef;
                case 1331510167: goto L_0x00e5;
                case 1791837707: goto L_0x00da;
                case 1803088381: goto L_0x00d0;
                default: goto L_0x00ce;
            }     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
        L_0x00ce:
            goto L_0x0135
        L_0x00d0:
            java.lang.String r8 = "Constraint"
            boolean r5 = r5.equals(r8)     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
            if (r5 == 0) goto L_0x0135
            r8 = 0
            goto L_0x0136
        L_0x00da:
            java.lang.String r8 = "CustomAttribute"
            boolean r5 = r5.equals(r8)     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
            if (r5 == 0) goto L_0x0135
            r8 = 8
            goto L_0x0136
        L_0x00e5:
            java.lang.String r8 = "Barrier"
            boolean r5 = r5.equals(r8)     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
            if (r5 == 0) goto L_0x0135
            r8 = 3
            goto L_0x0136
        L_0x00ef:
            java.lang.String r8 = "CustomMethod"
            boolean r5 = r5.equals(r8)     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
            if (r5 == 0) goto L_0x0135
            r8 = 9
            goto L_0x0136
        L_0x00fa:
            java.lang.String r9 = "Guideline"
            boolean r5 = r5.equals(r9)     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
            if (r5 == 0) goto L_0x0135
            goto L_0x0136
        L_0x0103:
            java.lang.String r8 = "Transform"
            boolean r5 = r5.equals(r8)     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
            if (r5 == 0) goto L_0x0135
            r8 = 5
            goto L_0x0136
        L_0x010d:
            java.lang.String r8 = "PropertySet"
            boolean r5 = r5.equals(r8)     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
            if (r5 == 0) goto L_0x0135
            r8 = 4
            goto L_0x0136
        L_0x0117:
            java.lang.String r8 = "ConstraintOverride"
            boolean r5 = r5.equals(r8)     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
            if (r5 == 0) goto L_0x0135
            r8 = 1
            goto L_0x0136
        L_0x0121:
            java.lang.String r8 = "Motion"
            boolean r5 = r5.equals(r8)     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
            if (r5 == 0) goto L_0x0135
            r8 = 7
            goto L_0x0136
        L_0x012b:
            java.lang.String r8 = "Layout"
            boolean r5 = r5.equals(r8)     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
            if (r5 == 0) goto L_0x0135
            r8 = 6
            goto L_0x0136
        L_0x0135:
            r8 = -1
        L_0x0136:
            java.lang.String r5 = "XML parser error must be within a Constraint "
            switch(r8) {
                case 0: goto L_0x0218;
                case 1: goto L_0x020f;
                case 2: goto L_0x0202;
                case 3: goto L_0x01f5;
                case 4: goto L_0x01d0;
                case 5: goto L_0x01ab;
                case 6: goto L_0x0185;
                case 7: goto L_0x015f;
                case 8: goto L_0x013d;
                case 9: goto L_0x013d;
                default: goto L_0x013b;
            }
        L_0x013b:
            goto L_0x0225
        L_0x013d:
            if (r7 == 0) goto L_0x0146
            java.util.HashMap r5 = r7.f16421f     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
            x.a.a(r12, r13, r5)     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
            goto L_0x0225
        L_0x0146:
            java.lang.RuntimeException r12 = new java.lang.RuntimeException     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
            r2.<init>()     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
            r2.append(r5)     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
            int r13 = r13.getLineNumber()     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
            r2.append(r13)     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
            java.lang.String r13 = r2.toString()     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
            r12.<init>(r13)     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
            throw r12     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
        L_0x015f:
            if (r7 == 0) goto L_0x016c
            x.j r5 = r7.f16418c     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
            android.util.AttributeSet r8 = android.util.Xml.asAttributeSet(r13)     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
            r5.a(r12, r8)     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
            goto L_0x0225
        L_0x016c:
            java.lang.RuntimeException r12 = new java.lang.RuntimeException     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
            r2.<init>()     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
            r2.append(r5)     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
            int r13 = r13.getLineNumber()     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
            r2.append(r13)     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
            java.lang.String r13 = r2.toString()     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
            r12.<init>(r13)     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
            throw r12     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
        L_0x0185:
            if (r7 == 0) goto L_0x0192
            x.i r5 = r7.f16419d     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
            android.util.AttributeSet r8 = android.util.Xml.asAttributeSet(r13)     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
            r5.a(r12, r8)     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
            goto L_0x0225
        L_0x0192:
            java.lang.RuntimeException r12 = new java.lang.RuntimeException     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
            r2.<init>()     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
            r2.append(r5)     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
            int r13 = r13.getLineNumber()     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
            r2.append(r13)     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
            java.lang.String r13 = r2.toString()     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
            r12.<init>(r13)     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
            throw r12     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
        L_0x01ab:
            if (r7 == 0) goto L_0x01b7
            x.l r5 = r7.f16420e     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
            android.util.AttributeSet r8 = android.util.Xml.asAttributeSet(r13)     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
            r5.a(r12, r8)     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
            goto L_0x0225
        L_0x01b7:
            java.lang.RuntimeException r12 = new java.lang.RuntimeException     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
            r2.<init>()     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
            r2.append(r5)     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
            int r13 = r13.getLineNumber()     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
            r2.append(r13)     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
            java.lang.String r13 = r2.toString()     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
            r12.<init>(r13)     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
            throw r12     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
        L_0x01d0:
            if (r7 == 0) goto L_0x01dc
            x.k r5 = r7.f16417b     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
            android.util.AttributeSet r8 = android.util.Xml.asAttributeSet(r13)     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
            r5.a(r12, r8)     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
            goto L_0x0225
        L_0x01dc:
            java.lang.RuntimeException r12 = new java.lang.RuntimeException     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
            r2.<init>()     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
            r2.append(r5)     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
            int r13 = r13.getLineNumber()     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
            r2.append(r13)     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
            java.lang.String r13 = r2.toString()     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
            r12.<init>(r13)     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
            throw r12     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
        L_0x01f5:
            android.util.AttributeSet r5 = android.util.Xml.asAttributeSet(r13)     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
            x.h r5 = x.m.d(r12, r5, r2)     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
            x.i r7 = r5.f16419d     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
            r7.f16438h0 = r4     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
            goto L_0x0220
        L_0x0202:
            android.util.AttributeSet r5 = android.util.Xml.asAttributeSet(r13)     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
            x.h r5 = x.m.d(r12, r5, r2)     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
            x.i r7 = r5.f16419d     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
            r7.f16423a = r4     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
            goto L_0x0220
        L_0x020f:
            android.util.AttributeSet r5 = android.util.Xml.asAttributeSet(r13)     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
            x.h r5 = x.m.d(r12, r5, r4)     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
            goto L_0x0220
        L_0x0218:
            android.util.AttributeSet r5 = android.util.Xml.asAttributeSet(r13)     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
            x.h r5 = x.m.d(r12, r5, r2)     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
        L_0x0220:
            r7 = r5
            goto L_0x0225
        L_0x0222:
            r13.getName()     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
        L_0x0225:
            int r5 = r13.next()     // Catch:{ XmlPullParserException -> 0x0230, IOException -> 0x022b }
            goto L_0x0064
        L_0x022b:
            r12 = move-exception
            r12.printStackTrace()
            goto L_0x0234
        L_0x0230:
            r12 = move-exception
            r12.printStackTrace()
        L_0x0234:
            android.util.SparseArray r12 = r11.f16403b
            r12.put(r1, r0)
            goto L_0x023e
        L_0x023a:
            int r3 = r3 + 1
            goto L_0x000b
        L_0x023e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: x.f.a(android.content.Context, android.content.res.XmlResourceParser):void");
    }
}
