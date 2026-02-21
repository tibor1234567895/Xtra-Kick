package k1;

import android.net.Uri;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.SocketTimeoutException;

public final class h0 extends c {

    /* renamed from: e  reason: collision with root package name */
    public final int f8997e = 8000;

    /* renamed from: f  reason: collision with root package name */
    public final byte[] f8998f;

    /* renamed from: g  reason: collision with root package name */
    public final DatagramPacket f8999g;

    /* renamed from: h  reason: collision with root package name */
    public Uri f9000h;

    /* renamed from: i  reason: collision with root package name */
    public DatagramSocket f9001i;

    /* renamed from: j  reason: collision with root package name */
    public MulticastSocket f9002j;

    /* renamed from: k  reason: collision with root package name */
    public InetAddress f9003k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f9004l;

    /* renamed from: m  reason: collision with root package name */
    public int f9005m;

    public h0() {
        super(true);
        byte[] bArr = new byte[2000];
        this.f8998f = bArr;
        this.f8999g = new DatagramPacket(bArr, 0, 2000);
    }

    public final void close() {
        this.f9000h = null;
        MulticastSocket multicastSocket = this.f9002j;
        if (multicastSocket != null) {
            try {
                InetAddress inetAddress = this.f9003k;
                inetAddress.getClass();
                multicastSocket.leaveGroup(inetAddress);
            } catch (IOException unused) {
            }
            this.f9002j = null;
        }
        DatagramSocket datagramSocket = this.f9001i;
        if (datagramSocket != null) {
            datagramSocket.close();
            this.f9001i = null;
        }
        this.f9003k = null;
        this.f9005m = 0;
        if (this.f9004l) {
            this.f9004l = false;
            s();
        }
    }

    public final Uri j() {
        return this.f9000h;
    }

    public final int o(byte[] bArr, int i10, int i11) {
        if (i11 == 0) {
            return 0;
        }
        int i12 = this.f9005m;
        DatagramPacket datagramPacket = this.f8999g;
        if (i12 == 0) {
            try {
                DatagramSocket datagramSocket = this.f9001i;
                datagramSocket.getClass();
                datagramSocket.receive(datagramPacket);
                int length = datagramPacket.getLength();
                this.f9005m = length;
                r(length);
            } catch (SocketTimeoutException e10) {
                throw new g0(e10, 2002);
            } catch (IOException e11) {
                throw new g0(e11, 2001);
            }
        }
        int length2 = datagramPacket.getLength();
        int i13 = this.f9005m;
        int min = Math.min(i13, i11);
        System.arraycopy(this.f8998f, length2 - i13, bArr, i10, min);
        this.f9005m -= min;
        return min;
    }

    public final long q(m mVar) {
        Uri uri = mVar.f9022a;
        this.f9000h = uri;
        String host = uri.getHost();
        host.getClass();
        int port = this.f9000h.getPort();
        t();
        try {
            this.f9003k = InetAddress.getByName(host);
            InetSocketAddress inetSocketAddress = new InetSocketAddress(this.f9003k, port);
            if (this.f9003k.isMulticastAddress()) {
                MulticastSocket multicastSocket = new MulticastSocket(inetSocketAddress);
                this.f9002j = multicastSocket;
                multicastSocket.joinGroup(this.f9003k);
                this.f9001i = this.f9002j;
            } else {
                this.f9001i = new DatagramSocket(inetSocketAddress);
            }
            this.f9001i.setSoTimeout(this.f8997e);
            this.f9004l = true;
            u(mVar);
            return -1;
        } catch (SecurityException e10) {
            throw new g0(e10, 2006);
        } catch (IOException e11) {
            throw new g0(e11, 2001);
        }
    }
}
