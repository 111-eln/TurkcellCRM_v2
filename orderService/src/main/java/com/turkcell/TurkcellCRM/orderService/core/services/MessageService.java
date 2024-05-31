package com.turkcell.TurkcellCRM.orderService.core.services;

public interface MessageService {
    String getMessages(String key);
    String getMessagesWithArgs(String key, Object... args);
}
