package z9;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import la.v;
import org.json.JSONObject;
import xa.j;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public DataInputStream f17786a;

    /* renamed from: b  reason: collision with root package name */
    public DataOutputStream f17787b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f17788c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f17789d;

    /* renamed from: e  reason: collision with root package name */
    public final Socket f17790e;

    public a() {
        this(0);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:16|19|20) */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:10|13|14|(3:16|19|20)(2:17|18)) */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:2|3|(5:5|6|7|8|(4:10|13|14|(3:16|19|20)(2:17|18))(2:11|12))|21|22|23) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0019 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0027 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x002c */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x001d A[Catch:{ Exception -> 0x0027 }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0021 A[Catch:{ Exception -> 0x0027 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f17788c
            monitor-enter(r0)
            boolean r1 = r3.f17789d     // Catch:{ all -> 0x0030 }
            if (r1 != 0) goto L_0x002c
            r1 = 1
            r3.f17789d = r1     // Catch:{ all -> 0x0030 }
            r1 = 0
            java.io.DataInputStream r2 = r3.f17786a     // Catch:{ Exception -> 0x0019 }
            if (r2 == 0) goto L_0x0013
            r2.close()     // Catch:{ Exception -> 0x0019 }
            goto L_0x0019
        L_0x0013:
            java.lang.String r2 = "dataInput"
            xa.j.l(r2)     // Catch:{ Exception -> 0x0019 }
            throw r1     // Catch:{ Exception -> 0x0019 }
        L_0x0019:
            java.io.DataOutputStream r2 = r3.f17787b     // Catch:{ Exception -> 0x0027 }
            if (r2 == 0) goto L_0x0021
            r2.close()     // Catch:{ Exception -> 0x0027 }
            goto L_0x0027
        L_0x0021:
            java.lang.String r2 = "dataOutput"
            xa.j.l(r2)     // Catch:{ Exception -> 0x0027 }
            throw r1     // Catch:{ Exception -> 0x0027 }
        L_0x0027:
            java.net.Socket r1 = r3.f17790e     // Catch:{ Exception -> 0x002c }
            r1.close()     // Catch:{ Exception -> 0x002c }
        L_0x002c:
            la.v r1 = la.v.f9814a     // Catch:{ all -> 0x0030 }
            monitor-exit(r0)
            return
        L_0x0030:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: z9.a.a():void");
    }

    public final DataInputStream b() {
        DataInputStream dataInputStream;
        synchronized (this.f17788c) {
            e();
            f();
            dataInputStream = this.f17786a;
            if (dataInputStream == null) {
                j.l("dataInput");
                throw null;
            }
        }
        return dataInputStream;
    }

    public final e c() {
        e eVar;
        synchronized (this.f17788c) {
            e();
            f();
            DataInputStream dataInputStream = this.f17786a;
            if (dataInputStream != null) {
                String readUTF = dataInputStream.readUTF();
                j.b("dataInput.readUTF()", readUTF);
                String lowerCase = readUTF.toLowerCase();
                j.b("(this as java.lang.String).toLowerCase()", lowerCase);
                JSONObject jSONObject = new JSONObject(lowerCase);
                int i10 = jSONObject.getInt("status");
                int i11 = jSONObject.getInt("type");
                int i12 = jSONObject.getInt("connection");
                long j10 = jSONObject.getLong("date");
                long j11 = jSONObject.getLong("content-length");
                String string = jSONObject.getString("md5");
                String string2 = jSONObject.getString("sessionid");
                j.b("md5", string);
                j.b("sessionId", string2);
                eVar = new e(i10, i11, i12, j10, j11, string, string2);
            } else {
                j.l("dataInput");
                throw null;
            }
        }
        return eVar;
    }

    public final void d(c cVar) {
        j.g("fileRequest", cVar);
        synchronized (this.f17788c) {
            e();
            f();
            DataOutputStream dataOutputStream = this.f17787b;
            if (dataOutputStream != null) {
                dataOutputStream.writeUTF(cVar.u());
                DataOutputStream dataOutputStream2 = this.f17787b;
                if (dataOutputStream2 != null) {
                    dataOutputStream2.flush();
                    v vVar = v.f9814a;
                } else {
                    j.l("dataOutput");
                    throw null;
                }
            } else {
                j.l("dataOutput");
                throw null;
            }
        }
    }

    public final void e() {
        if (this.f17789d) {
            throw new Exception("FetchFileResourceTransporter is already closed.");
        }
    }

    public final void f() {
        DataInputStream dataInputStream = this.f17786a;
        if (dataInputStream != null) {
            if (dataInputStream != null) {
                DataOutputStream dataOutputStream = this.f17787b;
                if (dataOutputStream == null) {
                    j.l("dataOutput");
                    throw null;
                } else if (dataOutputStream != null) {
                    return;
                }
            }
            throw new Exception("You forgot to call connect before calling this method.");
        }
        j.l("dataInput");
        throw null;
    }

    public a(int i10) {
        Socket socket = new Socket();
        this.f17790e = socket;
        this.f17788c = new Object();
        if (socket.isConnected() && !socket.isClosed()) {
            this.f17786a = new DataInputStream(socket.getInputStream());
            this.f17787b = new DataOutputStream(socket.getOutputStream());
        }
        if (socket.isClosed()) {
            this.f17789d = true;
        }
    }
}
