package br.com.devmedia.blog.converter;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply=true)
public class LocalDateConverter implements AttributeConverter<LocalDate, Date>{

	public Date convertToDatabaseColumn(LocalDate attribute) {

		return Date.valueOf(attribute);
	}

	public LocalDate convertToEntityAttribute(Date dbData) {

		return dbData.toLocalDate();
	}

}
