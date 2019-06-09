package com.fasttrackit.weatherapp.tools;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasttrackit.weatherapp.domain.currentweather.CurrentWeather;
import com.fasttrackit.weatherapp.transfer.currentweather.CurrentWeatherResponse;
import com.fasttrackit.weatherapp.weatherprovider.OpenWeatherMapWeatherProvider;

/**
 * 
 * @author Nicolae Iotu, nicolae.g.iotu@gmail.com
 *
 */
public abstract class CurrentWeatherTools {

	private static final ObjectMapper objectMapper = new ObjectMapper();

	public static CurrentWeather loadCurrentWeather(long wwwapiid)
			throws IOException, NoSuchMethodException, SecurityException {
		OpenWeatherMapWeatherProvider owmwp = new OpenWeatherMapWeatherProvider(wwwapiid);

		if (owmwp.getQueryComponents().get("appid") == "") {
			throw new RuntimeException(
					"It's time to register and get an app id from https://openweathermap.org. Copy this id as appid at com.fasttrackit.weatherapp.weatherprovider.OpenWeatherMapWeatherProvider.");
		}
		CurrentWeatherResponse currentWeatherResponse = null;

		URL url = new URL(owmwp.getCallUri());
		System.out.println(owmwp.getCallUri());
		currentWeatherResponse = objectMapper.readValue(url, CurrentWeatherResponse.class);

		return currentWeatherResponse.toCurrentWeather();
	}

	/**
	 * This method can copy properties between objects.<br/>
	 * A list of property names to be skipped while copying can be optionally
	 * provided.<br/>
	 * The method is still under testing, but for the purpose of this project works
	 * just fine.
	 * 
	 * @author Nicolae Iotu, nicolae.g.iotu@gmail.com
	 * @param <T>
	 * @param target
	 * @param source
	 * @param skipPropertyNames
	 * @return boolean - success status of this operation
	 */
	public static <T> boolean map(T target, T source, List<String> skipPropertyNames) {
		String basenm, gnm, snm;
		@SuppressWarnings("unchecked")
		Class<T> tgtClass = (Class<T>) target.getClass();
		@SuppressWarnings("unchecked")
		Class<T> srcClass = (Class<T>) source.getClass();
		List<Method> tgtClassMethods = new ArrayList<Method>();

		for (Method method : tgtClass.getMethods()) {
			tgtClassMethods.add(method);
		}

		if (skipPropertyNames != null && !skipPropertyNames.isEmpty()) {
			Iterator<Method> iterator = tgtClassMethods.iterator();
			while (iterator.hasNext()) {
				for (String propName : skipPropertyNames) {
					Method meth = iterator.next();
					if (meth.getName().toLowerCase().indexOf(propName.toLowerCase()) != -1) {
						iterator.remove();
					}
				}
			}
		}

		for (Method tm : tgtClassMethods) {
			if (tm.getName().startsWith("set")) {
				Method sm = null;
				snm = tm.getName();
				basenm = snm.substring(3);
				gnm = "get" + basenm;

				try {
					sm = srcClass.getMethod(gnm, null); // !important, do not cast
				} catch (NoSuchMethodException | SecurityException e1) {
					// nothing to do here
				}

				if (sm != null) {
					try {
						tm.invoke(target, sm.invoke(source, (Object[]) null));
					} catch (IllegalAccessException | IllegalArgumentException
							| InvocationTargetException e) {
						e.printStackTrace();
						return false;
					}
				}
			}
		}
		return true;
	}

}
