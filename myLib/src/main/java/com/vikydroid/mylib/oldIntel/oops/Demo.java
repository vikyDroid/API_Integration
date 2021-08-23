package com.vikydroid.mylib.oldIntel.oops;


public class Demo {

    public static void main(String[] args) {
        Trial trial = Trial.create(new MyInterface() {
            @Override
            public void call(Subscriber s) {
                System.out.println(s);
            }
        });

        Observable observable = Observable.create(new Observable.OnSubscribe() {
            @Override
            public void call(Subscriber<String> subscriber) {
                subscriber.onNext("blue color");
                subscriber.onCompleted();
            }
        });


        Subscriber<String> subscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {
                System.out.println("onCompleted");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("onError");
            }

            @Override
            public void onNext(String data) {
                System.out.println(data);
            }
        };

        observable.subscribe(subscriber);

    }
}
