package controller;

import model.TestData;
import service.ConvertSqlToPdf;
import service.TestDataService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/testdata")
public class TestDataController {

    private TestDataService testDataService = new TestDataService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() throws Exception{
        return Response.ok().entity(testDataService.getAll()).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") Long id) throws Exception{
        return Response.ok().entity(testDataService.getById(id)).build();
    }

    @GET
    @Path("/createPdf")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createPdf() throws Exception{
        ConvertSqlToPdf.convert();
        return Response.ok().build();
    }

    @GET
    @Path("/data/{section}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("section") String section) throws Exception{
        TestData result = testDataService.getDataBySection(section);
        if(result.getData() != null) {
            return Response.ok().entity(result).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(TestData testData) throws Exception{
        testDataService.add(testData);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(TestData testData) throws Exception{
        testDataService.update(testData);
        return Response.noContent().build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) throws Exception {
        testDataService.remove(testDataService.getById(id));
        return Response.status(202).entity("Deleted").build();
    }

}
