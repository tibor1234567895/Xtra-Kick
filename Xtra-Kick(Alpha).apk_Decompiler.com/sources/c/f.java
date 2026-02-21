package c;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import androidx.activity.ComponentActivity;
import androidx.activity.i;
import androidx.activity.result.c;
import androidx.activity.result.g;
import androidx.emoji2.text.l;
import androidx.fragment.app.p0;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import e.a;
import j0.j;
import java.util.ArrayList;
import java.util.List;

public final class f implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f2711h;

    /* renamed from: i  reason: collision with root package name */
    public final int f2712i;

    /* renamed from: j  reason: collision with root package name */
    public final Object f2713j;

    /* renamed from: k  reason: collision with root package name */
    public final Object f2714k;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public f(int i10, ArrayList arrayList) {
        this((List) arrayList, i10, (Throwable) null);
        this.f2711h = 5;
    }

    public final void run() {
        c cVar;
        int i10 = this.f2711h;
        int i11 = 0;
        Object obj = this.f2714k;
        int i12 = this.f2712i;
        Object obj2 = this.f2713j;
        switch (i10) {
            case 0:
                ((g) obj).u(i12, (Bundle) obj2);
                return;
            case 1:
                i iVar = (i) obj;
                Object obj3 = ((a) obj2).f4852i;
                String str = (String) iVar.f510b.get(Integer.valueOf(i12));
                if (str != null) {
                    androidx.activity.result.f fVar = (androidx.activity.result.f) iVar.f514f.get(str);
                    if (fVar == null || (cVar = fVar.f507a) == null) {
                        iVar.f516h.remove(str);
                        iVar.f515g.put(str, obj3);
                        return;
                    } else if (iVar.f513e.remove(str)) {
                        ((p0) cVar).k(obj3);
                        return;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            case 2:
                ((i) obj).a(i12, 0, new Intent().setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION", (IntentSender.SendIntentException) obj2));
                return;
            case 3:
                String[] strArr = (String[]) obj2;
                int[] iArr = new int[strArr.length];
                Activity activity = (Activity) obj;
                PackageManager packageManager = activity.getPackageManager();
                String packageName = activity.getPackageName();
                int length = strArr.length;
                while (i11 < length) {
                    iArr[i11] = packageManager.checkPermission(strArr[i11], packageName);
                    i11++;
                }
                ((b0.c) activity).onRequestPermissionsResult(i12, strArr, iArr);
                return;
            case 4:
                ((j) obj2).a(i12);
                return;
            case Constants.MAX_COMPATIBILITY_VERSION /*5*/:
                List list = (List) obj2;
                int size = list.size();
                if (i12 != 1) {
                    while (i11 < size) {
                        ((l) list.get(i11)).a();
                        i11++;
                    }
                    return;
                }
                while (i11 < size) {
                    ((l) list.get(i11)).b();
                    i11++;
                }
                return;
            default:
                ((BottomSheetBehavior) obj).H((View) obj2, i12, false);
                return;
        }
    }

    public f(ComponentActivity componentActivity, String[] strArr, int i10) {
        this.f2711h = 3;
        this.f2713j = strArr;
        this.f2714k = componentActivity;
        this.f2712i = i10;
    }

    public /* synthetic */ f(g gVar, int i10, Object obj, int i11) {
        this.f2711h = i11;
        this.f2714k = gVar;
        this.f2712i = i10;
        this.f2713j = obj;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public f(androidx.emoji2.text.l r3, int r4) {
        /*
            r2 = this;
            r0 = 5
            r2.f2711h = r0
            r0 = 1
            androidx.emoji2.text.l[] r0 = new androidx.emoji2.text.l[r0]
            if (r3 == 0) goto L_0x0014
            r1 = 0
            r0[r1] = r3
            java.util.List r3 = java.util.Arrays.asList(r0)
            r0 = 0
            r2.<init>((java.util.List) r3, (int) r4, (java.lang.Throwable) r0)
            return
        L_0x0014:
            java.lang.NullPointerException r3 = new java.lang.NullPointerException
            java.lang.String r4 = "initCallback cannot be null"
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: c.f.<init>(androidx.emoji2.text.l, int):void");
    }

    public /* synthetic */ f(Object obj, Object obj2, int i10, int i11) {
        this.f2711h = i11;
        this.f2714k = obj;
        this.f2713j = obj2;
        this.f2712i = i10;
    }

    public f(List list, int i10, Throwable th) {
        this.f2711h = 5;
        if (list != null) {
            this.f2713j = new ArrayList(list);
            this.f2712i = i10;
            this.f2714k = th;
            return;
        }
        throw new NullPointerException("initCallbacks cannot be null");
    }
}
