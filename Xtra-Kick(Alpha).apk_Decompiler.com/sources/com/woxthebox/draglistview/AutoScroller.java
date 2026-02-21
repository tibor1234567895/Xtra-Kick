package com.woxthebox.draglistview;

import android.content.Context;
import android.os.Handler;

class AutoScroller {
    private static final int AUTO_SCROLL_UPDATE_DELAY = 12;
    private static final int COLUMN_SCROLL_UPDATE_DELAY = 1000;
    private static final int SCROLL_SPEED_DP = 8;
    private AutoScrollMode mAutoScrollMode = AutoScrollMode.POSITION;
    private Handler mHandler = new Handler();
    private boolean mIsAutoScrolling;
    private long mLastScrollTime;
    private AutoScrollListener mListener;
    private int mScrollSpeed;

    /* renamed from: com.woxthebox.draglistview.AutoScroller$3  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$woxthebox$draglistview$AutoScroller$ScrollDirection;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.woxthebox.draglistview.AutoScroller$ScrollDirection[] r0 = com.woxthebox.draglistview.AutoScroller.ScrollDirection.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$woxthebox$draglistview$AutoScroller$ScrollDirection = r0
                com.woxthebox.draglistview.AutoScroller$ScrollDirection r1 = com.woxthebox.draglistview.AutoScroller.ScrollDirection.UP     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$woxthebox$draglistview$AutoScroller$ScrollDirection     // Catch:{ NoSuchFieldError -> 0x001d }
                com.woxthebox.draglistview.AutoScroller$ScrollDirection r1 = com.woxthebox.draglistview.AutoScroller.ScrollDirection.DOWN     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$woxthebox$draglistview$AutoScroller$ScrollDirection     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.woxthebox.draglistview.AutoScroller$ScrollDirection r1 = com.woxthebox.draglistview.AutoScroller.ScrollDirection.LEFT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$woxthebox$draglistview$AutoScroller$ScrollDirection     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.woxthebox.draglistview.AutoScroller$ScrollDirection r1 = com.woxthebox.draglistview.AutoScroller.ScrollDirection.RIGHT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.woxthebox.draglistview.AutoScroller.AnonymousClass3.<clinit>():void");
        }
    }

    public interface AutoScrollListener {
        void onAutoScrollColumnBy(int i10);

        void onAutoScrollPositionBy(int i10, int i11);
    }

    public enum AutoScrollMode {
        POSITION,
        COLUMN
    }

    public enum ScrollDirection {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    public AutoScroller(Context context, AutoScrollListener autoScrollListener) {
        this.mListener = autoScrollListener;
        this.mScrollSpeed = (int) (context.getResources().getDisplayMetrics().density * 8.0f);
    }

    /* access modifiers changed from: private */
    public void autoScrollColumnBy(final int i10) {
        if (this.mIsAutoScrolling) {
            int i11 = ((System.currentTimeMillis() - this.mLastScrollTime) > 1000 ? 1 : ((System.currentTimeMillis() - this.mLastScrollTime) == 1000 ? 0 : -1));
            AutoScrollListener autoScrollListener = this.mListener;
            if (i11 > 0) {
                autoScrollListener.onAutoScrollColumnBy(i10);
                this.mLastScrollTime = System.currentTimeMillis();
            } else {
                autoScrollListener.onAutoScrollColumnBy(0);
            }
            this.mHandler.postDelayed(new Runnable() {
                public void run() {
                    AutoScroller.this.autoScrollColumnBy(i10);
                }
            }, 12);
        }
    }

    /* access modifiers changed from: private */
    public void autoScrollPositionBy(final int i10, final int i11) {
        if (this.mIsAutoScrolling) {
            this.mListener.onAutoScrollPositionBy(i10, i11);
            this.mHandler.postDelayed(new Runnable() {
                public void run() {
                    AutoScroller.this.autoScrollPositionBy(i10, i11);
                }
            }, 12);
        }
    }

    private void startAutoScrollColumnBy(int i10) {
        if (!this.mIsAutoScrolling) {
            this.mIsAutoScrolling = true;
            autoScrollColumnBy(i10);
        }
    }

    private void startAutoScrollPositionBy(int i10, int i11) {
        if (!this.mIsAutoScrolling) {
            this.mIsAutoScrolling = true;
            autoScrollPositionBy(i10, i11);
        }
    }

    public boolean isAutoScrolling() {
        return this.mIsAutoScrolling;
    }

    public void setAutoScrollMode(AutoScrollMode autoScrollMode) {
        this.mAutoScrollMode = autoScrollMode;
    }

    public void startAutoScroll(ScrollDirection scrollDirection) {
        int i10;
        int i11;
        int i12 = AnonymousClass3.$SwitchMap$com$woxthebox$draglistview$AutoScroller$ScrollDirection[scrollDirection.ordinal()];
        if (i12 == 1) {
            i10 = this.mScrollSpeed;
        } else if (i12 != 2) {
            if (i12 != 3) {
                if (i12 == 4) {
                    if (this.mAutoScrollMode == AutoScrollMode.POSITION) {
                        i11 = -this.mScrollSpeed;
                    } else {
                        startAutoScrollColumnBy(-1);
                        return;
                    }
                } else {
                    return;
                }
            } else if (this.mAutoScrollMode == AutoScrollMode.POSITION) {
                i11 = this.mScrollSpeed;
            } else {
                startAutoScrollColumnBy(1);
                return;
            }
            startAutoScrollPositionBy(i11, 0);
            return;
        } else {
            i10 = -this.mScrollSpeed;
        }
        startAutoScrollPositionBy(0, i10);
    }

    public void stopAutoScroll() {
        this.mIsAutoScrolling = false;
    }
}
