package com.passing.platform.returndatatype;

public class Rdatatype<T> {
    public int errorcode;
    public String message;
    public T data;

    public Rdatatype(){

    }
    public Rdatatype(int errorcode,String message,T data){
        this.errorcode = errorcode;
        this.message = message;
        this.data = data;
    }

    public static <T> Rdatatype<T> onSuccess(T data){
        return new Rdatatype(1,"sucess",data);
    }

    public static <T> Rdatatype<T> onError(String msg){
        return new Rdatatype(0,"error",msg);
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public void setErrorcode(int errorcode) {
        this.errorcode = errorcode;
    }

    public String getMessage() {
        return message;
    }

    public int getErrorcode() {
        return errorcode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Rdatatype{" +
                "errorcode=" + errorcode +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
