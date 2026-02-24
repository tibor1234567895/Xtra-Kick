package l6;

import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.k2;
import xa.j;

public final class h extends k2 {

    /* renamed from: h  reason: collision with root package name */
    public final TextView f9606h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ l f9607i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(l lVar, View view) {
        super(view);
        this.f9607i = lVar;
        this.f9606h = (TextView) view;
    }

    public final void a(CharSequence charSequence, SpannableStringBuilder spannableStringBuilder, int i10, int i11, String str) {
        j.f("originalMessage", charSequence);
        j.f("formattedMessage", spannableStringBuilder);
        l lVar = this.f9607i;
        TextView textView = this.f9606h;
        textView.setText(spannableStringBuilder);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setOnClickListener(new g(lVar, charSequence, spannableStringBuilder, i10, i11, str));
    }
}
