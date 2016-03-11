package com.bssys.training.chapter4;

import com.bssys.training.chapter4.jaxb.Add;
import com.bssys.training.chapter4.jaxb.AddResponse;
import com.bssys.training.chapter4.jaxb.ObjectFactory;

public class JAXBLocalService {
	
	public AddResponse addOperation(Add request){
		int intA = request.getIntA();
		int intB = request.getIntB();
		ObjectFactory factory = new ObjectFactory();
		AddResponse addResponse = factory.createAddResponse();
		addResponse.setAddResult(intA + intB);
		return addResponse;
	}
}
