package binod.suman;






import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/datasend")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DataResource {

    @Inject
    DataProducer producer;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response send(Data data) {
        producer.sendMovieToKafka(data);
        // Return an 202 - Accepted response.
        System.out.println("Income Data :"+data.country+"    "+data.code);
       // return "Data Receipt "+"Income Data :"+data.country+"    "+data.code;
        return Response.accepted().build();

    }
}
