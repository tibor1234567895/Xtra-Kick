package i6;

import androidx.lifecycle.p0;
import com.github.andreyasadchy.xtra.ui.view.chat.ChatView;
import java.util.Collection;
import java.util.List;
import l6.l;
import la.b;
import r7.o;
import xa.g;
import xa.i;
import xa.j;

public final /* synthetic */ class c implements p0, g {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f8305a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f8306b;

    public /* synthetic */ c(int i10, Object obj) {
        this.f8305a = i10;
        this.f8306b = obj;
    }

    public final b a() {
        int i10 = this.f8305a;
        Object obj = this.f8306b;
        switch (i10) {
            case 0:
                return new i(1, (Object) (ChatView) obj, ChatView.class, "submitList", "submitList(Ljava/util/List;)V");
            case 1:
                return new i(1, (Object) (ChatView) obj, ChatView.class, "addGlobalStvEmotes", "addGlobalStvEmotes(Ljava/util/List;)V");
            case 2:
                return new i(1, (Object) (ChatView) obj, ChatView.class, "addChannelStvEmotes", "addChannelStvEmotes(Ljava/util/List;)V");
            case 3:
                return new i(1, (Object) (ChatView) obj, ChatView.class, "addGlobalBadges", "addGlobalBadges(Ljava/util/List;)V");
            case 4:
                return new i(1, (Object) (ChatView) obj, ChatView.class, "addChannelBadges", "addChannelBadges(Ljava/util/List;)V");
            case Constants.MAX_COMPATIBILITY_VERSION:
                return new i(1, (Object) (ChatView) obj, ChatView.class, "setRecentEmotes", "setRecentEmotes(Ljava/util/List;)V");
            case 6:
                return new i(1, (Object) (ChatView) obj, ChatView.class, "addToAutoCompleteList", "addToAutoCompleteList(Ljava/util/Collection;)V");
            default:
                return new i(1, (Object) (o) obj, o.class, "submitList", "submitList(Ljava/util/List;)V");
        }
    }

    public final void b(Object obj) {
        switch (this.f8305a) {
            case 0:
                c((List) obj);
                return;
            case 1:
                c((List) obj);
                return;
            case 2:
                c((List) obj);
                return;
            case 3:
                c((List) obj);
                return;
            case 4:
                c((List) obj);
                return;
            case Constants.MAX_COMPATIBILITY_VERSION:
                c((List) obj);
                return;
            case 6:
                ((ChatView) this.f8306b).m((Collection) obj);
                return;
            default:
                c((List) obj);
                return;
        }
    }

    public final void c(List list) {
        int i10;
        int i11 = this.f8305a;
        Object obj = this.f8306b;
        switch (i11) {
            case 0:
                l lVar = ((ChatView) obj).f3552y;
                if (lVar != null) {
                    List list2 = lVar.f9640o;
                    if (list2 != null) {
                        i10 = list2.size();
                    } else {
                        i10 = 0;
                    }
                    if (i10 > 0) {
                        lVar.notifyItemRangeRemoved(0, i10);
                    }
                    lVar.f9640o = list;
                    return;
                }
                j.l("adapter");
                throw null;
            case 1:
                ChatView chatView = (ChatView) obj;
                l lVar2 = chatView.f3552y;
                if (lVar2 != null) {
                    lVar2.f9646u = list;
                    chatView.m(list);
                    return;
                }
                j.l("adapter");
                throw null;
            case 2:
                ChatView chatView2 = (ChatView) obj;
                l lVar3 = chatView2.f3552y;
                if (lVar3 != null) {
                    lVar3.f9647v = list;
                    chatView2.m(list);
                    return;
                }
                j.l("adapter");
                throw null;
            case 3:
                l lVar4 = ((ChatView) obj).f3552y;
                if (lVar4 != null) {
                    lVar4.f9648w = list;
                    return;
                } else {
                    j.l("adapter");
                    throw null;
                }
            case 4:
                l lVar5 = ((ChatView) obj).f3552y;
                if (lVar5 != null) {
                    lVar5.f9649x = list;
                    return;
                } else {
                    j.l("adapter");
                    throw null;
                }
            case Constants.MAX_COMPATIBILITY_VERSION:
                ((ChatView) obj).setRecentEmotes(list);
                return;
            default:
                ((o) obj).a(list);
                return;
        }
    }

    public final boolean equals(Object obj) {
        switch (this.f8305a) {
            case 0:
                if (!(obj instanceof p0) || !(obj instanceof g)) {
                    return false;
                }
                return j.a(a(), ((g) obj).a());
            case 1:
                if (!(obj instanceof p0) || !(obj instanceof g)) {
                    return false;
                }
                return j.a(a(), ((g) obj).a());
            case 2:
                if (!(obj instanceof p0) || !(obj instanceof g)) {
                    return false;
                }
                return j.a(a(), ((g) obj).a());
            case 3:
                if (!(obj instanceof p0) || !(obj instanceof g)) {
                    return false;
                }
                return j.a(a(), ((g) obj).a());
            case 4:
                if (!(obj instanceof p0) || !(obj instanceof g)) {
                    return false;
                }
                return j.a(a(), ((g) obj).a());
            case Constants.MAX_COMPATIBILITY_VERSION:
                if (!(obj instanceof p0) || !(obj instanceof g)) {
                    return false;
                }
                return j.a(a(), ((g) obj).a());
            case 6:
                if (!(obj instanceof p0) || !(obj instanceof g)) {
                    return false;
                }
                return j.a(a(), ((g) obj).a());
            default:
                if (!(obj instanceof p0) || !(obj instanceof g)) {
                    return false;
                }
                return j.a(a(), ((g) obj).a());
        }
    }

    public final int hashCode() {
        switch (this.f8305a) {
            case 0:
                return ((i) a()).hashCode();
            case 1:
                return ((i) a()).hashCode();
            case 2:
                return ((i) a()).hashCode();
            case 3:
                return ((i) a()).hashCode();
            case 4:
                return ((i) a()).hashCode();
            case Constants.MAX_COMPATIBILITY_VERSION:
                return ((i) a()).hashCode();
            case 6:
                return ((i) a()).hashCode();
            default:
                return ((i) a()).hashCode();
        }
    }
}
