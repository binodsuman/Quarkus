package binod.suman;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GreetingService {
	
	public String greeting(String name) {
		return "Hello Mr. "+name;
	}

}
