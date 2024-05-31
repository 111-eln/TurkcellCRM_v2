package com.turkcell.TurkcellCRM.basketService.core.services;

public interface MessageService {
    String getMessages(String key);
    String getMessagesWithArgs(String key, Object... args);
}
