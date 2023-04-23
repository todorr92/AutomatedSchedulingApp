package schedule;
import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import schedule.scheduleGrpc.scheduleImplBase;

public class ServerSchedule extends scheduleImplBase{
	public static void main(String[] args) throws InterruptedException, IOException {
		
		System.out.println("Starting Schedule server.");
			
		ServerSchedule scheduleService = new ServerSchedule();
		
		int port = 50052;
		
		try {
		Server server = ServerBuilder.forPort(port)
				.addService(scheduleService)
				.build()
				.start();

		System.out.println("User service started, listening on " + port);

		server.awaitTermination();
		} catch(IOException e){
			e.printStackTrace();
		} catch(InterruptedException e){
			e.printStackTrace();
		}
	}

	@Override
	public void bookEvent(Event request, StreamObserver<ResponseMessage> responseObserver) {
		String eventName = request.getName();
		int eventId = request.getId();
		
		ResponseMessage.Builder message = ResponseMessage.newBuilder();
		
		message.setMessage("Event with id: " + eventId + " and name: " + eventName + " is now created.");
		
		responseObserver.onNext(message.build());
		responseObserver.onCompleted();

	}

	@Override
	public void sendReminder(SendReminder request, StreamObserver<ResponseMessage> responseObserver) {
		String email = request.getEmail();
		
		ResponseMessage.Builder message = ResponseMessage.newBuilder();
		
		message.setMessage("Reminder sent to " + email);
		responseObserver.onNext(message.build());
		responseObserver.onCompleted();
	}
	

}
