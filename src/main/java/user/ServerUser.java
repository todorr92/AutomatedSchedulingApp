package user;
import java.io.IOException;
import java.util.Properties;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.InetAddress;


import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import user.userGrpc.userImplBase;;

public class ServerUser extends userImplBase{
	
	public static void main(String[] args) throws InterruptedException, IOException {
		
		System.out.println("Starting User server.");
		
		ServerUser userService = new ServerUser();
		
		Properties prop = userService.getProperties();
		
		userService.registerService(prop);
		
		int port = Integer.valueOf( prop.getProperty("service_port") );// #.50051;
		
		try {
		Server server = ServerBuilder.forPort(port)
				.addService(userService)
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
	
private Properties getProperties() {
		
		Properties prop = null;		
		
		 try (InputStream input = new FileInputStream("src/main/resources/user.properties")) {

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
