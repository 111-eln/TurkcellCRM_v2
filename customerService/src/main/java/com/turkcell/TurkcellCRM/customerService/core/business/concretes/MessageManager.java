package com.turkcell.TurkcellCRM.customerService.core.business.concretes;

import com.turkcell.TurkcellCRM.customerService.core.business.abstracts.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MessageManager implements MessageService {
    private MessageSource messageSource;
    @Override
    public String getMessages(String key) {
        return messageSource.getMessage(key,null, LocaleContextHolder.getLocale());
    }

    @Override
    public String getMessagesWithArgs(String key, Object... args) {
        return messageSource.getMessage(key,args,LocaleContextHolder.getLocale());
    }
}