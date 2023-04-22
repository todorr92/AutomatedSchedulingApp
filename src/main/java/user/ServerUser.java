package user;
import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import user.userGrpc.userImplBase;;

public class ServerUser extends userImplBase{
	public static void main(String[] args) throws InterruptedException, IOException {
		
		System.out.println("Starting User server.");
		
		ServerUser userService = new ServerUser();
		
		int port = 50051;
		
		Server server = ServerBuilder.forPort(port)
				.addService(userService)
				.build()
				.start();

		System.out.println("User service started, listening on " + port);

		server.awaitTermination();
	}
	
	@Override
	public void userLogin(LoginRequest request, StreamObserver<LoginMessage> responseObserver) {
		
		String userName = request.getUserName();
		String password = request.getPassword();
		
		LoginMessage.Builder message = LoginMessage.newBuilder();
		if(userName.equals(password)){
			
			message.setMessage("Welcome " + userName);
		}else {
			message.setMessage("Invalid username/password!");
		}
		
		responseObserver.onNext(message.build());
		responseObserver.onCompleted();
	}

	@Override
	public void userLogout(EmptyMessage request, StreamObserver<LogOutMessage> responseObserver) {
		
		LogOutMessage.Builder message = LogOutMessage.newBuilder();
		
		message.setMessage("See you next time.");
		
		responseObserver.onNext(message.build());
		responseObserver.onCompleted();
	}
	

}
