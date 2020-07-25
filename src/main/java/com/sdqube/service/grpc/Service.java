package com.sdqube.service.grpc;

import com.google.common.collect.Maps;
import com.sdqube.service.logger.LoggingContext;
import org.slf4j.Logger;

import java.util.Map;

/**
 * Created by >Sagar Duwal<
 * Github: @sagarduwal
 * Date: 7/26/20 2:04 AM
 */
public interface Service<T, D> extends LoggingContext<D> {
    T illegal(String msg);

    T exception(Throwable throwable, final Logger logger, D debug);

    T npe(String msg);

    T duplicate(String msg);

    T failed(String msg);

    T notfound(String msg);

    T invalid(String msg);

    default Map<String, Object> constructMsgPlaceholder() {
        return Maps.newHashMapWithExpectedSize(6);
    }
}
