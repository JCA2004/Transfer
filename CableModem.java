/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ModemClass;

/**
 *
 * @author jamesashby
 */
public class CableModem extends Modem {
    String method = "cable connection";
    
    public void connect() {
        System.out.println("Connecting to the Internet");
        System.out.println("Using a " + method);
        
    }
}
