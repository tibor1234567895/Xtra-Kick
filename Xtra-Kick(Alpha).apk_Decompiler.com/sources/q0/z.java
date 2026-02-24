package q0;

import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import java.lang.reflect.Method;

public final class z implements ActionMode.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final ActionMode.Callback f13124a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f13125b;

    /* renamed from: c  reason: collision with root package name */
    public Class f13126c;

    /* renamed from: d  reason: collision with root package name */
    public Method f13127d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f13128e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f13129f = false;

    public z(ActionMode.Callback callback, TextView textView) {
        this.f13124a = callback;
        this.f13125b = textView;
    }

    public final boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.f13124a.onActionItemClicked(actionMode, menuItem);
    }

    public final boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        return this.f13124a.onCreateActionMode(actionMode, menu);
    }

    public final void onDestroyActionMode(ActionMode actionMode) {
        this.f13124a.onDestroyActionMode(actionMode);
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x009f A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onPrepareActionMode(android.view.ActionMode r14, android.view.Menu r15) {
        /*
            r13 = this;
            android.widget.TextView r0 = r13.f13125b
            android.content.Context r1 = r0.getContext()
            android.content.pm.PackageManager r2 = r1.getPackageManager()
            boolean r3 = r13.f13129f
            r4 = 1
            r5 = 0
            java.lang.String r6 = "removeItemAt"
            if (r3 != 0) goto L_0x0032
            r13.f13129f = r4
            java.lang.String r3 = "com.android.internal.view.menu.MenuBuilder"
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x002b }
            r13.f13126c = r3     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x002b }
            java.lang.Class[] r7 = new java.lang.Class[r4]     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x002b }
            java.lang.Class r8 = java.lang.Integer.TYPE     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x002b }
            r7[r5] = r8     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x002b }
            java.lang.reflect.Method r3 = r3.getDeclaredMethod(r6, r7)     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x002b }
            r13.f13127d = r3     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x002b }
            r13.f13128e = r4     // Catch:{ ClassNotFoundException | NoSuchMethodException -> 0x002b }
            goto L_0x0032
        L_0x002b:
            r3 = 0
            r13.f13126c = r3
            r13.f13127d = r3
            r13.f13128e = r5
        L_0x0032:
            boolean r3 = r13.f13128e     // Catch:{ IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0127 }
            if (r3 == 0) goto L_0x0041
            java.lang.Class r3 = r13.f13126c     // Catch:{ IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0127 }
            boolean r3 = r3.isInstance(r15)     // Catch:{ IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0127 }
            if (r3 == 0) goto L_0x0041
            java.lang.reflect.Method r3 = r13.f13127d     // Catch:{ IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0127 }
            goto L_0x004f
        L_0x0041:
            java.lang.Class r3 = r15.getClass()     // Catch:{ IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0127 }
            java.lang.Class[] r7 = new java.lang.Class[r4]     // Catch:{ IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0127 }
            java.lang.Class r8 = java.lang.Integer.TYPE     // Catch:{ IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0127 }
            r7[r5] = r8     // Catch:{ IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0127 }
            java.lang.reflect.Method r3 = r3.getDeclaredMethod(r6, r7)     // Catch:{ IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0127 }
        L_0x004f:
            int r6 = r15.size()     // Catch:{ IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0127 }
            int r6 = r6 - r4
        L_0x0054:
            java.lang.String r7 = "android.intent.action.PROCESS_TEXT"
            if (r6 < 0) goto L_0x007e
            android.view.MenuItem r8 = r15.getItem(r6)     // Catch:{ IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0127 }
            android.content.Intent r9 = r8.getIntent()     // Catch:{ IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0127 }
            if (r9 == 0) goto L_0x007b
            android.content.Intent r8 = r8.getIntent()     // Catch:{ IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0127 }
            java.lang.String r8 = r8.getAction()     // Catch:{ IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0127 }
            boolean r7 = r7.equals(r8)     // Catch:{ IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0127 }
            if (r7 == 0) goto L_0x007b
            java.lang.Object[] r7 = new java.lang.Object[r4]     // Catch:{ IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0127 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r6)     // Catch:{ IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0127 }
            r7[r5] = r8     // Catch:{ IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0127 }
            r3.invoke(r15, r7)     // Catch:{ IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0127 }
        L_0x007b:
            int r6 = r6 + -1
            goto L_0x0054
        L_0x007e:
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            boolean r6 = r1 instanceof android.app.Activity
            java.lang.String r8 = "text/plain"
            if (r6 != 0) goto L_0x008a
            goto L_0x00d5
        L_0x008a:
            android.content.Intent r6 = new android.content.Intent
            r6.<init>()
            android.content.Intent r6 = r6.setAction(r7)
            android.content.Intent r6 = r6.setType(r8)
            java.util.List r6 = r2.queryIntentActivities(r6, r5)
            java.util.Iterator r6 = r6.iterator()
        L_0x009f:
            boolean r9 = r6.hasNext()
            if (r9 == 0) goto L_0x00d5
            java.lang.Object r9 = r6.next()
            android.content.pm.ResolveInfo r9 = (android.content.pm.ResolveInfo) r9
            java.lang.String r10 = r1.getPackageName()
            android.content.pm.ActivityInfo r11 = r9.activityInfo
            java.lang.String r11 = r11.packageName
            boolean r10 = r10.equals(r11)
            if (r10 == 0) goto L_0x00ba
            goto L_0x00ce
        L_0x00ba:
            android.content.pm.ActivityInfo r10 = r9.activityInfo
            boolean r11 = r10.exported
            if (r11 != 0) goto L_0x00c1
            goto L_0x00cc
        L_0x00c1:
            java.lang.String r10 = r10.permission
            if (r10 == 0) goto L_0x00ce
            int r10 = r1.checkSelfPermission(r10)
            if (r10 != 0) goto L_0x00cc
            goto L_0x00ce
        L_0x00cc:
            r10 = 0
            goto L_0x00cf
        L_0x00ce:
            r10 = 1
        L_0x00cf:
            if (r10 == 0) goto L_0x009f
            r3.add(r9)
            goto L_0x009f
        L_0x00d5:
            r1 = 0
        L_0x00d6:
            int r6 = r3.size()
            if (r1 >= r6) goto L_0x0127
            java.lang.Object r6 = r3.get(r1)
            android.content.pm.ResolveInfo r6 = (android.content.pm.ResolveInfo) r6
            int r9 = r1 + 100
            java.lang.CharSequence r10 = r6.loadLabel(r2)
            android.view.MenuItem r9 = r15.add(r5, r5, r9, r10)
            android.content.Intent r10 = new android.content.Intent
            r10.<init>()
            android.content.Intent r10 = r10.setAction(r7)
            android.content.Intent r10 = r10.setType(r8)
            boolean r11 = r0 instanceof android.text.Editable
            if (r11 == 0) goto L_0x010b
            boolean r11 = r0.onCheckIsTextEditor()
            if (r11 == 0) goto L_0x010b
            boolean r11 = r0.isEnabled()
            if (r11 == 0) goto L_0x010b
            r11 = 1
            goto L_0x010c
        L_0x010b:
            r11 = 0
        L_0x010c:
            r11 = r11 ^ r4
            java.lang.String r12 = "android.intent.extra.PROCESS_TEXT_READONLY"
            android.content.Intent r10 = r10.putExtra(r12, r11)
            android.content.pm.ActivityInfo r6 = r6.activityInfo
            java.lang.String r11 = r6.packageName
            java.lang.String r6 = r6.name
            android.content.Intent r6 = r10.setClassName(r11, r6)
            android.view.MenuItem r6 = r9.setIntent(r6)
            r6.setShowAsAction(r4)
            int r1 = r1 + 1
            goto L_0x00d6
        L_0x0127:
            android.view.ActionMode$Callback r0 = r13.f13124a
            boolean r14 = r0.onPrepareActionMode(r14, r15)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: q0.z.onPrepareActionMode(android.view.ActionMode, android.view.Menu):boolean");
    }
}
