package q0;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import java.util.Locale;

public final class u {
    private u() {
    }

    public static Drawable[] a(TextView textView) {
        return textView.getCompoundDrawablesRelative();
    }

    public static int b(View view) {
        return view.getLayoutDirection();
    }

    public static int c(View view) {
        return view.getTextDirection();
    }

    public static Locale d(TextView textView) {
        return textView.getTextLocale();
    }

    public static void e(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        textView.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
    }

    public static void f(TextView textView, int i10, int i11, int i12, int i13) {
        textView.setCompoundDrawablesRelativeWithIntrinsicBounds(i10, i11, i12, i13);
    }

    public static void g(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
    }

    public static void h(View view, int i10) {
        view.setTextDirection(i10);
    }
}
