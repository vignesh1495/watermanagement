package com.watermanage.execptions;

public class NoSuchCommandException extends Exception {

    @Override
    public String toString() {
        return "No such Command Found!";
    }
}
