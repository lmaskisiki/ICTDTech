package infosource.homeaffairs.services;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;

@Component
public class BCProcessor {

	public BCertificate getCertificateResponse(String jsonString) {
		Gson jsonMapper = new Gson();
		BCertificate certificate = jsonMapper.fromJson(jsonString,
				BCertificate.class);
		return certificate;
	}

}
