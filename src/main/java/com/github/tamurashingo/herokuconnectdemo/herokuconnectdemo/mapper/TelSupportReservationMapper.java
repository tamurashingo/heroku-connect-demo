package com.github.tamurashingo.herokuconnectdemo.herokuconnectdemo.mapper;

import com.github.tamurashingo.herokuconnectdemo.herokuconnectdemo.model.TelSupportReservation;
import org.apache.ibatis.annotations.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Mapper
public interface TelSupportReservationMapper {

    @Select(
        " SELECT "
      + "   id, "
      + "   externalid__c as externalid, "
      + "   emptystatus__c as emptystatus, "
      + "   type__c as type, "
      + "   name, "
      + "   reservationcustomer__c as reservationcustomer, "
      + "   reservationdatetime__c as reservationdatetime, "
      + "   startdatetime__c as startdatetime, "
      + "   enddatetime__c as enddatetime "
      + " FROM "
      + "   salesforce.telsupportreservation__c "
      + " ORDER BY "
      + "   startdatetime__c "
    )
    List<TelSupportReservation> selectAll();

    @Select(
      " SELECT "
    + "   id, "
    + "   externalid__c as externalid, "
    + "   emptystatus__c as emptystatus, "
    + "   type__c as type, "
    + "   name, "
    + "   reservationcustomer__c as reservationcustomer, "
    + "   reservationdatetime__c as reservationdatetime, "
    + "   startdatetime__c as startdatetime, "
    + "   enddatetime__c as enddatetime "
    + " FROM "
    + "   salesforce.telsupportreservation__c "
    + " WHERE "
    + "   externalid__c = #{externalid}"
    )
    TelSupportReservation selectByKey(String externalid);

    @Update(
        " UPDATE salesforce.telsupportreservation__c "
      + " SET "
      + "   reservationcustomer__c = #{reservationcustomer}, "
      + "   reservationdatetime__c = #{reservationdatetime} "
      + " WHERE "
      + "   externalid__c = #{externalid} "
    )
    int updateByPrimaryKey(TelSupportReservation r);


    @Insert(
        " INSERT INTO salesforce.telsupportreservation__c "
      + " ( "
      + "   externalid__c, "
      + "   emptystatus__c, "
      + "   type__c, "
      + "   reservationcustomer__c, "
      + "   reservationdatetime__c, "
      + "   startdatetime__c, "
      + "   enddatetime__c "
      + " ) "
      + " VALUES ( "
      + "   #{externalId}, #{emptyStatus}, #{type}, null, null, #{startDatetime}, #{endDatetime} "
      + " ) "
    )
    int insert(TelSupportReservation reservation);

    @Select(
        " SELECT "
      + "   COUNT(*) "
      + " FROM "
      + "   salesforce.telsupportreservation__c"
      + " WHERE "
      + "   #{startDate} < enddatetime__c "
      + " AND "
      + "   #{endDate} > startdatetime__c "
    )
    Long selectCountByTargetdate(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);
}
