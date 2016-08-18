package infosource.messaging.router;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public   class GsonUTCdateAdapter implements
		JsonSerializer<java.util.Date>, JsonDeserializer<java.util.Date> {

	private final DateFormat dateFormat;

	public GsonUTCdateAdapter() {
		dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS",
				Locale.US); // This is the format I need
		dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
	}

	@Override
	public synchronized JsonElement serialize(Date date, Type type,
			JsonSerializationContext jsonSerializationContext) {
		return new JsonPrimitive(dateFormat.format(date));
	}

	@Override
	public synchronized Date deserialize(JsonElement jsonElement, Type type,
			JsonDeserializationContext jsonDeserializationContext) {
		try {
			
			return dateFormat.parse(jsonElement.getAsString());
		} catch (ParseException e) {
			throw new JsonParseException(e);
		}
	}
}