package main._202501._06;

import java.net.http.WebSocket;
import java.nio.ByteBuffer;
import java.util.concurrent.CompletableFuture;

public class Chatting {
    public static void main(String[] args) {


        WebSocket webSocket = new WebSocket() {
            @Override
            public CompletableFuture<WebSocket> sendText(CharSequence data, boolean last) {
                return null;
            }

            @Override
            public CompletableFuture<WebSocket> sendBinary(ByteBuffer data, boolean last) {
                return null;
            }

            @Override
            public CompletableFuture<WebSocket> sendPing(ByteBuffer message) {
                return null;
            }

            @Override
            public CompletableFuture<WebSocket> sendPong(ByteBuffer message) {
                return null;
            }

            @Override
            public CompletableFuture<WebSocket> sendClose(int statusCode, String reason) {
                return null;
            }

            @Override
            public void request(long n) {

            }

            @Override
            public String getSubprotocol() {
                return null;
            }

            @Override
            public boolean isOutputClosed() {
                return false;
            }

            @Override
            public boolean isInputClosed() {
                return false;
            }

            @Override
            public void abort() {

            }
        };

        int statusCode = 100;
        String reason = "종료";
        webSocket.sendClose(100, reason);


    }
}
