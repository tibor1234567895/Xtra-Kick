package r0;

import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import androidx.emoji2.text.z;

public final class a extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f13519a = 0;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f13520b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(b bVar) {
        super(new Handler());
        this.f13520b = bVar;
    }

    public final boolean deliverSelfNotifications() {
        switch (this.f13519a) {
            case 0:
                return true;
            default:
                return super.deliverSelfNotifications();
        }
    }

    public final void onChange(boolean z10) {
        Cursor cursor;
        switch (this.f13519a) {
            case 0:
                b bVar = (b) this.f13520b;
                if (bVar.f13522i && (cursor = bVar.f13523j) != null && !cursor.isClosed()) {
                    bVar.f13521h = bVar.f13523j.requery();
                    return;
                }
                return;
            default:
                super.onChange(z10);
                return;
        }
    }

    public final void onChange(boolean z10, Uri uri) {
        switch (this.f13519a) {
            case 1:
                ((z) this.f13520b).c();
                return;
            default:
                super.onChange(z10, uri);
                return;
        }
    }
}
