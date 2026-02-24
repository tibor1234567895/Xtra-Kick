package m0;

import android.support.v4.media.h;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.woxthebox.draglistview.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.WeakHashMap;

public final class b1 {

    /* renamed from: d  reason: collision with root package name */
    public static final ArrayList f10043d = new ArrayList();

    /* renamed from: a  reason: collision with root package name */
    public WeakHashMap f10044a = null;

    /* renamed from: b  reason: collision with root package name */
    public SparseArray f10045b = null;

    /* renamed from: c  reason: collision with root package name */
    public WeakReference f10046c = null;

    public static void b(View view) {
        int size;
        ArrayList arrayList = (ArrayList) view.getTag(R.id.tag_unhandled_key_listeners);
        if (arrayList != null && arrayList.size() - 1 >= 0) {
            h.y(arrayList.get(size));
            throw null;
        }
    }

    public final View a(View view) {
        View a10;
        WeakHashMap weakHashMap = this.f10044a;
        if (weakHashMap == null || !weakHashMap.containsKey(view)) {
            return null;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            do {
                childCount--;
                if (childCount >= 0) {
                    a10 = a(viewGroup.getChildAt(childCount));
                }
            } while (a10 == null);
            return a10;
        }
        b(view);
        return null;
    }
}
