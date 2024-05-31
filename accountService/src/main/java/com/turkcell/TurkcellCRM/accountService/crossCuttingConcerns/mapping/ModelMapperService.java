package com.turkcell.TurkcellCRM.accountService.crossCuttingConcerns.mapping;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {

    ModelMapper forResponse();

    ModelMapper forRequest();
}
