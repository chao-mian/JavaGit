 package com.shop.convert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class CustomConvertor implements Converter<String, Date> {

	@Override
	public Date convert(String source) {

		try {
			Date date = (Date) new SimpleDateFormat("yyyy-MM-dd").parse(source);
			return date;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
