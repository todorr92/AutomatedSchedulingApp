package integrate;
import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import integrate.integrateGrpc.integrateImplBase;;


public class ServerIntegrate extends integrateImplBase{
	public static void main(String[] args) throws InterruptedException, IOException {
		
		System.out.println("Starting Integrate server.");
		
		ServerIntegrate integrateService = new ServerIntegrate();
		
		int port = 50053;
		try {
		Server server = ServerBuilder.forPort(port)
				.addService(integrateService)
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
	public StreamObserver<Integration> doIntegration(StreamObserver<ResponseMessage> responseObserver) {
		StringBuilder sb = new StringBuilder();
		
		return new StreamObserver<Integration>() {

			@Override
			public void onNext(Integration request) {
				sb.append("Integration ");
				sb.append(request.getName());
				sb.append("is implemented!\n");
				
			}

			@Override
			public void onError(Throwable t) {
				responseObserver.onError(t);
			}

			@Override
			public void onCompleted() {
				responseObserver.onNext(ResponseMessage.newBuilder().setMessage(sb.toString()).build());
				responseObserver.onCompleted();
				
			}
			
		};
	}
	

}
