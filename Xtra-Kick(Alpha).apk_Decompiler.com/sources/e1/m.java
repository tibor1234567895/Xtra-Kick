package e1;

import android.service.media.MediaBrowserService;
import com.google.gson.internal.bind.l;

public class m extends MediaBrowserService {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ n f4928h;

    public m(n nVar, a0 a0Var) {
        this.f4928h = nVar;
        attachBaseContext(a0Var);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: android.os.Bundle} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.service.media.MediaBrowserService.BrowserRoot onGetRoot(java.lang.String r13, int r14, android.os.Bundle r15) {
        /*
            r12 = this;
            android.support.v4.media.session.u.p(r15)
            r0 = 0
            if (r15 != 0) goto L_0x0008
            r1 = r0
            goto L_0x000d
        L_0x0008:
            android.os.Bundle r1 = new android.os.Bundle
            r1.<init>(r15)
        L_0x000d:
            e1.n r15 = r12.f4928h
            e1.a0 r2 = r15.f4932d
            r3 = -1
            if (r1 == 0) goto L_0x0065
            r4 = 0
            java.lang.String r5 = "extra_client_version"
            int r4 = r1.getInt(r5, r4)
            if (r4 == 0) goto L_0x0065
            r1.remove(r5)
            android.os.Messenger r4 = new android.os.Messenger
            android.support.v4.media.b r5 = r2.f4892m
            r4.<init>(r5)
            r15.f4931c = r4
            android.os.Bundle r4 = new android.os.Bundle
            r4.<init>()
            java.lang.String r5 = "extra_service_version"
            r6 = 2
            r4.putInt(r5, r6)
            android.os.Messenger r5 = r15.f4931c
            android.os.IBinder r5 = r5.getBinder()
            java.lang.String r6 = "extra_messenger"
            b0.j.b(r4, r6, r5)
            android.support.v4.media.session.MediaSessionCompat$Token r5 = r2.f4893n
            if (r5 == 0) goto L_0x0055
            android.support.v4.media.session.f r5 = r5.u()
            if (r5 != 0) goto L_0x004b
            r5 = r0
            goto L_0x004f
        L_0x004b:
            android.os.IBinder r5 = r5.asBinder()
        L_0x004f:
            java.lang.String r6 = "extra_session_binder"
            b0.j.b(r4, r6, r5)
            goto L_0x005a
        L_0x0055:
            java.util.ArrayList r5 = r15.f4929a
            r5.add(r4)
        L_0x005a:
            java.lang.String r5 = "extra_calling_pid"
            int r3 = r1.getInt(r5, r3)
            r1.remove(r5)
            r9 = r3
            goto L_0x0067
        L_0x0065:
            r4 = r0
            r9 = -1
        L_0x0067:
            e1.j r3 = new e1.j
            e1.a0 r7 = r15.f4932d
            r11 = 0
            r6 = r3
            r8 = r13
            r10 = r14
            r6.<init>(r7, r8, r9, r10, r11)
            r2.f4891l = r3
            e1.h r13 = r2.a(r1)
            r2.f4891l = r0
            if (r13 != 0) goto L_0x007e
            r14 = r0
            goto L_0x009f
        L_0x007e:
            android.os.Messenger r14 = r15.f4931c
            if (r14 == 0) goto L_0x0087
            java.util.ArrayList r14 = r2.f4889j
            r14.add(r3)
        L_0x0087:
            java.lang.Object r14 = r13.f4908b
            if (r4 != 0) goto L_0x008f
            r4 = r14
            android.os.Bundle r4 = (android.os.Bundle) r4
            goto L_0x0096
        L_0x008f:
            android.os.Bundle r14 = (android.os.Bundle) r14
            if (r14 == 0) goto L_0x0096
            r4.putAll(r14)
        L_0x0096:
            e1.h r14 = new e1.h
            java.lang.Object r13 = r13.f4907a
            java.lang.String r13 = (java.lang.String) r13
            r14.<init>(r4, r13)
        L_0x009f:
            if (r14 != 0) goto L_0x00a2
            goto L_0x00af
        L_0x00a2:
            android.service.media.MediaBrowserService$BrowserRoot r0 = new android.service.media.MediaBrowserService$BrowserRoot
            java.lang.Object r13 = r14.f4907a
            java.lang.String r13 = (java.lang.String) r13
            java.lang.Object r14 = r14.f4908b
            android.os.Bundle r14 = (android.os.Bundle) r14
            r0.<init>(r13, r14)
        L_0x00af:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e1.m.onGetRoot(java.lang.String, int, android.os.Bundle):android.service.media.MediaBrowserService$BrowserRoot");
    }

    public final void onLoadChildren(String str, MediaBrowserService.Result result) {
        l lVar = new l(result);
        n nVar = this.f4928h;
        nVar.getClass();
        l lVar2 = new l(str, lVar, 0);
        a0 a0Var = nVar.f4932d;
        a0Var.f4891l = a0Var.f4888i;
        a0Var.b(lVar2);
        a0Var.f4891l = null;
    }
}
