package user;
import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import user.userGrpc.userImplBase;;

public class ServerUser extends userImplBase{
	public static void main(String[] args) throws InterruptedException, IOException {
		
		System.out.println("Starting User server.");
		
		UserService userService = new UserService();
		
		int port = 50051;
		
		Server server = ServerBuilder.forPort(port)
				.addService(userService)
				.build()
				.start();

		System.out.println("User service started, listening on " + port);

		server.awaitTermination();
	}	
	

}
