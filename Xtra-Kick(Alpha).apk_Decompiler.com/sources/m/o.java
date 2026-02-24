package m;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import c0.c;
import c0.g;
import g0.a;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import m0.e1;
import m0.f1;

public class o implements a {

    /* renamed from: y  reason: collision with root package name */
    public static final int[] f9971y = {1, 4, 5, 3, 2, 0};

    /* renamed from: a  reason: collision with root package name */
    public final Context f9972a;

    /* renamed from: b  reason: collision with root package name */
    public final Resources f9973b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f9974c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f9975d;

    /* renamed from: e  reason: collision with root package name */
    public m f9976e;

    /* renamed from: f  reason: collision with root package name */
    public final ArrayList f9977f;

    /* renamed from: g  reason: collision with root package name */
    public final ArrayList f9978g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f9979h;

    /* renamed from: i  reason: collision with root package name */
    public final ArrayList f9980i;

    /* renamed from: j  reason: collision with root package name */
    public final ArrayList f9981j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f9982k;

    /* renamed from: l  reason: collision with root package name */
    public int f9983l = 0;

    /* renamed from: m  reason: collision with root package name */
    public CharSequence f9984m;

    /* renamed from: n  reason: collision with root package name */
    public Drawable f9985n;

    /* renamed from: o  reason: collision with root package name */
    public View f9986o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f9987p = false;

    /* renamed from: q  reason: collision with root package name */
    public boolean f9988q = false;

    /* renamed from: r  reason: collision with root package name */
    public boolean f9989r = false;

    /* renamed from: s  reason: collision with root package name */
    public boolean f9990s = false;

    /* renamed from: t  reason: collision with root package name */
    public final ArrayList f9991t = new ArrayList();

    /* renamed from: u  reason: collision with root package name */
    public final CopyOnWriteArrayList f9992u = new CopyOnWriteArrayList();

    /* renamed from: v  reason: collision with root package name */
    public q f9993v;

    /* renamed from: w  reason: collision with root package name */
    public boolean f9994w = false;

    /* renamed from: x  reason: collision with root package name */
    public boolean f9995x;

    public o(Context context) {
        boolean z10;
        boolean z11 = false;
        this.f9972a = context;
        Resources resources = context.getResources();
        this.f9973b = resources;
        this.f9977f = new ArrayList();
        this.f9978g = new ArrayList();
        this.f9979h = true;
        this.f9980i = new ArrayList();
        this.f9981j = new ArrayList();
        this.f9982k = true;
        if (resources.getConfiguration().keyboard != 1) {
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            Method method = f1.f10074a;
            if (Build.VERSION.SDK_INT >= 28) {
                z10 = e1.b(viewConfiguration);
            } else {
                Resources resources2 = context.getResources();
                int identifier = resources2.getIdentifier("config_showMenuShortcutsWhenKeyboardPresent", "bool", "android");
                if (identifier == 0 || !resources2.getBoolean(identifier)) {
                    z10 = false;
                } else {
                    z10 = true;
                }
            }
            if (z10) {
                z11 = true;
            }
        }
        this.f9975d = z11;
    }

    public q a(int i10, int i11, int i12, CharSequence charSequence) {
        int i13;
        int i14 = (-65536 & i12) >> 16;
        if (i14 < 0 || i14 >= 6) {
            throw new IllegalArgumentException("order does not contain a valid category.");
        }
        int i15 = (f9971y[i14] << 16) | (65535 & i12);
        q qVar = new q(this, i10, i11, i12, i15, charSequence, this.f9983l);
        ArrayList arrayList = this.f9977f;
        int size = arrayList.size();
        while (true) {
            size--;
            if (size >= 0) {
                if (((q) arrayList.get(size)).f10002d <= i15) {
                    i13 = size + 1;
                    break;
                }
            } else {
                i13 = 0;
                break;
            }
        }
        arrayList.add(i13, qVar);
        p(true);
        return qVar;
    }

    public final MenuItem add(int i10) {
        return a(0, 0, 0, this.f9973b.getString(i10));
    }

