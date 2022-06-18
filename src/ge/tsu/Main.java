package ge.tsu;

import ge.tsu.classes.Message;
import ge.tsu.enums.MessageType;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

    static int highCount;
    static int mediumCount;
    static int lightCount;
    static int noneCount;


    public static void main(String[] args) {
        List<Message> messageList = new ArrayList<>();
        messageList.add(new Message("prick 111", new Date(System.currentTimeMillis())));
        messageList.add(new Message("freak 222", new Date(System.currentTimeMillis())));
        messageList.add(new Message("jerk 333", new Date(System.currentTimeMillis())));
        messageList.add(new Message("loser 444", new Date(System.currentTimeMillis())));
        messageList.add(new Message("dumb 555 ", new Date(System.currentTimeMillis())));
        messageList.add(new Message("idiot 666", new Date(System.currentTimeMillis())));
        messageList.add(new Message("shorty 777", new Date(System.currentTimeMillis())));
        messageList.add(new Message("thin 888", new Date(System.currentTimeMillis())));
        messageList.add(new Message("weak 999", new Date(System.currentTimeMillis())));
        messageList.add(new Message("000", new Date(System.currentTimeMillis())));



        messageList.forEach(
                message -> {
                    String folder = null;
                    switch (message.getMessageType()){
                        case HIGH:
                            addFile(message,"HIGH",++highCount);
                            break;
                        case LIGHT:
                            addFile(message,"LIGHT",++lightCount);
                            break;
                        case MEDIUM:
                            addFile(message,"MEDIUM",++mediumCount);
                            break;
                        case NONE:
                            addFile(message,"NONE",++noneCount);
                            break;
                    }

                }
        );
        // WRITE LOGIC HERE
        // WRITE SORTED MESSAGES INTO /sorted-messages folder
        // For example, `/sorted-messages/High/[message1_time].dat`,
        // `/sorted-messages/High/[message2_time].dat` and etc.
    }

    public static void addFile(Message message,String folder, int count){
        try {
            File parent = new File("C:\\Users\\hamba\\Downloads\\message-sorter\\message-sorter\\sorted-messages\\"+folder);
            parent.mkdir();
            File file = new File(parent,"message"+count+"_"+new SimpleDateFormat("dd-MM-yyyy").format(message.getSendTime())+".txt");
            file.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(message.getText().getBytes());
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
