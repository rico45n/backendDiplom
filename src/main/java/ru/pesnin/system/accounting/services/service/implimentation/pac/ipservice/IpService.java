package ru.pesnin.system.accounting.services.service.implimentation.pac.ipservice;

import org.springframework.stereotype.Service;
import ru.pesnin.system.accounting.services.service.interfase.pac.ipservice.IpServiceI;


import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

@Service
public class IpService implements IpServiceI {
    @Override
    public String netAddress (String addr){
        try {
            String[] parts = addr.split("/");
            String ip = parts[0];
            int prefix;
            if (parts.length < 2) {
                prefix = 0;
            } else {
                prefix = Integer.parseInt(parts[1]);
            }
            int mask = 0xffffffff << (32 - prefix);

            int value = mask;
            byte[] bytes = new byte[]{
                    (byte) (value >>> 24), (byte) (value >> 16 & 0xff), (byte) (value >> 8 & 0xff), (byte) (value & 0xff)};

            InetAddress netAddr = InetAddress.getByAddress(bytes);

            String[] arrayMask = netAddr.getHostAddress().replace(".", "/").split("/");
            String[] arrayAddress = ip.replace(".", "/").split("/");

            List<String> bitMask = new ArrayList<>();
            for (String elementArrayMask : arrayMask) {
                StringBuffer binMask = new StringBuffer();
                char[] charsMask = Integer.toBinaryString(Integer.parseInt(elementArrayMask)).toCharArray();
                for (char i : charsMask) {
                    if (i == '0') {
                        binMask.append('1');
                    } else {
                        binMask.append('0');
                    }
                }
                if (binMask.length() < 8) {
                    int l = binMask.length();
                    while (l != 8) {
                        binMask.append('1');
                        l++;
                    }
                }
                bitMask.add(binMask.toString());
            }

            List<String> bitAddress = new ArrayList<>();
            for (String elementArrayAddress : arrayAddress) {
                StringBuffer binAddress = new StringBuffer();
                char[] charsAddress = Integer.toBinaryString(Integer.parseInt(elementArrayAddress)).toCharArray();
                if (charsAddress.length != 8) {
                    int l = charsAddress.length;
                    while (l != 8) {
                        binAddress.append('0');
                        l++;
                    }
                    binAddress.append(charsAddress);
                } else {
                    for (char t : charsAddress) {
                        binAddress.append(t);
                    }
                }
                bitAddress.add(binAddress.toString());
            }

            String resultAdd = new String();
            for (int i = 0; i < bitAddress.size(); i++) {
                char[] arrayCharAddress = bitAddress.get(i).toCharArray();
                char[] arrayCharMask = bitMask.get(i).toCharArray();
                for (int j = 0; j < arrayCharAddress.length; j++) {
                    if (arrayCharAddress[j] == '0' && arrayCharMask[j] == '0') {
                        resultAdd += '0';
                    } else {
                        resultAdd += '1';
                    }
                }
                resultAdd += ".";
            }

            String[] splitIP = resultAdd.replace(".", "/").split("/");
            StringBuffer resultIP = new StringBuffer();
            for (int i = 0; i <= splitIP.length - 1; i++) {
                resultIP.append(Integer.parseInt(splitIP[i], 2));
                if (i < splitIP.length - 1)
                    resultIP.append(".");
            }

            return resultIP.toString();
        }catch (UnknownHostException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<String> getAllIpAddress(String startAddress, String endAddress){
        String[] startParts = startAddress.replace(".", "/").split("/");
        String[] endParts = endAddress.replace(".", "/").split("/");

        int endActet4 = Integer.parseInt(endParts[3]);
        List<String> resultListAddress = new ArrayList<>();

        int actet4 = 0;
        while(Integer.parseInt(startParts[1]) <= Integer.parseInt(endParts[1])) {
            actet4 = 0;

            while (Integer.parseInt(startParts[2]) <= Integer.parseInt(endParts[2])) {
                actet4 = 0;
                if(Integer.parseInt(startParts[2]) == Integer.parseInt(endParts[2])){
                    while (actet4 <= endActet4 - 1) {
                        startParts[3] = String.valueOf((Integer.parseInt(startParts[3]) + 1));
                        resultListAddress.add(startParts[0] + "." + startParts[1] + "." + startParts[2] + "." + startParts[3]);
                        actet4++;
                    }
                    break;
                }
                else{
                    while (actet4 <= 254){
                        startParts[3] = String.valueOf((Integer.parseInt(startParts[3]) + 1));
                        resultListAddress.add(startParts[0]+"."+startParts[1]+"."+startParts[2]+"."+startParts[3]);
                        actet4++;
                    }
                    startParts[3] = String.valueOf('0');
                }
                startParts[2] = String.valueOf((Integer.parseInt(startParts[2]) + 1));
                resultListAddress.add(startParts[0]+"."+startParts[1]+"."+startParts[2]+"."+startParts[3]);
            }
            startParts[1] = String.valueOf((Integer.parseInt(startParts[1]) + 1));
            resultListAddress.add(startParts[0] + "." + startParts[1] + "." + startParts[2] + "." + startParts[3]);
        }
        return resultListAddress;
    }

}
