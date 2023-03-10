package io.myproject.codec;

import com.google.protobuf.util.JsonFormat;

public class AbstractRemoteDataEncoderCodec {
    public static final String ENCODE_PATH_POSTFIX = "/encode";
    public static final String DECODE_PATH_POSTFIX = "/decode";
    public static final String CONTENT_TYPE_APPLICATION_JSON = "application/json";

    public static final JsonFormat.Parser JSON_FORMAT = JsonFormat.parser();
    public static final JsonFormat.Printer JSON_PRINTER = JsonFormat.printer();
}
