package schedule;
import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import schedule.scheduleGrpc.scheduleImplBase;

public class ServerSchedule extends scheduleImplBase{
	public static void main(String[] args) throws InterruptedException, IOException {
		
		System.out.println("Starting Schedule server.");
			
		ServerSchedule scheduleService = new ServerSchedule();
		
		int port = 50052;
		
		Server server = ServerBuilder.forPort(port)
				.addService(scheduleService)
				.build()
				.start();

		System.out.println("User service started, listening on " + port);

		server.awaitTermination();
	}

}
