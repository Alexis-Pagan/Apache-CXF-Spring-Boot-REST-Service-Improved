package restpro.impls;

import java.io.PrintWriter;

import org.springframework.stereotype.Service;

import restpro.interfaces.ProgrammingI;
import restpro.models.Information;
import restpro.models.MasterProgramDescription;
import restpro.response.Response;
import restpro.response.RestCustCode;

@Service
public class ProgrammingEndpoint implements ProgrammingI {

	@Override
	public MasterProgramDescription getPoemByName() {

		MasterProgramDescription model = new MasterProgramDescription();
		model.setProgramming("Java, less coffee needed.");
		
		return model;
	}

	@Override
	public Response proLangInfo(String lan) {

		/**
		 * better encapsulation is viable for instances of objects created
		 * on this scope.
		 * @author alexis
		 */
		Information obj = new Information();
		obj.setInform(lan);
		
		String sendData = obj.getInform();
		
		PrintWriter console = new PrintWriter(System.out, true);
		console.println(sendData);
		
		if(obj.getInform().equals("C++")) {
			console.println("The language is C++");
		} else {
			console.println("Is another language");
		}
		
		Response response = new Response();

		response.setMessage("Language Received: " + lan);
		response.setStatus(RestCustCode.RECEIVED);
		
		return response;
	}
}

