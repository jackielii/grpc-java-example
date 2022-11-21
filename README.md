## Test coc-java with genearted code

to reproduce the problem, run (on mac m1):

1. `./mvnw -Dos.detected.classifier=osx-x86_64 compile`
2. `tree target/generated-sources/protobuf/` should see generated source
3. comment out `"java.autobuild.enabled": false` (default to true)
6. open `./src/main/java/io/grpc/examples/helloworld/service/GreeterImpl.java`
	and project should build automatcially and this file will show error
6. `tree target/generated-sources/protobuf/` should see generated source gone
7. repeate 1-6 but skip 3, you shouldn't see any errors


Observations:

It seems building manaually doesn't trigger this problem(full or incremental). The LSP issued was
   ```
[Trace - 16:56:34] Sending request 'java/buildWorkspace - (6)'.
Params: [
    true
]
   ```

Init workspace will clean out the source code. the `java.autobuild.enabled`
will set the `initializationOptions.settings.java.autobuild.enabled` to
`false`. You can check by inspecting `java.output`

