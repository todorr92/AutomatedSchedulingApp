package integrate;
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
import integrate.integrateGrpc.integrateImplBase;;


public class ServerIntegrate extends integrateImplBase{
	public static void main(String[] args) throws InterruptedException, IOException {
		
		System.out.println("Starting Integrate server.");
		
		ServerIntegrate integrateService = new ServerIntegrate();
		
		Properties prop = integrateService.getProperties();
		
		integrateService.registerService(prop);
		
		int port = Integer.valueOf( prop.getProperty("service_port") );// #.50053;
		
		try {
		Server server = ServerBuilder.forPort(port)
				.addService(integrateService)
				.build()
				.start();

		System.out.println("Integrate service started, listening on " + port);

		server.awaitTermination();
		} catch(IOException e){
			e.printStackTrace();
		} catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
private Properties getProperties() {
		
		Properties prop = null;		
		
		 try (InputStream input = new FileInputStream("src/main/resources/integrate.properties")) {

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
