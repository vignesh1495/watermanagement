package com.watermanage.execptions;

public class NoFileFoundException extends Exception {

    @Override
    public String toString() {
        return "No such File Found!";
    }
}
