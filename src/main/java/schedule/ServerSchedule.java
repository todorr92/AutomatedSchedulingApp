package schedule;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.Properties;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import schedule.scheduleGrpc.scheduleImplBase;

public class ServerSchedule extends scheduleImplBase{
	public static void main(String[] args) throws InterruptedException, IOException {
		
		System.out.println("Starting Schedule server.");
			
		ServerSchedule scheduleService = new ServerSchedule();
		
		
		Properties prop = scheduleService.getProperties();
		
		scheduleService.registerService(prop);
		
		int port = Integer.valueOf( prop.getProperty("service_port") );// #.50052;
		
		try {
		Server server = ServerBuilder.forPort(port)
				.addService(scheduleService)
				.build()
				.start();

		System.out.println("Schedule service started, listening on " + port);

		server.awaitTermination();
		} catch(IOException e){
			e.printStackTrace();
		} catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
private Properties getProperties() {
		
		Properties prop = null;		
		
		 try (InputStream input = new FileInputStream("src/main/resources/schedule.properties")) {

	            prop = new Properties();

	            // load a properties file
	            prop.load(input);

	            // get the property value and print it out
	            System.out.println("Math Service properies ...");
	            System.out.println("\t service_type: " + prop.getProperty("service_type"));
	            System.out.println("\t service_name: " +prop.getProperty("service_name"));
	            System.out.println("\t service_description: " +prop.getProperty("service_description"));
		        System.out.println("\t service_port: " +prop.getProperty("service_port"));

	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	
		 return prop;
	}

private  void registerService(Properties prop) {
	
	 try {
           // Create a JmDNS instance
           JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
           
           String service_type = prop.getProperty("service_type") ;//"_http._tcp.local.";
           String service_name = prop.getProperty("service_name")  ;// "example";
          // int service_port = 1234;
           int service_port = Integer.valueOf( prop.getProperty("service_port") );// #.50051;

           
           String service_description_properties = prop.getProperty("service_description")  ;//"path=index.html";
           
           // Register a service
           ServiceInfo serviceInfo = ServiceInfo.create(service_type, service_name, service_port, service_description_properties);
           jmdns.registerService(serviceInfo);
           
           System.out.printf("registrering service with type %s and name %s \n", service_type, service_name);
           
           // Wait a bit
           Thread.sleep(1000);

           // Unregister all services
           //jmdns.unregisterAllServices();

       } catch (IOException e) {
           System.out.println(e.getMessage());
       } catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   
}

	@Override
	public void bookEvent(Event request, StreamObserver<ResponseMessage> responseObserver) {
		String eventName = request.getName();
		String eventEmail = request.getEmail();
		
		ResponseMessage.Builder message = ResponseMessage.newBuilder();
		
		message.setMessage("Event with name: " + eventName + " and email address" + eventEmail + " is now created.");
		
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
