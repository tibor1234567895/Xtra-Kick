package androidx.recyclerview.widget;

import android.view.MotionEvent;

public interface u1 {
    boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent);

    void onRequestDisallowInterceptTouchEvent(boolean z10);

    void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent);
}
