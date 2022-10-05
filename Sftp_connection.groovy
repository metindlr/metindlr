import com.sap.gateway.ip.core.customdev.util.Message;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;
import com.sap.it.api.securestore.SecureStoreService;
import com.sap.it.api.securestore.UserCredential;
import com.sap.it.api.ITApiFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Properties;


        
def Message processData(Message message) {
        Session session = null;
        Properties props = new Properties();
        props.put("StrictHostKeyChecking", "no");
        //props.put("PreferredAuthentications", "publickey,keyboard-interactive,password");
        props.put("PreferredAuthentications", "password");
       String result ="res";
        try {
        	JSch jsch = new JSch();
       
        	
            session = jsch.getSession("13520758T", "sftp012.successfactors.eu", 22);
            session.setConfig(props);
            session.setPassword("OVZ3NWqzak9W");
            
            session.connect();
            
            Channel channel = session.openChannel("sftp");
            channel.connect();
            ChannelSftp sftpChannel = (ChannelSftp) channel;
         
        	ByteArrayOutputStream out = new ByteArrayOutputStream();
            //sftpChannel.get("/ONB/outbound/myFile.txt","C:/Users/TR25456/Desktop/local.txt");
          //  sftpChannel.get("/ONB/outbound/NH-borusanT1-20191203095500.csv", out);
        //    result = out.toString("UTF-8");
          

             Vector<ChannelSftp.LsEntry> list = sftpChannel.ls("/ONB/outbound/*.csv");
           
        	for(ChannelSftp.LsEntry entry : list) {
        	     
        	     sftpChannel.get("/ONB/outbound/" + entry.getFilename(), out);
        	     result = result + "" + out.toString("UTF-8");
                 
        	}
        	
            sftpChannel.exit();
            session.disconnect();
           
        } catch (JSchException e) {
            e.printStackTrace();  
        } catch (SftpException e) {
            e.printStackTrace();
        }
        message.setBody(result);
	
	    return message;
      
    
}