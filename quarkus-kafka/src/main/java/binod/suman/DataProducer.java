package binod.suman;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import io.smallrye.mutiny.Multi;
import io.smallrye.reactive.messaging.kafka.Record;


@ApplicationScoped
public class DataProducer {
	
	@Inject @Channel("data-output")
    Emitter<Record<String, Integer>> emitter;

	//@Outgoing("data-output")
    public void sendMovieToKafka(Data data) {
    	System.out.println("Received in Producer");
        emitter.send(Record.of(data.country, data.code));
    }

    
    
}
