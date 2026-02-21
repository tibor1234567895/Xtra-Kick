package f6;

import com.github.andreyasadchy.xtra.model.ui.User;
import java.util.Comparator;
import oa.a;

public final class f implements Comparator {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f5847h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Comparator f5848i;

    public /* synthetic */ f(a aVar, int i10) {
        this.f5847h = i10;
        this.f5848i = aVar;
    }

    public final int compare(Object obj, Object obj2) {
        int i10 = this.f5847h;
        Comparator comparator = this.f5848i;
        switch (i10) {
            case 0:
                return comparator.compare(((User) obj).getFollowedAt(), ((User) obj2).getFollowedAt());
            case 1:
                return comparator.compare(((User) obj).getLastBroadcast(), ((User) obj2).getLastBroadcast());
            case 2:
                return comparator.compare(((User) obj).getChannelSlug(), ((User) obj2).getChannelSlug());
            case 3:
                return comparator.compare(((User) obj2).getFollowedAt(), ((User) obj).getFollowedAt());
            case 4:
                return comparator.compare(((User) obj2).getLastBroadcast(), ((User) obj).getLastBroadcast());
            default:
                return comparator.compare(((User) obj2).getChannelSlug(), ((User) obj).getChannelSlug());
        }
    }
}
