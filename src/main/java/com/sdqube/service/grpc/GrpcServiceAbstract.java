package com.sdqube.service.grpc;

import com.google.protobuf.Message;
import com.sdqube.entities.AuthenticationPb;
import com.sdqube.entities.AuthenticationRpcGrpc;
import com.sdqube.entities.CommonsPb;
import com.sdqube.service.exception.AuthException;
import com.sdqube.service.exception.PermissionException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;

/**
 * Created by >Sagar Duwal<
 * Github: @sagarduwal
 * Date: 7/26/20 2:04 AM
 */
public abstract class GrpcServiceAbstract<T extends Message> implements Service<T, CommonsPb.Debug> {
    private final AuthenticationRpcGrpc.AuthenticationRpcBlockingStub authServiceCall;

    public GrpcServiceAbstract(){
        authServiceCall = null;
    }
    public GrpcServiceAbstract(final AuthenticationRpcGrpc.AuthenticationRpcBlockingStub authServiceCall) {
        this.authServiceCall = authServiceCall;
    }

    public abstract T error(CommonsPb.ErrorCode errorCode, String msg);

    public AuthenticationPb.AuthResponse authorize(AuthenticationPb.GAuthorization authorization,
                                                   String permission) throws AuthException, PermissionException {
        AuthenticationPb.GAuthorization auth = authorization.toBuilder()
                .setPermission(CommonsPb.Permission.newBuilder()
                        .setName(permission).build()).build();
        AuthenticationPb.AuthBaseResponse response = authServiceCall.authorize(AuthenticationPb.AuthBaseRequest.newBuilder()
                .setAuthorization(auth).build());
        if (null == response) {
            throw new AuthException();
        }
        if (response.getError()) {
            throw new AuthException();
        }
        if (!response.getAuthResponse().getGranted()) {
            throw new PermissionException();
        }
        return response.getAuthResponse();
    }

    @Override
    public T illegal(String msg) {
        return error(CommonsPb.ErrorCode.NPE, msg);
    }

    @Override
    public T exception(Throwable throwable, Logger logger, CommonsPb.Debug debug) {
        return null;
    }

    @Override
    public T npe(String msg) {
        return error(CommonsPb.ErrorCode.NPE, msg);
    }

    @Override
    public T duplicate(String msg) {
        return error(CommonsPb.ErrorCode.DUPLICATE, msg);
    }

    @Override
    public T failed(String msg) {
        return error(CommonsPb.ErrorCode.FAILED, msg);
    }

    @Override
    public T notfound(String msg) {
        return error(CommonsPb.ErrorCode.NOTFOUND, msg);
    }

    @Override
    public T invalid(String msg) {
        return error(CommonsPb.ErrorCode.INVALID, msg);
    }

    protected String withDebugInfo(String msg, CommonsPb.Debug debugInfo) {
        if (StringUtils.isBlank(msg)) {
            return msg;
        }
        if (null != debugInfo) {
            if (StringUtils.isNotBlank(debugInfo.getDebugId())) {
                msg = msg + " Debug Id : " + debugInfo.getDebugId();
            }
        }
        return msg;
    }

    @Override
    public void error(Logger logger, CommonsPb.Debug debug, String msg, Throwable throwable) {
        logger.error(withDebugInfo(msg, debug), throwable);
    }

    @Override
    public void error(Logger logger, CommonsPb.Debug debug, String msg) {
        logger.error(withDebugInfo(msg, debug));

    }

    @Override
    public void error(Logger logger, CommonsPb.Debug debug, String format, Object... arguments) {
        logger.error(withDebugInfo(format, debug), arguments);

    }

    @Override
    public void debug(Logger logger, CommonsPb.Debug debug, String msg) {
        logger.debug(withDebugInfo(msg, debug));

    }

    @Override
    public void debug(Logger logger, CommonsPb.Debug debug, String msg, Throwable throwable) {
        logger.debug(withDebugInfo(msg, debug), throwable);

    }

    @Override
    public void debug(Logger logger, CommonsPb.Debug debug, String format, Object... arguments) {
        logger.debug(withDebugInfo(format, debug), arguments);

    }

    @Override
    public void info(Logger logger, CommonsPb.Debug debug, String msg) {
        logger.info(withDebugInfo(msg, debug));

    }

    @Override
    public void info(Logger logger, CommonsPb.Debug debug, String msg, Throwable throwable) {
        logger.info(withDebugInfo(msg, debug), throwable);

    }

    @Override
    public void warn(Logger logger, CommonsPb.Debug debug, String msg) {
        logger.warn(withDebugInfo(msg, debug));

    }

    @Override
    public void warn(Logger logger, CommonsPb.Debug debug, String msg, Throwable throwable) {
        logger.warn(withDebugInfo(msg, debug), throwable);

    }

    @Override
    public void warn(Logger logger, CommonsPb.Debug debug, String format, Object... arguments) {
        logger.warn(withDebugInfo(format, debug), arguments);

    }
}
