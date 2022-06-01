package com.zp.leetcode;

public class Solution468 {
    public String validIPAddress(String queryIP) {
        if(isIPv4(queryIP)) {
            return "IPv4";
        }
        if(isIPv6(queryIP)) {
            return "IPv6";
        }
        return "Neither";
    }

    boolean isIPv4(String queryIP) {
        String[] sub = queryIP.split("\\.");
        if(sub.length != 4) return false;
        for(String s: sub) {
            if(s.startsWith("0")) return false;
            try{
                Integer i = Integer.valueOf(s);
                if(i<0 && i>255){
                    return false;
                }
            }catch(Exception e) {
                return false;
            }
        }
        return true;
    }

    boolean isIPv6(String queryIP) {
        String[] sub = queryIP.split(":");
        if(sub.length != 8) return false;
        for(String s: sub) {
            if(s.length()>4) return false;
            try{
                Integer i = Integer.valueOf(s,16);
                if(i<0 && i>0xffff){
                    return false;
                }
            }catch(Exception e) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution468 s = new Solution468();
        System.out.println(s.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));
    }
}
