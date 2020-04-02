package com.tpsoft.platform.common.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
public class DateConverter implements Converter<String,Date>{

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	@Override
	public Date convert(String source) {
		Date date ;
		if(source!=null && source!="") {
			try {
				date=sdf.parse(source);
				return date;
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
}