    /* JADX WARNING: type inference failed for: r15v0, types: [android.view.MenuItem[]] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int addIntentOptions(int r8, int r9, int r10, android.content.ComponentName r11, android.content.Intent[] r12, android.content.Intent r13, int r14, android.view.MenuItem[] r15) {
        /*
            r7 = this;
            android.content.Context r0 = r7.f9972a
            android.content.pm.PackageManager r0 = r0.getPackageManager()
            r1 = 0
            java.util.List r11 = r0.queryIntentActivityOptions(r11, r12, r13, r1)
            if (r11 == 0) goto L_0x0012
            int r2 = r11.size()
            goto L_0x0013
        L_0x0012:
            r2 = 0
        L_0x0013:
            r14 = r14 & 1
            if (r14 != 0) goto L_0x001a
            r7.removeGroup(r8)
        L_0x001a:
            if (r1 >= r2) goto L_0x005b
            java.lang.Object r14 = r11.get(r1)
            android.content.pm.ResolveInfo r14 = (android.content.pm.ResolveInfo) r14
            android.content.Intent r3 = new android.content.Intent
            int r4 = r14.specificIndex
            if (r4 >= 0) goto L_0x002a
            r4 = r13
            goto L_0x002c
        L_0x002a:
            r4 = r12[r4]
        L_0x002c:
            r3.<init>(r4)
            android.content.ComponentName r4 = new android.content.ComponentName
            android.content.pm.ActivityInfo r5 = r14.activityInfo
            android.content.pm.ApplicationInfo r6 = r5.applicationInfo
            java.lang.String r6 = r6.packageName
            java.lang.String r5 = r5.name
            r4.<init>(r6, r5)
            r3.setComponent(r4)
            java.lang.CharSequence r4 = r14.loadLabel(r0)
            m.q r4 = r7.a(r8, r9, r10, r4)
            android.graphics.drawable.Drawable r5 = r14.loadIcon(r0)
            r4.setIcon((android.graphics.drawable.Drawable) r5)
            r4.f10005g = r3
            if (r15 == 0) goto L_0x0058
            int r14 = r14.specificIndex
            if (r14 < 0) goto L_0x0058
            r15[r14] = r4
        L_0x0058:
            int r1 = r1 + 1
            goto L_0x001a
        L_0x005b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: m.o.addIntentOptions(int, int, int, android.content.ComponentName, android.content.Intent[], android.content.Intent, int, android.view.MenuItem[]):int");
    }

    public final SubMenu addSubMenu(int i10) {
        return addSubMenu(0, 0, 0, (CharSequence) this.f9973b.getString(i10));
    }

    public final void b(c0 c0Var, Context context) {
        this.f9992u.add(new WeakReference(c0Var));
        c0Var.h(context, this);
        this.f9982k = true;
    }

    public final void c(boolean z10) {
        if (!this.f9990s) {
            this.f9990s = true;
            CopyOnWriteArrayList copyOnWriteArrayList = this.f9992u;
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                c0 c0Var = (c0) weakReference.get();
                if (c0Var == null) {
                    copyOnWriteArrayList.remove(weakReference);
                } else {
                    c0Var.a(this, z10);
                }
            }
            this.f9990s = false;
        }
    }

    public final void clear() {
        q qVar = this.f9993v;
        if (qVar != null) {
            d(qVar);
        }
        this.f9977f.clear();
        p(true);
    }

    public final void clearHeader() {
        this.f9985n = null;
        this.f9984m = null;
        this.f9986o = null;
        p(false);
    }

    public final void close() {
        c(true);
    }

    public boolean d(q qVar) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.f9992u;
        boolean z10 = false;
        if (!copyOnWriteArrayList.isEmpty() && this.f9993v == qVar) {
            x();
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                c0 c0Var = (c0) weakReference.get();
                if (c0Var == null) {
                    copyOnWriteArrayList.remove(weakReference);
                } else {
                    z10 = c0Var.m(qVar);
                    if (z10) {
                        break;
                    }
                }
            }
            w();
            if (z10) {
                this.f9993v = null;
            }
        }
        return z10;
    }

    public boolean e(o oVar, MenuItem menuItem) {
        m mVar = this.f9976e;
        return mVar != null && mVar.e(oVar, menuItem);
    }

    public boolean f(q qVar) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.f9992u;
        boolean z10 = false;
        if (copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        x();
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            c0 c0Var = (c0) weakReference.get();
            if (c0Var == null) {
                copyOnWriteArrayList.remove(weakReference);
            } else {
                z10 = c0Var.g(qVar);
                if (z10) {
                    break;
                }
            }
        }
        w();
        if (z10) {
            this.f9993v = qVar;
        }
        return z10;
    }

    public final MenuItem findItem(int i10) {
        MenuItem findItem;
        int size = size();
        for (int i11 = 0; i11 < size; i11++) {
            q qVar = (q) this.f9977f.get(i11);
            if (qVar.f9999a == i10) {
                return qVar;
            }
            if (qVar.hasSubMenu() && (findItem = qVar.f10013o.findItem(i10)) != null) {
                return findItem;
            }
        }
        return null;
    }

    public final q g(int i10, KeyEvent keyEvent) {
        char c10;
        ArrayList arrayList = this.f9991t;
        arrayList.clear();
        h(arrayList, i10, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return (q) arrayList.get(0);
        }
        boolean n10 = n();
        for (int i11 = 0; i11 < size; i11++) {
            q qVar = (q) arrayList.get(i11);
            if (n10) {
                c10 = qVar.f10008j;
            } else {
                c10 = qVar.f10006h;
            }
            char[] cArr = keyData.meta;
            if ((c10 == cArr[0] && (metaState & 2) == 0) || ((c10 == cArr[2] && (metaState & 2) != 0) || (n10 && c10 == 8 && i10 == 67))) {
                return qVar;
            }
        }
        return null;
    }

    public final MenuItem getItem(int i10) {
        return (MenuItem) this.f9977f.get(i10);
    }

    public final void h(ArrayList arrayList, int i10, KeyEvent keyEvent) {
        char c10;
        int i11;
        boolean z10;
        ArrayList arrayList2 = arrayList;
        int i12 = i10;
        KeyEvent keyEvent2 = keyEvent;
        boolean n10 = n();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent2.getKeyData(keyData) || i12 == 67) {
            ArrayList arrayList3 = this.f9977f;
            int size = arrayList3.size();
            for (int i13 = 0; i13 < size; i13++) {
                q qVar = (q) arrayList3.get(i13);
                if (qVar.hasSubMenu()) {
                    qVar.f10013o.h(arrayList2, i12, keyEvent2);
                }
                if (n10) {
                    c10 = qVar.f10008j;
                } else {
                    c10 = qVar.f10006h;
                }
                if (n10) {
                    i11 = qVar.f10009k;
                } else {
                    i11 = qVar.f10007i;
                }
                if ((modifiers & 69647) == (i11 & 69647)) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (z10 && c10 != 0) {
                    char[] cArr = keyData.meta;
                    if (c10 != cArr[0] && c10 != cArr[2]) {
                        if (n10 && c10 == 8) {
                            if (i12 != 67) {
                            }
                        }
                    }
                    if (qVar.isEnabled()) {
                        arrayList2.add(qVar);
                    }
                }
            }
        }
    }

    public final boolean hasVisibleItems() {
        if (this.f9995x) {
            return true;
        }
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            if (((q) this.f9977f.get(i10)).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public final void i() {
        ArrayList l10 = l();
        if (this.f9982k) {
            CopyOnWriteArrayList copyOnWriteArrayList = this.f9992u;
            Iterator it = copyOnWriteArrayList.iterator();
            boolean z10 = false;
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                c0 c0Var = (c0) weakReference.get();
                if (c0Var == null) {
                    copyOnWriteArrayList.remove(weakReference);
                } else {
                    z10 |= c0Var.i();
                }
            }
            ArrayList arrayList = this.f9980i;
            ArrayList arrayList2 = this.f9981j;
            arrayList.clear();
            arrayList2.clear();
            if (z10) {
                int size = l10.size();
                for (int i10 = 0; i10 < size; i10++) {
                    q qVar = (q) l10.get(i10);
                    if (qVar.f()) {
                        arrayList.add(qVar);
                    } else {
                        arrayList2.add(qVar);
                    }
                }
            } else {
                arrayList2.addAll(l());
            }
            this.f9982k = false;
        }
    }

    public final boolean isShortcutKey(int i10, KeyEvent keyEvent) {
        return g(i10, keyEvent) != null;
    }

    public String j() {
        return "android:menu:actionviewstates";
    }

    public o k() {
        return this;
    }

    public final ArrayList l() {
        boolean z10 = this.f9979h;
        ArrayList arrayList = this.f9978g;
        if (!z10) {
            return arrayList;
        }
        arrayList.clear();
        ArrayList arrayList2 = this.f9977f;
        int size = arrayList2.size();
        for (int i10 = 0; i10 < size; i10++) {
            q qVar = (q) arrayList2.get(i10);
            if (qVar.isVisible()) {
                arrayList.add(qVar);
            }
        }
        this.f9979h = false;
        this.f9982k = true;
        return arrayList;
    }

    public boolean m() {
        return this.f9994w;
    }

    public boolean n() {
        return this.f9974c;
    }

    public boolean o() {
        return this.f9975d;
    }

    public final void p(boolean z10) {
        if (!this.f9987p) {
            if (z10) {
                this.f9979h = true;
                this.f9982k = true;
            }
            CopyOnWriteArrayList copyOnWriteArrayList = this.f9992u;
            if (!copyOnWriteArrayList.isEmpty()) {
                x();
                Iterator it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    c0 c0Var = (c0) weakReference.get();
                    if (c0Var == null) {
                        copyOnWriteArrayList.remove(weakReference);
                    } else {
                        c0Var.e(z10);
                    }
                }
                w();
                return;
            }
            return;
        }
        this.f9988q = true;
        if (z10) {
            this.f9989r = true;
        }
    }

    public final boolean performIdentifierAction(int i10, int i11) {
        return q(findItem(i10), (c0) null, i11);
    }

    public final boolean performShortcut(int i10, KeyEvent keyEvent, int i11) {
        boolean z10;
        q g10 = g(i10, keyEvent);
        if (g10 != null) {
            z10 = q(g10, (c0) null, i11);
        } else {
            z10 = false;
        }
        if ((i11 & 2) != 0) {
            c(true);
        }
        return z10;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0059, code lost:
        if (r1 != false) goto L_0x00c1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0067, code lost:
        if ((r9 & 1) == 0) goto L_0x00c1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00bf, code lost:
        if (r1 == false) goto L_0x00c1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x005c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean q(android.view.MenuItem r7, m.c0 r8, int r9) {
        /*
            r6 = this;
            m.q r7 = (m.q) r7
            r0 = 0
            if (r7 == 0) goto L_0x00c5
            boolean r1 = r7.isEnabled()
            if (r1 != 0) goto L_0x000d
            goto L_0x00c5
        L_0x000d:
            android.view.MenuItem$OnMenuItemClickListener r1 = r7.f10014p
            r2 = 1
            if (r1 == 0) goto L_0x0019
            boolean r1 = r1.onMenuItemClick(r7)
            if (r1 == 0) goto L_0x0019
            goto L_0x003e
        L_0x0019:
            m.o r1 = r7.f10012n
            boolean r3 = r1.e(r1, r7)
            if (r3 == 0) goto L_0x0022
            goto L_0x003e
        L_0x0022:
            android.content.Intent r3 = r7.f10005g
            if (r3 == 0) goto L_0x0034
            android.content.Context r1 = r1.f9972a     // Catch:{ ActivityNotFoundException -> 0x002c }
            r1.startActivity(r3)     // Catch:{ ActivityNotFoundException -> 0x002c }
            goto L_0x003e
        L_0x002c:
            r1 = move-exception
            java.lang.String r3 = "MenuItemImpl"
            java.lang.String r4 = "Can't find activity to handle intent; ignoring"
            android.util.Log.e(r3, r4, r1)
        L_0x0034:
            m0.d r1 = r7.A
            if (r1 == 0) goto L_0x0040
            boolean r1 = r1.e()
            if (r1 == 0) goto L_0x0040
        L_0x003e:
            r1 = 1
            goto L_0x0041
        L_0x0040:
            r1 = 0
        L_0x0041:
            m0.d r3 = r7.A
            if (r3 == 0) goto L_0x004d
            boolean r4 = r3.a()
            if (r4 == 0) goto L_0x004d
            r4 = 1
            goto L_0x004e
        L_0x004d:
            r4 = 0
        L_0x004e:
            boolean r5 = r7.e()
            if (r5 == 0) goto L_0x005c
            boolean r7 = r7.expandActionView()
            r1 = r1 | r7
            if (r1 == 0) goto L_0x00c4
            goto L_0x00c1
        L_0x005c:
            boolean r5 = r7.hasSubMenu()
            if (r5 != 0) goto L_0x006a
            if (r4 == 0) goto L_0x0065
            goto L_0x006a
        L_0x0065:
            r7 = r9 & 1
            if (r7 != 0) goto L_0x00c4
            goto L_0x00c1
        L_0x006a:
            r9 = r9 & 4
            if (r9 != 0) goto L_0x0071
            r6.c(r0)
        L_0x0071:
            boolean r9 = r7.hasSubMenu()
            if (r9 != 0) goto L_0x0085
            m.i0 r9 = new m.i0
            android.content.Context r5 = r6.f9972a
            r9.<init>(r5, r6, r7)
            r7.f10013o = r9
            java.lang.CharSequence r5 = r7.f10003e
            r9.setHeaderTitle((java.lang.CharSequence) r5)
        L_0x0085:
            m.i0 r7 = r7.f10013o
            if (r4 == 0) goto L_0x008c
            r3.f(r7)
        L_0x008c:
            java.util.concurrent.CopyOnWriteArrayList r9 = r6.f9992u
            boolean r3 = r9.isEmpty()
            if (r3 == 0) goto L_0x0095
            goto L_0x00be
        L_0x0095:
            if (r8 == 0) goto L_0x009b
            boolean r0 = r8.k(r7)
        L_0x009b:
            java.util.Iterator r8 = r9.iterator()
        L_0x009f:
            boolean r3 = r8.hasNext()
            if (r3 == 0) goto L_0x00be
            java.lang.Object r3 = r8.next()
            java.lang.ref.WeakReference r3 = (java.lang.ref.WeakReference) r3
            java.lang.Object r4 = r3.get()
            m.c0 r4 = (m.c0) r4
            if (r4 != 0) goto L_0x00b7
            r9.remove(r3)
            goto L_0x009f
        L_0x00b7:
            if (r0 != 0) goto L_0x009f
            boolean r0 = r4.k(r7)
            goto L_0x009f
        L_0x00be:
            r1 = r1 | r0
            if (r1 != 0) goto L_0x00c4
        L_0x00c1:
            r6.c(r2)
        L_0x00c4:
            return r1
        L_0x00c5:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: m.o.q(android.view.MenuItem, m.c0, int):boolean");
    }

    public final void r(c0 c0Var) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.f9992u;
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            c0 c0Var2 = (c0) weakReference.get();
            if (c0Var2 == null || c0Var2 == c0Var) {
                copyOnWriteArrayList.remove(weakReference);
            }
        }
    }

    public final void removeGroup(int i10) {
        ArrayList arrayList;
        int size = size();
        int i11 = 0;
        int i12 = 0;
        while (true) {
            arrayList = this.f9977f;
            if (i12 >= size) {
                i12 = -1;
                break;
            } else if (((q) arrayList.get(i12)).f10000b == i10) {
                break;
            } else {
                i12++;
            }
        }
        if (i12 >= 0) {
            int size2 = arrayList.size() - i12;
            while (true) {
                int i13 = i11 + 1;
                if (i11 >= size2 || ((q) arrayList.get(i12)).f10000b != i10) {
                    p(true);
                } else {
                    if (i12 >= 0 && i12 < arrayList.size()) {
                        arrayList.remove(i12);
                    }
                    i11 = i13;
                }
            }
            p(true);
        }
    }

    public final void removeItem(int i10) {
        ArrayList arrayList;
        int size = size();
        int i11 = 0;
        while (true) {
            arrayList = this.f9977f;
            if (i11 >= size) {
                i11 = -1;
                break;
            } else if (((q) arrayList.get(i11)).f9999a == i10) {
                break;
            } else {
                i11++;
            }
        }
        if (i11 >= 0 && i11 < arrayList.size()) {
            arrayList.remove(i11);
            p(true);
        }
    }

    public final void s(Bundle bundle) {
        MenuItem findItem;
        if (bundle != null) {
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(j());
            int size = size();
            for (int i10 = 0; i10 < size; i10++) {
                MenuItem item = getItem(i10);
                View actionView = item.getActionView();
                if (!(actionView == null || actionView.getId() == -1)) {
                    actionView.restoreHierarchyState(sparseParcelableArray);
                }
                if (item.hasSubMenu()) {
                    ((i0) item.getSubMenu()).s(bundle);
                }
            }
            int i11 = bundle.getInt("android:menu:expandedactionview");
            if (i11 > 0 && (findItem = findItem(i11)) != null) {
                findItem.expandActionView();
            }
        }
    }

    public final void setGroupCheckable(int i10, boolean z10, boolean z11) {
        int i11;
        ArrayList arrayList = this.f9977f;
        int size = arrayList.size();
        for (int i12 = 0; i12 < size; i12++) {
            q qVar = (q) arrayList.get(i12);
            if (qVar.f10000b == i10) {
                int i13 = qVar.f10022x & -5;
                if (z11) {
                    i11 = 4;
                } else {
                    i11 = 0;
                }
                qVar.f10022x = i13 | i11;
                qVar.setCheckable(z10);
            }
        }
    }

    public void setGroupDividerEnabled(boolean z10) {
        this.f9994w = z10;
    }

    public final void setGroupEnabled(int i10, boolean z10) {
        ArrayList arrayList = this.f9977f;
        int size = arrayList.size();
        for (int i11 = 0; i11 < size; i11++) {
            q qVar = (q) arrayList.get(i11);
            if (qVar.f10000b == i10) {
                qVar.setEnabled(z10);
            }
        }
    }

    public final void setGroupVisible(int i10, boolean z10) {
        int i11;
        boolean z11;
        ArrayList arrayList = this.f9977f;
        int size = arrayList.size();
        boolean z12 = false;
        for (int i12 = 0; i12 < size; i12++) {
            q qVar = (q) arrayList.get(i12);
            if (qVar.f10000b == i10) {
                int i13 = qVar.f10022x;
                int i14 = i13 & -9;
                if (z10) {
                    i11 = 0;
                } else {
                    i11 = 8;
                }
                int i15 = i14 | i11;
                qVar.f10022x = i15;
                if (i13 != i15) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11) {
                    z12 = true;
                }
            }
        }
        if (z12) {
            p(true);
        }
    }

    public void setQwertyMode(boolean z10) {
        this.f9974c = z10;
        p(false);
    }

    public final int size() {
        return this.f9977f.size();
    }

    public final void t(Bundle bundle) {
        int size = size();
        SparseArray sparseArray = null;
        for (int i10 = 0; i10 < size; i10++) {
            MenuItem item = getItem(i10);
            View actionView = item.getActionView();
            if (!(actionView == null || actionView.getId() == -1)) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((i0) item.getSubMenu()).t(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(j(), sparseArray);
        }
    }

    public void u(m mVar) {
        this.f9976e = mVar;
    }

    public final void v(int i10, CharSequence charSequence, int i11, Drawable drawable, View view) {
        if (view != null) {
            this.f9986o = view;
            this.f9984m = null;
            this.f9985n = null;
        } else {
            if (i10 > 0) {
                this.f9984m = this.f9973b.getText(i10);
            } else if (charSequence != null) {
                this.f9984m = charSequence;
            }
            if (i11 > 0) {
                Object obj = g.f2717a;
                this.f9985n = c.b(this.f9972a, i11);
            } else if (drawable != null) {
                this.f9985n = drawable;
            }
            this.f9986o = null;
        }
        p(false);
    }

    public final void w() {
        this.f9987p = false;
        if (this.f9988q) {
            this.f9988q = false;
            p(this.f9989r);
        }
    }

    public final void x() {
        if (!this.f9987p) {
            this.f9987p = true;
            this.f9988q = false;
            this.f9989r = false;
        }
    }

    public final MenuItem add(int i10, int i11, int i12, int i13) {
        return a(i10, i11, i12, this.f9973b.getString(i13));
    }

    public final SubMenu addSubMenu(int i10, int i11, int i12, int i13) {
        return addSubMenu(i10, i11, i12, (CharSequence) this.f9973b.getString(i13));
    }

    public final MenuItem add(int i10, int i11, int i12, CharSequence charSequence) {
        return a(i10, i11, i12, charSequence);
    }

    public SubMenu addSubMenu(int i10, int i11, int i12, CharSequence charSequence) {
        q a10 = a(i10, i11, i12, charSequence);
        i0 i0Var = new i0(this.f9972a, this, a10);
        a10.f10013o = i0Var;
        i0Var.setHeaderTitle(a10.f10003e);
        return i0Var;
    }

    public final MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    public final SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }
}
