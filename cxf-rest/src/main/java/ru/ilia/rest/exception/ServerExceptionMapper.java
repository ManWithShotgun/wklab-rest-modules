package ru.ilia.rest.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 * Created by ILIA on 12.04.2017.
 */
public class ServerExceptionMapper implements
        ExceptionMapper<NotImplementedException> {

    /**
     * @param e NotImplementedException
     * @return Response
     * */
    public final Response toResponse(final NotImplementedException e) {
        return Response.status(Response.Status.NOT_IMPLEMENTED)
                .header("Content-Type", "application/json")
                .entity(e.getMessage()).build();
    }
}
