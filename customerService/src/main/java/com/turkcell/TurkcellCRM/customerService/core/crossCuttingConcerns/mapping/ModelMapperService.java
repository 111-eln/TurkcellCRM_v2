package com.turkcell.TurkcellCRM.customerService.core.crossCuttingConcerns.mapping;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {

    ModelMapper forResponse();

    ModelMapper forRequest();
}
