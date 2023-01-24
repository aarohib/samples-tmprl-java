package io.myproject;

import io.temporal.serviceclient.SimpleSslContextBuilder;
import io.temporal.serviceclient.WorkflowServiceStubs;
import io.temporal.serviceclient.WorkflowServiceStubsOptions;

import javax.net.ssl.SSLException;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class Utils {
    public static final String TARGET_ENDPOINT = "<your tmprl.dev cloud endpoint>"; //replace this with your tmprl.dev cloud endpoint
    public static final String NAMESPACE = "<your cloud namespace>"; //replace this with your temporal dev cloud namespace
    //public static final String DEFAULT_TASK_QUEUE = "myTaskQueue";
    private static final InputStream CLIENT_CERT = Utils.getFileInputStream("/<your client cert>"); //replace this with your own cert
    private static final InputStream CLIENT_KEY = Utils.getFileInputStream("/<your client key>"); //replace this with your own cert

    private static InputStream getFileInputStream(String fileName) {
        try {
            return new FileInputStream(getFile(fileName));
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
            return null;
        }
    }
    public static final WorkflowServiceStubs service(){
        try {
            return WorkflowServiceStubs.newServiceStubs(
                    WorkflowServiceStubsOptions.newBuilder()
                            .setSslContext(SimpleSslContextBuilder.forPKCS8(CLIENT_CERT, CLIENT_KEY).build())
                            .setTarget(TARGET_ENDPOINT)
                            .build());
        } catch (SSLException e) {
            System.out.println("Exception: " + e.getMessage());
            return null;
        }
    }

    private static File getFile(String fileName) {
        return new File(Utils.class.getResource(fileName).getFile());
    }


}
