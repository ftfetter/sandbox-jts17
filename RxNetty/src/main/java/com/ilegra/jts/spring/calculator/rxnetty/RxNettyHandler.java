package com.ilegra.jts.spring.calculator.rxnetty;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.reactivex.netty.protocol.http.server.HttpServerRequest;
import io.reactivex.netty.protocol.http.server.HttpServerResponse;
import io.reactivex.netty.protocol.http.server.RequestHandler;
import rx.Observable;

public class RxNettyHandler implements RequestHandler<ByteBuf, ByteBuf> {

    private final String calculatorUri;
    private final CalculatorResource calculatorResource;

    public RxNettyHandler(String calculatorUri, CalculatorResource calculatorResource) {
        this.calculatorUri = calculatorUri;
        this.calculatorResource = calculatorResource;
    }

    @Override
    public Observable<Void> handle(HttpServerRequest<ByteBuf> request, HttpServerResponse<ByteBuf> response) {
        if (request.getUri().startsWith(calculatorUri)) {
            response.setStatus(HttpResponseStatus.OK);
            return response.writeStringAndFlush(calculatorResource.history());
        } else {
            response.setStatus(HttpResponseStatus.NOT_FOUND);
            return response.close();
        }
    }
}