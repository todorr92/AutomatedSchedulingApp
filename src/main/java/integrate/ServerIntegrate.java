package integrate;
import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import integrate.integrateGrpc.integrateImplBase;;


public class ServerIntegrate extends integrateImplBase{
	public static void main(String[] args) throws InterruptedException, IOException {
		
		ServerIntegrate integrateService = new ServerIntegrate();
		
		int port = 50053;
		
		Server server = ServerBuilder.forPort(port)
				.addService(integrateService)
				.build()
				.start();

		System.out.println("User service started, listening on " + port);

		server.awaitTermination();
	}

}
