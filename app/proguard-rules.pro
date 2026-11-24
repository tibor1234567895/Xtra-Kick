# Preserve source file names and line numbers for R8 stack trace retracing.
-keepattributes SourceFile,LineNumberTable

# Preserve WebView @JavascriptInterface entry points.
-keepclassmembers class * {
    @android.webkit.JavascriptInterface <methods>;
}

# nav_graph.xml declares app:argType="com.xtrakick.app.model.ui.Tag[]" (loaded via Class.forName).
-keepnames class com.xtrakick.app.model.ui.Tag

# CustomSwipeRefreshLayout matches CircleImageView by simpleName.
-keep class androidx.swiperefreshlayout.widget.CircleImageView { *; }

# ViewExtensions reflects on ViewPager2.mRecyclerView and RecyclerView.mTouchSlop.
-keepclassmembers class androidx.viewpager2.widget.ViewPager2 {
    androidx.recyclerview.widget.RecyclerView mRecyclerView;
}
-keepclassmembers class androidx.recyclerview.widget.RecyclerView {
    int mTouchSlop;
}

-assumenosideeffects class android.util.Log {
    public static *** d(...);
    public static *** v(...);
}
