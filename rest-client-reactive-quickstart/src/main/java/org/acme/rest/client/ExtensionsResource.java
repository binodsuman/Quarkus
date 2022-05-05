package org.acme.rest.client;

import io.smallrye.common.annotation.Blocking;
import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.Set;
import java.util.concurrent.CompletionStage;

@Path("/extension")
public class ExtensionsResource {

    @RestClient
    ExtensionsService extensionsService;


    @GET
    @Path("/id/{id}")
    @Blocking
    public Set<Extension> id(String id) {
//    	System.out.println("::: Inside the Blocking Call :::");
//    	Thread.getAllStackTraces()
//		  .keySet()
//		  .stream()
//		  .forEach(System.out::println);
    	for(int i=0;i<10;i++) {
    		System.out.println("Blocking i:"+i);
    		try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	System.out.println("Blocking out of for loop");
        return extensionsService.getById(id);
    }

    @GET
    @Path("/id-async/{id}")
    public CompletionStage<Set<Extension>> idAsync(String id) {
        return extensionsService.getByIdAsync(id);
    }

    @GET
    @Path("/id-uni/{id}")
    public Uni<Set<Extension>> idUni(String id) {
//    	System.out.println("::: Inside the Reactive Call :::");
//    	Thread.getAllStackTraces()
//		  .keySet()
//		  .stream()
//		  .forEach(System.out::println);
    	for(int i=0;i<10;i++) {
    		System.out.println("Uni i:"+i);
    		try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	System.out.println("Uni out of for loop");
        return extensionsService.getByIdAsUni(id);
    }
    
    @GET
    @Path("/fruits")
    public Uni<Set<Fruit>> getFruits() {
		System.out.println("Uni Call 111 !!!!!!!!!!!");
		Uni<Set<Fruit>> data = extensionsService.getAll().onItem().transform(fruits -> {
			System.out.println("Data received !!!!!!!!!!!");
			return fruits;
		});
		System.out.println("Uni Call 222 !!!!!!!!!!!");
		return data;
    }
    
    @GET
    @Path("/fruits/blocking")
    @Blocking
    public Set<Fruit> getFruitsBlocking() {
		System.out.println("Uni Call 111 !!!!!!!!!!!");
		Set<Fruit> data = extensionsService.getAllBlocking();
		System.out.println("data :"+data);
		System.out.println("Uni Call 222 !!!!!!!!!!!");
		return data;
    }
}
