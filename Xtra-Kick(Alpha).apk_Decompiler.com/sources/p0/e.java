package p0;

import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;

public final class e extends InputConnectionWrapper {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c f12406a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(InputConnection inputConnection, c cVar) {
        super(inputConnection, false);
        this.f12406a = cVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x0081  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean performPrivateCommand(java.lang.String r12, android.os.Bundle r13) {
        /*
            r11 = this;
            p0.c r0 = r11.f12406a
            r1 = 1
            r2 = 0
            if (r13 != 0) goto L_0x0008
            goto L_0x0085
        L_0x0008:
            java.lang.String r3 = "androidx.core.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT"
            boolean r3 = android.text.TextUtils.equals(r3, r12)
            if (r3 == 0) goto L_0x0012
            r3 = 0
            goto L_0x001b
        L_0x0012:
            java.lang.String r3 = "android.support.v13.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT"
            boolean r3 = android.text.TextUtils.equals(r3, r12)
            if (r3 == 0) goto L_0x0085
            r3 = 1
        L_0x001b:
            r4 = 0
            if (r3 == 0) goto L_0x0021
            java.lang.String r5 = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_RESULT_RECEIVER"
            goto L_0x0023
        L_0x0021:
            java.lang.String r5 = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_RESULT_RECEIVER"
        L_0x0023:
            android.os.Parcelable r5 = r13.getParcelable(r5)     // Catch:{ all -> 0x007d }
            android.os.ResultReceiver r5 = (android.os.ResultReceiver) r5     // Catch:{ all -> 0x007d }
            if (r3 == 0) goto L_0x002e
            java.lang.String r6 = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_URI"
            goto L_0x0030
        L_0x002e:
            java.lang.String r6 = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_URI"
        L_0x0030:
            android.os.Parcelable r6 = r13.getParcelable(r6)     // Catch:{ all -> 0x007b }
            android.net.Uri r6 = (android.net.Uri) r6     // Catch:{ all -> 0x007b }
            if (r3 == 0) goto L_0x003b
            java.lang.String r7 = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION"
            goto L_0x003d
        L_0x003b:
            java.lang.String r7 = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION"
        L_0x003d:
            android.os.Parcelable r7 = r13.getParcelable(r7)     // Catch:{ all -> 0x007b }
            android.content.ClipDescription r7 = (android.content.ClipDescription) r7     // Catch:{ all -> 0x007b }
            if (r3 == 0) goto L_0x0048
            java.lang.String r8 = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI"
            goto L_0x004a
        L_0x0048:
            java.lang.String r8 = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI"
        L_0x004a:
            android.os.Parcelable r8 = r13.getParcelable(r8)     // Catch:{ all -> 0x007b }
            android.net.Uri r8 = (android.net.Uri) r8     // Catch:{ all -> 0x007b }
            if (r3 == 0) goto L_0x0055
            java.lang.String r9 = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS"
            goto L_0x0057
        L_0x0055:
            java.lang.String r9 = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS"
        L_0x0057:
            int r9 = r13.getInt(r9)     // Catch:{ all -> 0x007b }
            if (r3 == 0) goto L_0x0060
            java.lang.String r3 = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_OPTS"
            goto L_0x0062
        L_0x0060:
            java.lang.String r3 = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_OPTS"
        L_0x0062:
            android.os.Parcelable r3 = r13.getParcelable(r3)     // Catch:{ all -> 0x007b }
            android.os.Bundle r3 = (android.os.Bundle) r3     // Catch:{ all -> 0x007b }
            if (r6 == 0) goto L_0x0075
            if (r7 == 0) goto L_0x0075
            e.a r10 = new e.a     // Catch:{ all -> 0x007b }
            r10.<init>((android.net.Uri) r6, (android.content.ClipDescription) r7, (android.net.Uri) r8)     // Catch:{ all -> 0x007b }
            boolean r2 = r0.k(r10, r9, r3)     // Catch:{ all -> 0x007b }
        L_0x0075:
            if (r5 == 0) goto L_0x0085
            r5.send(r2, r4)
            goto L_0x0085
        L_0x007b:
            r12 = move-exception
            goto L_0x007f
        L_0x007d:
            r12 = move-exception
            r5 = r4
        L_0x007f:
            if (r5 == 0) goto L_0x0084
            r5.send(r2, r4)
        L_0x0084:
            throw r12
        L_0x0085:
            if (r2 == 0) goto L_0x0088
            return r1
        L_0x0088:
            boolean r12 = super.performPrivateCommand(r12, r13)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: p0.e.performPrivateCommand(java.lang.String, android.os.Bundle):boolean");
    }
}
