package r1;

import java.io.BufferedReader;
import java.util.ArrayDeque;
import java.util.NoSuchElementException;
import java.util.Queue;

public final class r {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f13624a;

    /* renamed from: b  reason: collision with root package name */
    public final BufferedReader f13625b;

    /* renamed from: c  reason: collision with root package name */
    public final Queue f13626c;

    /* renamed from: d  reason: collision with root package name */
    public String f13627d;

    public /* synthetic */ r(ArrayDeque arrayDeque, BufferedReader bufferedReader, int i10) {
        this.f13624a = i10;
        this.f13626c = arrayDeque;
        this.f13625b = bufferedReader;
    }

    public final boolean a() {
        String trim;
        String trim2;
        int i10 = this.f13624a;
        BufferedReader bufferedReader = this.f13625b;
        Queue queue = this.f13626c;
        switch (i10) {
            case 0:
                if (this.f13627d != null) {
                    return true;
                }
                if (!queue.isEmpty()) {
                    String str = (String) queue.poll();
                    str.getClass();
                    this.f13627d = str;
                    return true;
                }
                do {
                    String readLine = bufferedReader.readLine();
                    this.f13627d = readLine;
                    if (readLine == null) {
                        return false;
                    }
                    trim2 = readLine.trim();
                    this.f13627d = trim2;
                } while (trim2.isEmpty());
                return true;
            default:
                if (this.f13627d != null) {
                    return true;
                }
                if (!queue.isEmpty()) {
                    String str2 = (String) queue.poll();
                    str2.getClass();
                    this.f13627d = str2;
                    return true;
                }
                do {
                    String readLine2 = bufferedReader.readLine();
                    this.f13627d = readLine2;
                    if (readLine2 == null) {
                        return false;
                    }
                    trim = readLine2.trim();
                    this.f13627d = trim;
                } while (trim.isEmpty());
                return true;
        }
    }

    public final String b() {
        switch (this.f13624a) {
            case 0:
                if (a()) {
                    String str = this.f13627d;
                    this.f13627d = null;
                    return str;
                }
                throw new NoSuchElementException();
            default:
                if (a()) {
                    String str2 = this.f13627d;
                    this.f13627d = null;
                    return str2;
                }
                throw new NoSuchElementException();
        }
    }
}
