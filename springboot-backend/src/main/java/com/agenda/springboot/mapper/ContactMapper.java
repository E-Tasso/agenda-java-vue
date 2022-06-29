package com.agenda.springboot.mapper;

import com.agenda.springboot.controller.vo.response.GetContactResponse;
import com.agenda.springboot.entity.Contact;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface ContactMapper {

    ContactMapper INSTANCE = Mappers.getMapper( ContactMapper.class );

    GetContactResponse contactToGetContactResponse(Contact contact);
}
