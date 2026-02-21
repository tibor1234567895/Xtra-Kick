package i6;

import com.github.andreyasadchy.xtra.model.chat.KickEmote;
import java.util.Comparator;
import oa.b;

public final class k implements Comparator {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ m f8318h;

    public /* synthetic */ k(m mVar) {
        this.f8318h = mVar;
    }

    public final int compare(Object obj, Object obj2) {
        boolean z10;
        int ownerId = ((KickEmote) obj2).getOwnerId();
        m mVar = this.f8318h;
        boolean z11 = true;
        if (ownerId == mVar.f8322b) {
            z10 = true;
        } else {
            z10 = false;
        }
        Boolean valueOf = Boolean.valueOf(z10);
        if (((KickEmote) obj).getOwnerId() != mVar.f8322b) {
            z11 = false;
        }
        return b.a(valueOf, Boolean.valueOf(z11));
    }
}
