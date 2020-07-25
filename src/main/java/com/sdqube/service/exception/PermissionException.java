package com.sdqube.service.exception;

/**
 * Created by >Sagar Duwal<
 * Github: @sagarduwal
 * Date: 7/26/20 2:25 AM
 */
public class PermissionException extends Throwable {

    private static final long serialVersionUID = 1L;

    public PermissionException() {
        super("No permission");
    }

    public PermissionException(String msg) {
        super(msg);
    }
}
