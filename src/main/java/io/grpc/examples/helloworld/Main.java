package io.grpc.examples.helloworld;

import java.io.IOException;
import java.util.logging.Logger;

import io.grpc.examples.helloworld.server.HelloWorldServer;

public class Main {

	private static final Logger logger = Logger.getLogger(Main.class.getName());

	/**
	 * Main launches the server from the command line.
	 *
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws IOException, InterruptedException {
		// Start the RPC server. You shouldn't see any output from gRPC before this.
		logger.info("GRPC server starting.");
		HelloWorldServer service = HelloWorldServer.getInstance();
		service.start();
		service.blockUntilShutdown();
	}
}
