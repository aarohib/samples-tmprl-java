# io.myproject:data-converter-cloud Project

Implements a simple Workflow + Activity that takes an input, selects a random word from the dictionary and returns the input appended with the random word.
It implements a custom data converter to encode and decode the payloads.

To run the Workflow:

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
