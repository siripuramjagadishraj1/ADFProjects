package model.bean;

import java.math.BigDecimal;

import oracle.jbo.server.DBTransaction;
import oracle.jbo.server.SequenceImpl;
import java.util.Date;

import javax.faces.application.FacesMessage;

import javax.faces.context.FacesContext;

import oracle.adf.model.BindingContext;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;


public class ModelUtil {
    public static BigDecimal getSequenceNextVal(DBTransaction transaction){
        SequenceImpl seq = new SequenceImpl("ID_SEQ", transaction);
        return new BigDecimal(seq.getSequenceNumber().toString());
    }
    
    public static java.sql.Timestamp getCurrentDate(){
        return new java.sql.Timestamp((new Date()).getTime());
    }
    
    
}
