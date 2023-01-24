package io.myproject.rdecodecserver;

import com.google.common.base.Preconditions;
import com.sun.net.httpserver.HttpServer;
import io.myproject.codec.AbstractRemoteDataEncoderCodec;
import io.temporal.payload.codec.PayloadCodec;

import java.io.Closeable;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.List;

public class RDEHttpServer implements Closeable {
    private final List<PayloadCodec> codecs;
    private final int port;
    private HttpServer server;

    public RDEHttpServer(List<PayloadCodec> codecs) {
        this(codecs, -1);
    }

    public RDEHttpServer(List<PayloadCodec> codecs, int port) {
        this.codecs = codecs;
        this.port = port;
    }

    public synchronized void start() throws IOException {
        Preconditions.checkState(server == null, "Server already started");
        server =
                this.port > 0 ? HttpServer.create(new InetSocketAddress(port), 0) : HttpServer.create();

        server.createContext(
                AbstractRemoteDataEncoderCodec.ENCODE_PATH_POSTFIX, new DataEncoderHandler(codecs));
        server.createContext(
                AbstractRemoteDataEncoderCodec.DECODE_PATH_POSTFIX, new DataEncoderHandler(codecs));

        server.setExecutor(null);
        server.start();
    }

 /*   public int getPort() {
        return server != null ? server.getAddress().getPort() : port;
    }*/

    @Override
    public synchronized void close() {
        if (server != null) {
            server.stop(0);
        }
    }
}
