package io.myproject.rdecodecserver;

import io.myproject.codec.CustomCodecAB;

import java.io.IOException;
import java.util.Collections;

public class RunServer {
        public static void main(String[] args) {
            try {
                new RDEHttpServer(Collections.singletonList(new CustomCodecAB()), 8888).start();
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
}
