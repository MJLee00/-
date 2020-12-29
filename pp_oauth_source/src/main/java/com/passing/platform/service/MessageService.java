package com.passing.platform.service;

import com.passing.platform.domain.Message;

import java.util.List;

public interface MessageService {
    boolean createMessage(Message message);
    List<Message> selectBysenderid(int senderid);
    List<Message> selectByrecid(int recid);
    boolean changeStage(int messageId, boolean ifread);
}
