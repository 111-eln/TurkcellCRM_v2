package com.turkcell.TurkcellCRM.customerService.core.business.abstracts;

public interface MessageService {
    String getMessages(String key);
    String getMessagesWithArgs(String key, Object... args);
}
