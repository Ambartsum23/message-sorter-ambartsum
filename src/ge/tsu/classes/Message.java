package ge.tsu.classes;

import ge.tsu.enums.MessageType;

import java.util.Date;

public class Message {
    private String text;
    private Date sendTime;
    private MessageType messageType;

    public Message(String text, Date sendTime) {
        this.text = text;
        this.sendTime = sendTime;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public MessageType getMessageType() {
        if (text.contains("jerk")||text.contains("freak")||text.contains("prick"))
            return MessageType.HIGH;
        if (text.contains("loser")||text.contains("idiot")||text.contains("dumb"))
            return MessageType.MEDIUM;
        if (text.contains("shorty")||text.contains("thin")||text.contains("weak"))
            return MessageType.LIGHT;
        return MessageType.NONE;
    }
}
