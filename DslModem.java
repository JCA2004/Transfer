package com.ModemClass;

class DslModem extends Modem {
    
    String method = "DSL phone connection";
    
    public void connect() {
        System.out.println("Connecting to the internet ...");
        System.out.println("Using a " + method);
    }
}