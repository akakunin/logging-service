package ru.emdev.logging;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wso2.msf4j.Request;

@Path("/logging")
public class LoggingService {
	private static final Logger log = LoggerFactory.getLogger(LoggingService.class);
	
	@GET
	@Path("/{param}")
    public String logGetWithParam(@PathParam("param") String param, @Context Request request) {
		log.info("GET Received");
		log.info("Param: " + param);
		
		return logGet(request);
	}
	
	@GET
	public String logGet(@Context Request request) {
		try {
			request.getHeaders().getAll().stream()
	        .forEach(header -> log.info("Header Name: " + header.getName() + " value : " + header.getValue()));
			
			for (ByteBuffer byteBuffer : request.getFullMessageBody()) {
				byte[] bytes = new byte[byteBuffer.capacity()];
				byteBuffer.get(bytes);
				String content = new String(bytes, "UTF-8");
				log.info("Message Body: " + content);
			}
		} catch (Exception ex) {
			log.error("Error during processing", ex);
		}
		return "OK GET";
    }
	
	@POST
	@Path("/{param}")
    public String logPostWithParam(@PathParam("param") String param, @Context Request request) {
		log.info("POST Received");
		log.info("Param: " + param);

		return logGet(request);
	}
	
	@POST
	public String logPost(@Context Request request) {
		try {
			request.getHeaders().getAll().stream()
	        .forEach(header -> log.info("Header Name: " + header.getName() + " value : " + header.getValue()));
			
			for (ByteBuffer byteBuffer : request.getFullMessageBody()) {
				byte[] bytes = new byte[byteBuffer.capacity()];
				byteBuffer.get(bytes);
				String content = new String(bytes, "UTF-8");
				log.info("Message Body: " + content);
			}
		} catch (Exception ex) {
			log.error("Error during processing", ex);
		}		
		
		return "OK POST";
    }
	
	@PUT
	@Path("/{param}")
	public String logPutWithParam(@PathParam("param") String param, @Context Request request) {
		log.info("PUT Received");
		log.info("Param: " + param);

		return logGet(request);
	}
	
	@PUT
	public String logPut(@Context Request request) {
		try {
			request.getHeaders().getAll().stream()
	        .forEach(header -> log.info("Header Name: " + header.getName() + " value : " + header.getValue()));
			
			for (ByteBuffer byteBuffer : request.getFullMessageBody()) {
				byte[] bytes = new byte[byteBuffer.capacity()];
				byteBuffer.get(bytes);
				String content = new String(bytes, "UTF-8");
				log.info("Message Body: " + content);
			}
		} catch (Exception ex) {
			log.error("Error during processing", ex);
		}		
		
		return "OK PUT";
    }
	
	
}
