# io.myproject:data-converter-AB:4 Project

Implements a simple Workflow + Activity that takes an input, selects a random word from the dictionary and returns the input appended with the random word.
It also uses a custom data converter to encode and decode the payloads.

To run the created workflow you have to have the Temporal server installed.

1. Start the Temporal Server locally.

```
git clone git@github.com:temporalio/docker-compose.git
cd docker-compose
docker compose up
```

2. Run the Worker

3. Run the Starter

4. Check Web UI for encrypted payloads in the Workflow Execution.

## Run the Remote Codec Server 

1. Run `RunServer` to start the remote httpserver. It starts at http://localhost:8888.

2. In the Data Encoder option on the WebUI, enter `http://localhost:8888` as the codec endpoint.

3. Refresh (and/or clear your browser cache) the page if you don't see your payloads decrypted.

4. Check decrypted input and output. If you have multiple runs of this Workflow, the inputs and outputs in all the executions should show decrypted.
