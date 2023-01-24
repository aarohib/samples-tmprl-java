# io.myproject:data-converter-AB:4 Project

Implements a simple use case and uses custom data converter to encode and decode payloads.

To run the created workflow you have to have the Temporal server installed.
Easy way is to do that with [Docker Compose](https://docs.docker.com/compose/gettingstarted/).

1. Log in to your Temporal Cloud account/namespace.
2. Update the cloud target endpoint, namespace, your client certificate and key in the Utils file.
3. Run the Worker
4. Run the Starter

Check Cloud Web UI for encrypted payloads in the input and output sections of your Workflow Execution.

## Run the RDEHttpServer
1. Run `RunServer` to start the remote httpserver. It starts at http://localhost:8888. Note that this is running locally for you.

2. In the Data Encoder option on the Cloud WebUI, enter `http://localhost:8888` as the codec endpoint.

3. Refresh (and/or clear your browser cache) the page if you don't see your payloads decrypted.

4. Check decrypted input and output. If you have multiple runs of this Workflow, the inputs and outputs 
   in all the executions should show decrypted for you (but encrypted for everyone else).
