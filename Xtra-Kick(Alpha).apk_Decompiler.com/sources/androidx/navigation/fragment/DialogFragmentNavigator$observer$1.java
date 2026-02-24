package androidx.navigation.fragment;

import androidx.lifecycle.b0;
import l3.e;

public final class DialogFragmentNavigator$observer$1 implements b0 {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ e f1869h;

    public DialogFragmentNavigator$observer$1(e eVar) {
        this.f1869h = eVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: j3.r} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: j3.r} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: j3.r} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: j3.r} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: j3.r} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: j3.r} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: j3.r} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: j3.r} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v9, resolved type: j3.r} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v13, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: j3.r} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v11, resolved type: j3.r} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v12, resolved type: j3.r} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void d(androidx.lifecycle.d0 r8, androidx.lifecycle.r r9) {
        /*
            r7 = this;
            int[] r0 = l3.d.f9536a
            int r9 = r9.ordinal()
            r9 = r0[r9]
            r0 = 1
            r1 = 0
            l3.e r2 = r7.f1869h
            if (r9 == r0) goto L_0x00fb
            r0 = 2
            r3 = 0
            if (r9 == r0) goto L_0x00c2
            r0 = 3
            if (r9 == r0) goto L_0x0059
            r0 = 4
            if (r9 == r0) goto L_0x001a
            goto L_0x013a
        L_0x001a:
            androidx.fragment.app.t r8 = (androidx.fragment.app.t) r8
            int r9 = l3.e.f9537h
            j3.r2 r9 = r2.b()
            kb.n0 r9 = r9.f8679f
            java.lang.Object r9 = r9.getValue()
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.util.Iterator r9 = r9.iterator()
        L_0x002e:
            boolean r0 = r9.hasNext()
            if (r0 == 0) goto L_0x0047
            java.lang.Object r0 = r9.next()
            r1 = r0
            j3.r r1 = (j3.r) r1
            java.lang.String r1 = r1.f8665m
            java.lang.String r4 = r8.F
            boolean r1 = xa.j.a(r1, r4)
            if (r1 == 0) goto L_0x002e
            r3 = r0
            goto L_0x002e
        L_0x0047:
            j3.r r3 = (j3.r) r3
            if (r3 == 0) goto L_0x0052
            j3.r2 r9 = r2.b()
            r9.b(r3)
        L_0x0052:
            androidx.lifecycle.g0 r8 = r8.V
            r8.c(r7)
            goto L_0x013a
        L_0x0059:
            androidx.fragment.app.t r8 = (androidx.fragment.app.t) r8
            android.app.Dialog r9 = r8.o0()
            boolean r9 = r9.isShowing()
            if (r9 != 0) goto L_0x013a
            int r9 = l3.e.f9537h
            j3.r2 r9 = r2.b()
            kb.n0 r9 = r9.f8678e
            java.lang.Object r9 = r9.getValue()
            java.util.List r9 = (java.util.List) r9
            int r0 = r9.size()
            java.util.ListIterator r0 = r9.listIterator(r0)
        L_0x007b:
            boolean r4 = r0.hasPrevious()
            if (r4 == 0) goto L_0x0093
            java.lang.Object r4 = r0.previous()
            r5 = r4
            j3.r r5 = (j3.r) r5
            java.lang.String r5 = r5.f8665m
            java.lang.String r6 = r8.F
            boolean r5 = xa.j.a(r5, r6)
            if (r5 == 0) goto L_0x007b
            r3 = r4
        L_0x0093:
            j3.r r3 = (j3.r) r3
            java.lang.Object r9 = ma.z.A(r9)
            boolean r9 = xa.j.a(r9, r3)
            if (r9 != 0) goto L_0x00b7
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r0 = "Dialog "
            r9.<init>(r0)
            r9.append(r8)
            java.lang.String r8 = " was dismissed while it was not the top of the back stack, popping all dialogs above this dismissed dialog"
            r9.append(r8)
            java.lang.String r8 = r9.toString()
            java.lang.String r9 = "DialogFragmentNavigator"
            android.util.Log.i(r9, r8)
        L_0x00b7:
            if (r3 == 0) goto L_0x013a
            j3.r2 r8 = r2.b()
            r8.e(r3, r1)
            goto L_0x013a
        L_0x00c2:
            androidx.fragment.app.t r8 = (androidx.fragment.app.t) r8
            int r9 = l3.e.f9537h
            j3.r2 r9 = r2.b()
            kb.n0 r9 = r9.f8679f
            java.lang.Object r9 = r9.getValue()
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.util.Iterator r9 = r9.iterator()
        L_0x00d6:
            boolean r0 = r9.hasNext()
            if (r0 == 0) goto L_0x00ef
            java.lang.Object r0 = r9.next()
            r1 = r0
            j3.r r1 = (j3.r) r1
            java.lang.String r1 = r1.f8665m
            java.lang.String r4 = r8.F
            boolean r1 = xa.j.a(r1, r4)
            if (r1 == 0) goto L_0x00d6
            r3 = r0
            goto L_0x00d6
        L_0x00ef:
            j3.r r3 = (j3.r) r3
            if (r3 == 0) goto L_0x013a
            j3.r2 r8 = r2.b()
            r8.b(r3)
            goto L_0x013a
        L_0x00fb:
            androidx.fragment.app.t r8 = (androidx.fragment.app.t) r8
            int r9 = l3.e.f9537h
            j3.r2 r9 = r2.b()
            kb.n0 r9 = r9.f8678e
            java.lang.Object r9 = r9.getValue()
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            boolean r2 = r9 instanceof java.util.Collection
            if (r2 == 0) goto L_0x0119
            r2 = r9
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x0119
            goto L_0x0134
        L_0x0119:
            java.util.Iterator r9 = r9.iterator()
        L_0x011d:
            boolean r2 = r9.hasNext()
            if (r2 == 0) goto L_0x0134
            java.lang.Object r2 = r9.next()
            j3.r r2 = (j3.r) r2
            java.lang.String r2 = r2.f8665m
            java.lang.String r3 = r8.F
            boolean r2 = xa.j.a(r2, r3)
            if (r2 == 0) goto L_0x011d
            goto L_0x0135
        L_0x0134:
            r0 = 0
        L_0x0135:
            if (r0 != 0) goto L_0x013a
            r8.l0()
        L_0x013a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.fragment.DialogFragmentNavigator$observer$1.d(androidx.lifecycle.d0, androidx.lifecycle.r):void");
    }
}
