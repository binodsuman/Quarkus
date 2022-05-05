package binod.suman;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;
import org.jboss.logging.Logger;

import io.smallrye.reactive.messaging.kafka.Record;


@ApplicationScoped
public class DataConsumer {
	
	private final Logger logger = Logger.getLogger(DataConsumer.class);

    @Incoming("data-input")
    public void receive(Record<String, Integer> record) {
    	System.out.println("Inside the consumer");
       logger.infof("Got a movie: %s - %d", record.key(), record.value());
    	//logger.info(record.key()+" : "+ record.value());
    	
    }
    
    
    
    @Incoming("data-input")
    @Outgoing("data-output")
    public String process(String in) {
    	System.out.println("Converting method is called");
        return in+" Processed and modified";
    }
}
