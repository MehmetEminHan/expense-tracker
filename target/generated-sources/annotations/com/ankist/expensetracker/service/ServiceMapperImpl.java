package com.ankist.expensetracker.service;

import com.ankist.expensetracker.model.ExpenseDTO;
import com.ankist.expensetracker.repository.ExpenseEntity;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-03-07T18:50:22-0500",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class ServiceMapperImpl implements ServiceMapper {

    private final DatatypeFactory datatypeFactory;

    public ServiceMapperImpl() {
        try {
            datatypeFactory = DatatypeFactory.newInstance();
        }
        catch ( DatatypeConfigurationException ex ) {
            throw new RuntimeException( ex );
        }
    }

    @Override
    public ExpenseDTO mapExpenseEntityToDTO(ExpenseEntity expenseEntity) {
        if ( expenseEntity == null ) {
            return null;
        }

        ExpenseDTO expenseDTO = new ExpenseDTO();

        expenseDTO.setId( expenseEntity.getId() );
        expenseDTO.setExpenseAmount( expenseEntity.getExpenseAmount() );
        expenseDTO.setExpenseDate( expenseEntity.getExpenseDate() );
        expenseDTO.setRegisterDate( xmlGregorianCalendarToLocalDateTime( localDateToXmlGregorianCalendar( expenseEntity.getRegisterDate() ) ) );
        expenseDTO.setCurrency( expenseEntity.getCurrency() );
        expenseDTO.setCategory( expenseEntity.getCategory() );
        expenseDTO.setNote( expenseEntity.getNote() );

        return expenseDTO;
    }

    @Override
    public ExpenseEntity mapExpenseDtoToEntity(ExpenseDTO expenseDTO) {
        if ( expenseDTO == null ) {
            return null;
        }

        ExpenseEntity expenseEntity = new ExpenseEntity();

        expenseEntity.setId( expenseDTO.getId() );
        expenseEntity.setExpenseAmount( expenseDTO.getExpenseAmount() );
        expenseEntity.setExpenseDate( expenseDTO.getExpenseDate() );
        expenseEntity.setRegisterDate( xmlGregorianCalendarToLocalDate( localDateTimeToXmlGregorianCalendar( expenseDTO.getRegisterDate() ) ) );
        expenseEntity.setCurrency( expenseDTO.getCurrency() );
        expenseEntity.setCategory( expenseDTO.getCategory() );
        expenseEntity.setNote( expenseDTO.getNote() );

        return expenseEntity;
    }

    @Override
    public List<ExpenseDTO> mapListExpenseEntityToDTO(List<ExpenseEntity> expenseEntities) {
        if ( expenseEntities == null ) {
            return null;
        }

        List<ExpenseDTO> list = new ArrayList<ExpenseDTO>( expenseEntities.size() );
        for ( ExpenseEntity expenseEntity : expenseEntities ) {
            list.add( mapExpenseEntityToDTO( expenseEntity ) );
        }

        return list;
    }

    private static LocalDateTime xmlGregorianCalendarToLocalDateTime( XMLGregorianCalendar xcal ) {
        if ( xcal == null ) {
            return null;
        }

        if ( xcal.getYear() != DatatypeConstants.FIELD_UNDEFINED
            && xcal.getMonth() != DatatypeConstants.FIELD_UNDEFINED
            && xcal.getDay() != DatatypeConstants.FIELD_UNDEFINED
            && xcal.getHour() != DatatypeConstants.FIELD_UNDEFINED
            && xcal.getMinute() != DatatypeConstants.FIELD_UNDEFINED
        ) {
            if ( xcal.getSecond() != DatatypeConstants.FIELD_UNDEFINED
                && xcal.getMillisecond() != DatatypeConstants.FIELD_UNDEFINED ) {
                return LocalDateTime.of(
                    xcal.getYear(),
                    xcal.getMonth(),
                    xcal.getDay(),
                    xcal.getHour(),
                    xcal.getMinute(),
                    xcal.getSecond(),
                    Duration.ofMillis( xcal.getMillisecond() ).getNano()
                );
            }
            else if ( xcal.getSecond() != DatatypeConstants.FIELD_UNDEFINED ) {
                return LocalDateTime.of(
                    xcal.getYear(),
                    xcal.getMonth(),
                    xcal.getDay(),
                    xcal.getHour(),
                    xcal.getMinute(),
                    xcal.getSecond()
                );
            }
            else {
                return LocalDateTime.of(
                    xcal.getYear(),
                    xcal.getMonth(),
                    xcal.getDay(),
                    xcal.getHour(),
                    xcal.getMinute()
                );
            }
        }
        return null;
    }

    private static LocalDate xmlGregorianCalendarToLocalDate( XMLGregorianCalendar xcal ) {
        if ( xcal == null ) {
            return null;
        }

        return LocalDate.of( xcal.getYear(), xcal.getMonth(), xcal.getDay() );
    }

    private XMLGregorianCalendar localDateTimeToXmlGregorianCalendar( LocalDateTime localDateTime ) {
        if ( localDateTime == null ) {
            return null;
        }

        return datatypeFactory.newXMLGregorianCalendar(
            localDateTime.getYear(),
            localDateTime.getMonthValue(),
            localDateTime.getDayOfMonth(),
            localDateTime.getHour(),
            localDateTime.getMinute(),
            localDateTime.getSecond(),
            localDateTime.get( ChronoField.MILLI_OF_SECOND ),
            DatatypeConstants.FIELD_UNDEFINED );
    }

    private XMLGregorianCalendar localDateToXmlGregorianCalendar( LocalDate localDate ) {
        if ( localDate == null ) {
            return null;
        }

        return datatypeFactory.newXMLGregorianCalendarDate(
            localDate.getYear(),
            localDate.getMonthValue(),
            localDate.getDayOfMonth(),
            DatatypeConstants.FIELD_UNDEFINED );
    }
}
