package z6;

import com.github.andreyasadchy.xtra.model.offline.VodBookmarkIgnoredUser;
import com.github.andreyasadchy.xtra.ui.saved.bookmarks.BookmarksViewModel;
import e6.g2;
import e6.h2;
import e6.i2;
import e6.j2;
import hb.d1;
import hb.f0;
import hb.h0;
import hb.p0;
import la.v;
import pa.e;
import pa.h;
import qa.a;
import ra.i;
import wa.p;

public final class l extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f17773i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ BookmarksViewModel f17774j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f17775k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public l(BookmarksViewModel bookmarksViewModel, int i10, e eVar) {
        super(2, eVar);
        this.f17774j = bookmarksViewModel;
        this.f17775k = i10;
    }

    public final e create(Object obj, e eVar) {
        return new l(this.f17774j, this.f17775k, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((l) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f17773i;
        int i11 = this.f17775k;
        BookmarksViewModel bookmarksViewModel = this.f17774j;
        if (i10 == 0) {
            h0.O1(obj);
            j2 j2Var = bookmarksViewModel.f3459f;
            this.f17773i = 1;
            j2Var.getClass();
            obj = h0.c2(p0.f7834b, new h2(j2Var, i11, (e) null), this);
            if (obj == aVar) {
                return aVar;
            }
        } else if (i10 == 1) {
            h0.O1(obj);
        } else if (i10 == 2) {
            h0.O1(obj);
            return v.f9814a;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (obj != null) {
            j2 j2Var2 = bookmarksViewModel.f3459f;
            VodBookmarkIgnoredUser vodBookmarkIgnoredUser = new VodBookmarkIgnoredUser(i11);
            j2Var2.getClass();
            h0.b1(d1.f7786h, (h) null, 0, new g2(j2Var2, vodBookmarkIgnoredUser, (e) null), 3);
        } else {
            j2 j2Var3 = bookmarksViewModel.f3459f;
            VodBookmarkIgnoredUser vodBookmarkIgnoredUser2 = new VodBookmarkIgnoredUser(i11);
            this.f17773i = 2;
            j2Var3.getClass();
            Object c22 = h0.c2(p0.f7834b, new i2(j2Var3, vodBookmarkIgnoredUser2, (e) null), this);
            if (c22 != aVar) {
                c22 = v.f9814a;
            }
            if (c22 == aVar) {
                return aVar;
            }
        }
        return v.f9814a;
    }
}
